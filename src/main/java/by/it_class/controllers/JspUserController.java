package by.it_class.controllers;

import by.it_class.model.db.DbInMemory;
import by.it_class.model.entities.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "jspUserController", urlPatterns = "/jspSearch")
public class JspUserController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        User user = DbInMemory.findUserByName(name);
        //resp.sendRedirect(name);  метод forward этого объекта (потом) вернет ответ клиенту сказав что нужно идти по другому адресу и скажет по какому
        RequestDispatcher rd = req.getRequestDispatcher("/user.jsp");// метод forward этого объекта (потом) не вернет ответ клиенту, а перенаправляет на другой адрес
        if (user != null) {
            req.setAttribute("user", user);//
        } else {
            String mess = "User with name " + name + " wasn't  found";
            req.setAttribute("message", mess);//
        }
        rd.forward(req, resp);//перенаправит нашу пару запрос, ответ
    }
}
