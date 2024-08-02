<script setup>
import {ref,watch} from 'vue'

// 1.创建响应式变量来存储name输入框的值
const input1Value = ref('')
// 1.创建图标的响应式变量
const inputIco1Name = ref('none')
const inputIco2Name = ref('none')
// 1.创建响应式变量来存储name测试的值
const inputTest1 = ref('none')
// 1.定义name的正则表达式
const rules1 = /^[\u4e00-\u9fa5]{2,4}$/
// 1.监听name变化
watch(input1Value,(newValue)=>{
    if (rules1.test(newValue)) {
        inputIco1Name.value = 'block'
        inputIco2Name.value = 'none'
        inputTest1.value = 'none'
      } else if(rules1.test(newValue)==='') {
        inputIco1Name.value = 'none'
        inputIco2Name.value = 'block'
        inputTest1.value = 'block'
      } else{
        inputIco1Name.value = 'none'
        inputIco2Name.value = 'block'
        inputTest1.value = 'block'
      }
})

// 2.创建响应式变量来存储number输入框的值
const input2Value = ref('')
// 2.创建图标的响应式变量
const inputIco1Number = ref('none')
const inputIco2Number = ref('none')
// 2.创建响应式变量来存储number测试的值
const inputTest2 = ref('none')
// 2.定义number的正则表达式
const rules2 = /^2024\d{8}$/
// 2.监听number变化
watch(input2Value,(newValue)=>{
    if (rules2.test(newValue)) {
        inputIco1Number.value = 'block'
        inputIco2Number.value = 'none'
        inputTest2.value = 'none'
      } else if(rules2.test(newValue)==='') {
        inputIco1Number.value = 'none'
        inputIco2Number.value = 'block'
        inputTest2.value = 'block'
      } else{
        inputIco1Number.value = 'none'
        inputIco2Number.value = 'block'
        inputTest2.value = 'block'
      }
})

// 3.创建响应式变量来存储Class输入框的值
const input3Value = ref('')
// 3.创建图标的响应式变量
const inputIco1Class = ref('none')
const inputIco2Class = ref('none')
// 3.创建响应式变量来存储Class测试的值
const inputTest3 = ref('none')
// 3.定义Class的正则表达式
const rules3 = /^[\u4e00-\u9fa5]+[\d]+班$/
// 3.监听Class变化
watch(input3Value,(newValue)=>{
    if (rules3.test(newValue)) {
        inputIco1Class.value = 'block'
        inputIco2Class.value = 'none'
        inputTest3.value = 'none'
      } else if(rules3.test(newValue)==='') {
        inputIco1Class.value = 'none'
        inputIco2Class.value = 'block'
        inputTest3.value = 'block'
      } else{
        inputIco1Class.value = 'none'
        inputIco2Class.value = 'block'
        inputTest3.value = 'block'
      }
})

// 4.创建响应式变量来存储Email输入框的值
const input4Value = ref('')
// 4.创建图标的响应式变量
const inputIco1Email = ref('none')
const inputIco2Email = ref('none')
// 4.创建响应式变量来存储Email测试的值
const inputTest4 = ref('none')
// 4.定义Email的正则表达式
const rules4 = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/
// 4.监听Email变化
watch(input4Value,(newValue)=>{
    if (rules4.test(newValue)) {
        inputIco1Email.value = 'block'
        inputIco2Email.value = 'none'
        inputTest4.value = 'none'
      } else if(rules4.test(newValue)==='') {
        inputIco1Email.value = 'none'
        inputIco2Email.value = 'block'
        inputTest4.value = 'block'
      } else{
        inputIco1Email.value = 'none'
        inputIco2Email.value = 'block'
        inputTest4.value = 'block'
      }
})
</script>

