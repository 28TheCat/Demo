<script setup>
import { ref, onMounted } from 'vue'
import BookCover from './components/BookCover.vue'
import BookDetail from './components/BookDetail.vue'
import AddBookForm from './components/AddBookForm.vue'

// 书籍数据
const books = ref([
  {
    id: '1',
    title: 'JavaScript高级程序设计',
    author: '马特·弗里斯比',
    publisher: '人民邮电出版社',
    year: '2019',
    price: '139.00元',
    coverUrl: 'https://img3.doubanio.com/view/subject/l/public/s29409636.jpg',
    description: '《JavaScript高级程序设计》是JavaScript领域的经典之作，全面介绍了JavaScript语言的核心概念和高级特性，包括作用域、闭包、对象、原型链、异步编程等内容。'  
  },
  {
    id: '2',
    title: 'Vue.js设计与实现',
    author: '霍春阳',
    publisher: '电子工业出版社',
    year: '2022',
    price: '129.00元',
    coverUrl: 'https://img1.doubanio.com/view/subject/l/public/s34214752.jpg',
    description: '本书深入剖析Vue.js 3的设计理念和实现原理，从响应式系统、渲染器、组件系统等核心模块入手，全面讲解了Vue.js的工作机制。'  
  },
  {
    id: '3',
    title: 'Python编程：从入门到实践',
    author: 'Eric Matthes',
    publisher: '人民邮电出版社',
    year: '2016',
    price: '79.00元',
    coverUrl: 'https://img2.doubanio.com/view/subject/l/public/s28173812.jpg',
    description: '本书是一本Python入门经典，通过大量示例和项目实践，帮助读者快速掌握Python编程的基础知识和应用技巧。'  
  },
  {
    id: '4',
    title: '算法导论',
    author: 'Thomas H. Cormen',
    publisher: '机械工业出版社',
    year: '2013',
    price: '128.00元',
    coverUrl: 'https://img3.doubanio.com/view/subject/l/public/s1727293.jpg',
    description: '《算法导论》是算法领域的权威著作，全面介绍了各种算法的设计、分析和应用，是计算机科学领域的经典教材。'  
  },
  {
    id: '5',
    title: '深入理解计算机系统',
    author: 'Randal E. Bryant',
    publisher: '机械工业出版社',
    year: '2016',
    price: '139.00元',
    coverUrl: 'https://img3.doubanio.com/view/subject/l/public/s27481938.jpg',
    description: '本书从程序员的角度深入讲解计算机系统的工作原理，包括计算机体系结构、操作系统、编译原理等内容，是计算机科学领域的经典教材。'  
  }
])

// 选中的书籍
const selectedBook = ref(null)
const showDetail = ref(false)

// 添加新书
const addBook = (newBook) => {
  books.value.push(newBook)
}

// 打开书籍详情
const openBookDetail = (book) => {
  selectedBook.value = book
  showDetail.value = true
}

// 关闭书籍详情
const closeBookDetail = () => {
  showDetail.value = false
  selectedBook.value = null
}
</script>

<template>
  <div class="app-container">
    <header class="app-header">
      <h1>书的封面流动展示</h1>
    </header>
    
    <main class="app-main">
      <!-- 书封面流动展示 -->
      <section class="book-cover-section">
        <h2>推荐书籍</h2>
        <BookCover 
          :books="books" 
          :on-book-click="openBookDetail" 
        />
      </section>
      
      <!-- 添加新书表单 -->
      <section class="add-book-section">
        <AddBookForm @add-book="addBook" />
      </section>
    </main>
    
    <!-- 书籍详情弹窗 -->
    <BookDetail 
      :book="selectedBook" 
      :visible="showDetail" 
      @close="closeBookDetail" 
    />
  </div>
</template>

<style scoped>
.app-container {
  max-width: 1200px;
  margin: 0 auto;
  padding: 20px;
  font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
}

.app-header {
  text-align: center;
  margin-bottom: 30px;
}

.app-header h1 {
  color: #333;
  font-size: 32px;
  font-weight: 600;
}

.app-main {
  display: flex;
  flex-direction: column;
  gap: 50px;
}

.book-cover-section {
  margin-bottom: 30px;
}

.book-cover-section h2 {
  text-align: center;
  margin-bottom: 20px;
  color: #444;
  font-size: 24px;
}

.add-book-section {
  margin-top: 50px;
}
</style>
