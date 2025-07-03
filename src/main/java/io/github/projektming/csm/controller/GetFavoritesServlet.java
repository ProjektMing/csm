package io.github.projektming.csm.controller;

import io.github.projektming.csm.model.beans.User;
import io.github.projektming.csm.model.dao.FavoriteDao;
import io.github.projektming.csm.model.dao.FavoriteDaoImpl;
import io.github.projektming.csm.util.JsonUtil;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/get-favorites")
public class GetFavoritesServlet extends HttpServlet {
    private final FavoriteDao favoriteDao = new FavoriteDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession(false);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        if (session == null || session.getAttribute("user") == null) {
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        User user = (User) session.getAttribute("user");
        List<Map<String, Object>> favorites = favoriteDao.getFavoriteDetailsByUserId(user.getUserId());

        resp.getWriter().write(JsonUtil.toJson(favorites));
    }
}
