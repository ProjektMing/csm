<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>用户登录</title>
    <link rel="stylesheet" type="text/css" href="styles/login.css">
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