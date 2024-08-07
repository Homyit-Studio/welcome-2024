<script setup>
import {ref,watch} from 'vue'
import axios from 'axios'
import 'animate.css'
import {CircleCheckFilled,CircleCloseFilled} from '@element-plus/icons-vue'

// alert弹出警告
const currentAlert = ref('')

// 1.创建响应式变量来存储name输入框的值
const input1Value = ref('')
// 1.创建图标的响应式变量
const inputIco1Name = ref('none')
const inputIco2Name = ref('none')
// 1.创建响应式变量来存储name测试的值
const inputTest1 = ref(0)
// 1.定义name的正则表达式
const rules1 = /.+/
// 1.监听name变化
watch(input1Value,(newValue)=>{
    if (rules1.test(newValue)) {
        inputIco1Name.value = 'block'
        inputIco2Name.value = 'none'
        inputTest1.value = 0
      }else{
        inputIco1Name.value = 'none'
        inputIco2Name.value = 'block'
        inputTest1.value = 1
      }
})

// 2.创建响应式变量来存储number输入框的值
const input2Value = ref('')
// 2.创建图标的响应式变量
const inputIco1Number = ref('none')
const inputIco2Number = ref('none')
// 2.创建响应式变量来存储number测试的值
const inputTest2 = ref(0)
// 2.定义number的正则表达式
const rules2 = /^\d{12}$/
// 2.监听number变化
watch(input2Value,(newValue)=>{
    if (rules2.test(newValue)) {
        inputIco1Number.value = 'block'
        inputIco2Number.value = 'none'
        inputTest2.value = 0
      } else if(rules2.test(newValue)==='') {
        inputIco1Number.value = 'none'
        inputIco2Number.value = 'block'
        inputTest2.value = 1
      } else{
        inputIco1Number.value = 'none'
        inputIco2Number.value = 'block'
        inputTest2.value = 1
      }
})

// 3.创建响应式变量来存储Class输入框的值
const input3Value = ref('')
// 3.创建图标的响应式变量
const inputIco1Class = ref('none')
const inputIco2Class = ref('none')
// 3.创建响应式变量来存储Class测试的值
const inputTest3 = ref(0)
// 3.定义Class的正则表达式
const rules3 = /.+/
// 3.监听Class变化
watch(input3Value,(newValue)=>{
    if (rules3.test(newValue)) {
        inputIco1Class.value = 'block'
        inputIco2Class.value = 'none'
        inputTest3.value = 0
      } else if(rules3.test(newValue)==='') {
        inputIco1Class.value = 'none'
        inputIco2Class.value = 'block'
        inputTest3.value = 1
      } else{
        inputIco1Class.value = 'none'
        inputIco2Class.value = 'block'
        inputTest3.value = 1
      }
})

// 4.创建响应式变量来存储Email输入框的值
const input4Value = ref('')
// 4.创建图标的响应式变量
const inputIco1Email = ref('none')
const inputIco2Email = ref('none')
// 4.创建响应式变量来存储Email测试的值
const inputTest4 = ref(0)
// 4.定义Email的正则表达式
const rules4 = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/
// 4.监听Email变化
watch(input4Value,(newValue)=>{
    if (rules4.test(newValue)) {
        inputIco1Email.value = 'block'
        inputIco2Email.value = 'none'
        inputTest4.value = 0
      } else if(rules4.test(newValue)==='') {
        inputIco1Email.value = 'none'
        inputIco2Email.value = 'block'
        inputTest4.value = 1
      } else{
        inputIco1Email.value = 'none'
        inputIco2Email.value = 'block'
        inputTest4.value = 1
      }
})

// 5.获取选中的方向
const selectDirection = ref('')

// 6.获取自我介绍
const input6Value = ref('')

