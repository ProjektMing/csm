<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>用户登录</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Arial', sans-serif;
        }

        body {
            background-color: #f5f5f5;
            color: #333;
            line-height: 1.6;
        }

        .container {
            max-width: 500px;
            margin: 50px auto;
            padding: 30px;
            background: #fff;
            border-radius: 10px;
            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.1);
        }

        h1 {
            text-align: center;
            color: #2c3e50;
            margin-bottom: 20px;
            font-size: 28px;
        }

        hr {
            border: 0;
            height: 1px;
            background: #ddd;
            margin: 20px 0;
        }

        .form-group {
            margin-bottom: 20px;
        }

        label {
            display: block;
            margin-bottom: 8px;
            font-weight: bold;
            color: #555;
        }

        input[type="text"],
        input[type="password"] {
            width: 100%;
            padding: 12px;
            border: 1px solid #ddd;
            border-radius: 4px;
            font-size: 16px;
            transition: border 0.3s;
        }

        input[type="text"]:focus,
        input[type="password"]:focus {
            border-color: #3498db;
            outline: none;
            box-shadow: 0 0 5px rgba(52, 152, 219, 0.3);
        }

        .btn {
            display: inline-block;
            background: #3498db;
            color: white;
            padding: 12px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
            transition: background 0.3s;
            margin-right: 10px;
        }

        .btn:hover {
            background: #2980b9;
        }

        .btn-reset {
            background: #95a5a6;
        }

        .btn-reset:hover {
            background: #7f8c8d;
        }

        .check-username {
            color: #3498db;
            text-decoration: none;
            font-size: 14px;
            margin-left: 10px;
        }

        .check-username:hover {
            text-decoration: underline;
        }

        .register-link {
            text-align: center;
            margin-top: 20px;
        }

        .register-link a {
            color: #3498db;
            text-decoration: none;
        }

        .register-link a:hover {
            text-decoration: underline;
        }

        .form-footer {
            margin-top: 20px;
            text-align: center;
        }
    </style>
    <script>
        function check() {
            if (f.username.value === "") {
                alert("用户名不能为空");
                return false;
            } else if (f.password.value === "") {
                alert("密码不能为空！");
                return false;
            } else {
                return true;
            }
        }
    </script>
</head>
<body>
<div class="container">
    <h1>即刻开吃！</h1>
    <hr>
    <form name="f" method="post" action="login.action" onSubmit="return check()">
        <div class="form-group">
            <label for="username">用户名：</label>
            <div style="display: flex; align-items: center;">
                <input type="text" id="username" name="username" placeholder="请输入用户名">
            </div>
        </div>
        <div class="form-group">
            <label for="password">密码：</label>
            <input type="password" id="password" name="password" placeholder="请输入密码">
        </div>
        <div class="form-footer">
            <input type="submit" value="登录" class="btn">
            <input type="reset" value="重置" class="btn btn-reset">
            <p class="register-link">还没有账户？<a href="register.jsp">立即注册</a></p>
            <p class="register-link">想立刻体验？<a href="randomizer.jsp">游客登陆</a></p>
        </div>
    </form>
</div>
</body>
</html>