<script setup>
import { Stamp, Goods, DocumentChecked } from "@element-plus/icons-vue"
import { ref, onUnmounted } from 'vue'
import axios from "axios"
import { useRouter } from 'vue-router'
import { useUserStore } from '@/store/userStore'

const verificationCode = ref(generateVerificationCode())
const inputCode = ref('')
const account = ref('')
const password = ref('')
const isRefreshing = ref(false)
const remainingTime = ref(0)
let timer = null

function generateVerificationCode() {
  let code = ''
  for (let i = 0; i < 6; i++) {
    code += Math.floor(Math.random() * 10) // 生成0-9之间的随机数
  }
  return code
}

function handleRefreshCode() {
  if (isRefreshing.value) return // 如果正在刷新，则不允许再次点击
  
  startTimer() // 开始倒计时
  verificationCode.value = generateVerificationCode() // 刷新验证码
}

function startTimer() {
  isRefreshing.value = true
  remainingTime.value = 60 // 设置倒计时时间为60秒
  
  timer = setInterval(() => {
    remainingTime.value -= 1
    if (remainingTime.value <= 0) {
      clearInterval(timer)
      isRefreshing.value = false
    }
  }, 1000) // 每秒钟更新一次
}

// 组件销毁时清理定时器
onUnmounted(() => {
  clearInterval(timer)
})

const router = useRouter()
const userStore = useUserStore()
const message = ref("")
// alert弹出警告
const currentAlert = ref("")
// 表单提交处理函数
const handleSubmit = async () => {
  // 清除之前的警告
  currentAlert.value = ""

  // 检查输入是否为空
  if (!account.value || !password.value || !inputCode.value) {
    currentAlert.value = 'emptyFields'
    return
  }

  // 检查验证码输入是否正确
  if (inputCode.value !== verificationCode.value) {
    currentAlert.value = 'inputError'
    return
  }

  const postData = {
    name: account.value,
    password: password.value
  }

  try {
    const token = userStore.token
    // 发送请求
    const response = await axios.post('/api/guanliyuan/login', postData, { 
      headers: {
        'token': `${token}`,
        'Content-Type': 'application/json',
      }
    })

    if (response.data.code === 200) {
      currentAlert.value = 'success'
      console.log('成功:', response.data)
      // 登录成功后保存 token
      userStore.setToken(response.data.data)
      // 登录成功后跳转页面
      setTimeout(() => { 
        router.push('/Main') 
      }, 500)} 
    else {
      currentAlert.value = 'requestFailed'
    }
  }
  catch (error) {
    currentAlert.value = 'requestFailed'
    console.log('登录失败:', error)
  }
}
</script>

<template>
  <el-alert
        v-if="currentAlert === 'success'"
        title="Success alert"
        type="success"
        description="登录成功"
        show-icon
        class="custom-alert"
    />
    <el-alert
        v-if="currentAlert === 'emptyFields'"
        title="Error alert"
        type="error"
        description="请输入完整的信息"
        show-icon
        class="custom-alert"
    />
    <el-alert
        v-if="currentAlert === 'inputError'"
        title="Error alert"
        type="error"
        description="验证码输入错误"
        show-icon
        class="custom-alert"
    />
    <el-alert
        v-if="currentAlert === 'requestFailed'"
        title="Error alert"
        type="error"
        :description="message"
        show-icon
        class="custom-alert"
    />
  <div>
    <div class="w">
      <div class="main">
        <div class="left"></div>
        <div class="right">
          <div class="header">
            <h2>OP后台管理系统</h2>
          </div>
          <div class="top">账号登录</div>
          <form method="post" @submit.prevent="handleSubmit">
            <div class="content">
              <div class="account">
                <el-icon size="25" class="icon1">
                  <Stamp />
                </el-icon>
                <input type="text" class="inputAccount" placeholder="请输入账号" v-model="account">
              </div>
              <div class="password">
                <el-icon size="25" class="icon2">
                  <Goods />
                </el-icon>
                <input type="password" class="inputPassword" placeholder="请输入密码" v-model="password">
              </div>
              <div class="code">
                <el-icon size="25" class="icon3">
                  <DocumentChecked />
                </el-icon>
                <input type="text" class="inputCode" placeholder="请输入验证码" v-model="inputCode">
                <span class="initCode">{{ verificationCode }}</span>
                <span class="change" @click="handleRefreshCode" :disabled="isRefreshing">
                  {{ isRefreshing ? `请等待 ${remainingTime} 秒` : '换一换' }}
                </span>
              </div>
              <div class="login" @click="handleSubmit">登录</div>
            </div>
          </form>
          <div class="bottom">
            <ul>
              <li class="register">
                <a href="#">立即注册</a>
              </li>
              <li class="forget">
                <a href="#">忘记密码</a>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>