// 表单提交处理函数
const handleSubmit = async () => {
  // 清除之前的警告
  currentAlert.value = ''
  // 检查输入是否为空
  if(!input1Value.value || !input2Value.value || !input3Value.value || !input4Value.value){
    currentAlert.value = 'emptyFields'
    return
  }
  // 检查输入是否错误
  if(inputTest1.value === 1 || inputTest2.value === 1 || inputTest3.value === 1 || inputTest4.value === 1){
    currentAlert.value = 'inputError'
    return
  }
  const postData = {
    name:input1Value.value,
    number:input2Value.value,
    class:input3Value.value,
    email:input4Value.value,
    direction:selectDirection.value,
    selfIntroduction:input6Value.value
  }
  try{
    const response = await axios.post('http://8.136.124.250:8080/baoming',postData)
    currentAlert.value = 'success'
    console.log(response.data)
  }catch(error){
    currentAlert.value = 'requestFailed'
    console.error(error)
  }
}
</script>

<template>
      <el-alert
        v-if="currentAlert === 'success'"
        title="Success alert"
        type="success"
        description="注册成功"
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
        description="请输入正确的信息"
        show-icon
        class="custom-alert"
      />
      <el-alert
        v-if="currentAlert === 'requestFailed'"
        title="Error alert"
        type="error"
        description="提交失败,请稍后再试"
        show-icon
        class="custom-alert"
      />
  <div class="container">
      <form method="post" id="main" @submit.prevent="handleSubmit">
        <div class="top">
          <div class="register animate__animated animate__swing"><span>Register</span></div>
        </div>
        <div class="content">
          <div id="name">
            <span class="name">姓名</span>
            <input class="inputName" v-model="input1Value" placeholder="请输入你的姓名" type="text">
            <el-icon size="25" class="icon1" :style="{display:inputIco1Name}" ><CircleCheckFilled /></el-icon>
            <el-icon size="25" class="icon2" :style="{display:inputIco2Name}" ><CircleCloseFilled /></el-icon>
            <div class="name-test" :style="{opacity:inputTest1}">请输入真实姓名</div>
          </div>
          <div id="number">
            <span class="number">学号</span>
            <input class="inputNumber" v-model="input2Value" placeholder="请输入你的学号" type="text">
            <el-icon size="25" class="icon1" :style="{display:inputIco1Number}" ><CircleCheckFilled /></el-icon>
            <el-icon size="25" class="icon2" :style="{display:inputIco2Number}" ><CircleCloseFilled /></el-icon>
            <div class="number-test" :style="{opacity:inputTest2}">学号应该共12位</div>
          </div>
          <div id="class">
            <span class="class">班级</span>
            <input class="inputClass" v-model="input3Value" placeholder="请输入你的班级" type="text">
            <el-icon size="25" class="icon1" :style="{display:inputIco1Class}" ><CircleCheckFilled /></el-icon>
            <el-icon size="25" class="icon2" :style="{display:inputIco2Class}" ><CircleCloseFilled /></el-icon>
            <div class="class-test" :style="{opacity:inputTest3}">请输入正确的班级名称</div>
          </div>
          <div id="email">
            <span class="email">邮箱</span>
            <input class="inputEmail" v-model="input4Value" placeholder="请输入你的邮箱" type="text">
            <el-icon size="25" class="icon1" :style="{display:inputIco1Email}" ><CircleCheckFilled /></el-icon>
            <el-icon size="25" class="icon2" :style="{display:inputIco2Email}" ><CircleCloseFilled /></el-icon>
            <div class="email-test" :style="{opacity:inputTest4}">请输入正确邮箱地址</div>
          </div>
          <div id="direction">
            <span class="direction">方向</span>
            <select class="choice" v-model="selectDirection">
              <option disabled value="">请选择方向</option>
              <option value="前端">前端</option>
              <option value="后端">后端</option>
              <option value="UI">UI</option>
            </select>
          </div>
          <div id="selfIntroduction">
            <span class="selfIntroduction">自我介绍</span>
            <textarea class="inputSelfIntroduction" style="resize: none;" v-model="input6Value"></textarea>
          </div>
          <button class="button" type="submit">Submit</button>
        </div>
      </form>
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
.container{
  display: flex;
  align-items: center;
  width: 100%;
  height: 115vh;
  transform: translateY(60px);
  margin: 0 auto;
  overflow: hidden;
  background: url(../../assets/join.jpg) no-repeat;
  margin-bottom: 60px;
}
#main{
  width: 500px;
  height: 500px;
  margin: 0 auto;
  transform: translateY(-40px);
  display: flex;
  flex-direction: column;
  align-items: center;
  overflow: hidden;
  border: 2px solid #ccc;
  border-radius: 40px;
  box-shadow: 10px 10px 20px #ddd;
}
.top{
  width: 100%;
  text-align: center;
  height: 50px;
  font-size: 25px;
  line-height: 50px;
}
.content{
  width: 100%;
  flex: 1;
  display: flex;
  flex-direction: column;
  align-items: center;
}
#name{
  flex: 1;
  position: relative;
  width: 100%;
  height: 40px;
}
#name .name{
  position: absolute;
  width: 9%;
  height: 40px;
  top: 5%;
  left: 10%;
  font-size: 20px;
}
#name .inputName{
  position: absolute;
  width: 70%;
  height: 40px;
  top: 0;
  left: 20%;
  border-radius: 10px;
  border: 1px solid gray;
  outline: none;
  padding-left: 5px;
}
#name .name-test{
  position: absolute;
  width: 60%;
  bottom: 10%;
  left: 22%;
  font-size: 12px;
  color: #F56C6C;
}
#number{
  flex: 1;
  position: relative;
  width: 100%;
  height: 40px;
}
#number .number{
  position: absolute;
  width: 9%;
  height: 40px;
  top: 5%;
  left: 10%;
  font-size: 20px;
}
#number .inputNumber{
  position: absolute;
  width: 70%;
  height: 40px;
  top: 0;
  left: 20%;
  border-radius: 10px;
  border: 1px solid gray;
  outline: none;
  padding-left: 5px;
}
#number .number-test{
  position: absolute;
  width: 60%;
  bottom: 10%;
  left: 22%;
  font-size: 12px;
  color: #F56C6C;
}
#class{
  flex: 1;
  position: relative;
  width: 100%;
  height: 40px;
}
#class .class{
  position: absolute;
  width: 9%;
  height: 40px;
  top: 5%;
  left: 10%;
  font-size: 20px;
}
#class .inputClass{
  position: absolute;
  width: 70%;
  height: 40px;
  top: 0;
  left: 20%;
  border-radius: 10px;
  border: 1px solid gray;
  outline: none;
  padding-left: 5px;
}
#class .class-test{
  position: absolute;
  width: 60%;
  bottom: 10%;
  left: 22%;
  font-size: 12px;
  color:#F56C6C;
