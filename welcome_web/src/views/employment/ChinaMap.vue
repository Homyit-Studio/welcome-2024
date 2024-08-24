<script setup>
import { ref, onMounted } from "vue"

import axios from "axios"
import { LinesData, data, geoCoordMap } from "@/contant"
import { initMapData } from "@/utils"

import { init, registerMap } from "echarts"
//地图的存放盒子chart的获取
let chart = ref()
//数据的声明以及数据的默认值
let mapData = []

const convertData = function (data) {
    var res = []
    for (var i = 0; i < data.length; i++) {
        var geoCoord = geoCoordMap[data[i].name]
        if (geoCoord) {
            res.push({
                name: data[i].name,
                value: geoCoord.concat(data[i].value),
            })
        }
    }
    return res
}
//挂载

function xhr() {
    var myChart = init(chart.value)
    axios
        .post("/api/data")
        .then(async (response) => {
            mapData = response.data.data
            let chinaMap = localStorage.getItem("mapData")
            if (!chinaMap) {
                await initMapData()
                chinaMap = localStorage.getItem("mapData")
            }
            chinaMap = JSON.parse(chinaMap)
            //注册可用地图
            registerMap("china", chinaMap)
            //开始配置
            let option = {
                //配置浮动框
                tooltip: [
                    {
                        transitionDuration: 2, //浮动框过度时间
                        borderWidth: 0,
                        padding: 0,
                        textStyle: {
                            color: "#000",
                            decoration: "none",
                        },
                        //自定义浮动框
                        formatter: function (params) {
                            //模板字符串,用于设计悬浮框样式
                            let tipHtml =
                                '<div style="width:180px;height:100px;background:rgba(22,80,158,0.8);border:1px solid rgba(7,166,255,0.7)">' +
                                '<div style="width:180px;height:40px;line-height:40px;border-bottom:2px solid rgba(7,166,255,0.7);padding:0 20px">' +
                                '<i style="display:inline-block;width:8px;height:8px;background:#16d6ff;border-radius:40px;">' +
                                "</i>" +
                                '<span style="margin-left:10px;color:#fff;font-size:16px;">' +
                                params.name +
                                "</span>" +
                                "</div>" +
                                '<div style="padding:10px">' +
                                '<p style="color:#fff;font-size:12px;">' +
                                '<i style="display:inline-block;width:10px;height:10px;background:#16d6ff;border-radius:40px;margin:0 8px">' +
                                "</i>" +
                                "人数：" +
                                '<span style="color:#25f4f2;margin:0 6px;">' +
                                params.value +
                                "</span>" +
                                "个" +
                                "</p>" +
                                "</div>" +
                                "</div>"
                            return tipHtml
                        },
                    },
                ],
                //最左边的正方形框,以及地图颜色的相关配置
                visualMap: {
                    show: false, //是否显示
                    type: "continuous",
                    min: 0, //最小个数
                    max: 10, //最大个数
                    realtime: true, //根据数据变化
                    left: "0%", //离左边的距离,这边我直接给他隐藏了
                    top: "20%", //位置
                    calculable: true,
                    seriesIndex: [0], //如果只有一个map系列，这里应该是0
                    inRange: {
                        color: ["#04387b", "#00d8ff"], // 由浅蓝到深蓝
                    },
                },
                geo: {
                    //
                    type: "map",
                    map: "china",
                    label: {
                        //文字
                        show: true, //字体标签显示
                        color: "#fff",
                        fontSize: 7,
                        opacity: 0.6,
                    },
                    itemStyle: {
                        areaColor: "#fff",
                        borderColor: "#3B5077",
                        borderWidth: 1, //省份分界线
                    },
                    zoom: 1.2, //地图的缩放比
                    emphasis: {
                        //高亮时的效果展示
                        label: {
                            //字体的颜色
                            show: true,
                            color: "#fff",
                            fontSize: 10,
                            opacity: 1,
                        },
                        itemStyle: {
                            areaColor: "#2B91B7", //高亮时的颜色
                            borderColor: "#3B5077", //边缘的颜色
                        },
                    },
                },
                series: [
                    {
                        //地图
                        name: "省份",
                        type: "map",
                        map: "china",
                        geoIndex: 0, //地图的层数
                        data: mapData,
                        emphasis: {
                            //高亮时的效果展示
                            itemStyle: {
                                areaColor: "#2B91B7", //高亮时的颜色
                                borderColor: "#3B5077", //边缘的颜色
                            },
                            label: {
                                //字体的颜色
                                show: true,
                                color: "#fff",
                                fontSize: 10,
                                opacity: 1,
                            },
                        },
                        selectedMode: false, //选择模式，单选，只能选中一个地市
                    },
                    {
                        name: "一线城市散点图",
                        type: "scatter",
                        coordinateSystem: "geo",
                        data: convertData(data),
                        symbolSize: function (val) {
                            return val[2] / 3
                        },
                        label: {
                            formatter: "{b}",
                            position: "center",
                            fontSize: 10,
                            show: false,
                        },
                        itemStyle: {
                            color: "yellow",
                        },
                        emphasis: {
                            label: {
                                show: true,
                            },
                        },
                        tooltip: {
                            show: false,
                        },
                    },
                    {
                        name: "Top 4",
                        type: "effectScatter",
                        coordinateSystem: "geo",
                        data: convertData(
                            data
                                .sort(function (a, b) {
                                    return b.value - a.value
                                })
                                .slice(0, 4)
                        ),
                        symbolSize: function (val) {
                            return val[2] / 5
                        },
                        encode: {
                            value: 2,
                        },
                        showEffectOn: "render",
                        rippleEffect: {
                            number: 5,
                            period: 5,
                            scale: 5,
                            brushType: "fill",
                        },
                        label: {
                            formatter: "{b}",
                            position: "left",
                            fontSize: 5,
                            show: true,
                        },
                        itemStyle: {
                            color: "gold",
                            shadowBlur: 10,
                            shadowColor: "yellow",
                        },
                        emphasis: {
                            scale: true,
                        },
                        tooltip: {
                            show: false,
                        },
                    },
                    {
                        name: "线条",
                        type: "lines",
                        symbol: ["none"],
                        synbolSize: 1,
                        lineStyle: {
                            color: "#93EBF8",
                            width: 2.5, //宽度
                            opacity: 0.6, //尾迹透明度
                            curveness: 0.2, //尾迹线条曲直度
                        },
                        data: LinesData,
                        tooltip: {
                            show: false,
                        },
                    },
                ],
            }
            //使用指定的配置和数据显示图表
            myChart.setOption(option)
            //图表自适应
        })
        .catch((error) => console.log(error))
    window.addEventListener("resize", () => {
        myChart.resize()
    })
}
//发送请求
onMounted(() => {
    xhr()
})
</script>

<template>
    <div class="marg">
        <div ref="chart" id="chinaMap"></div>
    </div>
</template>

<style scoped>
.marg {
    padding-top: 0px;
}

#chinaMap {
    width: 100%;
    height: 1000px;
}

@media screen and (max-width: 992px) {
    #chinaMap {
        width: 100%;
        height: 500px;
    }
}
</style>
