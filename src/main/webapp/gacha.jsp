<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>随机选菜</title>
    <link rel="stylesheet" type="text/css" href="styles/md3.less">
</head>
<body class="mdc-typography">
<div class="container">
    <div class="header">
        <h1 class="mdc-typography--headline4" style="color: var(--mdc-theme-primary); font-weight: bold;">
            今天吃什么？
        </h1>
    </div>

    <!-- 结果显示区域 -->
    <div class="result-card mdc-elevation--z2" id="resultCard">
        <i class="material-icons-round result-icon" id="resultIcon">restaurant_menu</i>
        <p class="mdc-typography--subtitle1" id="resultPrompt">点击下方按钮随机选择一道菜</p>
        <h2 class="result-text" id="resultText" style="display: none;"></h2>
    </div>

    <!-- 随机选择按钮 -->
    <button class="mdc-button mdc-button--raised" id="randomButton" style="width: 100%; padding: 12px 0; margin-bottom: 24px;">
            <span class="mdc-button__label" style="font-size: 18px;">
                <i class="material-icons-round" style="margin-right: 8px;">shuffle</i>
                随机选菜
            </span>
    </button>

    <!-- 菜品列表标题 -->
    <h2 class="mdc-typography--headline6" style="color: var(--mdc-theme-primary); margin-bottom: 8px;">
        可选菜品 (<span id="dishCount">20</span>)
    </h2>

    <!-- 菜品列表 -->
    <div class="dish-list mdc-elevation--z1">
        <!-- 示例菜品，实际应该从服务器获取 -->
        <div class="dish-item">
            <span class="dish-name mdc-typography--body1">红烧肉</span>
            <button class="mdc-icon-button material-icons-round delete-btn" onclick="deleteDish(this)">delete</button>
        </div>
        <div class="dish-item">
            <span class="dish-name mdc-typography--body1">清蒸鱼</span>
            <button class="mdc-icon-button material-icons-round delete-btn" onclick="deleteDish(this)">delete</button>
        </div>
        <div class="dish-item">
            <span class="dish-name mdc-typography--body1">宫保鸡丁</span>
            <button class="mdc-icon-button material-icons-round delete-btn" onclick="deleteDish(this)">delete</button>
        </div>
        <div class="dish-item">
            <span class="dish-name mdc-typography--body1">麻婆豆腐</span>
            <button class="mdc-icon-button material-icons-round delete-btn" onclick="deleteDish(this)">delete</button>
        </div>
        <div class="dish-item">
            <span class="dish-name mdc-typography--body1">水煮肉片</span>
            <button class="mdc-icon-button material-icons-round delete-btn" onclick="deleteDish(this)">delete</button>
        </div>
        <div class="dish-item">
            <span class="dish-name mdc-typography--body1">鱼香肉丝</span>
            <button class="mdc-icon-button material-icons-round delete-btn" onclick="deleteDish(this)">delete</button>
        </div>
        <div class="dish-item">
            <span class="dish-name mdc-typography--body1">回锅肉</span>
            <button class="mdc-icon-button material-icons-round delete-btn" onclick="deleteDish(this)">delete</button>
        </div>
        <div class="dish-item">
            <span class="dish-name mdc-typography--body1">糖醋排骨</span>
            <button class="mdc-icon-button material-icons-round delete-btn" onclick="deleteDish(this)">delete</button>
        </div>
        <div class="dish-item">
            <span class="dish-name mdc-typography--body1">西红柿炒鸡蛋</span>
            <button class="mdc-icon-button material-icons-round delete-btn" onclick="deleteDish(this)">delete</button>
        </div>
        <div class="dish-item">
            <span class="dish-name mdc-typography--body1">青椒土豆丝</span>
            <button class="mdc-icon-button material-icons-round delete-btn" onclick="deleteDish(this)">delete</button>
        </div>
        <div class="dish-item">
            <span class="dish-name mdc-typography--body1">地三鲜</span>
            <button class="mdc-icon-button material-icons-round delete-btn" onclick="deleteDish(this)">delete</button>
        </div>
        <div class="dish-item">
            <span class="dish-name mdc-typography--body1">酸辣汤</span>
            <button class="mdc-icon-button material-icons-round delete-btn" onclick="deleteDish(this)">delete</button>
        </div>
        <div class="dish-item">
            <span class="dish-name mdc-typography--body1">炒青菜</span>
            <button class="mdc-icon-button material-icons-round delete-btn" onclick="deleteDish(this)">delete</button>
        </div>
        <div class="dish-item">
            <span class="dish-name mdc-typography--body1">红烧牛肉</span>
            <button class="mdc-icon-button material-icons-round delete-btn" onclick="deleteDish(this)">delete</button>
        </div>
        <div class="dish-item">
            <span class="dish-name mdc-typography--body1">咖喱鸡饭</span>
            <button class="mdc-icon-button material-icons-round delete-btn" onclick="deleteDish(this)">delete</button>
        </div>
        <div class="dish-item">
            <span class="dish-name mdc-typography--body1">炸酱面</span>
            <button class="mdc-icon-button material-icons-round delete-btn" onclick="deleteDish(this)">delete</button>
        </div>
        <div class="dish-item">
            <span class="dish-name mdc-typography--body1">饺子</span>
            <button class="mdc-icon-button material-icons-round delete-btn" onclick="deleteDish(this)">delete</button>
        </div>
        <div class="dish-item">
            <span class="dish-name mdc-typography--body1">Pizza</span>
            <button class="mdc-icon-button material-icons-round delete-btn" onclick="deleteDish(this)">delete</button>
        </div>
        <div class="dish-item">
            <span class="dish-name mdc-typography--body1">汉堡</span>
            <button class="mdc-icon-button material-icons-round delete-btn" onclick="deleteDish(this)">delete</button>
        </div>
        <div class="dish-item">
            <span class="dish-name mdc-typography--body1">沙拉</span>
            <button class="mdc-icon-button material-icons-round delete-btn" onclick="deleteDish(this)">delete</button>
        </div>
    </div>