;
}
#email{
  flex: 1;
  position: relative;
  width: 100%;
  height: 40px;
}
#email .email{
  position: absolute;
  width: 9%;
  height: 40px;
  top: 5%;
  left: 10%;
  font-size: 20px;
}
#email .inputEmail{
  position: absolute;
  width: 70%;
  height: 40px;
  top: 0;
  left: 20%;
  border-radius: 10px;
  border: 1px solid gray;
  outline: none;
  padding-left: 5px;
}
#email .email-test{
  position: absolute;
  width: 60%;
  bottom: 10%;
  left: 22%;
  font-size: 12px;
  color: #F56C6C;
}
#direction{
  flex: 1;
  position: relative;
  width: 100%;
  height: 40px;
}
#direction .direction{
  position: absolute;
  width: 9%;
  height: 40px;
  top: 5%;
  left: 10%;
  font-size: 20px;
}
#direction .choice{
  position: absolute;
  width: 70%;
  height: 40px;
  top: 0;
  left: 20%;
  border-radius: 10px;
  border: 1px solid gray;
  outline: none;
  padding-left: 5px;
}
#selfIntroduction{
  flex: 1;
  position: relative;
  width: 100%;
  height: 40px;
}
#selfIntroduction .selfIntroduction{
  position: absolute;
  width: 17%;
  height: 55px;
  top: 16%;
  left: 2%;
  font-size: 20px;
}
#selfIntroduction .inputSelfIntroduction{
  position: absolute;
  width: 70%;
  height: 55px;
  top: 0;
  left: 20%;
  border-radius: 10px;
  border: 1px solid gray;
  outline: none;
  padding-top: 5px;
  padding-left: 5px;
}
.icon1{
  color: green;
  position: absolute;
  top: 15%;
  right: 12%;
}
.icon2{
  color: red;
  position: absolute;
  top: 15%;
  right: 12%;
}
.button{
  width: 90px;
  height: 50px;
  font-size: 20px;
  margin-bottom: 10px;
}
.button:hover{
  cursor: pointer;
}
@media screen and (min-width:350px){
#main{
  width: 300px;
  transform: translateY(-30px);
}
#name .name{
  width: 11%;
  top: 10%;
  left: 8%;
  font-size: 16px;
}
#name .name-test{
  font-size: 11px;
}
#number .number{
  width: 11%;
  top: 10%;
  left: 8%;
  font-size: 16px;
}
#number .number-test{
  font-size: 11px;
}
#class .class{
  width: 11%;
  top: 10%;
  left: 8%;
  font-size: 16px;
}
#class .class-test{
  font-size: 11px;
}
#email .email{
  width: 11%;
  top: 10%;
  left: 8%;
  font-size: 16px;
}
#email .email-test{
  font-size: 11px;
}
#direction .direction{
  width: 11%;
  top: 10%;
  left: 8%;
  font-size: 16px;
}
#selfIntroduction .selfIntroduction{
  width: 11%;
  top: 10%;
  left: 8%;
  font-size: 16px;
}
.button{
  width: 80px;
  height: 50px;
  font-size: 20px;
  margin-bottom: 10px;
}
}

