# 小茅庐网站部署指南

## 部署选项

### 1. GitHub Pages 部署

1. 构建项目：
```bash
npm run build
```

2. 将 `dist` 目录中的内容推送到 GitHub 仓库的 `gh-pages` 分支，或启用 GitHub Pages 并选择 `gh-pages` 分支作为源。

3. 或者使用 GitHub Actions 自动部署，配置如下：

在 `.github/workflows/deploy.yml` 中添加：

```yaml
name: Deploy to GitHub Pages

on:
  push:
    branches: [ main ]

jobs:
  deploy:
    runs-on: ubuntu-latest
    steps:
    - uses: actions/checkout@v3
    - uses: actions/setup-node@v3
      with:
        node-version: 18
        
    - name: Install dependencies
      run: npm install
      
    - name: Build
      run: npm run build
      
    - name: Deploy to GitHub Pages
      uses: peaceiris/actions-gh-pages@v3
      with:
        github_token: ${{ secrets.GITHUB_TOKEN }}
        publish_dir: ./dist
        publish_branch: gh-pages
```

### 2. Netlify 部署

1. 在项目根目录运行：
```bash
npm run build
```

2. 将 `dist` 目录拖放到 Netlify 仪表板或连接 GitHub 仓库。

### 3. Vercel 部署

1. 安装 Vercel CLI：
```bash
npm i -g vercel
```

2. 登录并部署：
```bash
vercel
```

### 4. 其他静态托管服务

将 `dist` 目录的内容上传到任何静态网站托管服务（如 Firebase Hosting、Surge、Now 等）。

## 环境变量

如需部署到不同环境，可在部署时设置基础路径：

```bash
# 对于子路径部署
vite build --config vite.config.github.ts
```

## 注意事项

- 确保后端API接口（如果有的话）已正确部署并配置CORS策略
- 管理员联系方式：dangruizhi@outlook.com 已在网站各处显示
- 检查所有外部链接是否有效

## 验证部署

部署完成后，访问部署的URL并验证：

1. 网站能正常加载
2. Logo 图片显示正常
3. 所有功能正常
4. 管理员联系方式可见