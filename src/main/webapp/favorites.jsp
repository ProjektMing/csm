<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的收藏</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://unpkg.com/material-components-web@latest/dist/material-components-web.min.css">
    <style>
        body {
            font-family: 'Roboto', sans-serif;
            background-color: #f5f5f5;
            padding: 20px;
        }

        .container {
            max-width: 800px;
            margin: 0 auto;
        }

        .mdc-card {
            margin-bottom: 16px;
        }

        .mdc-card__primary-action {
            padding: 16px;
        }

        .mdc-card__title {
            font-size: 1.25rem;
            font-weight: 500;
        }

        .mdc-card__subtitle {
            font-size: 0.875rem;
            color: rgba(0, 0, 0, 0.6);
        }

        .mdc-card__actions {
            justify-content: flex-end;
        }

        #favorites-list {
            list-style-type: none;
            padding: 0;
        }
    </style>
</head>
<body>

<div class="container">
    <h1 class="mdc-typography--headline4">我的收藏</h1>

    <ul id="favorites-list">
        <!-- 收藏的餐厅将在这里动态加载 -->
    </ul>
</div>

<script src="https://unpkg.com/material-components-web@latest/dist/material-components-web.min.js"></script>
<script src="${pageContext.request.contextPath}/js/favorites.js" defer></script>
</body>
</html>

