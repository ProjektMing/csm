package io.github.projektming.csm.util;

import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FailSolver {
    private static final Logger log = Logger.getLogger(FailSolver.class.getName());

    public static void alertAndRedirect(HttpServletResponse response, String msg, String direction) {
        try {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script language='javascript'>alert('" + msg + "');window.location.href='" + direction + "';</script>");
            out.flush();
            out.close();
        } catch (IOException e) {
            log.log(Level.WARNING, "Could not redirect to " + direction, e);
        }
    }
}
