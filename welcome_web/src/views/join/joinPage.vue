<script setup>
import {ref,watch} from 'vue'
import axios from 'axios'
import 'animate.css'
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
const rules4 = /.+/
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

// 表单提交处理函数
const handleSubmit = async () => {
  if(!input1Value.value || !input2Value.value || !input3Value.value || !input4Value.value){
    alert('请输入完整的信息')
    return
  }
  if(inputTest1.value === 1 || inputTest2.value === 1 || inputTest3.value === 1 || inputTest4.value === 1){
    alert('请输入正确的信息')
    return
  }
  const postData = {
    name:input1Value.value,
    number:input2Value.value,
    class:input3Value.value,
    email:input4Value.value
  }
  try{
    const response = await axios.post('url',postData)
    alert('提交成功')
    console.log(response.data)
  }catch(error){
    console.error(error)
    alert('提交失败,请稍后再试')
  }
}
</script>

<template>
  <div class="container">
    <img class="left animate__animated animate__fadeInRight animate__slow 1s" src="../../assets/join-left.png" alt="">
    <img class="right animate__animated animate__fadeInLeft animate__slow 1s" src="../../assets/join-right.png" alt="">
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
            <div class="number-test" :style="{opacity:inputTest2}">学号应该共12位</div>
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
  .left{
  position: absolute;
  top: 22%;
  left: 0;
  width: 120px;
  height: 120px;
  }
  .right{
  position: absolute;
  top: 22%;
  right: 0;
  width: 120px;
  height: 120px;
  }
  img{
  width: 100%;
  height: 100%;
}      
}
@media screen and (min-width:360px){
  .main{
    width: 270px;
  }
  .left{
  position: absolute;
  top: 22%;
  left: 0;
  width: 135px;
  height: 135px;
  }
  .right{
  position: absolute;
  top: 22%;
  right: 0;
  width: 135px;
  height: 135px;
  }
  img{
  width: 100%;
  height: 100%;
}
}      
@media screen and (min-width:375px){
  .main{
    width: 282px;
  }
  .left{
  position: absolute;
  top: 22%;
  left: 0;
  width: 140px;
  height: 140px;
  }
  .right{
  position: absolute;
  top: 22%;
  right: 0;
  width: 140px;
  height: 140px;
  }
  img{
  width: 100%;
  height: 100%;
}     
}      
@media screen and (min-width:390px){
  .main{
    width: 294px;
  }
  .left{
  position: absolute;
  top: 22%;
  left: 0;
  width: 146px;
  height: 146px;
  }
  .right{
  position: absolute;
  top: 22%;
  right: 0;
  width: 146px;
  height: 146px;
  }
  img{
  width: 100%;
  height: 100%;
}      
}
@media screen and (min-width:405px){
  .main{
    width: 306px;
  }
  .left{
  position: absolute;
  top: 22%;
  left: 0;
  width: 152px;
  height: 152px;
  }
  .right{
  position: absolute;
  top: 22%;
  right: 0;
  width: 152px;
  height: 152px;
  }
  img{
  width: 100%;
  height: 100%;
}      
}
@media screen and (min-width:420px){
  .main{
    width: 318px;
  }
  .left{
  position: absolute;
  top: 22%;
  left: 0;
  width: 157px;
  height: 157px;
  }
  .right{
  position: absolute;
  top: 22%;
  right: 0;
  width: 157px;
  height: 157px;
  }
  img{
  width: 100%;
  height: 100%;
}      
}
@media screen and (min-width:480px){
  .main{
    width: 360px;
  }
  .left{
  position: absolute;
  top: 22%;
  left: 0;
  width: 180px;
  height: 180px;
  }
  .right{
  position: absolute;
  top: 22%;
  right: 0;
  width: 180px;
  height: 180px;
  }
  img{
  width: 100%;
  height: 100%;
}      
}
@media screen and (min-width:540px){
  .main{
    width: 405px;
  }
  .left{
  position: absolute;
  top: 22%;
  left: 0;
  width: 202px;
  height: 202px;
  }
  .right{
  position: absolute;
  top: 22%;
  right: 0;
  width: 202px;
  height: 202px;
  }
  img{
  width: 100%;
  height: 100%;
  }      
}
@media screen and (min-width:750px){
  .left{
  position: absolute;
  top: 22%;
  left: 0;
  width: 281px;
  height: 281px;
  }
  .right{
  position: absolute;
  top: 22%;
  right: 0;
  width: 281px;
  height: 281px;
  }
  img{
  width: 100%;
  height: 100%;
  }      
}
@media screen and (min-width:970px){
  .main{
    width: 405px;
  }
  .left{
  position: absolute;
  top: 22%;
  left: 0;
  width: 364px;
  height: 364px;
  }
  .right{
  position: absolute;
  top: 22%;
  right: 0;
  width: 364px;
  height: 364px;
  }
  img{
  width: 100%;
  height: 100%;
  }      
}
@media screen and (min-width:1120px){
  .main{
    width: 405px;
  }
  .left{
  position: absolute;
  top: 22%;
  left: 0;
  width: 420px;
  height: 420px;
  }
  .right{
  position: absolute;
  top: 22%;
  right: 0;
  width: 420px;
  height: 420px;
  }
  img{
  width: 100%;
  height: 100%;
  }      
}
.container{
  transform: translateY(60px);
  width: 100%;
  height: 100vh;
  position: relative;
  margin-bottom: 60px;
  background: url(../../assets/join.jpg) no-repeat;
}
.main{
  position: relative;
  margin: 0 auto;
  height: 470px;
  transform: translateY(140px);
  text-align: center;
  border-radius: 25px;
  overflow: hidden;
  border: 1px solid #ccc;
  background-color: rgba(255,255,255, .5);
  box-shadow: 10px 10px 20px rgba(25,0,0, .5);
}
.top{
  position: absolute;
  top: 0px;
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
  position: absolute;
  top: 55px;
  left: -5%;
  position: relative;
}
#name .name{
  position: absolute;
  display: inline-block;
  width: 50px;
  font-size: 15px;
  top: 5px;
  left: 33px;
  color: black;
}
#name .inputName{
  position: absolute;
  top: 0;
  left: 80px;
  width: 70%;
  height: 35px;
  border-radius: 10px;
  border: 2px solid #ccc;
  outline: none;
  padding-left: 6px;
  font-size: 12px;
}
.name-test{
  position: absolute;
  top: 30px;
  left: 88px;
  font-size: 10px;
  margin-top: 4px;
  color: red;
}
#number{
  position: absolute;
  top: 110px;
  left: -5%;
  position: relative;
}
#number .number{
  position: absolute;
  display: inline-block;
  width: 50px;
  font-size: 15px;
  top: 5px;
  left: 33px;
  color: black;
}
#number .inputNumber{
  position: absolute;
  top: 0;
  left: 80px;
  width: 70%;
  height: 35px;
  border-radius: 10px;
  border: 2px solid #ccc;
  outline: none;
  padding-left: 6px;
  font-size: 12px;
}
.number-test{
  position: absolute;
  top: 30px;
  left: 88px;
  font-size: 10px;
  margin-top: 4px;
  color: red;
}
#class{
  position: absolute;
  top: 170px;
  left: -5%;
  position: relative;
}
#class .class{
  position: absolute;
  top: 5px;
  left: 33px;
  color: black;
  display: inline-block;
  width: 50px;
  font-size: 15px;
}
#class .inputClass{
  position: absolute;
  top: 0;
  left: 80px;
  width: 70%;
  height: 35px;
  border-radius: 10px;
  border: 2px solid #ccc;
  outline: none;
  padding-left: 6px;
  font-size: 12px;
}
.class-test{
  position: absolute;
  top: 30px;
  left: 88px;
  font-size: 10px;
  margin-top: 4px;
  color: red;
}
#email{
  position: absolute;
  top: 230px;
  left: -5%;
  position: relative;
}
#email .email{
  position: absolute;
  top: 5px;
  left: 33px;
  color: black;
  display: inline-block;
  width: 50px;
  font-size: 15px;
}
#email .inputEmail{
  position: absolute;
  top: 0;
  left: 80px;
  width: 70%;
  height: 35px;
  border-radius: 10px;
  border: 2px solid #ccc;
  outline: none;
  padding-left: 6px;
  font-size: 12px;
}
.email-test{
  position: absolute;
  top: 30px;
  left: 88px;
  font-size: 10px;
  margin-top: 4px;
  color: red;
}
#direction{
  position: absolute;
  top: 290px;
  left: -5%;
  position: relative;
}
#direction .direction{
  position: absolute;
  top: 5px;
  left: 33px;
  color: black;
  display: inline-block;
  width: 50px;
  font-size: 15px;
}
.choice{
  position: absolute;
  top: 0;
  left: 80px;
  width: 70%;
  height: 35px;
  border-radius: 10px;
  border: 2px solid #ccc;
  outline: none;
  padding-left: 6px;
  font-size: 12px;
}
#selfIntroduction{
  position: absolute;
  top: 350px;
  left: -5%;
  position: relative;
}
#selfIntroduction .selfIntroduction{
  position: absolute;
  top: 20px;
  left: 40px;
  color: black;
  display: inline-block;
  width: 30px;
  font-size: 15px;
  transform: translateY(-22px);
}
#selfIntroduction .inputSelfIntroduction{
  position: absolute;
  top: 0;
  left: 80px;
  width: 70%;
  height: 40px;
  border: 2px solid #ccc;
  outline: none;
  padding-left: 6px;
  padding-top: 6px;
  font-size: 12px;
}
.button{
  position: absolute;
  top: 410px;
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
  cursor: pointer;
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
  width: 20px;
  height: 20px;
  right: 12%;
  top: 8px;
}
.icon2{
  position: absolute;
  width: 20px;
  height: 20px;
  right: 12%;
  top: 8px;
}
</style>