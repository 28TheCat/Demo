<script setup>
import { ref } from 'vue'

// 定义事件
const emit = defineEmits(['add-book'])

// 表单数据
const formData = ref({
  title: '',
  author: '',
  publisher: '',
  year: '',
  price: '',
  description: '',
  coverUrl: ''
})

// 文件上传相关
const coverFile = ref(null)
const coverPreview = ref('')

// 处理文件选择
const handleFileChange = (event) => {
  const file = event.target.files[0]
  if (file) {
    coverFile.value = file
    
    // 创建图片预览
    const reader = new FileReader()
    reader.onload = (e) => {
      coverPreview.value = e.target.result
      formData.value.coverUrl = e.target.result // 将Base64保存到表单数据
    }
    reader.readAsDataURL(file)
  }
}

// 提交表单
const submitForm = (event) => {
  event.preventDefault()
  
  // 简单验证
  if (!formData.value.title || !formData.value.coverUrl) {
    alert('请填写书名并选择封面图片')
    return
  }
  
  // 生成唯一ID
  const newBook = {
    id: Date.now().toString(),
    ...formData.value
  }
  
  // 发送添加书籍事件
  emit('add-book', newBook)
  
  // 重置表单
  resetForm()
}

// 重置表单
const resetForm = () => {
  formData.value = {
    title: '',
    author: '',
    publisher: '',
    year: '',
    price: '',
    description: '',
    coverUrl: ''
  }
  coverFile.value = null
  coverPreview.value = ''
}
</script>

<template>
  <div class="add-book-form-container">
    <h2>添加新书</h2>
    <form @submit="submitForm" class="add-book-form">
      <div class="form-row">
        <div class="form-group">
          <label for="title">书名:</label>
          <input 
            type="text" 
            id="title" 
            v-model="formData.title" 
            placeholder="请输入书名"
            required
          />
        </div>
        
        <div class="form-group">
          <label for="author">作者:</label>
          <input 
            type="text" 
            id="author" 
            v-model="formData.author" 
            placeholder="请输入作者"
          />
        </div>
      </div>
      
      <div class="form-row">
        <div class="form-group">
          <label for="publisher">出版社:</label>
          <input 
            type="text" 
            id="publisher" 
            v-model="formData.publisher" 
            placeholder="请输入出版社"
          />
        </div>
        
        <div class="form-group">
          <label for="year">出版年份:</label>
          <input 
            type="text" 
            id="year" 
            v-model="formData.year" 
            placeholder="请输入出版年份"
          />
        </div>
      </div>
      
      <div class="form-row">
        <div class="form-group">
          <label for="price">价格:</label>
          <input 
            type="text" 
            id="price" 
            v-model="formData.price" 
            placeholder="请输入价格"
          />
        </div>
      </div>
      
      <div class="form-group">
        <label for="coverImage">封面图片:</label>
        <input 
          type="file" 
          id="coverImage" 
          accept="image/*" 
          @change="handleFileChange"
          required
        />
        
        <!-- 图片预览 -->
        <div v-if="coverPreview" class="image-preview">
          <img :src="coverPreview" :alt="formData.title" />
        </div>
      </div>
      
      <div class="form-group">
        <label for="description">内容简介:</label>
        <textarea 
          id="description" 
          v-model="formData.description" 
          placeholder="请输入书籍简介"
          rows="4"
        ></textarea>
      </div>
      
      <div class="form-actions">
        <button type="submit" class="btn submit-btn">添加书籍</button>
        <button type="button" class="btn reset-btn" @click="resetForm">重置</button>
      </div>
    </form>
  </div>
</template>

<style scoped>
.add-book-form-container {
  max-width: 800px;
  margin: 0 auto;
  padding: 20px;
}

.add-book-form-container h2 {
  text-align: center;
  margin-bottom: 25px;
  color: #333;
}

.add-book-form {
  background-color: #f9f9f9;
  padding: 25px;
  border-radius: 8px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
}

.form-row {
  display: flex;
  gap: 20px;
  margin-bottom: 20px;
  flex-wrap: wrap;
}

.form-group {
  flex: 1;
  min-width: 250px;
  margin-bottom: 20px;
}

.form-group label {
  display: block;
  margin-bottom: 8px;
  font-weight: 500;
  color: #555;
}

.form-group input,
.form-group textarea {
  width: 100%;
  padding: 10px;
  border: 1px solid #ddd;
  border-radius: 4px;
  font-size: 16px;
  transition: border-color 0.3s ease;
}

.form-group input:focus,
.form-group textarea:focus {
  outline: none;
  border-color: #42b883;
}

.form-group textarea {
  resize: vertical;
  min-height: 100px;
}

/* 图片预览样式 */
.image-preview {
  margin-top: 15px;
  max-width: 200px;
  border-radius: 8px;
  overflow: hidden;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
}

.image-preview img {
  width: 100%;
  height: auto;
  display: block;
}

.form-actions {
  display: flex;
  justify-content: center;
  gap: 15px;
  margin-top: 30px;
}

.btn {
  padding: 12px 24px;
  border: none;
  border-radius: 4px;
  font-size: 16px;
  cursor: pointer;
  transition: background-color 0.3s ease;
}

.submit-btn {
  background-color: #42b883;
  color: white;
}

.submit-btn:hover {
  background-color: #369f71;
}

.reset-btn {
  background-color: #999;
  color: white;
}

.reset-btn:hover {
  background-color: #777;
}
</style>