package io.github.projektming.csm.controller;

import io.github.projektming.csm.model.beans.User;
import io.github.projektming.csm.model.dao.UserDao;
import io.github.projektming.csm.model.dao.UserDaoImpl;
import io.github.projektming.csm.util.FailSolver;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User ui = new User();
        ui.setUsername(username);
        ui.setPassword(password);
        UserDao pp = new UserDaoImpl();
        User p = pp.getUserByLogin(ui);

        if (p != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", p);
            request.getRequestDispatcher("/randomizer.jsp").forward(request, response);
        } else {
            FailSolver.alertAndRedirect(response, "用户名或密码错误，请重新输入！", "login.jsp");
        }
    }
}