<template>
  <section id="join" class="join-section">
    <div class="container">
      <h2 class="section-title">加入我们</h2>
      <div class="join-content">
        <div class="join-info">
          <h3>如何加入小茅庐语音房间</h3>
          <div class="room-details">
            <p><strong>房间名称：</strong>小茅庐</p>
            <p><strong>房间号码：</strong>636738</p>
            <p><strong>平台：</strong>小黑盒</p>
            <p><strong>开放时间：</strong>24小时开放</p>
          </div>
          <div class="steps">
            <h4>加入步骤：</h4>
            <div class="step-option">
              <h5>移动端加入：</h5>
              <ol>
                <li>下载并安装小黑盒App</li>
                <li>注册并登录账号</li>
                <li>在搜索框输入房间号 <strong>636738</strong> 或扫描二维码</li>
                <li>点击进入房间，开始愉快的游戏时光</li>
              </ol>
            </div>
            <div class="step-option">
              <h5>Web端加入：</h5>
              <ol>
                <li>访问 <a href="https://chat.xiaoheihe.cn" target="_blank">https://chat.xiaoheihe.cn</a></li>
                <li>登录小黑盒账号</li>
                <li>搜索房间号 <strong>636738</strong> 或直接访问 <a href="https://chat.xiaoheihe.cn/ib5c9x4z" target="_blank">https://chat.xiaoheihe.cn/ib5c9x4z</a></li>
                <li>点击进入房间，开始愉快的游戏时光</li>
              </ol>
            </div>
          </div>
        </div>
        <div class="join-form">
          <h3>留下您的联系方式</h3>
          <form @submit.prevent="handleSubmit">
            <div class="form-group">
              <label for="name">姓名</label>
              <input type="text" id="name" v-model="formData.name" required>
            </div>
            <div class="form-group">
              <label for="game">常玩游戏</label>
              <input type="text" id="game" v-model="formData.game">
            </div>
            <div class="form-group">
              <label for="contact">联系方式</label>
              <input type="text" id="contact" v-model="formData.contact" required>
            </div>
            <div class="form-group">
              <label for="message">留言</label>
              <textarea id="message" v-model="formData.message" rows="4"></textarea>
            </div>
            <button type="submit" class="btn btn-primary">提交</button>
          </form>
          
          <div class="admin-contact">
            <h3>联系管理员</h3>
            <p>如需反馈问题或寻求帮助，可直接联系管理员：</p>
            <p class="admin-email">📧 邮箱：<a href="mailto:dangruizhi@outlook.com">dangruizhi@outlook.com</a></p>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>

<script setup lang="ts">
import { ref } from 'vue';

interface FormData {
  name: string;
  game: string;
  contact: string;
  message: string;
}

const formData = ref<FormData>({
  name: '',
  game: '',
  contact: '',
  message: ''
});

const loading = ref(false);

const handleSubmit = async () => {
  loading.value = true;
  
  try {
    const response = await fetch('https://xiaomaolu-vercel-enhanced.vercel.app/api/contact', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(formData.value)
    });
    
    const result = await response.json();
    
    if (result.success) {
      alert('留言提交成功！我们会尽快与您联系。');
      // 重置表单
      formData.value = {
        name: '',
        game: '',
        contact: '',
        message: ''
      };
    } else {
      alert(`提交失败：${result.message || '未知错误'}`);
    }
  } catch (error) {
    console.error('提交错误:', error);
    alert('网络错误，请稍后重试');
  } finally {
    loading.value = false;
  }
};
</script>

<style scoped>
.join-section {
  background-color: white;
  padding: 5rem 0;
}

.join-content {
  display: grid;
  grid-template-columns: 1fr 1fr;
  gap: 4rem;
}

.join-info h3 {
  font-size: 1.8rem;
  color: #2c3e50;
  margin-bottom: 1.5rem;
}

.room-details {
  background-color: #f8f9fa;
  padding: 1.5rem;
  border-radius: 10px;
  margin-bottom: 2rem;
}

.room-details p {
  margin-bottom: 0.8rem;
  font-size: 1.1rem;
}

.steps h4 {
  margin-bottom: 1rem;
  color: #2c3e50;
}

.step-option {
  margin-bottom: 2rem;
}

.step-option h5 {
  color: #3498db;
  margin-bottom: 0.5rem;
}

.steps ol {
  padding-left: 1.5rem;
  margin-bottom: 1.5rem;
}

.steps li {
  margin-bottom: 0.5rem;
  line-height: 1.6;
}

.steps a {
  color: #3498db;
  text-decoration: none;
}

.steps a:hover {
  text-decoration: underline;
}

.join-form h3 {
  font-size: 1.8rem;
  color: #2c3e50;
  margin-bottom: 1.5rem;
}

.form-group {
  margin-bottom: 1.5rem;
}

.form-group label {
  display: block;
  margin-bottom: 0.5rem;
  font-weight: bold;
  color: #555;
}

.form-group input,
.form-group textarea {
  width: 100%;
  padding: 0.8rem;
  border: 1px solid #ddd;
  border-radius: 5px;
  font-size: 1rem;
}

.form-group input:focus,
.form-group textarea:focus {
  outline: none;
  border-color: #3498db;
}

@media (max-width: 768px) {
  .join-content {
    grid-template-columns: 1fr;
    gap: 2rem;
  }
}
</style>