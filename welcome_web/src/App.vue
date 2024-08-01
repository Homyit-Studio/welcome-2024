<script setup>
  
</script>

<template>
  <div>
    <div class="top_wrap">
      <WelHeader></WelHeader>
    </div>
    <div class="body">
      <router-view></router-view>
    </div>
    <div class="buttom_wrap">
      <WelButtom></WelButtom>
    </div>
  </div>
</template>

<style scoped>
* {
  box-sizing: border-box;
  padding: 0;
  margin: 0;
}

.top_wrap {
  /* position: fixed; */
  top: 0;
  left: 0;
  width: 100%;
  z-index: 1000;
}

</style>
