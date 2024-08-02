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
    { name: '北京市', value: 10 },
    { name: '天津市', value: 0 },
    { name: '河北省', value: 0 },
    { name: '山西省', value: 0 },
    { name: '内蒙古自治区', value: 0 },
    { name: '辽宁省', value: 0 },
    { name: '吉林省', value: 0 },
    { name: '黑龙江省', value: 0 },
    { name: '上海市', value: 15 },
    { name: '江苏省', value: 0 },
    { name: '浙江省', value: 0 },
    { name: '安徽省', value: 0 },
    { name: '福建省', value: 2 },
    { name: '江西省', value: 10 },
    { name: '山东省', value: 0 },
    { name: '河南省', value: 0 },
    { name: '湖北省', value: 0 },
    { name: '湖南省', value: 0 },
    { name: '广东省', value: 20 },
    { name: '广西壮族自治区', value: 0 },
    { name: '海南省', value: 0 },
    { name: '重庆市', value: 4 },
    { name: '四川省', value: 5 },
    { name: '贵州省', value: 0 },
    { name: '云南省', value: 0 },
    { name: '西藏自治区', value: 0 },
    { name: '陕西省', value: 0 },
    { name: '甘肃省', value: 0 },
    { name: '青海省', value: 0 },
    { name: '宁夏回族自治区', value: 0 },
    { name: '新疆维吾尔自治区', value: 0 },
    { name: '台湾省', value: 3 },
    { name: '香港特别行政区', value: 3 },
    { name: '澳门特别行政区', value: 3 },
    { name: '南海诸岛', value: 0 },
]
let data = [
    { name: '北京市', value: 19 },
    { name: '天津市', value: 10 },
    { name: '广州市', value: 17 },
    { name: '深圳市', value: 16 },
    { name: '成都市', value: 10 },
    { name: '西安市', value: 10 },
    { name: '南京市', value: 10 },
    { name: '武汉市', value: 10 },
    { name: '上海市', value: 18 },
    { name: '重庆市', value: 10 },
    { name: '沈阳市', value: 10 },
    { name: '广州市', value: 10 },
    { name: '青岛市', value: 10 },
    { name: '苏州市', value: 10 },
    { name: '郑州市', value: 10 },
    { name: '合肥市', value: 10 },
    { name: '长沙市', value: 10 },
    { name: '佛山市', value: 10 },
    { name: '东莞市', value: 10 },
    { name: '杭州市', value: 10 },
]



