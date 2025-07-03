<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的收藏</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://unpkg.com/material-components-web@latest/dist/material-components-web.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/favorites.css">
    <link rel="stylesheet" href="styles/md3.css">
</head>
<body>

<div class="container">
    <h1 class="mdc-typography--headline4">我的收藏</h1>

    <ul id="favorites-list">
        <!-- 收藏的餐厅将在这里动态加载 -->
    </ul>
</div>

<script src="https://unpkg.com/material-components-web@latest/dist/matrial-components-web.min.js"></script>
<script src="${pageContext.request.contextPath}/js/favorites.js" defer></script>
</body>
</html>

