
-- 创建用户表
CREATE TABLE Users (
    user_id SERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL
);

COMMENT ON TABLE Users IS '用户信息表';

-- 创建餐厅表
CREATE TABLE Restaurants (
    restaurant_id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    image_url VARCHAR(255),
    categories VARCHAR(255) NOT NULL,
    flavors VARCHAR(255),
    opening_time TIME,
    closing_time TIME
);

COMMENT ON TABLE Restaurants IS '餐厅信息表';
COMMENT ON COLUMN Restaurants.categories IS '提供的餐点类别，如中餐、西餐、快餐等，多个用逗号分隔';
COMMENT ON COLUMN Restaurants.flavors IS '口味风格，如辣、甜、清淡等，多个用逗号分隔';
COMMENT ON COLUMN Restaurants.opening_time IS '每天开店时间，如 08:00:00';
COMMENT ON COLUMN Restaurants.closing_time IS '每天关店时间，如 22:00:00';

-- 创建收藏表
CREATE TABLE Favorites (
    favorite_id SERIAL PRIMARY KEY,
    user_id INT NOT NULL,
    restaurant_id INT NOT NULL,
    rating DECIMAL(3,1) CHECK (rating >= 0 AND rating <= 10),
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (restaurant_id) REFERENCES Restaurants(restaurant_id),
    UNIQUE (user_id, restaurant_id)
);

COMMENT ON TABLE Favorites IS '用户收藏餐厅表';

-- 创建饮食偏好类型表
CREATE TABLE Dietary_Preference_Types (
    preference_type_id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    description VARCHAR(255)
);

COMMENT ON TABLE Dietary_Preference_Types IS '饮食偏好类型字典表';
COMMENT ON COLUMN Dietary_Preference_Types.name IS '偏好类型名称，如辣度、甜度等';
COMMENT ON COLUMN Dietary_Preference_Types.description IS '偏好类型描述';

-- 创建用户饮食偏好表
CREATE TABLE User_Dietary_Preferences (
    preference_id SERIAL PRIMARY KEY,
    user_id INT NOT NULL,
    preference_type_id INT NOT NULL,
    preference_level SMALLINT NOT NULL CHECK (preference_level BETWEEN -1 AND 1),
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (preference_type_id) REFERENCES Dietary_Preference_Types(preference_type_id),
    UNIQUE (user_id, preference_type_id)
);

COMMENT ON TABLE User_Dietary_Preferences IS '用户饮食偏好关联表';
COMMENT ON COLUMN User_Dietary_Preferences.preference_level IS '-1到1的偏好等级';

-- 插入常见的饮食偏好类型
INSERT INTO Dietary_Preference_Types (name, description) VALUES
('spice_level', '吃辣等级：-1(讨厌辣)，0(中立)，1(喜欢辣)'),
('sweetness_level', '甜度偏好：-1(讨厌甜)，0(中立)，1(喜欢甜)'),
('saltiness_level', '咸度偏好：-1(讨厌咸)，0(中立)，1(喜欢咸)'),
('oiliness_level', '油腻程度偏好：-1(讨厌油腻)，0(中立)，1(喜欢油腻)');

