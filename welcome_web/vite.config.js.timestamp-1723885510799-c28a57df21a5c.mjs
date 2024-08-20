// vite.config.js
import { fileURLToPath, URL } from "node:url";
import { defineConfig } from "file:///D:/%E6%A1%8C%E9%9D%A2/welcome-2024/welcome_web/node_modules/.pnpm/vite@5.4.1_@types+node@22.4.0/node_modules/vite/dist/node/index.js";
import vue from "file:///D:/%E6%A1%8C%E9%9D%A2/welcome-2024/welcome_web/node_modules/.pnpm/@vitejs+plugin-vue@5.1.2_vite@5.4.1_@types+node@22.4.0__vue@3.4.38/node_modules/@vitejs/plugin-vue/dist/index.mjs";
import AutoImport from "file:///D:/%E6%A1%8C%E9%9D%A2/welcome-2024/welcome_web/node_modules/.pnpm/unplugin-auto-import@0.18.2_@vueuse+core@9.13.0_vue@3.4.38__rollup@4.20.0/node_modules/unplugin-auto-import/dist/vite.js";
import Components from "file:///D:/%E6%A1%8C%E9%9D%A2/welcome-2024/welcome_web/node_modules/.pnpm/unplugin-vue-components@0.27.4_@babel+parser@7.25.3_rollup@4.20.0_vue@3.4.38/node_modules/unplugin-vue-components/dist/vite.js";
import { ElementPlusResolver } from "file:///D:/%E6%A1%8C%E9%9D%A2/welcome-2024/welcome_web/node_modules/.pnpm/unplugin-vue-components@0.27.4_@babel+parser@7.25.3_rollup@4.20.0_vue@3.4.38/node_modules/unplugin-vue-components/dist/resolvers.js";
import vitePluginImageMini from "file:///D:/%E6%A1%8C%E9%9D%A2/welcome-2024/welcome_web/node_modules/.pnpm/vite-plugin-imagemin@0.6.1_vite@5.4.1_@types+node@22.4.0_/node_modules/vite-plugin-imagemin/dist/index.mjs";
var __vite_injected_original_import_meta_url = "file:///D:/%E6%A1%8C%E9%9D%A2/welcome-2024/welcome_web/vite.config.js";
var vite_config_default = defineConfig({
  plugins: [
    vue(),
    vitePluginImageMini({
      optipng: {
        optimizationLevel: 7
      },
      pngquant: {
        quality: [0.8, 0.9]
      }
    }),
    AutoImport({
      resolvers: [ElementPlusResolver()]
    }),
    Components({
      resolvers: [ElementPlusResolver()]
    })
  ],
  resolve: {
    alias: {
      "@": fileURLToPath(new URL("./src", __vite_injected_original_import_meta_url))
    }
  },
  server: {
    open: true,
    // 在启动开发，会自服务器时动打开浏览器并访问指定的地址
    proxy: {
      "/api": {
        target: "https://abmy.online/welcome",
        // 接口域名
        changeOrigin: true,
        // 是否跨域
        ws: true,
        // 是否代理 websockets
        secure: true,
        // 是否htpps接口
        rewrite: (path) => path.replace(/^\/api/, "")
      }
    }
  }
});
export {
  vite_config_default as default
};
//# sourceMappingURL=data:application/json;base64,ewogICJ2ZXJzaW9uIjogMywKICAic291cmNlcyI6IFsidml0ZS5jb25maWcuanMiXSwKICAic291cmNlc0NvbnRlbnQiOiBbImNvbnN0IF9fdml0ZV9pbmplY3RlZF9vcmlnaW5hbF9kaXJuYW1lID0gXCJEOlxcXFxcdTY4NENcdTk3NjJcXFxcd2VsY29tZS0yMDI0XFxcXHdlbGNvbWVfd2ViXCI7Y29uc3QgX192aXRlX2luamVjdGVkX29yaWdpbmFsX2ZpbGVuYW1lID0gXCJEOlxcXFxcdTY4NENcdTk3NjJcXFxcd2VsY29tZS0yMDI0XFxcXHdlbGNvbWVfd2ViXFxcXHZpdGUuY29uZmlnLmpzXCI7Y29uc3QgX192aXRlX2luamVjdGVkX29yaWdpbmFsX2ltcG9ydF9tZXRhX3VybCA9IFwiZmlsZTovLy9EOi8lRTYlQTElOEMlRTklOUQlQTIvd2VsY29tZS0yMDI0L3dlbGNvbWVfd2ViL3ZpdGUuY29uZmlnLmpzXCI7aW1wb3J0IHsgZmlsZVVSTFRvUGF0aCwgVVJMIH0gZnJvbSBcIm5vZGU6dXJsXCJcclxuXHJcbmltcG9ydCB7IGRlZmluZUNvbmZpZyB9IGZyb20gXCJ2aXRlXCJcclxuaW1wb3J0IHZ1ZSBmcm9tIFwiQHZpdGVqcy9wbHVnaW4tdnVlXCJcclxuaW1wb3J0IEF1dG9JbXBvcnQgZnJvbSBcInVucGx1Z2luLWF1dG8taW1wb3J0L3ZpdGVcIlxyXG5pbXBvcnQgQ29tcG9uZW50cyBmcm9tIFwidW5wbHVnaW4tdnVlLWNvbXBvbmVudHMvdml0ZVwiXHJcbmltcG9ydCB7IEVsZW1lbnRQbHVzUmVzb2x2ZXIgfSBmcm9tIFwidW5wbHVnaW4tdnVlLWNvbXBvbmVudHMvcmVzb2x2ZXJzXCJcclxuaW1wb3J0IHZpdGVQbHVnaW5JbWFnZU1pbmkgZnJvbSBcInZpdGUtcGx1Z2luLWltYWdlbWluXCJcclxuXHJcbmV4cG9ydCBkZWZhdWx0IGRlZmluZUNvbmZpZyh7XHJcbiAgICBwbHVnaW5zOiBbXHJcbiAgICAgICAgdnVlKCksXHJcbiAgICAgICAgdml0ZVBsdWdpbkltYWdlTWluaSh7XHJcbiAgICAgICAgICAgIG9wdGlwbmc6IHtcclxuICAgICAgICAgICAgICAgIG9wdGltaXphdGlvbkxldmVsOiA3LFxyXG4gICAgICAgICAgICB9LFxyXG4gICAgICAgICAgICBwbmdxdWFudDoge1xyXG4gICAgICAgICAgICAgICAgcXVhbGl0eTogWzAuOCwgMC45XSxcclxuICAgICAgICAgICAgfSxcclxuICAgICAgICB9KSxcclxuICAgICAgICBBdXRvSW1wb3J0KHtcclxuICAgICAgICAgICAgcmVzb2x2ZXJzOiBbRWxlbWVudFBsdXNSZXNvbHZlcigpXSxcclxuICAgICAgICB9KSxcclxuICAgICAgICBDb21wb25lbnRzKHtcclxuICAgICAgICAgICAgcmVzb2x2ZXJzOiBbRWxlbWVudFBsdXNSZXNvbHZlcigpXSxcclxuICAgICAgICB9KSxcclxuICAgIF0sXHJcbiAgICByZXNvbHZlOiB7XHJcbiAgICAgICAgYWxpYXM6IHtcclxuICAgICAgICAgICAgXCJAXCI6IGZpbGVVUkxUb1BhdGgobmV3IFVSTChcIi4vc3JjXCIsIGltcG9ydC5tZXRhLnVybCkpLFxyXG4gICAgICAgIH0sXHJcbiAgICB9LFxyXG4gICAgc2VydmVyOiB7XHJcbiAgICAgICAgb3BlbjogdHJ1ZSwgLy8gXHU1NzI4XHU1NDJGXHU1MkE4XHU1RjAwXHU1M0QxXHVGRjBDXHU0RjFBXHU4MUVBXHU2NzBEXHU1MkExXHU1NjY4XHU2NUY2XHU1MkE4XHU2MjUzXHU1RjAwXHU2RDRGXHU4OUM4XHU1NjY4XHU1RTc2XHU4QkJGXHU5NUVFXHU2MzA3XHU1QjlBXHU3Njg0XHU1NzMwXHU1NzQwXHJcbiAgICAgICAgcHJveHk6IHtcclxuICAgICAgICAgICAgXCIvYXBpXCI6IHtcclxuICAgICAgICAgICAgICAgIHRhcmdldDogXCJodHRwczovL2FibXkub25saW5lL3dlbGNvbWVcIiwgLy8gXHU2M0E1XHU1M0UzXHU1N0RGXHU1NDBEXHJcbiAgICAgICAgICAgICAgICBjaGFuZ2VPcmlnaW46IHRydWUsIC8vIFx1NjYyRlx1NTQyNlx1OERFOFx1NTdERlxyXG4gICAgICAgICAgICAgICAgd3M6IHRydWUsIC8vIFx1NjYyRlx1NTQyNlx1NEVFM1x1NzQwNiB3ZWJzb2NrZXRzXHJcbiAgICAgICAgICAgICAgICBzZWN1cmU6IHRydWUsIC8vIFx1NjYyRlx1NTQyNmh0cHBzXHU2M0E1XHU1M0UzXHJcbiAgICAgICAgICAgICAgICByZXdyaXRlOiAocGF0aCkgPT4gcGF0aC5yZXBsYWNlKC9eXFwvYXBpLywgXCJcIiksXHJcbiAgICAgICAgICAgIH0sXHJcbiAgICAgICAgfSxcclxuICAgIH0sXHJcbn0pXHJcbiJdLAogICJtYXBwaW5ncyI6ICI7QUFBb1MsU0FBUyxlQUFlLFdBQVc7QUFFdlUsU0FBUyxvQkFBb0I7QUFDN0IsT0FBTyxTQUFTO0FBQ2hCLE9BQU8sZ0JBQWdCO0FBQ3ZCLE9BQU8sZ0JBQWdCO0FBQ3ZCLFNBQVMsMkJBQTJCO0FBQ3BDLE9BQU8seUJBQXlCO0FBUDJJLElBQU0sMkNBQTJDO0FBUzVOLElBQU8sc0JBQVEsYUFBYTtBQUFBLEVBQ3hCLFNBQVM7QUFBQSxJQUNMLElBQUk7QUFBQSxJQUNKLG9CQUFvQjtBQUFBLE1BQ2hCLFNBQVM7QUFBQSxRQUNMLG1CQUFtQjtBQUFBLE1BQ3ZCO0FBQUEsTUFDQSxVQUFVO0FBQUEsUUFDTixTQUFTLENBQUMsS0FBSyxHQUFHO0FBQUEsTUFDdEI7QUFBQSxJQUNKLENBQUM7QUFBQSxJQUNELFdBQVc7QUFBQSxNQUNQLFdBQVcsQ0FBQyxvQkFBb0IsQ0FBQztBQUFBLElBQ3JDLENBQUM7QUFBQSxJQUNELFdBQVc7QUFBQSxNQUNQLFdBQVcsQ0FBQyxvQkFBb0IsQ0FBQztBQUFBLElBQ3JDLENBQUM7QUFBQSxFQUNMO0FBQUEsRUFDQSxTQUFTO0FBQUEsSUFDTCxPQUFPO0FBQUEsTUFDSCxLQUFLLGNBQWMsSUFBSSxJQUFJLFNBQVMsd0NBQWUsQ0FBQztBQUFBLElBQ3hEO0FBQUEsRUFDSjtBQUFBLEVBQ0EsUUFBUTtBQUFBLElBQ0osTUFBTTtBQUFBO0FBQUEsSUFDTixPQUFPO0FBQUEsTUFDSCxRQUFRO0FBQUEsUUFDSixRQUFRO0FBQUE7QUFBQSxRQUNSLGNBQWM7QUFBQTtBQUFBLFFBQ2QsSUFBSTtBQUFBO0FBQUEsUUFDSixRQUFRO0FBQUE7QUFBQSxRQUNSLFNBQVMsQ0FBQyxTQUFTLEtBQUssUUFBUSxVQUFVLEVBQUU7QUFBQSxNQUNoRDtBQUFBLElBQ0o7QUFBQSxFQUNKO0FBQ0osQ0FBQzsiLAogICJuYW1lcyI6IFtdCn0K
