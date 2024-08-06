<script setup>
import ChinaMap from './ChinaMap.vue'
import AnimationList from './AnimationList.vue'
</script>


<template>
    <div style="background-color:#e6e6e6a0;">
        <div class="title"> 就业分布图</div>
        <div class="ltitle">----Homyit Studio</div>
        <ChinaMap />
        <AnimationList />
    </div>
</template>


<style scoped>
.title {
    padding-top: 100px;
    font-size: 6vmin;
    margin-left: 40%;
}

.ltitle {
    font-size: 3vmin;
    margin-left: 50%;
    color: #413d3da0;
}
</style>