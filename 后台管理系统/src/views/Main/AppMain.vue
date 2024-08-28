<script setup>
import { onMounted } from 'vue'
import { useRouter } from 'vue-router'
import { useUserStore } from '@/store/userStore'

const router = useRouter()
const userStore = useUserStore()

onMounted(() => {
  const btns = document.querySelectorAll('.button-link')
  btns.forEach(btn => {
    btn.onmousemove = (e) => {
      const rect = btn.getBoundingClientRect()
      const x = e.clientX - rect.left
      const y = e.clientY - rect.top
      btn.style.setProperty('--x', x + 'px')
      btn.style.setProperty('--y', y + 'px')
    }

    // 添加点击事件处理器
    if(btn.innerText === '退出登录'){
      btn.onclick = () => {
        // 清除token
        userStore.clearToken()
        // 跳转到login页面
        router.push('/login')
      }
    }
  })
})
</script>

<template>
  <div class="container">
    <nav>
      <router-link to="/Main/Employment" class="button-link" style="--clr:#0f0">Employment</router-link>
      <router-link to="/Main/Slider" class="button-link" style="--clr:#ff0">Slider</router-link>
      <router-link to="/Main/New" class="button-link" style="--clr:#f0f">New</router-link>
      <div class="button-link" style="--clr:#0ff">退出登录</div>
    </nav>
    <router-view></router-view>
  </div>
</template>

<style scoped>
.container {
  display: flex;
  flex-direction: column;
  align-items: center;
  padding-top: 30px;
  min-height: 98vh;
  background-color: #999;
  gap: 50px;
}

nav {
  display: flex;
  gap: 20px;
}

.button-link {
  position: relative;
  padding: 20px 60px;
  background-color: rgba(45, 45, 45, 1);
  border-radius: 50px;
  color: #fff;
  font-size: 1.5em;
  text-decoration: none;
  overflow: hidden;
  transition: .5s;
  border: 2px solid transparent; /* 透明边框 */
}
div:hover{
  cursor: pointer;
}
.button-link span {
  position: relative;
  z-index: 1;
  letter-spacing: .2rem;
}

.button-link:hover {
  color: var(--clr);
  text-shadow: 0 0 15px var(--clr), 0 0 40px var(--clr);
}

.button-link::before {
  content: '';
  position: absolute;
  top: var(--y);
  left: var(--x);
  transform: translate(-50%, -50%);
  width: 200px;
  height: 200px;
  background: radial-gradient(var(--clr), transparent, transparent);
  opacity: 0.5;
  transition: .5s top 0s, left 0s;
}
.button-link::after {
  content: '';
  background-color: var(--clr);
  background-color: rgba(45, 45, 45, .8);
  position: absolute;
  inset: 2px;
  border-radius: 50px;
  transition: border-color 0.5s; /* Ensure smooth border color transition */
}
</style>