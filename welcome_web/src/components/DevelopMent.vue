<script>

</script>

<template>
  <div class="main">
      <div class="devlopHeader">
        <h2>发展历程</h2>
        <div class="progress-bar">
          <div class="node">
            <div class="txt ">创立</div>
            <router-link to="" class="active"></router-link>
          </div>
          <div class="line"></div>
          <div class="node">
            <div class="txt">环境</div>
            <router-link to=""></router-link>
          </div>
          <div class="line"></div>
          <div class="node">
            <div class="txt">成就</div>
            <router-link to=""></router-link>
          </div>
          <div class="line"></div>
          <div class="node">
            <div class="txt">培养新能量</div>
            <router-link to=""></router-link>
          </div>
        </div>
      </div>
      <div class="contents">
        <div class="start">
          <div class="title">创立</div>
          <div class="set">
            <img src="@/assets/2020.jpg" alt="">
            <div class="words1">
              宏奕工作室成立于2013年9月,是在江西师范大学计算机信息工程学院各领导、
              老师的大力支持下迅速成长起来的学生自主研发的工作室。该工作室致力于Web开发,以社团的模式传承,
              在12级创始人王宏凯及十余名长老员共同努力下本着“有爱同行,踏实求新”的侠客情怀,
              致力于为学生提供一个专业的Web开发修炼圣地,培养出更多就业型人才。
            </div>
          </div>
        </div>
        <!-- <div class="enviroment">abc</div>
        <div class="success">dsc</div>
        <div class="new">5466</div> -->
      </div>
  </div>
</template>

<style scoped>
.main {
  box-sizing: border-box; 
  padding-top: 60px; 
  background-color:#f6f6f6;
}
.devlopHeader {
  position: relative;
  height: 384px;
  width: 100%;
  background-size: cover;
  background-image: url(@/assets/banner.jpg);
  background-position: center;
  color: #fff;
}

.devlopHeader h2 {
  text-align: center;
  font-size: 30px;
  line-height: 45px;
  padding-top: 150px;
  font-style: italic;
}
.progress-bar {
  width: 530px;
  margin: auto;
  padding-top: 70px;
}

.progress-bar .node {
  width: 24px;
  height: 24px;
  float: left;
  position: relative;
  border-radius: 50%;
  background: rgba(255, 255, 255, 0.5);
  cursor: pointer;
}

.progress-bar .line {
  float: left;
  height: 2px;
  background: rgba(255, 255, 255, 0.5);
  width: 140px;
  margin-top: 11px;
}
.progress-bar .node .txt {
  position: absolute;
  font-size: 16px;
  top: -30px;
  width: 200px;
  text-align: center;
  left: 50%;
  margin-left: -100px;
}

.progress-bar .node a {
  display: block;
  width: 18px;
  height: 18px;
  position: absolute;
  top: 3px;
  left: 3px;
  border-radius: 50%;
  /* background: rgba(255, 255, 255, 0.5); */
}
.start{
  width: 100%;
  height: 500px;
}
.enviroment{
  width: 100%;
  height: 500px;
  background-color: skyblue;
}
.success{
  width: 100%;
  height: 500px;
  background-color: red;
}
.new{
  width: 100%;
  height: 500px;
  background-color: green;
}
.contents .title {
  margin: 50px 0px;
  text-align: center;
  color: #585858;
  font: bold 20px 'Open Sans Condensed', sans-serif;
}
.set {
  position: relative;
  margin: auto;
  width: 90%;
  height: 560px;
}
.set img {
  height: 100%;
  width: 100%;
}
.set .words1 {
  position: absolute;
  padding: 64px 88px 88px 64px;
  background-color: rgba(255, 255, 255, 0.8);
  width: 40%;
  box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2); /* 添加阴影效果 */
  transition: box-shadow 0.3s ease; 
  top: 140px;
  left: -3%;
  z-index: 5;
  font-size: 14px;
  color: #000;
  letter-spacing: 0;
  line-height: 25px;
}
</style>