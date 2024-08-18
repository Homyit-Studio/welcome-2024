<script setup>
import { toast } from "syk-toast"
import { defineProps, ref, onMounted, onBeforeUnmount } from "vue"
const props = defineProps({
    src: {
        type: String,
        required: true,
        default: "",
    },
    rootMargin: {
        type: Number,
        default: 200,
    },
})
const imgRef = ref(null)
const observer = new IntersectionObserver(
    (entries) => {
        if (entries[0].isIntersecting) {
            const img = entries[0].target
            const src = img.dataset.src
            const imageComponent = new Image()
            imageComponent.src = src
            imageComponent.onload = () => {
                img.src = src
            }
            imageComponent.onerror = () => {
                toast.log("图片加载失败")
            }

            observer.unobserve(img)
        }
    },
    {
        rootMargin: `${props.rootMargin}px 0px`, // 预加载
        root: null,
        threshold: [0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9, 1],
    }
)
onMounted(() => {
    if (imgRef.value) {
        observer.observe(imgRef.value)
    }
})
onBeforeUnmount(() => {
    observer.disconnect()
})
</script>

<template>
    <img :data-src="props.src" ref="imgRef" />
</template>

<style scoped></style>
