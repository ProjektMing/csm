<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="io.github.projektming.csm.model.beans.Restaurant" %>
<html>
<head>
    <title>今天吃什么？</title>
    <link rel="stylesheet" type="text/css" href="styles/md3.less">
    <style>
        .flipper-container {
            perspective: 1000px;
            width: 100%;
            max-width: 400px;
            height: 250px;
            margin: 40px auto;
        }

        .flipper {
            width: 100%;
            height: 100%;
            transition: transform 0.6s;
            transform-style: preserve-3d;
            position: relative;
        }

        .flipper.is-flipped {
            transform: rotateY(180deg);
        }

        .flipper-face {
            position: absolute;
            width: 100%;
            height: 100%;
            backface-visibility: hidden;
            border-radius: 16px;
            box-shadow: 0 4px 8px 0 rgba(0,0,0,0.1);
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            padding: 20px;
            box-sizing: border-box;
        }

        .flipper-front {
            background-color: var(--md-sys-color-surface-variant);
            color: var(--md-sys-color-on-surface-variant);
        }

        .flipper-back {
            background-color: var(--md-sys-color-primary-container);
            color: var(--md-sys-color-on-primary-container);
            transform: rotateY(180deg);
        }

        #result-name {
            font-size: 24px;
            font-weight: 500;
        }

        #result-description {
            font-size: 16px;
            margin-top: 8px;
        }

    </style>
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
            </div>
        </div>
    </div>

    <button id="randomize-button" class="button">开始选择</button>
</div>

<script>
    document.getElementById('randomize-button').addEventListener('click', function() {
        const flipper = document.getElementById('flipper');
        const button = this;

        // 如果卡片已经翻转，先翻回去
        if (flipper.classList.contains('is-flipped')) {
            flipper.classList.remove('is-flipped');
        }

        button.disabled = true;
        button.textContent = '决定中...';

        // 等待翻回去的动画完成
        setTimeout(() => {
            // 发起请求获取随机餐厅
            fetch('${pageContext.request.contextPath}/random-restaurant')
                .then(response => response.json())
                .then(data => {
                    // 更新背面卡片内容
                    document.getElementById('result-name').textContent = data.name || '天意弄人';
                    document.getElementById('result-description').textContent = data.description || '今天不宜吃饭，建议辟谷。';

                    // 翻转卡片
                    flipper.classList.add('is-flipped');
                })
                .catch(error => {
                    console.error('Error fetching random restaurant:', error);
                    document.getElementById('result-name').textContent = '出错了';
                    document.getElementById('result-description').textContent = '网络似乎开小差了，请稍后再试。';
                    flipper.classList.add('is-flipped');
                })
                .finally(() => {
                    button.disabled = false;
                    button.textContent = '再试一次';
                });
        }, 300);
    });
</script>

</body>
</html>

