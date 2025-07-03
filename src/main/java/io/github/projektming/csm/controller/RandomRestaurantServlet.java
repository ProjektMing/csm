package io.github.projektming.csm.controller;

import io.github.projektming.csm.model.beans.Restaurant;
import io.github.projektming.csm.model.beans.User;
import io.github.projektming.csm.model.service.RestaurantService;
import io.github.projektming.csm.model.service.RestaurantServiceImpl;
import io.github.projektming.csm.util.JsonUtil;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/random-restaurant")
public class RandomRestaurantServlet extends HttpServlet {
    private final RestaurantService restaurantService = new RestaurantServiceImpl();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession(false); // false means don't create a new session if one doesn't exist
        User user = null;
        if (session != null) {
            user = (User) session.getAttribute("user");
        }

        Restaurant restaurant;
        if (user != null) {
            restaurant = restaurantService.getRandomRestaurant(user);
        } else {
            restaurant = restaurantService.getRandomRestaurant();
        }

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        String restaurantJson = JsonUtil.toJson(restaurant);

        PrintWriter out = resp.getWriter();
        out.print(restaurantJson);
        out.flush();
    }
}
