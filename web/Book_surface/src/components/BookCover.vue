<script setup>
import { ref, onMounted } from 'vue'

// 接收props
const props = defineProps({
  books: {
    type: Array,
    default: () => []
  },
  onBookClick: {
    type: Function,
    default: () => {}
  }
})

// 容器引用
const containerRef = ref(null)
const scrollSpeed = ref(50) // 滚动速度（像素/秒）
const scrollDistance = ref(0)

// 自动滚动函数
let scrollInterval = null

const startScrolling = () => {
  if (containerRef.value) {
    const container = containerRef.value
    const scrollWidth = container.scrollWidth
    const clientWidth = container.clientWidth
    
    scrollInterval = setInterval(() => {
      scrollDistance.value += scrollSpeed.value / 60 // 基于60fps
      
      // 计算实际滚动位置（循环滚动）
      const actualScroll = scrollDistance.value % (scrollWidth - clientWidth)
      container.scrollLeft = actualScroll
    }, 1000 / 60) // 60fps
  }
}

const stopScrolling = () => {
  if (scrollInterval) {
    clearInterval(scrollInterval)
    scrollInterval = null
  }
}

// 鼠标悬停时暂停滚动
const handleMouseEnter = () => {
  stopScrolling()
}

// 鼠标离开时继续滚动
const handleMouseLeave = () => {
  startScrolling()
}

// 组件挂载后开始滚动
onMounted(() => {
  startScrolling()
})
</script>

<template>
  <div class="book-cover-container" ref="containerRef" @mouseenter="handleMouseEnter" @mouseleave="handleMouseLeave">
    <div class="book-cover-wrapper">
      <div 
        v-for="(book, index) in books" 
        :key="book.id || index"
        class="book-cover"
        @click="onBookClick(book)"
      >
        <img 
          :src="book.coverUrl" 
          :alt="book.title" 
          class="book-image"
        />
        <div class="book-title">{{ book.title }}</div>
      </div>
    </div>
  </div>
</template>

<style scoped>
.book-cover-container {
  width: 100%;
  height: 350px;
  overflow-x: auto;
  overflow-y: hidden;
  position: relative;
  scroll-behavior: smooth;
  /* 隐藏滚动条 */
  -ms-overflow-style: none;
}

/* Chrome, Safari and Opera */
.book-cover-container::-webkit-scrollbar {
  display: none;
}

.book-cover-wrapper {
  display: flex;
  gap: 20px;
  padding: 20px 10px;
  height: 100%;
  align-items: center;
}

.book-cover {
  flex: 0 0 auto;
  width: 200px;
  height: 300px;
  cursor: pointer;
  transition: transform 0.3s ease;
  position: relative;
}

.book-cover:hover {
  transform: translateY(-10px) scale(1.05);
}

.book-image {
  width: 100%;
  height: 100%;
  object-fit: cover;
  border-radius: 8px;
  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.15);
}

.book-title {
  position: absolute;
  bottom: 0;
  left: 0;
  right: 0;
  padding: 10px;
  background: linear-gradient(transparent, rgba(0, 0, 0, 0.8));
  color: white;
  font-size: 14px;
  text-align: center;
  border-bottom-left-radius: 8px;
  border-bottom-right-radius: 8px;
  white-space: nowrap;
  overflow: hidden;
  text-overflow: ellipsis;
}
</style>