@media screen and (min-width:390px){
#main{
  width: 334px;
  transform: translateY(-40px);
}
}
@media screen and (min-width:430px){
#main{
  width: 368px;
  transform: translateY(-40px);
}
}
@media screen and (min-width:720px){
#main{
  width: 450px;
  transform: translateY(-40px);
}
#name .name{
  width: 11%;
  top: 10%;
  left: 10%;
  font-size: 18px;
}
#name .name-test{
  font-size: 12px;
}
#number .number{
  width: 11%;
  top: 10%;
  left: 10%;
  font-size: 18px;
}
#number .number-test{
  font-size: 12px;
}
#class .class{
  width: 11%;
  top: 10%;
  left: 10%;
  font-size: 18px;
}
#class .class-test{
  font-size: 12px;
}
#email .email{
  width: 11%;
  top: 10%;
  left: 10%;
  font-size: 18px;
}
#email .email-test{
  font-size: 12px;
}
#direction .direction{
  width: 11%;
  top: 10%;
  left: 10%;
  font-size: 18px;
}
#selfIntroduction .selfIntroduction{
  width: 11%;
  top: 5%;
  left: 10%;
  font-size: 18px;
}
}
@media screen and (min-width:970px){
#main{
  width: 480px;
  transform: translateY(-100px);
}
}
@media screen and (min-width:1170px){
#main{
  width: 500px;
  transform: translateY(-120px);
}
#name .name{
  left: 9%;
  top: 5%;
  font-size: 20px;
}
#number .number{
  left: 9%;
  top: 5%;
  font-size: 20px;
}
#class .class{
  left: 9%;
  top: 5%;
  font-size: 20px;
}
#email .email{
  left: 9%;
  top: 5%;
  font-size: 20px;
}
#direction .direction{
  left: 9%;
  top: 5%;
  font-size: 20px;
}
#selfIntroduction .selfIntroduction{
  width: 11%;
  top: 2%;
  left: 9%;
  font-size: 20px;
}
}
</style>