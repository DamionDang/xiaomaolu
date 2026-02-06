<template>
  <section id="about" class="about-section">
    <div class="container">
      <h2 class="section-title">关于我们</h2>
      <div class="about-content">
        <div class="about-text">
          <h3>{{ roomInfo.roomName || '小茅庐 - 游戏爱好者的温馨家园' }}</h3>
          <p>
            {{ roomInfo.description || '小茅庐是小黑盒平台上的一个语音房间（房间号：636738），致力于为所有游戏爱好者提供一个轻松愉快的交流环境。' }}
          </p>
          <p>
            无论你是新手玩家还是资深大神，在这里都能找到志同道合的朋友。我们专注于游戏开黑、经验分享以及日常聊天，
            让每一位成员都能感受到家一般的温暖。
          </p>
          <div class="stats">
            <div class="stat-item">
              <h4>{{ roomInfo.roomId || '636738' }}</h4>
              <p>房间号码</p>
            </div>
            <div class="stat-item">
              <h4>在线</h4>
              <p>状态</p>
            </div>
          </div>
          <div class="room-link">
            <a :href="'https://chat.xiaoheihe.cn/ib5c9x4z'" target="_blank" class="btn btn-primary">进入小茅庐房间</a>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>

<script setup lang="ts">
import { ref, onMounted } from 'vue';

interface RoomInfo {
  roomId?: string;
  roomName?: string;
  description?: string;
  onlineStatus?: boolean;
  memberCount?: number;
}

const roomInfo = ref<RoomInfo>({});

onMounted(async () => {
  try {
    const response = await fetch('https://xiaomaolu-vercel-api.vercel.app/api/room-info');
    if (response.ok) {
      roomInfo.value = await response.json();
    }
  } catch (error) {
    console.error('获取房间信息失败:', error);
    // 使用默认值
    roomInfo.value = {
      roomId: '636738',
      roomName: '小茅庐 - 游戏爱好者的温馨家园',
      description: '小茅庐是小黑盒平台上的一个语音房间（房间号：636738），致力于为所有游戏爱好者提供一个轻松愉快的交流环境。',
      onlineStatus: true,
      memberCount: 0
    };
  }
});
</script>

<style scoped>
.about-section {
  background-color: white;
  padding: 5rem 0;
}

.about-content {
  display: grid;
  grid-template-columns: 1fr;
  gap: 4rem;
  align-items: center;
}

.about-text h3 {
  font-size: 2rem;
  color: #2c3e50;
  margin-bottom: 1.5rem;
}

.about-text p {
  font-size: 1.1rem;
  margin-bottom: 1.5rem;
  color: #555;
  line-height: 1.8;
}

.stats {
  display: flex;
  justify-content: flex-start;
  margin-top: 2rem;
  flex-wrap: wrap;
  gap: 2rem;
}

.stat-item {
  text-align: center;
  padding: 1rem;
}

.stat-item h4 {
  font-size: 2rem;
  color: #4caf50; /* 更改为绿色 */
  margin-bottom: 0.5rem;
}

.stat-item p {
  font-size: 1rem;
  color: #777;
  margin: 0;
}

.room-link {
  margin-top: 2rem;
}

.btn-primary {
  display: inline-block;
  background-color: #4caf50; /* 更改为绿色 */
  color: white;
  padding: 0.8rem 1.5rem;
  border-radius: 5px;
  text-decoration: none;
  font-weight: bold;
  transition: background-color 0.3s;
}

.btn-primary:hover {
  background-color: #3d8b40; /* 稍深一点的绿色 */
}

@media (max-width: 768px) {
  .about-content {
    grid-template-columns: 1fr;
    gap: 2rem;
  }

  .about-text h3 {
    font-size: 1.8rem;
  }

  .stats {
    flex-direction: column;
    gap: 1.5rem;
  }
}
</style>