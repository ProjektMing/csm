let randomizeButton = document.getElementById("randomize-button");
let favoriteButton = document.getElementById("favorite-button");
let currentRestaurantId = null; // 用于存储当前餐厅的ID

randomizeButton.addEventListener('click', function () {
    // 如果卡片已经翻转，先翻回去
    if (flipper.classList.contains('is-flipped')) {
        flipper.classList.remove('is-flipped');
        favoriteButton.style.display = 'none'; // Hide favorite button when flipping back
    }

    // 修正这里：使用 randomizeButton 而不是 button
    randomizeButton.disabled = true;
    randomizeButton.textContent = '决定中...';

    // 等待翻回去的动画完成 (300ms)
    setTimeout(() => {
        // 使用 contextPath 构建请求 URL
        fetch(`./random-restaurant`)
            .then(response => {
                if (!response.ok) {
                    throw new Error('Network response was not ok ' + response.statusText);
                }
                return response.json();
            })
            .then(data => {
                if (data.error) {
                    document.write("错误: " + data.error);
                    throw new Error(data.error);
                }

                // 更新背面卡片内容
                document.getElementById('result-name').textContent = data.name;
                document.getElementById('result-description').textContent = data.description;
                currentRestaurantId = data.restaurantId; // 保存餐厅ID

                // 翻转卡片
                flipper.classList.add('is-flipped');
                favoriteButton.style.display = 'block'; // Show favorite button
                favoriteButton.disabled = false;
                favoriteButton.textContent = '❤️ 喜欢';
            })
            .catch(error => {
                console.error('Error fetching random restaurant:', error);
                document.getElementById('result-name').textContent = '出错了';
                document.getElementById('result-description').textContent = '网络似乎开小差了，请稍后再试。';
                flipper.classList.add('is-flipped');
            })
            .finally(() => {
                // 这里同样需要修正为 randomizeButton
                randomizeButton.disabled = false;
                randomizeButton.textContent = '再试一次';
            });
    }, 300);
});

favoriteButton.addEventListener('click', function () {
    if (!currentRestaurantId) {
        console.error('No restaurant selected to favorite.');
        return;
    }

    favoriteButton.disabled = true;
    favoriteButton.textContent = '...';

    fetch('./favorite', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded',
        },
        body: new URLSearchParams({
            'restaurantId': currentRestaurantId
        })
    })
        .then(response => {
            if (response.status === 401) {
                window.location.href = './login.jsp';
                throw new Error('User not logged in');
            }
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => {
            if (data.success) {
                favoriteButton.textContent = '已收藏';
            } else {
                favoriteButton.textContent = '收藏失败';
                console.error('Failed to favorite:', data.message);
            }
        })
        .catch(error => {
            console.error('Error favoriting restaurant:', error);
            favoriteButton.textContent = '出错';
            // Re-enable button if there was an error, so user can try again
            favoriteButton.disabled = false;
        });
});

// 添加查看收藏按钮的事件监听
document.getElementById('view-favorites-button').addEventListener('click', function () {
    window.location.href = './favorites.jsp';
});