<template>
  <div class="container">
    <img class="join" src="../../assets/join.jpg" alt="">
    <div class="main">
      <form method="post" @submit.prevent="handleSubmit">
        <div class="top">
          <div class="register"><span>Register</span></div>
        </div>
        <div class="content">
          <div id="name">
            <span class="name">姓名</span>
            <input class="inputName" v-model="input1Value" placeholder="请输入你的姓名" type="text">
            <span><img class="icon1" :style="{display:inputIco1Name}" src="../../assets/1.ico" alt=""></span>
            <span><img class="icon2" :style="{display:inputIco2Name}" src="../../assets/2.ico" alt=""></span>
          </div>
          <div class="name-test" :style="{display:inputTest1}">请输入真实姓名</div>
          <div id="number">
            <span class="number">学号</span>
            <input class="inputNumber" v-model="input2Value" placeholder="请输入你的学号" type="text">
            <span><img class="icon1" :style="{display:inputIco1Number}" src="../../assets/1.ico" alt=""></span>
            <span><img class="icon2" :style="{display:inputIco2Number}" src="../../assets/2.ico" alt=""></span>
          </div>
          <div class="number-test" :style="{display:inputTest2}">学号应以2024开头,共12位</div>
          <div id="class">
            <span class="class">班级</span>
            <input class="inputClass" v-model="input3Value" placeholder="请输入你的班级" type="text">
            <span><img class="icon1" :style="{display:inputIco1Class}" src="../../assets/1.ico" alt=""></span>
            <span><img class="icon2" :style="{display:inputIco2Class}" src="../../assets/2.ico" alt=""></span>
          </div>
          <div class="class-test" :style="{display:inputTest3}">请输入正确的班级名称</div>
          <div id="email">
            <span class="email">邮箱</span>
            <input class="inputEmail" v-model="input4Value" placeholder="请输入你的邮箱" type="text">
            <span><img class="icon1" :style="{display:inputIco1Email}" src="../../assets/1.ico" alt=""></span>
            <span><img class="icon2" :style="{display:inputIco2Email}" src="../../assets/2.ico" alt=""></span>
          </div>
          <div class="email-test" :style="{display:inputTest4}">请输入正确邮箱地址</div>
          <div id="direction">
            <span class="direction">方向</span>
            <select class="choice">
              <option>请选择方向</option>
              <option>前端</option>
              <option>后端</option>
              <option>UI</option>
            </select>
          </div>
          <div id="selfIntroduction">
            <span class="selfIntroduction">自我介绍</span>
            <textarea class="inputSelfIntroduction"></textarea>
          </div>
          <button class="button" type="submit">Submit</button>
        </div>
      </form>
    </div>
  </div>
</template>

