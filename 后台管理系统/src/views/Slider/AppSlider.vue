<script setup>
import { ref, onMounted } from 'vue'
import axios from 'axios'
import { useUserStore } from '@/store/userStore'

const userStore = useUserStore()
// 定义轮播图数据
const slides = ref([])
const loading = ref(true)
const imageFile = ref(null)
const uploadStatus = ref('')  // 上传状态提示

// 获取轮播图数据
const fetchSlides = async () => {
  try {
    const token = userStore.token  // 从 store 中获取 token
    console.log('Token:', token)
    const response = await axios.get('/api/guanliyuan/getallimages',{
      headers:{
        'token': `${token}`, // 添加 token 到请求头
        'Content-Type': 'application/json' // 设置请求内容类型
      } 
    })
    console.log(response)
    console.log(response.data)
    if (response.data.code === 905) {
      slides.value = response.data.data
      console.log(response.data.data)
    } else {
      console.log('Failed to load slides:', response.data.desc)
    }
  } catch (error) {
    console.log('Failed to load slides:', error)
  } finally {
    loading.value = false
  }
}

// 删除图片
const deleteSlide = async (id) => {
  try {
    const token = userStore.token  // 从 store 中获取 token
    console.log('Token:', token)
    const response = await axios.post('/api/guanliyuan/delectimages', { id },{ 
      headers:{
        'token': `${token}`, // 添加 token 到请求头
        'Content-Type': 'application/json' // 设置请求内容类型
      } 
    })
    console.log(response)
    console.log(response.data)
    if (response.data.code === 301) {
      slides.value = slides.value.filter(slide => slide.id !== id)
      alert('图片删除成功')
    } else {
      console.log('Failed to delete slide:', response.data.desc)
    }
  } catch (error) {
    console.log('Failed to delete slide:', error) 
  }
}

// 上传图片
const uploadImage = async () => {
  if(!imageFile.value) {
    uploadStatus.value = '请选择图片文件'
    return
  }
  const formData = new FormData()
  formData.append('file', imageFile.value)
  
  try {
    const token = userStore.token
    console.log('Token:', token)
    const response = await axios.post('/api/guanliyuan/upload', formData, {
      headers:{
        'token': `${token}`, // 添加 token 到请求头
        'Content-Type': 'multipart/form-data' // 设置请求内容类型
      }
    })
    console.log(response)
    console.log(response.data)
    if (response.data.code === 904) {
      const imagePath = response.data.path  // 获取图片保存路径
      const imagename = imagePath.split('/').pop()  // 从路径中提取图片名字

      uploadStatus.value = '图片上传成功'
      // 重新加载轮播图数据
      await fetchSlides()
      console.log('上传图片的名字:',imagename)
      
    } else {
      uploadStatus.value = `上传失败: ${response.data.desc}`
      console.log('上传失败:', response.data.desc)
    }
  } catch (error) {
    uploadStatus.value = '上传失败'
    // console.log('上传失败:', error)
  }
}

const handleFileChange = (event) => {
  imageFile.value = event.target.files[0]
}

// 在组件挂载时获取轮播图数据
onMounted(() => {
  fetchSlides()
})
</script>

<template>
  <div class="carousel-container">
    <div v-if="loading" class="loading">Loading...</div>
    <div v-else class="carousel">
      <div v-for="slide in slides" :key="slide.id" class="slide">
        <img :src="slide.url" :alt="slide.imagename" class="slide-image" />
        <div class="title">{{ slide.imagename }}</div>
        <button @click="deleteSlide(slide.id)" class="delete-button">删除</button>
      </div>
    </div>
    <div class="upload-container">
      <input type="file" @change="handleFileChange" class="choice" />
      <button @click="uploadImage" class="upload-button">上传图片</button>
      <div v-if="uploadStatus" class="upload-status">{{ uploadStatus }}</div>
    </div>
  </div>
</template>

<style scoped>
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  font-family: Arial, sans-serif;
}

/* 轮播容器 */
.carousel-container {
  max-width: 1200px;
  margin: 0 auto;
  padding: 20px;
  background-color: #f5f5f5;
  border-radius: 12px;
  box-shadow: 0 4px 15px rgba(0, 0, 0, 0.1);
}

/* 加载状态 */
.loading {
  text-align: center;
  font-size: 24px;
  color: #888;
  padding: 50px 0;
}

/* 轮播图样式 */
.carousel {
  display: flex;
  flex-wrap: wrap;
  gap: 20px;
}

.slide {
  position: relative;
  width: calc(33.333% - 20px);
  background-color: #fff;
  border-radius: 12px;
  overflow: hidden;
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
  transition: transform 0.3s ease;
}

.slide:hover {
  transform: scale(1.05);
}

.slide-image {
  width: 100%;
  height: auto;
  border-bottom: 1px solid #eee;
}

.title {
  padding: 10px;
  text-align: center;
  font-size: 18px;
  color: #333;
  background-color: #fafafa;
  border-bottom-left-radius: 12px;
  border-bottom-right-radius: 12px;
}

/* 删除按钮 */
.delete-button {
  position: absolute;
  top: 10px;
  right: 10px;
  background-color: #e53935;
  color: white;
  border: none;
  border-radius: 8px;
  padding: 5px 10px;
  font-size: 14px;
  cursor: pointer;
  transition: background-color 0.3s ease;
}

.delete-button:hover {
  background-color: #d32f2f;
}

/* 上传图片容器 */
.upload-container {
  margin-top: 30px;
  text-align: center;
}

.choice {
  display: block;
  margin: 0 auto 20px auto;
  padding: 10px;
  font-size: 16px;
  border-radius: 8px;
  border: 1px solid #ddd;
  cursor: pointer;
  transition: border-color 0.3s ease;
}

.choice:hover {
  border-color: #4CAF50;
}

.upload-button {
  padding: 12px 20px;
  font-size: 16px;
  color: white;
  background-color: #4CAF50;
  border: none;
  border-radius: 8px;
  cursor: pointer;
  transition: background-color 0.3s ease;
}

.upload-button:hover {
  background-color: #45a049;
}

.upload-status {
  margin-top: 10px;
  font-size: 16px;
  color: #333;
}
</style>