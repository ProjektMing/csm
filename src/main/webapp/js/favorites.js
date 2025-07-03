document.addEventListener('DOMContentLoaded', function () {
    const favoritesList = document.getElementById('favorites-list');

    fetch('./get-favorites') // This endpoint needs to be created
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
        .then(favorites => {
            if (favorites.length === 0) {
                favoritesList.innerHTML = '<p>您还没有收藏任何餐厅。</p>';
                return;
            }

            const fragment = document.createDocumentFragment();
            favorites.forEach(fav => {
                const li = document.createElement('li');
                li.classList.add('mdc-card');

                // This is a simplified card. We can add more details later.
                li.innerHTML = `
                    <div class="mdc-card__primary-action">
                        <div class="mdc-card__primary">
                            <h2 class="mdc-card__title">${fav.restaurant_name}</h2>
                            <h3 class="mdc-card__subtitle">${fav.restaurant_description}</h3>
                        </div>
                    </div>
                `;
                fragment.appendChild(li);
            });

            favoritesList.appendChild(fragment); // Append the fragment to the DOM once
        })
        .catch(error => {
            console.error('Error fetching favorites:', error);
            favoritesList.innerHTML = '<p>加载收藏失败，请稍后重试。</p>';
        });
});
