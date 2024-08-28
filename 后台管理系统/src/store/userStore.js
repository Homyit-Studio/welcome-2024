import { defineStore } from "pinia"

export const useUserStore = defineStore('userStore', {
  state: () => ({
    token: localStorage.getItem('token') || '', // 初始化时从 localStorage 中获取 token
  }),
  actions: {
    setToken(newToken) {
      this.token = newToken;
      localStorage.setItem('token', newToken); // 同步保存到 localStorage
    },
    clearToken() {
      this.token = '';
      localStorage.removeItem('token'); // 清除 localStorage 中的 token
    },
    loadToken() {
      this.token = localStorage.getItem('token') || ''
    }
  },
  persist: {
    enabled: true,
    strategies: [
      {
        key: 'userStore',
        storage: localStorage, // 使用 localStorage 持久化
      }
    ]
  }
})