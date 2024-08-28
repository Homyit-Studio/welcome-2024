import { fileURLToPath, URL } from 'node:url'
import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
import vueDevTools from 'vite-plugin-vue-devtools'

export default defineConfig({
  plugins: [
    vue(),
    vueDevTools(),
  ],
  resolve: {
    alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url))
    }
  },
  server: {
    open: true, // 在启动开发，会自服务器时动打开浏览器并访问指定的地址
    proxy: {
      // 配置代理
      '/api': {
        target: 'https://abmy.online/welcome', // 目标服务器的地址
        changeOrigin: true, // 修改请求头中的origin字段
        ws: true,     // 是否代理  websockets
        secure: true,  // 是否https接口
        rewrite: (path) => path.replace(/^\/api/, ''), // 替换路径中的 /api
      },
    },
  },
})
