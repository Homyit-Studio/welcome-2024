import { prettyLogger } from "syk-logger"

const computeLcp = () => {
    new PerformanceObserver((entryList) => {
        var maxSize = 0
        var renderTime = 0
        for (var entry of entryList.getEntries()) {
            // 渲染的内容看最大值
            if (entry.size > maxSize) {
                maxSize = entry.size
                renderTime = entry.startTime
            }
        }
        prettyLogger.danger("lcp", renderTime)
    }).observe({ type: "largest-contentful-paint", buffered: true })
}

export const reportPerformance = () => {
    const entry = performance.getEntriesByType("navigation")[0]

    const { domComplete, fetchStart, domInteractive, responseStart } = entry

    const fp = performance.getEntriesByName("first-paint")[0].startTime
    const fcp = performance.getEntriesByName("first-contentful-paint")[0].startTime
    const ttl = domComplete - fetchStart

    prettyLogger.success("fp", fp)
    prettyLogger.success("fcp", fcp)
    prettyLogger.primary("ttl", ttl)
    prettyLogger.primary("页面加载速度", domInteractive)
    prettyLogger.primary("接口响应速度", responseStart - fetchStart)
    computeLcp()
}
