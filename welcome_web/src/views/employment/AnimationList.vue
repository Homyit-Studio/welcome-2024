<script setup>
import { ref } from 'vue'
</script>


<template>
    <div class="conter">
        <!-- 第一屏 -->
        <div class="flatly-itemone">
        </div>
        <div class="playground">
            <div class="animation-container">
                <div class="titlemanifesto">
                    你好,世界!
                    <div class="list">
                        <div class="list-item">1</div>
                        <div class="list-item">1</div>
                        <div class="list-item">1</div>
                        <div class="list-item">1</div>
                        <div class="list-item">1</div>
                        <div class="list-item">1</div>
                        <div class="list-item">1</div>
                        <div class="list-item">1</div>
                        <div class="list-item">1</div>
                        <div class="list-item">1</div>
                        <div class="list-item">1</div>
                        <div class="list-item">1</div>
                    </div>
                </div>
            </div>
        </div>
        <!-- 第一屏 -->
        <div class="flatly-itemone">
        </div>
    </div>
</template>


<style scoped>
.flatly-itemone {
    height: 90vh;
    background-color: #60b5bb;
}

.playground {
    height: 310vh;
    background-color: #063868;
    position: relative;
}

.playground .animation-container {
    display: flex;
    position: sticky;
    top: 0;
    height: 100vh;
}



/* 标题 */
.playground .animation-container .titlemanifesto {
    height: 50px;
    width: 1000px;
    position: absolute;
    left: 50%;
    top: 23%;
    transform: translate(-50%);
    text-align: center;
    color: #fff;
    font-family: PingFangSC-Medium;
    font-weight: 500;
    font-size: 30px;
    line-height: 50px;
}

.playground .animation-container .list {
    height: 550px;
    width: 1000px;
    position: absolute;
    left: 50%;
    top: 50%;
    transform: translate(-50%, -28%);
    display: flex;
    flex-wrap: wrap;
    align-items: center;
    border-radius: 10px;
    padding: 15px 20px;
    opacity: 0.8;
}

.playground .animation-container .list .list-item {
    width: 100px;
    height: 155px;
    border-radius: 10px;
    background-color: #fff;
    margin: 50px 30px;
}

.playground .animation-container .list .list-item:nth-child(2n - 1) {
    background-color: skyblue;
}

.playground .animation-container .list .list-item:nth-child(2n) {
    background-color: rgb(111, 245, 111);
}

.playground .animation-container .list .list-item:nth-child(3n) {
    background-color: orange;
}
</style>