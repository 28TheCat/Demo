<script setup>
// 接收props
const props = defineProps({
  book: {
    type: Object,
    default: null
  },
  visible: {
    type: Boolean,
    default: false
  }
})

// 定义事件
const emit = defineEmits(['close'])

// 关闭详情页
const closeDetail = () => {
  emit('close')
}
</script>

<template>
  <div v-if="visible && book" class="book-detail-overlay" @click="closeDetail">
    <div class="book-detail-container" @click.stop>
      <button class="close-button" @click="closeDetail">×</button>
      
      <div class="book-detail-content">
        <div class="book-detail-image">
          <img :src="book.coverUrl" :alt="book.title" />
        </div>
        
        <div class="book-detail-info">
          <h2 class="book-detail-title">{{ book.title }}</h2>
          <p class="book-detail-author">作者: {{ book.author || '未知' }}</p>
          <p class="book-detail-publisher">出版社: {{ book.publisher || '未知' }}</p>
          <p class="book-detail-year">出版年份: {{ book.year || '未知' }}</p>
          <p class="book-detail-price">价格: {{ book.price || '未知' }}</p>
          
          <div class="book-detail-description">
            <h3>内容简介:</h3>
            <p>{{ book.description || '暂无简介' }}</p>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>
.book-detail-overlay {
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background-color: rgba(0, 0, 0, 0.8);
  display: flex;
  justify-content: center;
  align-items: center;
  z-index: 1000;
  animation: fadeIn 0.3s ease;
}

@keyframes fadeIn {
  from { opacity: 0; }
  to { opacity: 1; }
}

.book-detail-container {
  background-color: white;
  border-radius: 12px;
  padding: 20px;
  max-width: 900px;
  max-height: 80vh;
  overflow-y: auto;
  position: relative;
  box-shadow: 0 8px 32px rgba(0, 0, 0, 0.3);
  animation: slideUp 0.3s ease;
}

@keyframes slideUp {
  from { transform: translateY(50px); opacity: 0; }
  to { transform: translateY(0); opacity: 1; }
}

.close-button {
  position: absolute;
  top: 10px;
  right: 10px;
  background: none;
  border: none;
  font-size: 28px;
  cursor: pointer;
  color: #666;
  padding: 5px;
}

.close-button:hover {
  color: #000;
}

.book-detail-content {
  display: flex;
  gap: 30px;
  flex-wrap: wrap;
}

.book-detail-image {
  flex: 0 0 auto;
  width: 250px;
}

.book-detail-image img {
  width: 100%;
  height: auto;
  border-radius: 8px;
  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.15);
}

.book-detail-info {
  flex: 1;
  min-width: 300px;
}

.book-detail-title {
  font-size: 28px;
  margin-bottom: 15px;
  color: #333;
}

.book-detail-author,
.book-detail-publisher,
.book-detail-year,
.book-detail-price {
  font-size: 16px;
  margin-bottom: 10px;
  color: #666;
}

.book-detail-description {
  margin-top: 25px;
}

.book-detail-description h3 {
  font-size: 20px;
  margin-bottom: 15px;
  color: #333;
}

.book-detail-description p {
  font-size: 16px;
  line-height: 1.6;
  color: #444;
  text-align: justify;
}
</style>