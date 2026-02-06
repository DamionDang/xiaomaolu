<template>
  <section id="features" class="features-section">
    <div class="container">
      <h2 class="section-title">房间特色</h2>
      <div class="features-grid">
        <div class="feature-card">
          <div class="feature-icon">🎮</div>
          <h3>游戏开黑</h3>
          <p>与志同道合的伙伴一起畅玩各类游戏，享受团队协作的乐趣。</p>
        </div>
        <div class="feature-card">
          <div class="feature-icon">🎓</div>
          <h3>经验分享</h3>
          <p>资深玩家分享游戏攻略和技巧，新手也能快速成长。</p>
        </div>
        <div class="feature-card">
          <div class="feature-icon">💬</div>
          <h3>语音聊天</h3>
          <p>高质量语音交流，随时随地与朋友保持联系。</p>
        </div>
        <div class="feature-card">
          <div class="feature-icon">🎯</div>
          <h3>竞技提升</h3>
          <p>通过与高手切磋，不断提升自己的游戏水平。</p>
        </div>
        <div class="feature-card">
          <div class="feature-icon">🎉</div>
          <h3>活动赛事</h3>
          <p>定期举办各种游戏活动和小型比赛，增加互动乐趣。</p>
        </div>
        <div class="feature-card">
          <div class="feature-icon">🤝</div>
          <h3>友好氛围</h3>
          <p>友善和谐的社区环境，让每位成员都感到舒适。</p>
        </div>
      </div>
    </div>
  </section>
</template>

<script setup lang="ts">
// Features Section Component
</script>

<style scoped>
.features-section {
  background-color: #f8f9fa;
  padding: 5rem 0;
}

.features-grid {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(300px, 1fr));
  gap: 2rem;
}

.feature-card {
  background: white;
  border-radius: 10px;
  padding: 2rem;
  text-align: center;
  box-shadow: 0 5px 15px rgba(0,0,0,0.08);
  transition: transform 0.3s ease, box-shadow 0.3s ease;
}

.feature-card:hover {
  transform: translateY(-10px);
  box-shadow: 0 15px 30px rgba(0,0,0,0.15);
}

.feature-icon {
  font-size: 3rem;
  margin-bottom: 1.5rem;
}

.feature-card h3 {
  font-size: 1.5rem;
  color: #2c3e50;
  margin-bottom: 1rem;
}

.feature-card p {
  color: #666;
  line-height: 1.6;
}

@media (max-width: 768px) {
  .features-grid {
    grid-template-columns: 1fr;
  }
}
</style>