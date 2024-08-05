<script setup>
import {ref,onMounted} from 'vue' 

// 定义多个ref
const node1 = ref(null)
const node2 = ref(null)
const node3 = ref(null)
const node4 = ref(null)
// 点击事件处理函数
const changeColor = (node) => {
  console.log('Node clicked',node.value)
  if(node.value){
    node.value.style.backgroundColor = '#fff !important'
  }
}
onMounted(()=>{
  console.log('Node1:',node1.value)
  
})
</script>

<template>
  <div class="main">
      <div class="devlopHeader">
        <h2>发展历程</h2>
        <div class="progress-bar">
          <div class="node" ref="node1" @click="() => changeColor(node1)">
            <div class="txt">创立</div>
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
        <div class="start">123</div>
        <div class="enviroment">abc</div>
        <div class="success">dsc</div>
        <div class="new">5466</div>
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
  background-color: #ccc;
  cursor: pointer;
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
  background-color: pink;
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
</style>