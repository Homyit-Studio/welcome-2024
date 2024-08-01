<script setup>
import { ref, nextTick, onMounted } from 'vue'
//引入地图的json文件
import chinaMap from '../../assets/json/china.json'
//引入echarts核心模块
import * as echarts from 'echarts'
//地图的存放盒子chart的获取
let chart = ref()
//数据的声明以及数据的默认值
let mapData = [
    { name: '北京市', value: 290 },
    { name: '天津市', value: 320 },
    { name: '河北省', value: 240 },
    { name: '山西省', value: 520 },
    { name: '内蒙古自治区', value: 120 },
    { name: '辽宁省', value: 210 },
    { name: '吉林省', value: 620 },
    { name: '黑龙江省', value: 20 },
    { name: '上海市', value: 220 },
    { name: '江苏省', value: 820 },
    { name: '浙江省', value: 320 },
    { name: '安徽省', value: 520 },
    { name: '福建省', value: 120 },
    { name: '江西省', value: 620 },
    { name: '山东省', value: 920 },
    { name: '河南省', value: 220 },
    { name: '湖北省', value: 720 },
    { name: '湖南省', value: 210 },
    { name: '广东省', value: 20 },
    { name: '广西壮族自治区', value: 20 },
    { name: '海南省', value: 240 },
    { name: '重庆市', value: 20 },
    { name: '四川省', value: 240 },
    { name: '贵州省', value: 420 },
    { name: '云南省', value: 320 },
    { name: '西藏自治区', value: 20 },
    { name: '陕西省', value: 240 },
    { name: '甘肃省', value: 920 },
    { name: '青海省', value: 720 },
    { name: '宁夏回族自治区', value: 120 },
    { name: '新疆维吾尔自治区', value: 420 },
    { name: '台湾省', value: 230 },
    { name: '香港特别行政区', value: 420 },
    { name: '澳门特别行政区', value: 210 },
]
//挂载
//发送请求?
onMounted(() => {
    nextTick(() => {
        initChart()
    })
})


function initChart() {
    //基于准备好的dom,初始化echarts实例
    var myChart = echarts.init(chart.value)
    //注册可用地图
    echarts.registerMap('china', chinaMap)
    //开始配置
    let option = {
        //标题以及副标题
        title: {
            text: '就业分布',
            subtext: 'Homyit Studio',
            left: 'center'
        },
        //配置浮动框
        tooltip: {
            // triggerOn: 'click',//点击才会出现提示框
            enterable: true,//鼠标可以进入提示框
            transitionDuration: 2,//浮动框过度时间
            textStyle: {
                color: '#000',
                decoration: 'none',
            },
            //浮动框效果展示
            formatter: function (params) {
                //模板字符串,用于设计悬浮框样式
                let tipHtml = '<div style="width:180px;height:160px;background:rgba(22,80,158,0.8);border:1px solid rgba(7,166,255,0.7)">'
                    + '<div style="width:140px;height:60px;line-height:40px;border-bottom:2px solid rgba(7,166,255,0.7);padding:0 20px">' + '<i style="display:inline-block;width:8px;height:8px;background:#16d6ff;border-radius:40px;">' + '</i>'
                    + '<span style="margin-left:10px;color:#fff;font-size:16px;">' + params.name + '</span>' + '</div>'
                    + '<div style="padding:20px">'
                    + '<p style="color:#fff;font-size:12px;">' + '<i style="display:inline-block;width:10px;height:10px;background:#16d6ff;border-radius:40px;margin:0 8px">' + '</i>'
                    + '人数：' + '<span style="color:#25f4f2;margin:0 6px;">' + params.value + '</span>' + '个' + '</p>'
                    + '</div>' + '</div>';
                return tipHtml;
            }

        },
        //最左边的正方形框,以及地图颜色的相关配置
        visualMap: {
            //show: true,//是否显示具体个数
            min: 0,//最小个数
            max: 300,//最大个数
            left: '-100%',//离左边的距离
            top: '20%',//位置
            calculable: true,
            seriesIndex: [1],//颜色设计的层数
            inRange: {
                color: ['#467bc0', '#04387b'] // 由浅蓝到深蓝
            }
        },
        series: [
            //地图的第2层
            {
                name: '第二层',//该配置
                type: 'scatter',
                coordinateSystem: 'geo',
                data: mapData,
                // symbolSize: function (val) {
                //     return val[1] / 20;
                // },
                emphasis: {
                    label: {
                        show: true
                    }
                },
                itemStyle: {
                    color: '#fff',
                }
            },
            {   //地图的根本元素
                type: 'map',
                map: 'china',
                geoIndex: 0,//地图的层数
                // aspectScale: 20, //长宽比
                showLegendSymbol: false, // 存在legend时显示
                label: {//地图的数据,(地名),以及颜色
                    show: true,
                    color: '#fff',
                    fontSize: 8
                },
                zoom: 1.2,//缩放
                roam: {
                    scale: true,
                    move: false
                },
                emphasis: {
                    areaColor: '#031525',
                    borderColor: '#3B5077',
                    itemStyle: {
                        areaColor: '#2B91B7'
                    }
                },
                // animation: false,
                data: mapData
            },


        ]
    }
    //使用指定的配置和数据显示图表
    myChart.setOption(option)
    //图表自适应
    window.addEventListener('resize', () => {
        myChart.resize()
    })
}



</script>

<template>
    <div ref="chart" id="chinaMap"></div>
</template>

<style>
#chinaMap {
    width: 100%;
    height: 1000px;
}

/* @media screen and (min-width:992px) {
    #chinaMap {
        width: 100%;
        height: 500px;
    }
} */
</style>