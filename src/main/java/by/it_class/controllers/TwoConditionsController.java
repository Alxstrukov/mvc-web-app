package by.it_class.controllers;

import by.it_class.model.entities.User;
import by.it_class.model.services.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "twoConditionsController", urlPatterns = "/criteria")
public class TwoConditionsController extends HttpServlet {

    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> params = req.getParameterMap();

        List<User> users = userService.getUserByCriteria(params);

        if (!users.isEmpty()) {
            req.setAttribute("users", users);//
        } else {
            req.setAttribute("message", "Users weren't found");
        }
        RequestDispatcher rd = req.getRequestDispatcher("/users.jsp");
        rd.forward(req, resp);
    }
}
