<script setup>

</script>

<template>
  <div class="container">
    <div class="main">
      <form method="post">
        <div class="top">
          <div class="register"><span>Register</span></div>
        </div>
        <div class="content">
          <div id="name">
            <span class="name">姓名</span>
            <input class="inputName" placeholder="请输入你的姓名" type="text">
          </div>
          <div class="name-test"></div>
          <div id="number">
            <span class="number">学号</span>
            <input class="inputNumber" placeholder="请输入你的学号" type="text">
          </div>
          <div class="number-test"></div>
          <div id="class">
            <span class="class">班级</span>
            <input class="inputClass" placeholder="请输入你的班级" type="text">
          </div>
          <div class="class-test"></div>
          <div id="email">
            <span class="email">邮箱</span>
            <input class="inputEmail" placeholder="请输入你的邮箱" type="text">
          </div>
          <div class="email-test"></div>
          <div id="direction">
            <span class="direction">方向</span>
            <input class="inputDirection" placeholder="请输入你想学的方向" type="text">
          </div>
          <div class="direction-test"></div>
          <div id="selfIntroduction">
            <span class="selfIntroduction">自我介绍</span>
            <textarea class="inputSelfIntroduction"></textarea>
          </div>
          <button class="button">Submit</button>
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
.container{
  width: 100%;
  height: 675px;
  position: relative;
}
.main{
  width: 350px;
  height: 550px;
  position: absolute;
  top: 50%;
  left: 50%;
  background-color: rgb(173, 200, 234);
  transform: translate(-50%,-50%);
  border-radius: 25px;
  overflow: hidden;
  border: 1px solid #ccc;
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
  padding-top: 20px;
  position: relative;
}
#name .name{
  display: inline-block;
  width: 50px;
  font-size: 20px;
  margin-left: 20px;
}
#name .inputName{
  width: 70%;
  height: 40px;
  border-radius: 10px;
  border: 0;
  padding-left: 6px;
  font-size: 16px;
}
#number{
  padding-top: 20px;
  position: relative;
}
#number .number{
  display: inline-block;
  width: 50px;
  font-size: 20px;
  margin-left: 20px;
}
#number .inputNumber{
  width: 70%;
  height: 40px;
  border-radius: 10px;
  border: 0;
  padding-left: 6px;
  font-size: 16px;
}
#class{
  padding-top: 20px;
  position: relative;
}
#class .class{
  display: inline-block;
  width: 50px;
  font-size: 20px;
  margin-left: 20px;
}
#class .inputClass{
  width: 70%;
  height: 40px;
  border-radius: 10px;
  border: 0;
  padding-left: 6px;
  font-size: 16px;
}
#email{
  padding-top: 20px;
  position: relative;
}
#email .email{
  display: inline-block;
  width: 50px;
  font-size: 20px;
  margin-left: 20px;
}
#email .inputEmail{
  width: 70%;
  height: 40px;
  border-radius: 10px;
  border: 0;
  padding-left: 6px;
  font-size: 16px;
}
#direction{
  padding-top: 20px;
  position: relative;
}
#direction .direction{
  display: inline-block;
  width: 50px;
  font-size: 20px;
  margin-left: 20px;
}
#direction .inputDirection{
  width: 70%;
  height: 40px;
  border-radius: 10px;
  border: 0;
  padding-left: 6px;
  font-size: 16px;
}
#selfIntroduction{
  padding-top: 20px;
  position: relative;
}
#selfIntroduction .selfIntroduction{
  position: absolute;
  top: 20px;
  left: 20px;
  display: inline-block;
  width: 50px;
  font-size: 20px;
  /* margin-left: 20px; */
}
#selfIntroduction .inputSelfIntroduction{
  width: 70%;
  height: 60px;
  margin-left: 70px;
  padding-left: 6px;
  padding-top: 5px;
  font-size: 16px;
}
.button{
  width: 100px;
  height: 70px;
  background-color: skyblue;
  margin-top: 20px;
  margin-left: 120px;
  text-align: center;
  font-size: 25px;
  color: purple;
}
</style>