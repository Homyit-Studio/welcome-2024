<script setup>
import { defineProps, ref, onMounted, onBeforeUnmount } from "vue"
const props = defineProps({
    src: {
        type: String,
        required: true,
        default: "",
    },
    rootMargin: {
        type: Number,
        default: 50,
    },
})
const imgRef = ref(null)

const observer = new IntersectionObserver(
    (entries) => {
        if (entries[0].isIntersecting) {
            const img = entries[0].target
            img.src = img.dataset.src
            observer.unobserve(img)
        }
    },
    {
        rootMargin: `${-props.rootMargin}px 0px 0px 0px`, // 预加载
        root: null,
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