</div>

<!-- 添加菜品的浮动按钮 -->
<button class="mdc-fab mdc-fab--extended fab" onclick="showAddDialog()">
    <span class="material-icons-round mdc-fab__icon">add</span>
    <span class="mdc-fab__label">添加菜品</span>
</button>

<!-- 添加菜品的对话框 -->
<div class="mdc-dialog" id="addDishDialog">
    <div class="mdc-dialog__container">
        <div class="mdc-dialog__surface">
            <h2 class="mdc-dialog__title">添加新菜品</h2>
            <div class="mdc-dialog__content">
                <div class="mdc-text-field">
                    <input type="text" id="dishNameInput" class="mdc-text-field__input" required>
                    <label class="mdc-floating-label" for="dishNameInput">菜品名称</label>
                    <div class="mdc-line-ripple"></div>
                </div>
            </div>
            <div class="mdc-dialog__actions">
                <button type="button" class="mdc-button mdc-dialog__button" data-mdc-dialog-action="cancel">
                    <span class="mdc-button__label">取消</span>
                </button>
                <button type="button" class="mdc-button mdc-dialog__button" data-mdc-dialog-action="accept" onclick="addDish()">
                    <span class="mdc-button__label">添加</span>
                </button>
            </div>
        </div>
    </div>
    <div class="mdc-dialog__scrim"></div>
</div>

<!-- 引入 Material Components Web JS -->
<script src="https://unpkg.com/material-components-web@latest/dist/material-components-web.min.js"></script>
<script>
    // 初始化 Material Components
    const dialog = new mdc.dialog.MDCDialog(document.getElementById('addDishDialog'));
    const textField = new mdc.textField.MDCTextField(document.querySelector('.mdc-text-field'));

    // 菜品数据（实际项目中应该从服务器获取）
    let dishes = [
        "红烧肉", "清蒸鱼", "宫保鸡丁", "麻婆豆腐", "水煮肉片",
        "鱼香肉丝", "回锅肉", "糖醋排骨", "西红柿炒鸡蛋", "青椒土豆丝",
        "地三鲜", "酸辣汤", "炒青菜", "红烧牛肉", "咖喱鸡饭",
        "炸酱面", "饺子", "Pizza", "汉堡", "沙拉"
    ];

    // 随机选菜函数
    document.getElementById('randomButton').addEventListener('click', function() {
        // 显示加载状态
        document.getElementById('resultIcon').textContent = 'autorenew';
        document.getElementById('resultIcon').style.animation = 'spin 1s linear infinite';
        document.getElementById('resultPrompt').style.display = 'none';
        document.getElementById('resultText').style.display = 'none';

        // 模拟延迟
        setTimeout(function() {
            // 随机选择一道菜
            const randomIndex = Math.floor(Math.random() * dishes.length);
            const selectedDish = dishes[randomIndex];

            // 更新UI
            document.getElementById('resultIcon').textContent = 'dining';
            document.getElementById('resultIcon').style.animation = 'none';
            document.getElementById('resultText').textContent = selectedDish;
            document.getElementById('resultText').style.display = 'block';

            // 使用 MDC 的涟漪效果
            const resultCard = document.getElementById('resultCard');
            resultCard.classList.add('mdc-ripple-surface');
            mdc.ripple.MDCRipple.attachTo(resultCard);
        }, 1000);
    });

    // 删除菜品函数
    function deleteDish(button) {
        const dishItem = button.closest('.dish-item');
        const dishName = dishItem.querySelector('.dish-name').textContent;

        // 从数组中删除
        dishes = dishes.filter(dish => dish !== dishName);

        // 从DOM中删除
        dishItem.remove();

        // 更新计数
        document.getElementById('dishCount').textContent = dishes.length;
    }

    // 显示添加菜品对话框
    function showAddDialog() {
        dialog.open();
    }

    // 添加新菜品
    function addDish() {
        const input = document.getElementById('dishNameInput');
        const dishName = input.value.trim();

        if (dishName) {
            // 添加到数组
            dishes.push(dishName);

            // 添加到DOM
            const dishList = document.querySelector('.dish-list');
            const newDishItem = document.createElement('div');
            newDishItem.className = 'dish-item';
            newDishItem.innerHTML = `
                    <span class="dish-name mdc-typography--body1">${dishName}</span>
                    <button class="mdc-icon-button material-icons-round delete-btn" onclick="deleteDish(this)">delete</button>
                `;
            dishList.appendChild(newDishItem);

            // 更新计数
            document.getElementById('dishCount').textContent = dishes.length;

            // 清空输入框
            input.value = '';

            // 关闭对话框
            dialog.close();
        }
    }

    // 旋转动画
    const style = document.createElement('style');
    style.textContent = `
            @keyframes spin {
                from { transform: rotate(0deg); }
                to { transform: rotate(360deg); }
            }
        `;
    document.head.appendChild(style);
</script>
</body>
</html>