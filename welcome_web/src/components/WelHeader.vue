<script setup>

</script>

<template>
  <div class="header">
    <img src="@/assets/homyit_logo.png" alt="">
    <router-link to="/index">Index</router-link>
    <router-link to="/about">About</router-link>
    <router-link to="/employment">Employment</router-link>
    <router-link to="/join">Join</router-link>
  </div>
</template>

<style scoped>
* {
  box-sizing: border-box;
  padding: 0;
  margin: 0;
}

.header {
  display: flex;
  width: 100%;
  height: 60px;
  line-height: 60px;
  background-color: #2e9deb;
}

img {
  margin-right: 10%;
  width: 120px;
}

a {
  height: 100%;
  width: 130px;
  text-align: center;
  color: #000;
  font-size: 15px;
  display: inline-block;
  transition: color 0.3s, box-shadow 0.3s;
  box-shadow: 0 0 5px rgba(0, 0, 0, 0);
  text-decoration: none;
  padding-left: 0 5%;
}

a:hover {
  color: #f39c12;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
}

a.router-link-active {
  font-weight: bold;
  color: #fff;
}

</style>