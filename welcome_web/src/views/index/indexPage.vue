<template>
  <div class="main">
    <el-carousel height="90vh">
      <el-carousel-item class="index"><img src="@/assets/one.png" alt=""></el-carousel-item>
      <el-carousel-item class="index"><img src="@/assets/two.jpg" alt=""></el-carousel-item>
      <el-carousel-item class="index"><img src="@/assets/three.png" alt=""></el-carousel-item>
    </el-carousel>
    <!-- <el-carousel height="65vh">
      <el-carousel-item v-for="(image, index) in images" :key="index">
        <img :src="image.path" alt="">
      </el-carousel-item>
   </el-carousel> -->
    <div class="advatages">
      <div class="slogan">
        Our Ideas Will Raise Your Programs Above the Expected <br>
        <a href="javascript:;" @click="goToJoinPage" class="btn">JOIN</a>
      </div>
      <div class="box">
        <div class="ad">
          <h2 class="title">Consulting</h2>
          <span class="change" style="background-color: #b0caa2;">
            <a href="javascript:;" @click="goToJoinPage" class="btn2">JOIN</a>
          </span>
          <span class="unchange" style="background-color: #b0caa2;"></span>
        </div>
        <div class="ad">
          <h2 class="title">Development</h2>
          <span class="change" style="background-color: #caacc7;">
            <a href="javascript:;" @click="goToJoinPage" class="btn2">JOIN</a>
          </span>
          <span class="unchange" style="background-color: #caacc7;"></span>
        </div>
        <div class="ad">
          <h2 class="title">Analysis</h2>
          <span class="change" style="background-color: #caacb6;">
            <a href="javascript:;" @click="goToJoinPage" class="btn2">JOIN</a>
          </span>
          <span class="unchange" style="background-color: #caacb6;"></span>
        </div>
        <div class="ad">
          <h2 class="title">Itegration</h2>
          <span class="change" style="background-color: #a2bbca;">
            <a href="javascript:;" @click="goToJoinPage" class="btn2">JOIN</a>
          </span>
          <span class="unchange" style="background-color: #a2bbca;"></span>
        </div>
      </div>
    </div>
    <div class="projects">
      <div class="Title">Our Programs</div>
      <div class="projects_items">
        <div ref="animatedElement1" class="img animate__animated animate__fast	200ms">
          <div class="img1">
            <img src="@/assets/财务处.png" alt="">
          </div>
          <a href="https://sis.jxnu.edu.cn/">江西师范大学财务处官网</a>
        </div>
        <div ref="animatedElement2" class="img animate__animated animate__delay-0.5s animate__fast	200ms">
          <div class="img1">
            <img src="@/assets/管理决策评价中心.png" alt="">
          </div>
          <a href="https://gljcpj.jxnu.edu.cn/">江西师范大学管理决策评价研究中心官网</a>
        </div>
        <div ref="animatedElement3" class="img animate__animated animate__delay-0.8s animate__fast	200ms">
          <div class="img1">
            <img src="@/assets/国教.png" alt="">
          </div>
          <a href="https://sis.jxnu.edu.cn/">江西师范大学国际教育学院官网</a>
        </div>
        <div ref="animatedElement4" class="img animate__animated animate__delay-0.5s animate__fast	200ms">
          <div class="img1">
            <img src="@/assets/马院.png" alt="">
          </div>
          <a href="https://mar.jxnu.edu.cn/">江西师范大学马克思主义学院官网</a>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import 'animate.css'
// import axios from 'axios'

