<%--
  Created by IntelliJ IDEA.
  User: ming
  Date: 2025/7/1
  Time: 08:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="io.github.projektming.csm.model.beans.User" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Menu</title>
    <link rel="stylesheet" type="text/css" href="styles/md3.less">
</head>
<body>
<div class="user-profile">
    <%
        // 从session获取用户信息（示例）
        User currentUser = (User) session.getAttribute("currentUser");
        String username = (currentUser != null) ? currentUser.getUsername() : "Guest";
    %>

    <div class="dropdown">
        <button class="dropdown-toggle">
            <%= username %>
            <span class="caret"></span>
        </button>
        <div class="dropdown-menu">
            <a href="/profile">个人资料</a>
            <a href="/settings">账户设置</a>
            <a href="/messages">我的消息</a>
            <div class="divider"></div>
            <a href="/logout">退出登录</a>
        </div>
    </div>
</div>

<script>
    document.addEventListener('DOMContentLoaded', function() {
        const dropdown = document.querySelector('.dropdown');
        const toggle = dropdown.querySelector('.dropdown-toggle');

        toggle.addEventListener('click', function() {
            const menu = dropdown.querySelector('.dropdown-menu');
            menu.style.display = menu.style.display === 'block' ? 'none' : 'block';
        });

        // 点击外部关闭菜单
        document.addEventListener('click', function(e) {
            if (!dropdown.contains(e.target)) {
                dropdown.querySelector('.dropdown-menu').style.display = 'none';
            }
        });
    });
</script>
</body>
</html>
