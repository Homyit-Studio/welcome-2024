// vite.config.js
import { fileURLToPath, URL } from "node:url";
import { defineConfig } from "file:///C:/Users/34979/Desktop/%E8%BF%8E%E6%96%B0%E7%BD%91%E7%AB%99/welcome_web/node_modules/vite/dist/node/index.js";
import vue from "file:///C:/Users/34979/Desktop/%E8%BF%8E%E6%96%B0%E7%BD%91%E7%AB%99/welcome_web/node_modules/@vitejs/plugin-vue/dist/index.mjs";
import AutoImport from "file:///C:/Users/34979/Desktop/%E8%BF%8E%E6%96%B0%E7%BD%91%E7%AB%99/welcome_web/node_modules/unplugin-auto-import/dist/vite.js";
import Components from "file:///C:/Users/34979/Desktop/%E8%BF%8E%E6%96%B0%E7%BD%91%E7%AB%99/welcome_web/node_modules/unplugin-vue-components/dist/vite.js";
import { ElementPlusResolver } from "file:///C:/Users/34979/Desktop/%E8%BF%8E%E6%96%B0%E7%BD%91%E7%AB%99/welcome_web/node_modules/unplugin-vue-components/dist/resolvers.js";
var __vite_injected_original_import_meta_url = "file:///C:/Users/34979/Desktop/%E8%BF%8E%E6%96%B0%E7%BD%91%E7%AB%99/welcome_web/vite.config.js";
var vite_config_default = defineConfig({
  plugins: [
    vue(),
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
    // 在启动开发服务器时，会自动打开浏览器并访问指定的地址
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
//# sourceMappingURL=data:application/json;base64,ewogICJ2ZXJzaW9uIjogMywKICAic291cmNlcyI6IFsidml0ZS5jb25maWcuanMiXSwKICAic291cmNlc0NvbnRlbnQiOiBbImNvbnN0IF9fdml0ZV9pbmplY3RlZF9vcmlnaW5hbF9kaXJuYW1lID0gXCJDOlxcXFxVc2Vyc1xcXFwzNDk3OVxcXFxEZXNrdG9wXFxcXFx1OEZDRVx1NjVCMFx1N0Y1MVx1N0FEOVxcXFx3ZWxjb21lX3dlYlwiO2NvbnN0IF9fdml0ZV9pbmplY3RlZF9vcmlnaW5hbF9maWxlbmFtZSA9IFwiQzpcXFxcVXNlcnNcXFxcMzQ5NzlcXFxcRGVza3RvcFxcXFxcdThGQ0VcdTY1QjBcdTdGNTFcdTdBRDlcXFxcd2VsY29tZV93ZWJcXFxcdml0ZS5jb25maWcuanNcIjtjb25zdCBfX3ZpdGVfaW5qZWN0ZWRfb3JpZ2luYWxfaW1wb3J0X21ldGFfdXJsID0gXCJmaWxlOi8vL0M6L1VzZXJzLzM0OTc5L0Rlc2t0b3AvJUU4JUJGJThFJUU2JTk2JUIwJUU3JUJEJTkxJUU3JUFCJTk5L3dlbGNvbWVfd2ViL3ZpdGUuY29uZmlnLmpzXCI7aW1wb3J0IHsgZmlsZVVSTFRvUGF0aCwgVVJMIH0gZnJvbSAnbm9kZTp1cmwnXHJcblxyXG5pbXBvcnQgeyBkZWZpbmVDb25maWcgfSBmcm9tICd2aXRlJ1xyXG5pbXBvcnQgdnVlIGZyb20gJ0B2aXRlanMvcGx1Z2luLXZ1ZSdcclxuaW1wb3J0IEF1dG9JbXBvcnQgZnJvbSAndW5wbHVnaW4tYXV0by1pbXBvcnQvdml0ZSdcclxuaW1wb3J0IENvbXBvbmVudHMgZnJvbSAndW5wbHVnaW4tdnVlLWNvbXBvbmVudHMvdml0ZSdcclxuaW1wb3J0IHsgRWxlbWVudFBsdXNSZXNvbHZlciB9IGZyb20gJ3VucGx1Z2luLXZ1ZS1jb21wb25lbnRzL3Jlc29sdmVycydcclxuXHJcbmV4cG9ydCBkZWZhdWx0IGRlZmluZUNvbmZpZyh7XHJcbiAgcGx1Z2luczogW1xyXG4gICAgdnVlKCksXHJcbiAgICBBdXRvSW1wb3J0KHtcclxuICAgICAgcmVzb2x2ZXJzOiBbRWxlbWVudFBsdXNSZXNvbHZlcigpXSxcclxuICAgIH0pLFxyXG4gICAgQ29tcG9uZW50cyh7XHJcbiAgICAgIHJlc29sdmVyczogW0VsZW1lbnRQbHVzUmVzb2x2ZXIoKV0sXHJcbiAgICB9KSxcclxuICBdLFxyXG4gIHJlc29sdmU6IHtcclxuICAgIGFsaWFzOiB7XHJcbiAgICAgICdAJzogZmlsZVVSTFRvUGF0aChuZXcgVVJMKCcuL3NyYycsIGltcG9ydC5tZXRhLnVybCkpXHJcbiAgICB9XHJcbiAgfSxcclxuICBzZXJ2ZXI6e1xyXG4gICAgb3Blbjp0cnVlLCAgLy8gXHU1NzI4XHU1NDJGXHU1MkE4XHU1RjAwXHU1M0QxXHU2NzBEXHU1MkExXHU1NjY4XHU2NUY2XHVGRjBDXHU0RjFBXHU4MUVBXHU1MkE4XHU2MjUzXHU1RjAwXHU2RDRGXHU4OUM4XHU1NjY4XHU1RTc2XHU4QkJGXHU5NUVFXHU2MzA3XHU1QjlBXHU3Njg0XHU1NzMwXHU1NzQwXHJcbiAgICBwcm94eTp7XHJcbiAgICAgICcvYXBpJzp7XHJcbiAgICAgICAgdGFyZ2V0OidodHRwczovL2FibXkub25saW5lL3dlbGNvbWUnLCAvLyBcdTYzQTVcdTUzRTNcdTU3REZcdTU0MERcclxuICAgICAgICBjaGFuZ2VPcmlnaW46dHJ1ZSwgLy8gXHU2NjJGXHU1NDI2XHU4REU4XHU1N0RGXHJcbiAgICAgICAgd3M6dHJ1ZSwgIC8vIFx1NjYyRlx1NTQyNlx1NEVFM1x1NzQwNiB3ZWJzb2NrZXRzXHJcbiAgICAgICAgc2VjdXJlOnRydWUsICAvLyBcdTY2MkZcdTU0MjZodHBwc1x1NjNBNVx1NTNFM1xyXG4gICAgICAgIHJld3JpdGU6IChwYXRoKSA9PiBwYXRoLnJlcGxhY2UoL15cXC9hcGkvLCAnJylcclxuICAgICAgfVxyXG4gICAgfVxyXG4gIH1cclxufSlcclxuIl0sCiAgIm1hcHBpbmdzIjogIjtBQUFtVixTQUFTLGVBQWUsV0FBVztBQUV0WCxTQUFTLG9CQUFvQjtBQUM3QixPQUFPLFNBQVM7QUFDaEIsT0FBTyxnQkFBZ0I7QUFDdkIsT0FBTyxnQkFBZ0I7QUFDdkIsU0FBUywyQkFBMkI7QUFONkosSUFBTSwyQ0FBMkM7QUFRbFAsSUFBTyxzQkFBUSxhQUFhO0FBQUEsRUFDMUIsU0FBUztBQUFBLElBQ1AsSUFBSTtBQUFBLElBQ0osV0FBVztBQUFBLE1BQ1QsV0FBVyxDQUFDLG9CQUFvQixDQUFDO0FBQUEsSUFDbkMsQ0FBQztBQUFBLElBQ0QsV0FBVztBQUFBLE1BQ1QsV0FBVyxDQUFDLG9CQUFvQixDQUFDO0FBQUEsSUFDbkMsQ0FBQztBQUFBLEVBQ0g7QUFBQSxFQUNBLFNBQVM7QUFBQSxJQUNQLE9BQU87QUFBQSxNQUNMLEtBQUssY0FBYyxJQUFJLElBQUksU0FBUyx3Q0FBZSxDQUFDO0FBQUEsSUFDdEQ7QUFBQSxFQUNGO0FBQUEsRUFDQSxRQUFPO0FBQUEsSUFDTCxNQUFLO0FBQUE7QUFBQSxJQUNMLE9BQU07QUFBQSxNQUNKLFFBQU87QUFBQSxRQUNMLFFBQU87QUFBQTtBQUFBLFFBQ1AsY0FBYTtBQUFBO0FBQUEsUUFDYixJQUFHO0FBQUE7QUFBQSxRQUNILFFBQU87QUFBQTtBQUFBLFFBQ1AsU0FBUyxDQUFDLFNBQVMsS0FBSyxRQUFRLFVBQVUsRUFBRTtBQUFBLE1BQzlDO0FBQUEsSUFDRjtBQUFBLEVBQ0Y7QUFDRixDQUFDOyIsCiAgIm5hbWVzIjogW10KfQo=
