<%@ page contentType="text/html;charset=UTF-8" %>
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
                <div class="card__face card__face--back">
                    <div class="card__content">
                        <h2 id="result-name" class="card__header">餐厅名称</h2>
                        <p id="result-description" class="card__body">餐厅简介</p>
                        <button id="favorite-button" class="favorite-button" style="display: none;">❤️ 喜欢</button>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="button-container">
        <button id="randomize-button" class="button">开始选择</button>
    </div>
</div>

<script src="${pageContext.request.contextPath}/js/randomizer.js" data-context-path="${pageContext.request.contextPath}"
        defer></script>

</body>
</html>
