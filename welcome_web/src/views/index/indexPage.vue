<template>
  <div class="main">
    <el-carousel height="65vh">
    <el-carousel-item><img src="@/assets/one.png" alt=""></el-carousel-item>
    <el-carousel-item><img src="@/assets/two.jpg" alt=""></el-carousel-item>
    <el-carousel-item><img src="@/assets/three.jpg" alt=""></el-carousel-item>
  </el-carousel>
    <div class="advatages">
    <div class="slogan">
					Our Ideas Will Raise Your Programs Above the Expected <br>
					<a href="javascript:;" class="btn">more</a>
		</div>
    <div class="box">
      <div class="ad">
        <h2 class="title">Consulting</h2>
        <span class="change" style="background-color: #b0caa2;">
          <a href="javascript:;" class="btn2">more</a>
        </span>
        <span class="unchange" style="background-color: #b0caa2;"></span>
      </div>
      <div class="ad">
        <h2 class="title">Development</h2>
        <span class="change" style="background-color: #caacc7;">
          <a href="javascript:;" class="btn2">more</a>
        </span>
        <span class="unchange" style="background-color: #caacc7;"></span>
      </div>
      <div class="ad">
        <h2 class="title">Analysis</h2>
        <span class="change" style="background-color: #caacb6;">
          <a href="javascript:;" class="btn2">more</a>
        </span>
        <span class="unchange" style="background-color: #caacb6;"></span>
      </div>
      <div class="ad">
        <h2 class="title">Itegration</h2>
        <span class="change" style="background-color: #a2bbca;">
          <a href="javascript:;" class="btn2">more</a>
        </span>
        <span class="unchange" style="background-color: #a2bbca;"></span>
      </div>
    </div>
  </div>
  <div class="projects">
      <div class="Title">Programs</div>
       <div class="projects_items animate__animatedanimate__backInLeft">
      <div class="img">
        <img src="@/assets/财务处.png" alt="">
      </div>
      <div class="img">
        <img src="@/assets/管理决策评价中心.png" alt="">
      </div>
      <div class="img">
        <img src="@/assets/国教.png" alt="">
      </div>
      <div class="img">
        <img src="@/assets/马院.png" alt="">
      </div>
  </div>
  </div>
  </div>
</template>
<script>
  import 'animate.css'
</script>

<style scoped>
.main{
  background-color: #f6f6f6;
  box-sizing: border-box; 
  padding-top: 60px; 
}

img {
  width: 100%;
  height: 100%;
}

a {
	text-decoration: none;
	color: inherit;
	outline: none;
	transition: 0.5s ease;
	-o-transition: 0.5s ease;
	-webkit-transition: 0.5s ease;
}

a:hover {
	color: #a2cac2;	
}


a.btn {
	display: inline-block;
	color: #a2cac2;
	font: bold 18px/24px 'Open Sans Condensed', sans-serif;
	font: bold 1.2rem 'Open Sans Condensed', sans-serif;
	border: 2px solid #a2cac2;
	padding: .5% 4% .5%;
	margin-top: 47px;
}

a.btn:hover {
	background-color: #a2cac2;
	color: #fff;
}

.slogan {
	padding-top: 90px;
	padding-bottom: 56px;
	text-align: center;
	color: #585858;
	font: bold 29px 'Open Sans Condensed', sans-serif;
  line-height: 1.5;
}

.slogan a.btn {
	margin-top: 42px;
}

.box {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
}

.box .ad {
  position: relative;
  margin: 25px 25px;
  height: 300px;
  width: 230px;
  background-color: #fff;
  text-align: center;
  border-radius: 3%;
  box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
}

.box .ad .title {
  position: absolute;
  padding-top: 14px;
  height: 20%;
  width: 100%;
  text-align: center;
  left: 50%;
  transform: translateX(-50%);
	font: 300 30px 'Open Sans', sans-serif;
	color: #000;
}

.box .ad .change {  
  position: absolute;  
  display: block;  
  text-align: center;
  bottom: 29.75%;
  height: 30%;
  width: 100%;  
  /* background-color: pink;   */
  clip-path: polygon(0 100%, 100% 100%, 100% 0%); 
  transition: clip-path 5s ease, height 2s ease, opacity .5s ease;
  opacity: 1; 
}  

.box .ad .change a.btn2 {
  position: absolute;
  bottom: 0;
  text-align: center;
  left: 22%;
  display: none;
  text-decoration: none;
	color: inherit;
	outline: none;
	transition: 0.5s ease;
  -o-transition: 0.5s ease;
  -webkit-transition: 0.5s ease;
	color: #fff;
	font: bold 20px 'Open Sans Condensed', sans-serif;
	border: 2px solid #fff;
	padding: 2% 15% 2%;
  opacity: 0; /* 初始时按钮是透明的 */  
  transition: opacity 1s ease, transform 0.5s ease;  
  transform: translateY(20px); 
}

.box .ad:hover .change {  
  clip-path: polygon(0 0%, 100% 0%, 100% 100%, 0% 100%);  
  height: 40%; 
}

.box .ad:hover .change a.btn2 {
    display: block;
    display: block; /* 仍然需要设置为 block 以确保按钮占据空间 */  
    opacity: 1; /* 按钮变为不透明 */  
    transform: translateY(0); /* 按钮移回原位 */  
  }

.box .ad .unchange {
  position: absolute;
  display: block;
  bottom: 0;
  height: 30%;
  width: 100%;
  /* background-color: pink; */
}

.Title {
  padding-top: 90px;
	text-align: center;
	color: #585858;
	font: bold 29px 'Open Sans Condensed', sans-serif;
}

/* programs */
.projects_items {
  display: flex;
  align-items: center;
  justify-content: center;
  flex-wrap: wrap;
}

.projects_items .img {
  width: 500px;
  height: 400px;
  margin: 25px;
  border-radius: 3%;
  box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
}

/* 响应式 */
@media (max-width: 1024px) {  
  .slogan {
    font-size: 20px;
  }
  .box .ad .title {
    font-size: 25px;
  }
}  
  
@media (max-width: 768px) {  
  .slogan , .Title {
    font-size: 15px;
    padding-top: 50px;
    padding-bottom: 30px;
  }
  .box .ad {
    width: 130px;
    height: 200px;
    margin: 10px 25px;
  }
  .box .ad .title {
    font-size: 17px;
  }
  .box .ad .change a.btn2 {
    font-size: 12px;
  }
  .slogan a.btn {
    margin-top: 25px;
  }
}  
</style>
