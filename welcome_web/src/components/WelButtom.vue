<script setup>
</script>

<template>
  <div class="buttom">
    <div class="qq">
      <img src="../assets/qq.jpg" alt="" class="img1">
    </div>
    <div class="words">
      版权:江西师范大学(Jiangxi Normal University) <br>
      ICP备案编号:赣B2-20050166号-1 <br>
      学校地址：[瑶湖校区]江西省南昌市紫阳大道99号 <br>
      邮政编码:330022
    </div>
    <div class="logo">
        <img src="../assets/homyit_logo.png" alt="" class="img2">
    </div>
  </div>
</template>

<style scoped>
* {
  box-sizing: border-box;
  padding: 0;
  margin: 0;
}

.buttom {
  display: flex;
  height: 180px;
  width: 100%;
  font-size: 15px;
  background-color: #2e9deb;
}
.img1 {
  height: 100px;
  width: 100px;
}
.img2 {
  width: 200px;
}
.qq {
  flex: 1;
  padding-left: 5%;
  padding-top: 3%;
  width: 8%;
}
.words {
  flex: 4;
  text-align: center;
  padding-top: 3%;
}
.logo {
  flex: 2;
  padding-top: 3%;
}

/* 响应式 */
@media (max-width: 1024px) {  
  .buttom {
    font-size: 13px;
  }

  .img1 {
    height: 80px;
    width: 80px;
  }

  .img2 {
  width: 150px;
  }
}  
  
@media (max-width: 768px) {  
  .buttom {
    font-size: 10px;
    height: 120px;
  }

  .img1 {
    height: 50px;
    width: 50px;
  }

  .img2 {
    width: 100px;
  }
}  
</style>