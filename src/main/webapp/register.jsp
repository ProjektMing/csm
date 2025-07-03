<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>用户注册</title>
    <link rel="stylesheet" href="styles/register.css">
    <link rel="stylesheet" type="text/css" href="styles/md3.css">

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