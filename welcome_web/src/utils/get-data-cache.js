import axios from "axios"
import { toast } from "syk-toast"
const getPageData = () =>
    new Promise((resolve, reject) => {
        axios.get("https://geo.datav.aliyun.com/areas_v3/bound/100000_full.json").then(resolve).catch(reject)
    })
const cache = localStorage.getItem("mapData")
let retryCount = 0

export async function initMapData() {
    if (!cache) {
        try {
            const data = await getPageData()
            localStorage.setItem("mapData", JSON.stringify(data.data))
        } catch (e) {
            if (retryCount < 3) {
                retryCount++
                initMapData()
            } else {
                toast.error("获取地图数据失败，请刷新重试")
            }
        }
    }
}
