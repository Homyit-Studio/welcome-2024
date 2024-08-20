import { fileURLToPath, URL } from "node:url"

import { defineConfig } from "vite"
import vue from "@vitejs/plugin-vue"
import AutoImport from "unplugin-auto-import/vite"
import Components from "unplugin-vue-components/vite"
import { ElementPlusResolver } from "unplugin-vue-components/resolvers"
import vitePluginImageMini from "vite-plugin-imagemin"
import { visualizer } from "rollup-plugin-visualizer"
import { createHtmlPlugin } from "vite-plugin-html"
import externalGlobals from "rollup-plugin-external-globals"

export default defineConfig({
    plugins: [
        createHtmlPlugin({
            template: "./index.html",
            inject: {
                tags: [
                    {
                        injectTo: "body",
                        tag: "script",
                        attrs: {
                            src: "https://cdn.jsdelivr.net/npm/echarts@5.5.1/dist/echarts.min.js",
                        },
                        defer: true,
                    },
                ],
            },
        }),
        vue(),
        vitePluginImageMini({
            optipng: {
                optimizationLevel: 7,
            },
            pngquant: {
                quality: [0.8, 0.9],
            },
        }),
        visualizer({
            gzipSize: true,
            brotliSize: true,
            emitFile: false,
            filename: "test.html", //分析图生成的文件名
            open: true, //如果存在本地服务端口，将在打包后自动展示
        }),
        AutoImport({
            resolvers: [ElementPlusResolver()],
        }),
        Components({
            resolvers: [ElementPlusResolver()],
        }),
    ],
    resolve: {
        alias: {
            "@": fileURLToPath(new URL("./src", import.meta.url)),
        },
    },

    server: {
        open: true, // 在启动开发，会自服务器时动打开浏览器并访问指定的地址
        proxy: {
            "/api": {
                target: "https://abmy.online/welcome", // 接口域名
                changeOrigin: true, // 是否跨域
                ws: true, // 是否代理 websockets
                secure: true, // 是否htpps接口
                rewrite: (path) => path.replace(/^\/api/, ""),
            },
        },
    },
    build: {
        rollupOptions: {
            external: ["echarts"],
            plugins: [
                externalGlobals({
                    echarts: "echarts",
                }),
            ],
        },
    },
})
