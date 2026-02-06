<template>
  <section id="home" class="hero-section">
    <div class="container hero-content">
      <div class="hero-text">
        <h1 class="hero-title">欢迎来到 <span class="highlight">小茅庐</span></h1>
        <p class="hero-subtitle">小黑盒语音房间 - 房间号：636738</p>
        <p class="hero-description">
          专为游戏爱好者打造的温馨空间，提供游戏开黑、经验分享及日常聊天服务
        </p>
        <div class="hero-stats">
          <div class="stat-item">
            <span class="stat-number">636738</span>
            <span class="stat-label">房间号</span>
          </div>
          <div class="stat-item">
            <span class="stat-number">在线</span>
            <span class="stat-label">状态</span>
          </div>
          <div class="stat-item">
            <span class="stat-number">友爱</span>
            <span class="stat-label">社区氛围</span>
          </div>
        </div>
        <div class="hero-buttons">
          <a href="#about" class="btn btn-primary">了解更多</a>
          <a :href="'https://chat.xiaoheihe.cn/ib5c9x4z'" target="_blank" class="btn btn-secondary">进入房间</a>
        </div>
      </div>
    </div>
  </section>
</template>

<script setup lang="ts">
// Hero Section Component
</script>

<style scoped>
.hero-section {
  background: linear-gradient(135deg, #e8f5e9 0%, #c8e6c9 100%); /* 柔和的浅绿色渐变背景 */
  color: #333; /* 深色文字以提高对比度 */
  padding: 8rem 0;
  text-align: center;
  min-height: 80vh;
  display: flex;
  align-items: center;
}

.hero-content {
  max-width: 800px;
  margin: 0 auto;
}

.hero-title {
  font-size: 3.5rem;
  margin-bottom: 1rem;
  color: #2e7d32; /* 深绿色标题 */
}

.highlight {
  color: #4caf50; /* 绿色高亮 */
}

.hero-subtitle {
  font-size: 1.5rem;
  margin-bottom: 1.5rem;
  color: #555; /* 深灰色副标题 */
}

.hero-description {
  font-size: 1.2rem;
  margin-bottom: 2.5rem;
  line-height: 1.8;
  max-width: 700px;
  margin-left: auto;
  margin-right: auto;
  color: #666; /* 深灰色描述文字 */
}

.hero-stats {
  display: flex;
  justify-content: center;
  gap: 3rem;
  margin-bottom: 2.5rem;
  flex-wrap: wrap;
}

.stat-item {
  display: flex;
  flex-direction: column;
}

.stat-number {
  font-size: 2.5rem;
  font-weight: bold;
  color: #4caf50; /* 绿色数字 */
}

.stat-label {
  font-size: 1rem;
  margin-top: 0.5rem;
  color: #777; /* 灰色标签 */
}

.hero-buttons {
  display: flex;
  justify-content: center;
  gap: 1.5rem;
  flex-wrap: wrap;
}

.btn {
  padding: 0.8rem 2rem;
  border-radius: 50px;
  text-decoration: none;
  font-weight: bold;
  transition: transform 0.3s, box-shadow 0.3s;
}

.btn:hover {
  transform: translateY(-3px);
  box-shadow: 0 10px 20px rgba(0,0,0,0.2);
}

.btn-primary {
  background-color: #4caf50; /* 绿色背景 */
  color: white; /* 白色文字 */
}

.btn-secondary {
  background-color: #2196f3; /* 蓝色背景 */
  color: white; /* 白色文字 */
}

@media (max-width: 768px) {
  .hero-section {
    padding: 4rem 0;
    min-height: auto;
  }
  
  .hero-title {
    font-size: 2.5rem;
  }
  
  .hero-subtitle {
    font-size: 1.2rem;
  }
  
  .hero-description {
    font-size: 1rem;
  }
  
  .hero-stats {
    gap: 1.5rem;
  }
  
  .stat-number {
    font-size: 2rem;
  }
  
  .hero-buttons {
    flex-direction: column;
    align-items: center;
  }
  
  .btn {
    width: 200px;
  }
}
</style>