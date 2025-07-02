<%--
  Created by IntelliJ IDEA.
  User: ming
  Date: 2025/7/1
  Time: 08:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="your.package.User" %>
<div class="user-profile">
    <%
        // 从session获取用户信息（示例）
        User currentUser = (User) session.getAttribute("currentUser");
        String username = (currentUser != null) ? currentUser.getName() : "Guest";
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

<style>
    .user-profile {
        position: relative;
        display: inline-block;
        font-family: Arial, sans-serif;
    }

    .dropdown-toggle {
        background: #4285f4;
        color: white;
        border: none;
        padding: 8px 15px;
        border-radius: 4px;
        cursor: pointer;
        font-weight: bold;
    }

    .dropdown-menu {
        display: none;
        position: absolute;
        background: white;
        min-width: 160px;
        box-shadow: 0 2px 10px rgba(0,0,0,0.1);
        border-radius: 4px;
        z-index: 100;
        right: 0;
        top: 100%;
        margin-top: 5px;
    }

    .dropdown-menu a {
        display: block;
        padding: 10px 15px;
        text-decoration: none;
        color: #333;
        border-bottom: 1px solid #eee;
    }

    .dropdown-menu a:hover {
        background-color: #f5f5f5;
    }

    .divider {
        height: 1px;
        background: #eee;
        margin: 5px 0;
    }

    .caret {
        display: inline-block;
        margin-left: 5px;
        border-top: 5px solid;
        border-right: 5px solid transparent;
        border-left: 5px solid transparent;
    }
</style>

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
