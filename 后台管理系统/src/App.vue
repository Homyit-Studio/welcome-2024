<script setup>
import { useUserStore } from './store/userStore'
import { onMounted } from 'vue'

const userStore = useUserStore()

onMounted(()=>{
  userStore.loadToken()
})
</script>

<template>
  <div>
    <router-view></router-view>
  </div>
</template>

<style lang="scss" scoped>

</style>