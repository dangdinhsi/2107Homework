package controller;

import entity.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.googlecode.objectify.ObjectifyService.ofy;

public class DetailStudent extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Student student = ofy().load().type(Student.class).id(Long.parseLong(id)).now();
        req.setAttribute("student",student);
        req.getRequestDispatcher("/student/detail.jsp").forward(req,resp);
        System.out.println("get detail success!!!");
    }
}
