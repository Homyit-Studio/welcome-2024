<script setup>
import { ref, onMounted } from 'vue'
import axios from 'axios'
import { useUserStore } from '@/store/userStore'

const userStore = useUserStore()
const editingRegister = ref(null)  // 用于存储当前编辑的报名信息
const showEditForm = ref(false)  // 控制编辑表单的显示和隐藏
// 定义数据
const registers = ref([])
const loading = ref(true)
const error = ref(null)
const total = ref(100)  // 总数据条数
const currentPage = ref(1)  // 当前页码，默认第一页
const pageSize = ref(10)  // 每页显示条数

const newRegister = ref({
    name: '',
    youxiang: '',
    xuehao: '',
    banji: '',
    fangxiang: '',
    jieshao: ''
  })

// 搜索
const search = ref({
  name: '',
  banji: '',
  xuehao: '',
  fangxiang: ''
})

// 搜索功能
const handleSearch = () => {
  currentPage.value = 1
  fetchRegisterData()
}  

// 获取新生报名信息
const fetchRegisterData = async (page = 1) => {
  loading.value = true

  const xinsheng = {
    page,
    pageSize:pageSize.value,
    name: search.value.name,
    banji: search.value.banji,
    xuehao: search.value.xuehao,
    youxiang: '',
    fangxiang: search.value.fangxiang,
    jieshao: ''
  }
  try {
    const token = userStore.token 
    const response = await axios.post('/api/guanliyuan/selectall', xinsheng, { 
      headers:{
        'token': `${token}`,
        'Content-Type': 'application/json'
      } 
    })
    console.log(response.data)
    if(response.data.code === 907){
      registers.value = response.data.data || [] 
      // 如果返回数据长度小于 pageSize，说明这是最后一页，调整 total 的值
      if(registers.value.length < pageSize.value) {
        total.value = (page - 1) * pageSize.value + registers.value.length
      }
    }else{
      console.log('Failed to look:', response.data.desc)
      error.value = response.data.desc || '获取报名信息失败'
    }
  } catch (err) {
    console.error('请求出错:',err)  // 打印错误信息
    error.value = '获取报名信息失败'
  } finally {
    loading.value = false;
  }
  console.log('Total:',total.value)
  console.log('currentPage:',currentPage.value)
  console.log('pageSize:',pageSize.value)
}

// 新增报名信息
const handleAddRegister = async () => {
  try {
    const token = userStore.token
    const response = await axios.post('/api/guanliyuan/insert', newRegister.value, {
      headers: {
        'token': `${token}`,
        'Content-Type': 'application/json'
      }
    })
    console.log(response)
    if (response.data.code === 801) {
      // 重新获取数据
      await fetchRegisterData(currentPage.value)
      // 清空表单
      newRegister.value = {
        name: '',
        youxiang: '',
        xuehao: '',
        banji: '',
        fangxiang: '',
        jieshao: ''
      }
      console.log('Success to add:', response.data.desc)
    } else {
      console.log('Failed to add:', response.data.desc)
      error.value = response.data.desc || '新增失败'
    }
  } catch (err) {
    console.error('请求出错:', err)
    error.value = '新增失败'
  }
}

// 修改报名信息
const handleEdit = (register) => {
  editingRegister.value = { ...register }
  showEditForm.value = true
}
const handleUpdateRegister = async () => {
  try {
    const token = userStore.token
    const response = await axios.post('/api/guanliyuan/update', editingRegister.value, {
      headers: {
        'token': `${token}`,
        'Content-Type': 'application/json'
      }
    })
    if (response.data.code === 903) {
      // 更新本地数据
      const index = registers.value.findIndex(register => register.id === editingRegister.value.id)
      if (index !== -1) {
        registers.value[index] = { ...editingRegister.value }
      }
      showEditForm.value = false
      console.log('Success to update:', response.data.desc)
    } else {
      console.log('Failed to update:', response.data.desc)
      error.value = response.data.desc || '修改失败'
    }
  } catch (err) {
    console.error('请求出错:', err)
    error.value = '修改失败'
  }
}

// 删除报名信息
const handleDelete = async (id) => {
  if(confirm('确定要删除这条信息吗?')){
    try{
      const token = userStore.token
      const response = await axios.post('/api/guanliyuan/delect',{id},{
        headers:{
          'token': `${token}`,
          'Content-Type': 'application/json'
        }
      })
      console.log(response.data)
      
      if (response.data.code === 701) {
        // 成功删除，更新本地数据
        registers.value = registers.value.filter(register => register.id !== id)
        console.log('Success to delete:', response.data.desc)
      } else {
        console.log('Failed to delete:', response.data.desc)
        error.value = response.data.desc || '删除失败'
      }
    } catch (err) {
      console.error('请求出错:',err)
      error.value = '删除失败'
    }
  }
}