.custom-alert {
    position: fixed;
    top: 20px;
    left: 50%;
    transform: translateX(-50%);
    width: 80%;
    max-width: 400px;
    z-index: 1000;
}
.container {
    margin: 0 auto;
}
*{
  margin: 0;
  padding: 0;
}
a{
  text-decoration: none;
}
li{
  list-style: none;
}
.w{
  width: 100%;
  height: 100vh;
  background: url(../../assets/bgc.jpg) no-repeat;
  background-size: cover;
  display: flex;
  align-items: center;
}
.main{
  width: 800px;
  height: 500px;
  margin: 0 auto;
  background-color: #ccc;
}
.left{
  width: 400px;
  height: 500px;
  float: left;
  background: url(../../assets/left.png) no-repeat;
  background-size: 400px 500px;
}
.right{
  width: 400px;
  height: 500px;
  float: right;
}
.header {
  margin-top: 25px;
  margin-left: 10px;
}
.top{
  width: 400px;
  margin-top: 40px;
  margin-bottom: 20px;
  font-size: 18px;
  font-weight: bold;
  text-align: center;
}
.content{
  width: 400px;
  display: flex;
  flex-direction: column;
  align-items: center;
}
.account{
  position: relative;
  flex: 1;
  width: 400px;
  height: 50px;
  text-align: center;
  margin-bottom: 20px;
}
.inputAccount{
  box-sizing: border-box;
  width: 80%;
  height: 35px;
  padding-left: 30px;
  font-size: 12px;
  border: 1px solid #ccc;
  border-radius: 5px;
  outline: none;
}
.icon1{
  position: absolute;
  left: 45px;
  top: 5px;
  width: 25px;
  height: 25px;
}
.password {
  position: relative;
  flex: 1;
  width: 400px;
  height: 50px;
  text-align: center;
  margin-bottom: 20px;
}

.inputPassword {
  box-sizing: border-box;
  width: 80%;
  height: 35px;
  padding-left: 30px;
  font-size: 12px;
  border: 1px solid #ccc;
  border-radius: 5px;
  outline: none;
}
.icon2 {
  position: absolute;
  left: 45px;
  top: 5px;
  width: 25px;
  height: 25px;
}
.code {
  position: relative;
  flex: 1;
  width: 400px;
  height: 50px;
  margin-bottom: 20px;
  margin-left: 82px;
}

.inputCode {
  box-sizing: border-box;
  width: 40%;
  height: 35px;
  padding-left: 30px;
  font-size: 12px;
  border: 1px solid #ccc;
  border-radius: 5px;
  outline: none;
}
.initCode {
  display: inline-block;
  width: 80px;
  height: 30px;
  line-height: 35px;
  text-align: center;
  background-color: #f0f0f0;
  border: 1px solid #ccc;
  border-radius: 5px;
  transform: translateY(3px);
  margin-left: 10px;
}

.change {
  display: inline-block;
  line-height: 35px;
  color: #007bff;
  cursor: pointer;
  margin-left: 10px;
}

.change:disabled {
  color: #ccc;
  cursor: not-allowed;
}
.icon3 {
  position: absolute;
  left: 5px;
  top: 5px;
  width: 25px;
  height: 25px;
}
.login{
  width: 80%;
  height: 35px;
  line-height: 35px;
  color: #fff;
  text-align: center;
  background-color: rgba(64,158,254);
}
.login:hover{
  cursor: pointer;
}
.bottom{
  width: 45%;
  height: 20px;
  margin: 20px auto;
}
.register{
  font-size: 14px;
  float: left;
  border-right: 3px solid rgba(64, 158, 254);
  padding-right: 33px;
}
.forget{
  font-size: 14px;
  float: right;
}
</style>