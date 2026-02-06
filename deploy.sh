#!/bin/bash

echo "小茅庐网站部署脚本"

# 确认当前目录
echo "当前目录: $(pwd)"

# 安装依赖
echo "安装依赖..."
npm install

# 构建项目
echo "构建项目..."
npm run build

# 显示构建输出
echo "构建完成，输出文件:"
ls -la dist/
echo "Assets文件:"
ls -la dist/assets/

echo ""
echo "部署说明:"
echo "1. 将 dist 目录中的文件上传到您的托管服务"
echo "2. 确保服务器配置为在路由不存在时返回 index.html (用于 SPA 支持)"
echo "3. 网站已包含管理员联系方式: dangruizhi@outlook.com"
echo ""
echo "部署到常见平台的快速指南:"
echo "- GitHub Pages: 可使用 GitHub Actions 自动部署"
echo "- Netlify: 直接上传 dist 目录或将仓库连接到 Netlify"
echo "- Vercel: 安装 vercel CLI 并运行 'vercel' 命令"
echo "- 其他: 将 dist 目录内容上传到任何静态托管服务"