// 下载数据
const handleDownload = async () => {
  try {
    const token = userStore.token
    const response = await axios.get('/api/guanliyuan/download', {
      headers: {
        'token': `${token}`,
        'Content-Type': 'application/json'
      },
      responseType: 'blob' // 重要，确保后端返回的是文件数据
    })
    // 创建一个临时的 URL 对象，用于下载文件
    const url = window.URL.createObjectURL(new Blob([response.data]))
    const link = document.createElement('a')
    link.href = url
    link.setAttribute('download', 'data.xlsx') // 默认文件名
    document.body.appendChild(link)
    link.click()
    link.remove()
  } catch (err) {
    console.error('下载出错:', err)
    error.value = '下载失败'
  }
}

// 切换页面时调用
const handlePageChange = (newPage) => {
  currentPage.value = newPage
  fetchRegisterData(newPage)
}

// 在组件挂载后获取数据
onMounted(() => {
  fetchRegisterData(currentPage.value)
})
</script>

<template>
  <div class="register-list">
    <h1>新生报名信息</h1>
    <div v-if="showEditForm" class="edit-form">
      <h2>编辑报名信息</h2>
      <form @submit.prevent="handleUpdateRegister">
        <input v-model="editingRegister.name" placeholder="姓名" required />
        <input v-model="editingRegister.youxiang" placeholder="邮箱" required />
        <input v-model="editingRegister.xuehao" placeholder="学号" required />
        <input v-model="editingRegister.banji" placeholder="班级" required />
        <input v-model="editingRegister.fangxiang" placeholder="方向" required />
        <button type="submit">保存</button>
        <button type="button" @click="showEditForm = false">取消</button>
      </form>
    </div>
    <div v-if="loading" class="loading">加载中...</div>
    <div class="search-box">
      <input v-model="search.name" placeholder="搜索姓名" />
      <input v-model="search.banji" placeholder="搜索班级" />
      <input v-model="search.xuehao" placeholder="搜索学号" />
      <input v-model="search.fangxiang" placeholder="搜索方向" />
      <button @click="handleSearch">搜索</button>
    </div>
    <ul v-if="!loading && registers.length > 0">
      <li v-for="register in registers" :key="register.id" class="register-item">
        <div>姓名: {{ register.name }}</div>
        <div>班级: {{ register.banji }}</div>
        <div>学号: {{ register.xuehao }}</div>
        <div>邮箱: {{ register.youxiang }}</div>
        <div>方向: {{ register.fangxiang }}</div>
        <div>介绍: {{ register.jieshao }}</div>
        <button class="update" @click="handleEdit(register)">修改</button>
        <button class="delete" @click="handleDelete(register.id)">删除</button>
        <button class="upload" @click="handleDownload">下载</button>
      </li>
    </ul>
    <div v-else-if="!loading && registers.length === 0">没有数据</div>
    <div v-if="error" class="error">{{ error }}</div>
    <el-pagination 
      background 
      layout="prev, pager, next" 
      :total="total" 
      :current-page= "currentPage"
      :page-size="pageSize"
      @current-change="handlePageChange" 
    />
    <form @submit.prevent="handleAddRegister" class="register-form">
      <input v-model="newRegister.name" placeholder="姓名" required />
      <input v-model="newRegister.youxiang" placeholder="邮箱" required />
      <input v-model="newRegister.xuehao" placeholder="学号" required />
      <input v-model="newRegister.banji" placeholder="班级" required />
      <input v-model="newRegister.fangxiang" placeholder="方向" required />
      <input v-model="newRegister.jieshao" placeholder="介绍" required />
      <button type="submit" class="add">新增报名</button>
    </form>
  </div>
</template>

<style scoped>
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box; 
  font-family: Arial, sans-serif; 
}

.search-box {
  margin-bottom: 20px;
  display: flex;
  gap: 10px;
}

.search-box input {
  padding: 8px;
  border: 1px solid #ccc;
  border-radius: 4px;
  font-size: 14px;
  width: 150px;
}

.search-box button {
  padding: 8px 12px;
  background-color: #4CAF50;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  font-size: 14px;
  transition: background-color 0.2s;
}

.search-box button:hover {
  background-color: #45a049;
}

