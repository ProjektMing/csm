document.addEventListener('DOMContentLoaded', () => {
    const randomizeButton = document.getElementById('randomize-button');
    const favoriteButton = document.getElementById('favorite-button');
    const flipper = document.getElementById('flipper');
    // 从 script 标签的 data 属性获取 contextPath
    const contextPath = document.querySelector('script[data-context-path]').dataset.contextPath;

    let currentRestaurant = null;

    randomizeButton.addEventListener('click', function () {
        // 如果卡片已经翻转，先翻回去
        if (flipper.classList.contains('is-flipped')) {
            flipper.classList.remove('is-flipped');
            favoriteButton.style.display = 'none'; // Hide favorite button when flipping back
        }

        button.disabled = true;
        button.textContent = '决定中...';

        // 等待翻回去的动画完成 (300ms)
        setTimeout(() => {
            // 使用 contextPath 构建请求 URL
            fetch(`${contextPath}/random-restaurant`)
                .then(response => {
                    if (!response.ok) {
                        throw new Error('Network response was not ok ' + response.statusText);
                    }
                    return response.json();
                })
                .then(data => {
                    if (data.error) {
                        throw new Error(data.error);
                    }
                    currentRestaurant = data; // Store current restaurant data

                    // 更新背面卡片内容
                    document.getElementById('result-name').textContent = data.name || '天意弄人';
                    document.getElementById('result-description').textContent = data.description || '今天不宜吃饭，建议辟谷。';

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
                    button.disabled = false;
                    button.textContent = '再试一次';
                });
        }, 300);
    });

    favoriteButton.addEventListener('click', function () {
        if (!currentRestaurant) return;

        this.disabled = true;
        this.textContent = '添加中...';

        const params = new URLSearchParams();
        params.append('restaurantId', currentRestaurant.restaurantId);

        fetch(`${contextPath}/favorite`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded',
            },
            body: params
        })
            .then(response => response.json())
            .then(data => {
                if (data.success) {
                    this.textContent = '已收藏';
                    // Keep it disabled to prevent re-adding
                } else {
                    this.textContent = '添加失败'; // Or show original text
                    this.disabled = false; // Allow retry
                    alert(data.message || '无法添加到收藏夹。');
                }
            })
            .catch(error => {
                console.error('Error favoriting restaurant:', error);
                this.textContent = '出错了';
                this.disabled = false;
                alert('添加到收藏夹时出错。');
            });
    });
});
