# 小茅庐语音房间宣传网站

这是一个为小黑盒语音房间（房间号：636738，房间名：小茅庐）制作的宣传网站，主要功能是游戏开黑、游戏经验分享和语音聊天。

## 技术栈

- **前端**: Vue 3 + TypeScript
- **后端**: Java + Kotlin + Spring Boot
- **数据库**: H2 (开发环境)

## 功能特性

- 响应式设计，支持移动端访问
- 房间信息展示
- 特色功能介绍
- 用户留言系统
- 实时房间状态显示

## 项目结构

```
.
├── src/                    # 前端源码
│   ├── components/         # Vue组件
│   ├── views/             # 页面视图
│   ├── assets/            # 静态资源
│   ├── styles/            # 样式文件
│   ├── router/            # 路由配置
│   ├── types/             # 类型定义
│   ├── main.ts            # 主入口文件
│   └── App.vue            # 根组件
├── backend/               # 后端源码
│   ├── src/main/kotlin/   # Kotlin源码
│   ├── src/main/resources/ # 配置文件
│   └── pom.xml            # Maven配置
├── package.json           # 前端依赖配置
├── vite.config.ts         # Vite构建配置
└── README.md              # 项目说明
```

## 开发环境搭建

### 前端设置

1. 安装 Node.js (版本 >= 16.0.0)
2. 安装依赖：
```bash
npm install
```
3. 启动开发服务器：
```bash
npm run dev
```

### 后端设置

1. 确保已安装 JDK 17+
2. 构建项目：
```bash
cd backend
mvn clean install
```
3. 启动后端服务：
```bash
mvn spring-boot:run
```

## API 接口

- `GET /api/room/info` - 获取房间信息
- `POST /api/contact` - 提交联系表单
- `GET /api/contact` - 获取所有联系表单（管理员）

## 部署

### 前端部署

构建生产版本：
```bash
npm run build
```

构建后的文件位于 `dist/` 目录，可部署到任何静态文件服务器。

### 后端部署

打包成JAR文件：
```bash
cd backend
mvn clean package
```

运行JAR文件：
```bash
java -jar target/xiaoheizi-promotion-backend-1.0.0.jar
```

## 环境变量

- `SERVER_PORT`: 后端服务端口（默认: 8080）
- `FRONTEND_URL`: 前端地址（默认: http://localhost:3000）

## 贡献

欢迎提交 Issue 和 Pull Request 来改进此项目。

## 联系方式

如有问题或建议，请联系管理员：
- 邮箱：dangruizhi@outlook.com

## 许可证

本项目仅供学习参考使用。