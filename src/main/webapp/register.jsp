<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>用户注册</title>
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

        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }

        td {
            padding: 12px;
            vertical-align: middle;
        }

        td:first-child {
            text-align: right;
            font-weight: bold;
            color: #555;
            width: 30%;
        }

        input[type="text"],
        input[type="password"] {
            width: 100%;
            padding: 10px;
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
            background: #2ecc71;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
            transition: background 0.3s;
            margin-right: 10px;
            text-decoration: none;
        }

        .btn:hover {
            background: #27ae60;
        }

        .btn-reset {
            background: #95a5a6;
        }

        .btn-reset:hover {
            background: #7f8c8d;
        }

        .btn-back {
            background: #3498db;
        }

        .btn-back:hover {
            background: #2980b9;
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

        .form-footer {
            margin-top: 20px;
            text-align: center;
        }
    </style>
    <script>
        function checkName() {
            var username = f.username.value;
            if (username === "") {
                alert("请输入用户名");
            } else {
                window.open("checkName.action?username=" + encodeURI(username),
                    "check", "menubar=no,height=300,width=400,left=300,top=80");
            }
        }

        function check() {
            if (f.username.value === "") {
                alert("用户名不能为空");
                return false;
            } else if (f.password.value === "" || f.password.value !== f.password1.value) {
                alert("密码为空或两次密码不一致！");
                return false;
            } else {
                return true;
            }
        }
    </script>
</head>
<body>
<div class="container">
    <h1>用户注册</h1>
    <hr>
    <form name="f" method="post" action="register.action" onSubmit="return check()">
        <table>
            <tr>
                <td>用户名：</td>
                <td>
                    <input type="text" name="username" placeholder="请输入用户名">
                </td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><label>
                    <input type="password" name="password" placeholder="请输入密码">
                </label></td>
            </tr>
            <tr>
                <td>密码确认：</td>
                <td><label>
                    <input type="password" name="password1" placeholder="请再次输入密码">
                </label></td>
            </tr>
        </table>
        <div class="form-footer">
            <a href="login.jsp" class="btn btn-back">返回登录</a>
            <input type="submit" value="注册" class="btn">
            <input type="reset" value="重置" class="btn btn-reset">
        </div>
    </form>
</div>
</body>
</html>