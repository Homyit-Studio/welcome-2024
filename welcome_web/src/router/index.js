import { createRouter, createWebHistory } from "vue-router"
import EmployMentVue from "@/views/employment/employmentPage.vue"
import JoinPageComp from "@/views/join/joinPage.vue"
import IndexPageComp from "@/views/index/indexPage.vue"
import AboutPageComp from "@/views/about/aboutPage.vue"

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes: [
        { path: "/", redirect: "/index" },
        { path: "/index", component: IndexPageComp },
        { path: "/about", component: AboutPageComp },
        { path: "/employment", component: EmployMentVue },
        { path: "/join", component: JoinPageComp },
    ],
})

export default router
