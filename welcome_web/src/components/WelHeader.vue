<script setup>  

</script>  
  
<template>  
  <div class="header">  
    <div class="img">  
      <img src="@/assets/homyit_logo.png" alt="Logo">  
    </div>  
    <div class="guide">  
      <router-link to="/index" class="nav-link">Index</router-link>  
      <router-link to="/about" class="nav-link">About</router-link>  
      <router-link to="/employment" class="nav-link">Employment</router-link>  
      <router-link to="/join" class="nav-link">Join</router-link>  
    </div>  
  </div>  
</template>  
  
<style scoped>  
.header {  
  display: flex;  
  justify-content: space-between;  
  align-items: center;  
  width: 100%;  
  height: 60px;  
  background-color: #ffffff;  
  position: relative;  
  overflow: hidden;  
  position: fixed;
  z-index: 1000;
}  
  
.header .img {  
  width: 13%;  
  padding-left: 2%;  
}  
  
.header .img img {  
  width: 100%;  
  display: block;  
}  
  
.guide {  
  display: flex;  
  align-items: center;  
}  
  
.guide .nav-link {  
  position: relative;  
  display: inline-flex;  
  align-items: center;  
  justify-content: center;  
  margin: 0 15px;  
  color: #000;  
  font: 800 15px '优设标题黑';  
  text-decoration: none;  
  padding: 10px 20px;  
  border-radius: 5px;  
  transition: all 0.5s ease;  
  overflow: hidden;  
}  
  
.guide .nav-link::before {  
  content: '';  
  position: absolute;  
  top: 0;  
  left: -100%;  
  width: 100%;  
  height: 100%;  
  background: linear-gradient(120deg, #aac3d4, #9ebfd5);  
  transition: all 0.5s ease;  
  z-index: -1;  
  border-radius: 5px;  
}  
  
.guide .nav-link:hover::before {  
  left: 0;  
}  
  
.guide .nav-link:hover {  
  color: #ffffff;    
}  
  
.guide .nav-link.router-link-active {  
  color: #ffffff;  
  background: linear-gradient(120deg, #aac3d4, #9ebfd5);  
}  
  
.guide .nav-link.router-link-active::before {  
  left: 0;  
  opacity: 0;  
}  
  
/* 响应式 */
@media (max-width: 1024px) {  
  .header .img {  
    width: 15%;  
    padding-left: 1%;  
  }  
  
  .guide .nav-link {  
    margin: 0 10px;  
    padding: 8px 15px;  
    font-size: 14px;  
  }  
}  
  
@media (max-width: 768px) {  
  .header {  
    height: 50px;  
  }  
  
  .header .img {  
    width: 20%;  
    padding-left: 0;  
  }  
  
  .header .img img {  
    height: 40px; /* 限制logo图片高度，避免过大 */  
  }  
  
  .guide .nav-link {  
    margin: 0 5px;  
    padding: 5px 10px;  
    font-size: 13px;  
  }  
}  
</style>