export default {
  name: 'AnimatedElement',
  // ---------------
  // data() {
  //   return {
  //     images: []  // 用来存储从后端获取的图片信息
  //   };
  // },
  // ---------------
  mounted() {
    // 组件挂载后，可以在这里初始化IntersectionObserver
    this.initIntersectionObserver();
    // this.fetchImages();  // 在组件加载时调用获取图片的方法
  },

  methods: {
    initIntersectionObserver() {
      // 获取需要观察的元素，这里使用Vue的ref来获取DOM元素
      const elements = [
        this.$refs.animatedElement1,
        this.$refs.animatedElement2,
        this.$refs.animatedElement3,
        this.$refs.animatedElement4
      ];

      // 创建一个IntersectionObserver实例
      const observer = new IntersectionObserver((entries, observer) => {
        entries.forEach(entry => {
          if (entry.isIntersecting) {
            // 根据具体需求添加不同的动画类名
            if (entry.target === elements[0]) {
              entry.target.classList.add('animate__fadeInRight');
            } else if (entry.target === elements[1]) {
              entry.target.classList.add('animate__fadeInLeft');
            } else if (entry.target === elements[2]) {
              entry.target.classList.add('animate__fadeInRight');
            } else if (entry.target === elements[3]) {
              entry.target.classList.add('animate__fadeInLeft');
            }
            // 停止观察这个元素，因为动画已经触发
            observer.unobserve(entry.target);
          }
        });
      });

      // 对每个动画元素开始观察
      elements.forEach(element => {
        if (element) {
          observer.observe(element);
        }
      });
    },
     goToJoinPage() {
      this.$router.push({ path: '/join' })

      setTimeout(()=>{
        this.$router.go(0)
      },10)
    }
    // -----------------------
//      async fetchImages() {
//        try {
//          const response = await axios.get('/url');  // 发送GET请求到后端API接口
//          this.images = response.data;  // 将返回的图片数据存储到images数组中
//       } catch (error) {
//          console.error('获取失败', error);
//       }
// }
    // -----------------------
  }
};
</script>

<style scoped>
.main {
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
  color: #add0e7;
}


a.btn {
  display: inline-block;
  color: #add0e7;
  font: bold 1.2rem 'Open Sans Condensed', sans-serif;
  border: 2px solid #add0e7;
  padding: .5% 4% .5%;
  margin-top: 47px;
}

a.btn:hover {
  background-color: #add0e7;
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
  opacity: 0;
  /* 初始时按钮是透明的 */
  transition: opacity 1s ease, transform 0.5s ease;
  transform: translateY(20px);
}

.box .ad:hover .change {
  clip-path: polygon(0 0%, 100% 0%, 100% 100%, 0% 100%);
  height: 40%;
}

.box .ad:hover .change a.btn2 {
  display: block;
  display: block;
  /* 仍然需要设置为 block 以确保按钮占据空间 */
  opacity: 1;
  /* 按钮变为不透明 */
  transform: translateY(0);
  /* 按钮移回原位 */
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
  margin: 50px 0px;
  text-align: center;
  color: #585858;
  font: bold 29px 'Open Sans Condensed', sans-serif;
}

/* programs */
.projects_items {
  display: flex;
  align-content: center;
  justify-content: center;
  flex-wrap: wrap;
  text-align: center;
}

.projects_items .img {
  width: 580px;
  height: 400px;
  margin: 25px;
  border-radius: 3%;
  box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
}

.projects_items .img .img1 {
  height: 90%;
  width: 100%;
}

.projects_items .img a {
  font: 400 14px 'Open Sans Condensed', sans-serif;
  color: #585858;
  display: block;
  text-align: center;
  line-height: 35px;
}

.projects_items .img a:hover {
  color: #add0e7;
}


/* 响应式 */
@media (max-width: 1024px) {
  .slogan {
    font-size: 20px;
  }

  .box .ad .title {
    font-size: 25px;
  }

  .projects_items .img {
    width: 300px;
    height: 180px;
    margin: 20px;
  }

  .projects_items .img a {
    font-size: 10px;
    line-height: 18px;
  }
}

@media (max-width: 768px) {
  ::v-deep .el-carousel{
    height: 50vh !important;
  }
  .index{
    width: 100%;
    height: 50vh;
  }
  .index img{
    width: 100%;
    height: 100%;
  }
  .slogan,
  .Title {
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

  .projects_items .img {
    width: 350px;
    height: 200px;
    margin: 20px;
  }

  .projects_items .img a {
    font-size: 10px;
    line-height: 20px;
  }

  .Title {
    margin: 5px 0px;
    z-index: 100;
  }
}
</style>
