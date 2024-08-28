<script setup>
import { ref, onMounted } from 'vue'
import axios from 'axios'
import { useUserStore } from '@/store/userStore'

const userStore = useUserStore()

// 存储地图数据
const mapData = ref([])
const selectedItem = ref(null)
const newValue = ref('')
const search = ref('')

// 获取地图数据
const fetchMapData = async () => {
  try {
    const token = userStore.token  // 从 store 中获取 token
    console.log('Token:', token)
    const response = await axios.get('/api/guanliyuan/getmap',{
      headers: {
        'token': `${token}`, // 添加 token 到请求头
        'Content-Type': 'application/json' // 设置请求内容类型
      }
    })
    console.log(response)
    // console.log(response.data)
    if (response.data.code === 906) {
      mapData.value = response.data.data
    } else {
      console.log('Failed to load map data:', response.data.desc)
    }
  } catch (error) {
    console.log('Failed to load map data:', error)
  }
}

// 查询地图名
const handleSearch = async () => {
  try{
    const token = userStore.token
    const response = await axios.post('/api/guanliyuan/selectmap', {name:search.value} , {
      headers: {
        'token': `${token}`,
        'Content-Type': 'application/json'
      }
    })
    console.log(response.data)
    if(response.data.code === 940){
      console.log('Data before setting mapData:', response.data.data)
      mapData.value = [response.data.data]
      console.log('Updated mapData:', mapData.value)
    } else {
      console.log('Failed to search map data:',response.data.desc)
    }
  } catch (error) {
     console.log('Failed to search:',error)
  }
}

// 更新地图数据
const updateMapData = async () => {
  if (!selectedItem.value || newValue.value === '') {
    alert('请选择要更新的项，并输入新的值')
    return
  }
  try {
    const token = userStore.token
    const response = await axios.post('/api/guanliyuan/editmap', {
      name: selectedItem.value,
      value: Number(newValue.value)
    }, {
      headers: {
        'token': `${token}`, // 添加 token 到请求头
        'Content-Type': 'application/json' // 设置请求内容类型
      }
    })
    
    if (response.data.code === 931) {
      alert('地图数据更新成功')
      fetchMapData()  // 重新加载地图数据
    } else {
      console.log('Failed to update map data:', response.data.desc)
    }
  } catch (error) {
    console.log('Failed to update map data:', error)
  }
}

//选择地图项
const selectItem = (name) => {
  selectedItem.value = name
}

// 组件挂载时调用获取数据函数
onMounted(() => {
  fetchMapData()
})
</script>

<template>
  <div class="map-container">
    <h2>地图数据</h2>
    <div class="search-container">
      <input v-model="search" placeholder="搜索地图名" />
      <button @click="handleSearch" class="search-button">搜索</button>
    </div>
    <div class="map">
      <div v-for="item in mapData" :key="item.name" class="map-item">
        <span class="map-item-name">{{ item.name }}</span>
        <span class="map-item-value">{{ item.value }}</span>
        <button @click="selectItem(item.name)">选择</button>
      </div>
    </div>
    <div class="update-container">
      <input type="number" v-model="newValue" placeholder="输入新的值" />
      <button @click="updateMapData" class="update-button">更新值</button>
    </div>
  </div>
</template>

<style scoped>
.map-container {
  width: 1000px;
  padding: 20px;
  padding-top: 0;
  background-color: #ffffff;
  border-radius: 10px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  max-width: 900px;
  margin: 0 auto;
}

h2 {
  text-align: center;
  color: #333;
  font-size: 24px;
  margin-bottom: 20px;
  font-family: 'Arial', sans-serif;
}

.search-container {
  margin-top: 20px;
  text-align: center;
}

.search-container input {
  padding: 10px;
  border: 1px solid #ddd;
  border-radius: 4px;
  font-size: 16px;
  width: calc(100% - 130px);
  margin-right: 10px;
}

.search-button {
  padding: 10px 20px;
  background-color: #28a745;
  color: #fff;
  border: none;
  border-radius: 4px;
  font-size: 16px;
  cursor: pointer;
  transition: background-color 0.3s;
}

.search-button:hover {
  background-color: #218838;
}

.search-button:disabled {
  background-color: #cccccc;
  cursor: not-allowed;
}

.map {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(150px, 1fr));
  gap: 15px;
}

.map-item {
  background-color: #f9f9f9;
  padding: 15px;
  border-radius: 8px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  transition: background-color 0.3s, transform 0.3s;
}

.map-item:hover {
  background-color: #e0e0e0;
  transform: translateY(-5px);
}

.map-item-name {
  font-weight: 600;
  color: #333;
  font-size: 16px;
  margin-bottom: 8px;
  font-family: 'Arial', sans-serif;
}

.map-item-value {
  color: #007bff;
  font-size: 14px;
}

.update-container {
  margin-top: 20px;
  text-align: center;
}

.update-container input {
  padding: 10px;
  border: 1px solid #ddd;
  border-radius: 4px;
  font-size: 16px;
  width: calc(100% - 130px);
  margin-right: 10px;
}

.update-button {
  padding: 10px 20px;
  background-color: #28a745;
  color: #fff;
  border: none;
  border-radius: 4px;
  font-size: 16px;
  cursor: pointer;
  transition: background-color 0.3s;
}

.update-button:hover {
  background-color: #218838;
}

.update-button:disabled {
  background-color: #cccccc;
  cursor: not-allowed;
}
</style>