.register-form {
  margin-bottom: 20px;
  display: flex;
  flex-direction: column;
  gap: 15px;
  max-width: 600px;
  margin: 0 auto;
  padding: 20px;
  transform: translateY(10px);
  background-color: #ffffff;
  border-radius: 8px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

.register-form input {
  padding: 12px;
  font-size: 16px;
  border: 1px solid #ddd;
  border-radius: 6px;
  background-color: #f9f9f9;
  transition: border-color 0.3s, box-shadow 0.3s;
}

.register-form input:focus {
  border-color: #007bff;
  box-shadow: 0 0 8px rgba(0, 123, 255, 0.2);
  outline: none;
}

.register-form .add {
  align-self: flex-start;
  padding: 12px 24px;
  background-color: #007bff;
  color: white;
  border: none;
  border-radius: 6px;
  cursor: pointer;
  font-size: 16px;
  font-weight: bold;
  transition: background-color 0.3s, transform 0.2s;
}

.register-form .add:hover {
  background-color: #0056b3;
  transform: translateY(-2px);
}

.register-form .add:active {
  background-color: #004494;
  transform: translateY(0);
}

.register-list {
  font-family: Arial, sans-serif;
  margin: 20px;
  max-width: 800px;
  background-color: #f9f9f9;
  border-radius: 8px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
  padding: 20px;
}

h1 {
  font-size: 24px;
  margin-bottom: 20px;
  color: #333;
}

ul {
  list-style-type: none;
  padding: 0;
}

.loading {
  font-size: 18px;
  color: #666;
  text-align: center;
}

.register-item {
  position: relative;
  background-color: #fff;
  border: 1px solid #e0e0e0;
  border-radius: 6px;
  padding: 15px;
  margin-bottom: 10px;
  transition: transform 0.2s, box-shadow 0.2s;
}

.register-item:hover {
  transform: translateY(-2px);
  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
}

button {
  background-color: #4CAF50;
  color: white;
  border: none;
  border-radius: 4px;
  padding: 8px 12px;
  font-size: 14px;
  cursor: pointer;
  transition: background-color 0.2s;
  margin-right: 5px;
}

.update{
  position: absolute;
  top: 40%;
  right: 23%;
  background-color: #2196F3;
  margin-right: 15px;
}

.update:hover{
  cursor: pointer;
  opacity: 0.9;
}

.delete{
  position: absolute;
  top: 40%;
  right: 12%;
  background-color: #f44336;
  margin-right: 10px;
}

.delete:hover{
  cursor: pointer;
  opacity: 0.9;
}

.upload{
  position: absolute;
  top: 40%;
  right: 1%;
  background-color: #ff9800;
}

.upload:hover{
  cursor: pointer;
  opacity: 0.9;
}

button:focus {
  outline: none;
}

.register-item div {
  margin-bottom: 5px;
  color: #555;
  font-size: 14px;
}

.register-item div:last-child {
  margin-bottom: 0; 
}

.error {
  color: #d9534f; 
  font-size: 16px;
  text-align: center; 
  margin-top: 20px; 
}
.edit-form {
  z-index: 1000;
  position: fixed;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  padding: 30px;
  background-color: #ffffff;
  border: none;
  border-radius: 12px;
  box-shadow: 0 4px 15px rgba(0, 0, 0, 0.2);
  width: 400px;
  max-width: 90%;
}

.edit-form h2 {
  margin-bottom: 20px;
  font-size: 24px;
  color: #333;
  text-align: center;
}

.edit-form form {
  display: flex;
  flex-direction: column;
  gap: 15px;
}

.edit-form input {
  padding: 12px;
  font-size: 16px;
  border: 1px solid #ddd;
  border-radius: 8px;
  outline: none;
  transition: border-color 0.3s ease;
}

.edit-form input:focus {
  border-color: #4CAF50;
}

.edit-form button {
  padding: 12px;
  font-size: 16px;
  border: none;
  border-radius: 8px;
  cursor: pointer;
  transition: background-color 0.3s ease;
}

.edit-form button[type="submit"] {
  background-color: #4CAF50;
  color: white;
}

.edit-form button[type="submit"]:hover {
  background-color: #45a049;
}

.edit-form button[type="button"] {
  background-color: #f44336;
  color: white;
}

.edit-form button[type="button"]:hover {
  background-color: #e53935;
}

.edit-form button[type="submit"]:focus, 
.edit-form button[type="button"]:focus {
  outline: none;
  box-shadow: 0 0 3px 2px rgba(76, 175, 80, 0.5);
}
</style>