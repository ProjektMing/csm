package io.github.projektming.csm.controller;

import io.github.projektming.csm.model.beans.Favorite;
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
import java.util.HashMap;
import java.util.Map;

@WebServlet("/favorite")
public class FavoriteServlet extends HttpServlet {
    private final FavoriteDao favoriteDao = new FavoriteDaoImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession(false);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        Map<String, Object> responseMap = new HashMap<>();

        if (session == null || session.getAttribute("user") == null) {
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            responseMap.put("success", false);
            responseMap.put("message", "User not logged in.");
            resp.getWriter().write(JsonUtil.toJson(responseMap));
            return;
        }

        User user = (User) session.getAttribute("user");
        String restaurantIdStr = req.getParameter("restaurantId");

        if (restaurantIdStr == null || restaurantIdStr.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            responseMap.put("success", false);
            responseMap.put("message", "Restaurant ID is missing.");
            resp.getWriter().write(JsonUtil.toJson(responseMap));
            return;
        }

        try {
            int restaurantId = Integer.parseInt(restaurantIdStr);
            Favorite favorite = new Favorite();
            favorite.setUserId(user.getUserId());
            favorite.setRestaurantId(restaurantId);

            if (favoriteDao.addFavorite(favorite)) {
                responseMap.put("success", true);
                responseMap.put("message", "Added to favorites.");
                resp.getWriter().write(JsonUtil.toJson(responseMap));
            } else {
                resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                responseMap.put("success", false);
                responseMap.put("message", "Failed to add to favorites.");
                resp.getWriter().write(JsonUtil.toJson(responseMap));
            }
        } catch (NumberFormatException e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            responseMap.put("success", false);
            responseMap.put("message", "Invalid Restaurant ID format.");
            resp.getWriter().write(JsonUtil.toJson(responseMap));
        }
    }
}
