package com.kgn;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControllerServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        ApplicationSetting applicationSetting = new ApplicationSetting();
        CssClass cssClass = new CssClass();
        cssClass.setName("redUser");
        applicationSetting.setFormCssClass(cssClass);
        getServletContext().setAttribute("app", applicationSetting);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        user.setName("Kagan");
        user.setEmail("kgnk@gmail.com");

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/index.jsp");
        req.setAttribute("user", user);
        dispatcher.forward(req, resp);
    }
}