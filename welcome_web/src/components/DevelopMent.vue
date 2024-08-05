<script>
import 'animate.css'
export default {
  name: 'AnimatedElement',
  mounted() {
    // 组件挂载后，可以在这里初始化IntersectionObserver
    this.initIntersectionObserver();
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
    }
  }
};
</script>

<template>
  <div class="main">
      <div class="devlopHeader">
        <h2>发展历程</h2>
        <div class="progress-bar">
          <div class="node">
            <div class="txt ">创立</div>
          </div>
          <div class="line"></div>
          <div class="node" ref="node2" @click="() => changeColor(node2)">
            <div class="txt">环境</div>
          </div>
          <div class="line"></div>
          <div class="node" ref="node3" @click="() => changeColor(node3)">
            <div class="txt">成就</div>
          </div>
          <div class="line"></div>
          <div class="node" ref="node4" @click="() => changeColor(node4)">
            <div class="txt">培养新能量</div>
          </div>
        </div>
      </div>
      <div class="contents">
        <div class="start">
          <div class="title">创立</div>
          <div class="set">
            <img src="@/assets/2020.jpg" alt="">
            <div ref="animatedElement1" class="words1 animate__animated">
              宏奕工作室成立于2013年9月,是在江西师范大学计算机信息工程学院各领导、
              老师的大力支持下迅速成长起来的学生自主研发的工作室。该工作室致力于Web开发,以社团的模式传承,
              在12级创始人王宏凯及十余名长老员共同努力下本着“有爱同行,踏实求新”的侠客情怀,
              致力于为学生提供一个专业的Web开发修炼圣地,培养出更多就业型人才。
            </div>
          </div>
        </div>
        <div class="enviroment">
          <div class="title">环境</div>
          <div class="around">
            <img src="@/assets/工作室环境.jpg" alt="">
            <div ref="animatedElement2" class="words2 animate__animated">
              工作室致力于打造舒适温馨的学习环境,24h空调、饮用水不间断供应,内设冰箱等实用设备,
              为成员解决自习室短缺等问题，营造踏实努力的学习氛围。
              在这里，你有志同道合的好伙伴陪你一起学习，有什么问题也可以询问学长学姐！
            </div>
          </div>
        </div>
        <div class="success">
          <div class="title">成就</div>
          <div class="win">
            <img src="@/assets/获奖情况.jpg" alt="">
            <div ref="animatedElement3" class="words3 animate__animated">
              从2013年9月工作室成立至今,宏奕工作室也会参加部分web开发赛事,同样在一些赛事中也取得了较好成绩。
              同时，宏奕工作室也会外包商业项目和外包/协助学院老师开发项目，包括美院外包项目-毕业方向辅导小程序,
              我们学校的请假助手和宿舍管理与分配小程序。
          </div>
        </div>
        </div>
        <div class="new">
           <div class="title">培养新能量</div>
           <div class="cultivate">
            <img src="@/assets/新生培训.jpg" alt="">
            <div ref="animatedElement4" class="words4 animate__animated">
              宏奕工作室积极吸纳新鲜血液,工作室重视对新成员的培训和技能提升。
              通过组织培训、技术分享等活动帮助新成员快速适应工作环境,并掌握必要的技术和工具。
              这些培训不仅仅局限于技术层面,还包括团队协作、沟通能力以及解决问题的能力,全面提升新成员的综合素质。
              用实际行动为学校、为社会培养出更多掌握web开发的技术人员。
          </div>
        </div>
        </div>
      </div>
  </div>
</template>

<style scoped>
.main {
  box-sizing: border-box; 
  padding-top: 60px; 
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
}

.progress-bar .line {
  float: left;
  height: 2px;
  background-color: #fff;
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
  color: #fff;
}
.contents .title {
  margin: 50px 0px;
  text-align: center;
  color: #585858;
  font: bold 20px 'Open Sans Condensed', sans-serif;
}
.set {
  position: relative;
  margin: 10px auto;
  width: 90%;
  height: 560px;
}
.set img {
  height: 100%;
  width: 100%;
}
.set .words1 {
  position: absolute;
  padding: 5% 5%;
  background-color: rgba(255, 255, 255, 0.8);
  width: 40%;
  box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2); /* 添加阴影效果 */
  transition: box-shadow 0.3s ease; 
  z-index: 5;
  top: 23%;
  left: -3%;
  font-size: 14px;
  color: #000;
  letter-spacing: 0;
  line-height: 30px;
}
.around {
  position: relative;
  margin: 10px auto;
  width: 90%;
  height: 560px;
}
.around img {
  height: 100%;
  width: 100%;
}
.around .words2 {
  position: absolute;
  top: 140px;
  right: -3%;
  padding: 5% 5%;
  width: 40%;
  background-color: rgba(255, 255, 255, 0.8);
  box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
  transition: box-shadow 0.3s ease; 
  font-size: 14px;
  color: #000;
  letter-spacing: 0;
  line-height: 30px;
}
.win {
  position: relative;
  margin: 10px auto;
  width: 90%;
  height: 560px;
}
.win img {
  height: 100%;
  width: 100%;
}
.win .words3 {
  position: absolute;
  padding: 5% 5%;
  background-color: rgba(255, 255, 255, 0.8);
  width: 40%;
  box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2); /* 添加阴影效果 */
  transition: box-shadow 0.3s ease; 
  z-index: 5;
  top: 25%;
  left: -3%;
  font-size: 14px;
  color: #000;
  letter-spacing: 0;
  line-height: 30px;
}
.cultivate {
  position: relative;
  margin: 10px auto;
  width: 90%;
  height: 560px;
}
.cultivate img {
  height: 100%;
  width: 100%;
}
.cultivate .words4 {
  position: absolute;
  top: 140px;
  right: -3%;
  padding: 5% 5%;
  width: 40%;
  background-color: rgba(255, 255, 255, 0.8);
  box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
  transition: box-shadow 0.3s ease; 
  font-size: 14px;
  color: #000;
  letter-spacing: 0;
  line-height: 30px;
}
/* 响应式 */
@media (max-width: 1024px) {
  .set {
    width: 95%;
  }
  .set .words1 {
    width: 50%;
    left: -2%;
    font-size: 12px;
  }
  .around {
    width: 95%;
  }
  .around .words2 {
    width: 50%;
    right: -2%;
    font-size: 12px;
    top: 25%;
  }
  .win {
    width: 95%;
  }
  .win .words3 {
    width: 50%;
    left: -2%;
    font-size: 12px;
  }
  .cultivate {
    width: 95%;
  }
  .cultivate .words4 {
    width: 50%;
    right: -2%;
    font-size: 12px;
  }
}

