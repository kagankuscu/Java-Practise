package com.kgn;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/home", "*.do" })
public class SimpleServlet extends HttpServlet {

    String appName = "My Application";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // readinng
        String name = req.getParameter("name");

        if (name != null) {
            resp.setContentType("text/xml");
            resp.getWriter().printf("<application>" + 
                    "<name> Hello %s</name>" + 
                    "<product>%s</product>" +
                    "</application>" ,name, appName);
        } else {
            resp.sendRedirect("index.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException {
        String name = req.getParameter("name");

        if ( name != null && name != "") {
            resp.getWriter().printf("Hello %s", name);
        } else {
            resp.sendRedirect("index.jsp");
        }
    }

}