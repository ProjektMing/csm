package io.github.projektming.csm.controller;

import io.github.projektming.csm.model.beans.Restaurant;
import io.github.projektming.csm.model.service.RestaurantService;
import io.github.projektming.csm.model.service.RestaurantServiceImpl;

import jakarta.servlet .ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/random-restaurant")
public class RandomRestaurantServlet extends HttpServlet {
    private final RestaurantService restaurantService = new RestaurantServiceImpl();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Restaurant restaurant = restaurantService.getRandomRestaurant();

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter out = resp.getWriter();
        out.flush();
    }
}
