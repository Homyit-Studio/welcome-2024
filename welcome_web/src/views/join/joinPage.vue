<script setup>
import {ref,watch} from 'vue'
import 'animate.css';
// 1.创建响应式变量来存储name输入框的值
const input1Value = ref('')
// 1.创建图标的响应式变量
const inputIco1Name = ref('none')
const inputIco2Name = ref('none')
// 1.创建响应式变量来存储name测试的值
const inputTest1 = ref(0)
// 1.定义name的正则表达式
const rules1 = /^[\u4e00-\u9fa5]{2,4}$/
// 1.监听name变化
watch(input1Value,(newValue)=>{
    if (rules1.test(newValue)) {
        inputIco1Name.value = 'block'
        inputIco2Name.value = 'none'
        inputTest1.value = 0
      } else if(rules1.test(newValue)==='') {
        inputIco1Name.value = 'none'
        inputIco2Name.value = 'block'
        inputTest1.value = 1
      } else{
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
const rules2 = /^2024\d{8}$/
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
const rules3 = /^[\u4e00-\u9fa5]+[\d]+班$/
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
</script>

<template>
  <div class="container">
    <img class="join1" src="../../assets/join1.png" alt="">
    <img class="join2" src="../../assets/join2.png" alt="">
    <div class="main">
      <form method="post" @submit.prevent="handleSubmit">
        <div class="top">
          <div class="register animate__animated animate__swing"><span>Register</span></div>
        </div>
        <div class="content">
          <div id="name">
            <span class="name">姓名</span>
            <input class="inputName" v-model="input1Value" placeholder="请输入你的姓名" type="text">
            <span><img class="icon1" :style="{display:inputIco1Name}" src="../../assets/1.ico" alt=""></span>
            <span><img class="icon2" :style="{display:inputIco2Name}" src="../../assets/2.ico" alt=""></span>
            <div class="name-test" :style="{opacity:inputTest1}">请输入真实姓名</div>
          </div>
          <div id="number">
            <span class="number">学号</span>
            <input class="inputNumber" v-model="input2Value" placeholder="请输入你的学号" type="text">
            <span><img class="icon1" :style="{display:inputIco1Number}" src="../../assets/1.ico" alt=""></span>
            <span><img class="icon2" :style="{display:inputIco2Number}" src="../../assets/2.ico" alt=""></span>
            <div class="number-test" :style="{opacity:inputTest2}">学号应以2024开头,共12位</div>
          </div>
          <div id="class">
            <span class="class">班级</span>
            <input class="inputClass" v-model="input3Value" placeholder="请输入你的班级" type="text">
            <span><img class="icon1" :style="{display:inputIco1Class}" src="../../assets/1.ico" alt=""></span>
            <span><img class="icon2" :style="{display:inputIco2Class}" src="../../assets/2.ico" alt=""></span>
            <div class="class-test" :style="{opacity:inputTest3}">请输入正确的班级名称</div>
          </div>
          <div id="email">
            <span class="email">邮箱</span>
            <input class="inputEmail" v-model="input4Value" placeholder="请输入你的邮箱" type="text">
            <span><img class="icon1" :style="{display:inputIco1Email}" src="../../assets/1.ico" alt=""></span>
            <span><img class="icon2" :style="{display:inputIco2Email}" src="../../assets/2.ico" alt=""></span>
            <div class="email-test" :style="{opacity:inputTest4}">请输入正确邮箱地址</div>
          </div>
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
  transform: translateY(60px);
  background: linear-gradient(to bottom,#f6f6f6, #B0E0E6);
  width: 100%;
  height: 90vh;
  position: relative;
}
.join1{
  position: absolute;
  top: 0;
  left: 0;
  width: 50%;
  height: 100%;
}
.join2{
  position: absolute;
  top: 0;
  right: 0;
  width: 50%;
  height: 100%;
}
.main{
  position: absolute;
  top: 60px;
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
  font-weight: 700;
  color: #122021;
  font-size: 20px;
}
.register:hover{
  cursor: pointer;
}
#name{
  padding-top: 5px;
  position: relative;
}
#name .name{
  display: inline-block;
  width: 50px;
  font-size: 15px;
  margin-left: -10px;
  color: black;
}
#name .inputName{
  width: 70%;
  height: 35px;
  border-radius: 10px;
  border: 2px solid #ccc;
  outline: none;
  padding-left: 6px;
  font-size: 12px;
}
.name-test{
  font-size: 10px;
  margin-top: 4px;
  color: red;
}
#number{
  padding-top: 5px;
  position: relative;
}
#number .number{
  display: inline-block;
  width: 50px;
  font-size: 15px;
  margin-left: -10px;
}
#number .inputNumber{
  width: 70%;
  height: 35px;
  border-radius: 10px;
  border: 2px solid #ccc;
  outline: none;
  padding-left: 6px;
  font-size: 12px;
}
.number-test{
  font-size: 10px;
  margin-top: 4px;
  color: red;
}
#class{
  padding-top: 5px;
  position: relative;
}
#class .class{
  display: inline-block;
  width: 50px;
  font-size: 15px;
  margin-left: -10px;
}
#class .inputClass{
  width: 70%;
  height: 35px;
  border-radius: 10px;
  border: 2px solid #ccc;
  outline: none;
  padding-left: 6px;
  font-size: 12px;
}
.class-test{
  font-size: 10px;
  margin-top: 4px;
  color: red;
}
#email{
  padding-top: 5px;
  position: relative;
}
#email .email{
  display: inline-block;
  width: 50px;
  font-size: 15px;
  margin-left: -10px;
}
#email .inputEmail{
  width: 70%;
  height: 35px;
  border-radius: 10px;
  border: 2px solid #ccc;
  outline: none;
  padding-left: 6px;
  font-size: 12px;
}
.email-test{
  font-size: 10px;
  margin-top: 4px;
  color: red;
}
#direction{
  padding-top: 5px;
  position: relative;
}
#direction .direction{
  display: inline-block;
  width: 50px;
  font-size: 15px;
  margin-left: -12px;
}
.choice{
  width: 70%;
  height: 35px;
  border-radius: 10px;
  border: 2px solid #ccc;
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
  font-size: 15px;
  margin-left: -25px;
  transform: translateY(-15px);
}
#selfIntroduction .inputSelfIntroduction{
  width: 70%;
  height: 40px;
  border: 2px solid #ccc;
  outline: none;
  padding-left: 6px;
  padding-top: 6px;
  font-size: 12px;
}
.button{
  position: relative;
  width: 80px;
  height: 40px;
  margin-top: 10px;
  margin-bottom: 10px;
  font-size: 20px;
  color: #21ebff;
  background-color: #fff;
  border: 0;
  overflow: hidden;
  transition: .5s;
  -webkit-box-reflect: below 1px linear-gradient(transparent,#0003);
}
.button:hover{
  background-color: #21ebff;
  color: #111;
  box-shadow: 0 0 50px #21ebff;
  transition-delay: .5s;
}
.button::before{
  content: '';
  position: absolute;
  top: 0;
  left: 0;
  width: 10px;
  height: 10px;
  border-left: 2px solid #21ebff;
  border-top: 2px solid #21ebff;
  transition: .5s;
}
.button::after{
  content: '';
  position: absolute;
  bottom: 0;
  right: 0;
  width: 10px;
  height: 10px;
  border-bottom: 2px solid #21ebff;
  border-right: 2px solid #21ebff;
  transition: .5s;
}
.button:hover::before,.button:hover::after{
  width: 100%;
  height: 100%;
}
.icon1{
  position: absolute;
  right: 50px;
  top: 10px;
}
.icon2{
  position: absolute;
  right: 50px;
  top: 10px;
}
</style>