<style scoped>
*{
  margin: 0;
  padding: 0;
}
@media screen and (min-width:320px){
  .main{
    width: 240px;
  }      
}
@media screen and (min-width:360px){
  .main{
    width: 270px;
  }
}      
@media screen and (min-width:375px){
  .main{
    width: 282px;
  }     
}      
@media screen and (min-width:390px){
  .main{
    width: 294px;
  }      
}
@media screen and (min-width:405px){
  .main{
    width: 306px;
  }      
}
@media screen and (min-width:420px){
  .main{
    width: 318px;
  }      
}
@media screen and (min-width:480px){
  .main{
    width: 360px;
  }      
}
@media screen and (min-width:540px){
  .main{
    width: 405px;
  }      
}
.container{
  width: 100%;
  height: 80vh;
  position: relative;
}
.join{
  width: 100%;
  height: 100%;
  opacity: 1;
}
.main{
  position: absolute;
  top: 40px;
  left: 50%;
  transform: translateX(-50%);
  text-align: center;
  border-radius: 25px;
  overflow: hidden;
  border: 1px solid #ccc;
  background-color: rgba(255,255,255, .5);
  box-shadow: 10px 10px 20px rgba(25,0,0, .8);
}
.top{
  width: 100%;
  height: 50px;
  border-bottom: 1px solid rgb(238, 252, 255);
}
.register{
  text-align: center;
  line-height: 50px;
  color: #fff;
  font-size: 20px;
}
.register:hover{
  cursor: pointer;
}
.active{
  font-size: 20px;
  color: #2ea4bc;
}
.active span {
  border-bottom: 3px solid #2ea4bc;
  padding-bottom: 10px;
}
#name{
  padding-top: 10px;
  position: relative;
}
#name .name{
  display: inline-block;
  width: 50px;
  font-size: 16px;
  margin-left: -10px;
  color: gray;
}
#name .inputName{
  width: 70%;
  height: 35px;
  border-radius: 10px;
  border: 0;
  outline: none;
  padding-left: 6px;
  font-size: 12px;
}
.name-test{
  width: 100%;
  font-size: 12px;
  margin-top: 8px;
  color: red;
}
#number{
  padding-top: 10px;
  position: relative;
}
#number .number{
  display: inline-block;
  width: 50px;
  font-size: 16px;
  margin-left: -10px;
}
#number .inputNumber{
  width: 70%;
  height: 35px;
  border-radius: 10px;
  border: 0;
  outline: none;
  padding-left: 6px;
  font-size: 12px;
}
.number-test{
  width: 100%;
  font-size: 12px;
  margin-top: 8px;
  color: red;
}
#class{
  padding-top: 10px;
  position: relative;
}
#class .class{
  display: inline-block;
  width: 50px;
  font-size: 16px;
  margin-left: -10px;
}
#class .inputClass{
  width: 70%;
  height: 35px;
  border-radius: 10px;
  border: 0;
  outline: none;
  padding-left: 6px;
  font-size: 12px;
}
.class-test{
  width: 100%;
  font-size: 12px;
  margin-top: 8px;
  color: red;
}
#email{
  padding-top: 10px;
  position: relative;
}
#email .email{
  display: inline-block;
  width: 50px;
  font-size: 16px;
  margin-left: -10px;
}
#email .inputEmail{
  width: 70%;
  height: 35px;
  border-radius: 10px;
  border: 0;
  outline: none;
  padding-left: 6px;
  font-size: 12px;
}
.email-test{
  width: 100%;
  font-size: 12px;
  margin-top: 8px;
  color: red;
}
#direction{
  padding-top: 10px;
  position: relative;
}
#direction .direction{
  display: inline-block;
  width: 50px;
  font-size: 16px;
  margin-left: -15px;
}
.choice{
  width: 70%;
  height: 35px;
  border-radius: 10px;
  border: 0;
  outline: none;
  padding-left: 6px;
  font-size: 12px;
}
#selfIntroduction{
  padding-top: 10px;
  position: relative;
}
#selfIntroduction .selfIntroduction{
  display: inline-block;
  width: 65px;
  font-size: 14px;
  margin-left: -25px;
  transform: translateY(-15px);
}
#selfIntroduction .inputSelfIntroduction{
  width: 70%;
  height: 40px;
  border: 0;
  outline: none;
  padding-left: 6px;
  padding-top: 6px;
  font-size: 12px;
}
.button{
  position: relative;
  width: 100px;
  height: 50px;
  margin-top: 10px;
  margin-bottom: 10px;
  font-size: 25px;
  color: #333333;
  background-color: black;
  border: 0;
  overflow: hidden;
  transition: .5s;
  -webkit-box-reflect: below 1px linear-gradient(transparent,#0003);
}
.button:hover{
  background-color: #333333;
  color: #ccc;
  box-shadow: 0 0 50px #333333;
  transition-delay: .5s;
}
.button::before{
  content: '';
  position: absolute;
  top: 0;
  left: 0;
  width: 10px;
  height: 10px;
  border-left: 2px solid #ccc;
  border-top: 2px solid #ccc;
  transition: .5s;
}
.button::after{
  content: '';
  position: absolute;
  bottom: 0;
  right: 0;
  width: 10px;
  height: 10px;
  border-bottom: 2px solid #ccc;
  border-right: 2px solid #ccc;
  transition: .5s;
}
.button:hover::before,.button:hover::after{
  width: 100%;
  height: 100%;
}
.icon1{
  position: absolute;
  right: 40px;
  top: 18px;
}
.icon2{
  position: absolute;
  right: 40px;
  top: 18px;
}
</style>