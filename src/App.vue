<template>
  <div id="app">
    <header class="header">
      <nav class="navbar">
        <div class="logo">
          <img src="./assets/logo.jpg" alt="小茅庐" class="logo-icon" />
          <h1>小茅庐语音房间</h1>
        </div>
        <ul class="nav-links">
          <li><a href="#home">首页</a></li>
          <li><a href="#about">房间介绍</a></li>
          <li><a href="#features">特色功能</a></li>
          <li><a href="#join">加入我们</a></li>
        </ul>
      </nav>
    </header>

    <main>
      <HeroSection />
      <AboutSection />
      <FeaturesSection />
      <JoinSection />
    </main>

    <footer class="footer">
      <div class="footer-content">
        <p>&copy; {{ new Date().getFullYear() }} 小茅庐语音房间 - 房间号：636738</p>
        <p>联系管理员：📧 <a href="mailto:dangruizhi@outlook.com">dangruizhi@outlook.com</a></p>
      </div>
    </footer>
  </div>
</template>

<script setup lang="ts">
import HeroSection from '@/components/HeroSection.vue'
import AboutSection from '@/components/AboutSection.vue'
import FeaturesSection from '@/components/FeaturesSection.vue'
import JoinSection from '@/components/JoinSection.vue'
</script>

<style>
@import url('./styles/global.css');

.logo {
  display: flex;
  align-items: center;
  gap: 10px;
}

.logo-icon {
  width: 40px;
  height: 40px;
  border-radius: 50%;
  object-fit: cover;
}
</style>