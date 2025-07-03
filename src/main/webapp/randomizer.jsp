<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="io.github.projektming.csm.model.beans.Restaurant" %>
<html>
<head>
    <title>今天吃什么？</title>
    <link rel="stylesheet" type="text/css" href="styles/md3.less">
    <link rel="stylesheet" type="text/css" href="styles/randomizer.css">
</head>
<body>

<div style="text-align: center; margin-top: 50px;">
    <h1>今天吃什么？</h1>
    <p>让命运来帮你决定！</p>

    <div class="flipper-container">
        <div class="flipper" id="flipper">
            <div class="flipper-face flipper-front">
                <h2>准备好了吗？</h2>
            </div>
            <div class="flipper-face flipper-back">
                <h2 id="result-name"></h2>
                <p id="result-description"></p>
                <button id="favorite-button">❤️ 喜欢</button>
            </div>
        </div>
    </div>

    <button id="randomize-button" class="button">开始选择</button>
</div>

<script src="${pageContext.request.contextPath}/js/randomizer.js" data-context-path="${pageContext.request.contextPath}"
        defer></script>

</body>
</html>