let geoCoordMap = {
    北京市: [116.46, 39.92],
    上海市: [121.48, 31.22],
    广州市: [113.23, 23.16],
    深圳市: [114.07, 22.62],
    成都市: [104.06, 30.67],
    西安市: [108.95, 34.27],
    南京市: [118.78, 32.04],
    武汉市: [114.31, 30.52],
    重庆市: [106.54, 29.59],
    合肥市: [117.27, 31.86],
    长沙市: [113, 28.21],
    杭州市: [120.19, 30.26],
    东莞市: [113.75, 23.04],
    苏州市: [120.62, 31.32],
    郑州市: [113.65, 34.76],
    青岛市: [120.33, 36.07],
    佛山市: [113.11, 23.05],
    天津市: [117.2, 39.13],
    沈阳市: [123.38, 41.8],
}
const convertData = function (data) {
    var res = [];
    for (var i = 0; i < data.length; i++) {
        var geoCoord = geoCoordMap[data[i].name];
        if (geoCoord) {
            res.push({
                name: data[i].name,
                value: geoCoord.concat(data[i].value)
            });
        }
    }
    return res;
};
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
        tooltip: [{
            // triggerOn: 'click',//点击才会出现提示框
            //enterable: true,//鼠标可以进入提示框
            transitionDuration: 2,//浮动框过度时间
            borderWidth: 0,
            padding: 0,
            textStyle: {
                color: '#000',
                decoration: 'none',
            },
            //自定义浮动框
            formatter: function (params) {
                //模板字符串,用于设计悬浮框样式
                let tipHtml = '<div style="width:180px;height:100px;background:rgba(22,80,158,0.8);border:1px solid rgba(7,166,255,0.7)">'
                    + '<div style="width:140px;height:40px;line-height:40px;border-bottom:2px solid rgba(7,166,255,0.7);padding:0 20px">' + '<i style="display:inline-block;width:8px;height:8px;background:#16d6ff;border-radius:40px;">' + '</i>'
                    + '<span style="margin-left:10px;color:#fff;font-size:16px;">' + params.name + '</span>' + '</div>'
                    + '<div style="padding:10px">'
                    + '<p style="color:#fff;font-size:12px;">' + '<i style="display:inline-block;width:10px;height:10px;background:#16d6ff;border-radius:40px;margin:0 8px">' + '</i>'
                    + '人数：' + '<span style="color:#25f4f2;margin:0 6px;">' + params.value + '</span>' + '个' + '</p>'
                    + '</div>' + '</div>';
                return tipHtml;
            }

        },

        ],
        //最左边的正方形框,以及地图颜色的相关配置
        visualMap: {
            show: false,//是否显示
            type: 'continuous',
            min: 0,//最小个数
            max: 20,//最大个数
            realtime: true,//根据数据变化
            left: '0%',//离左边的距离,这边我直接给他隐藏了
            top: '20%',//位置
            calculable: true,
            seriesIndex: [0],//如果只有一个map系列，这里应该是0 
            inRange: {
                color: ['#04387b', '#00d8ff'] // 由浅蓝到深蓝
            }
        },
        geo: {//
            type: 'map',
            map: 'china',
            label: {//文字
                show: true,//字体标签显示
                color: '#fff',
                fontSize: 7,
                opacity: 0.6
            },
            itemStyle: {
                areaColor: '#fff',
                borderColor: '#3B5077',
                borderWidth: 1//省份分界线
            },
            zoom: 1.2,//地图的缩放比
            emphasis: {//高亮时的效果展示
                label: {//字体的颜色
                    show: true,
                    color: '#fff',
                    fontSize: 10,
                    opacity: 1
                },
                itemStyle: {
                    areaColor: '#2B91B7',//高亮时的颜色
                    borderColor: '#3B5077',//边缘的颜色
                }
            }
        },


        series: [
            {   //地图
                name: '省份',
                type: 'map',
                map: 'china',
                geoIndex: 0,//地图的层数
                data: mapData,
                emphasis: {//高亮时的效果展示
                    itemStyle: {
                        areaColor: '#2B91B7',//高亮时的颜色
                        borderColor: '#3B5077',//边缘的颜色
                    },
                    label: {//字体的颜色
                        show: true,
                        color: '#fff',
                        fontSize: 10,
                        opacity: 1
                    },

                },
                selectedMode: false, //选择模式，单选，只能选中一个地市
            },
            {
                name: '一线城市散点图',
                type: 'scatter',
                coordinateSystem: 'geo',
                data: convertData(data),
                symbolSize: function (val) {
                    return val[2] / 3;
                },
                label: {
                    formatter: '{b}',
                    position: 'center',
                    fontSize: 10,
                    show: false
                },
                itemStyle: {
                    color: 'yellow',
                },
                emphasis: {
                    label: {
                        show: true
                    }
                },
                tooltip: {
                    show: false
                }
            },
            {
                name: 'Top 4',
                type: 'effectScatter',
                coordinateSystem: 'geo',
                data: convertData(
                    data
                        .sort(function (a, b) {
                            return b.value - a.value;
                        })
                        .slice(0, 4)
                ),
                symbolSize: function (val) {
                    return val[2] / 5;
                },
                encode: {
                    value: 2
                },
                showEffectOn: 'render',
                rippleEffect: {
                    number: 5,
                    period: 5,
                    scale: 2.5,
                    brushType: 'fill'
                },
                label: {
                    formatter: '{b}',
                    position: 'left',
                    fontSize: 5,
                    show: true
                },
                itemStyle: {
                    color: 'gold',
                    shadowBlur: 10,
                    shadowColor: 'yellow'
                },
                emphasis: {
                    scale: true
                },
                tooltip: {
                    show: false
                }
            }

        ],

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
    <div class="marg">
        <div ref="chart" id="chinaMap"></div>
    </div>
</template>

<style scoped>
.marg {
    padding-top: 60px;
}

#chinaMap {
    width: 100%;
    height: 1000px;
}

@media screen and (max-width:992px) {
    #chinaMap {
        width: 100%;
        height: 500px;
    }
}
</style>