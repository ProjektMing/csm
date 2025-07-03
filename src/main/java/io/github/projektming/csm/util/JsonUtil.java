package io.github.projektming.csm.util;

import io.github.projektming.csm.model.beans.Restaurant;

import java.util.Map;
import java.util.stream.Collectors;

public class JsonUtil {

    /**
     * Manually serializes a Restaurant object to a JSON string.
     *
     * @param restaurant The restaurant object to serialize.
     * @return A JSON string representation of the restaurant.
     */
    public static String toJson(Restaurant restaurant) {
        if (restaurant == null) {
            return "{\"error\":\"No restaurant available\"}";
        }
        return "{" +
                "\"restaurantId\":" + restaurant.getRestaurantId() + "," +
                "\"name\":\"" + escapeJson(restaurant.getName()) + "\"," +
                "\"description\":\"" + escapeJson(restaurant.getDescription()) + "\"," +
                "\"imageUrl\":\"" + escapeJson(restaurant.getImageUrl()) + "\"," +
                "\"categories\":\"" + escapeJson(restaurant.getCategories()) + "\"," +
                "\"flavors\":\"" + escapeJson(restaurant.getFlavors()) + "\"," +
                "\"openingTime\":\"" + restaurant.getOpeningTime() + "\"," +
                "\"closingTime\":\"" + restaurant.getClosingTime() + "\"" +
                "}";
    }

    /**
     * Manually serializes a Map<String, Object> to a JSON string.
     *
     * @param map The map to serialize.
     * @return A JSON string representation of the map.
     */
    public static String toJson(Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            return "{}";
        }
        String entries = map.entrySet().stream()
                .map(entry -> "\"" + escapeJson(entry.getKey()) + "\":" + formatValue(entry.getValue()))
                .collect(Collectors.joining(","));
        return "{" + entries + "}";
    }

    /**
     * Formats a value for JSON based on its type.
     *
     * @param value The value to format.
     * @return A JSON-formatted string representation of the value.
     */
    private static String formatValue(Object value) {
        if (value instanceof String) {
            return "\"" + escapeJson((String) value) + "\"";
        }
        return value.toString(); // For boolean and numbers
    }

    /**
     * Escapes special characters in a string for JSON compatibility.
     *
     * @param str The string to escape.
     * @return The escaped string.
     */
    private static String escapeJson(String str) {
        if (str == null) {
            return "";
        }
        return str.replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\b", "\\b")
                .replace("\f", "\\f")
                .replace("\n", "\\n")
                .replace("\r", "\\r")
                .replace("\t", "\\t");
    }
}

