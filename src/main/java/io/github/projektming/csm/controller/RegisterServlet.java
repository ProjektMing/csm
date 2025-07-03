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

import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User ui = new User();
        ui.setUsername(username);
        ui.setPassword(password);
        UserDao pp = new UserDaoImpl();
        if (pp.addUser(ui)) {
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        } else {
            FailSolver.alertAndRedirect(response, "注册失败，请重试！", "register.jsp");
        }


    }
}