@media (max-width: 768px) {
.devlopHeader {
  height: 300px;
}

.devlopHeader h2 {
  font-size: 28px;
  line-height: 35px;
  padding-top: 100px;
}
.progress-bar {
  width: 50%;
  padding-top: 50px;
}

.progress-bar .node {
  width: 18.5px;
  height: 18.5px;
}

.progress-bar .line {
  width: 21%;
  margin-top: 8px;
}
.progress-bar .node .txt {
  font-size: 15px;
  top: -25px;
}
.contents .title {
  margin: 40px 0px;
  font: 18px;
}
.set {
  width: 95%;
  height: 500px;
}
.set .words1 {
  width: 50%;
  left: -2%;
  font-size: 13px;
}
.around {
  width: 95%;
  height: 500px;
}
.around .words2 {
  width: 50%;
  right: -2%;
  font-size: 13px;
}
.win {
  width: 95%;
  height: 500px;
}
.win .words3 {
  width: 50%;
  left: -2%;
  font-size: 13px;
}
.cultivate {
  width: 95%;
  height: 500px;
}
.cultivate .words4 {
  width: 50%;
  right: -2%;
  font-size: 13px;
  top: 20%;
}
}
@media (max-width: 700px) {
.contents .title {
  margin: 35px 0px;
  font: 17px;
}
.set {
  width: 95%;
  height: 450px;
}
.set .words1 {
  width: 50%;
  left: -2%;
  font-size: 12px;
  top: 20%;
}
.around {
  width: 95%;
  height: 450px;
}
.around .words2 {
  width: 50%;
  right: -2%;
  font-size: 12px;
  top: 20%;
}
.win {
  width: 95%;
  height: 450px;
}
.win .words3 {
  width: 50%;
  left: -2%;
  font-size: 12px;
  top: 20%;
}
.cultivate {
  width: 95%;
  height: 450px;
}
.cultivate .words4 {
  width: 50%;
  right: -2%;
  font-size: 12px;
  top: 20%;
}
}
@media (max-width: 600px) {
.set {
  width: 95%;
  height: 350px;
}
.set .words1 {
  width: 50%;
  left: -2%;
  font-size: 10px;
  top: 15%;
  line-height: 25px;
}
.around {
  width: 95%;
  height: 350px;
}
.around .words2 {
  width: 50%;
  right: -2%;
  font-size: 10px;
  top: 20%;
  line-height: 25px;
}
.win {
  width: 95%;
  height: 350px;
}
.win .words3 {
  width: 50%;
  left: -2%;
  font-size: 10px;
  top: 15%;
  line-height: 25px;
}
.cultivate {
  width: 95%;
  height: 350px;
}
.cultivate .words4 {
  width: 50%;
  right: -2%;
  font-size: 10px;
  top: 15%;
  line-height: 25px;
}
}
@media (max-width: 480px) {
.devlopHeader {
  height: 250px;
}

.devlopHeader h2 {
  font-size: 25px;
  line-height: 35px;
  padding-top: 70px;
}
.progress-bar {
  width: 50%;
  padding-top: 50px;
}

.progress-bar .node {
  width: 18.5px;
  height: 18.5px;
}

.progress-bar .line {
  width: 19.5%;
  margin-top: 8px;
}
.progress-bar .node .txt {
  font-size: 13px;
  top: -25px;
}
.contents .title {
  margin: 30px 0px;
  font: 16px;
}
.set {
  width: 95%;
  height: 300px;
}
.set .words1 {
  font-size: 9px;
  top: 10%;
  line-height: 22px;
}
.around {
  width: 95%;
  height: 300px;
}
.around .words2 {
 font-size: 9px;
  top: 20%;
  line-height: 22px;
}
.win {
  width: 95%;
  height: 300px;
}
.win .words3 {
 font-size: 9px;
  top: 10%;
  line-height: 22px;
}
.cultivate {
  width: 95%;
  height: 300px;
}
.cultivate .words4 {
  font-size: 9px;
  top: 10%;
  line-height: 22px;
}
}
</style>