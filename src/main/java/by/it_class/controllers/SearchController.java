package by.it_class.controllers;

import by.it_class.model.db.DbInMemory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "searchController", urlPatterns = "/search")
public class SearchController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        boolean isFound = DbInMemory.isUserByName(name);
        RequestDispatcher requestDispatcher;
        if (isFound) {
            requestDispatcher = req.getRequestDispatcher("/yes.html");
        } else {
            requestDispatcher = req.getRequestDispatcher("/no.html");
        }
        requestDispatcher.forward(req, resp);
    }
}
