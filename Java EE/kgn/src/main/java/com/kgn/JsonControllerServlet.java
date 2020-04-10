package com.kgn;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JsonControllerServlet extends HttpServlet {
    String jsonName;
    String message;

    @Override
    public void init() throws ServletException {
        jsonName = getInitParameter("JsonName");
        message = getInitParameter("message");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.getWriter().printf("{ message: { %s:%s }}", jsonName, message);
    }
}