package controller;

import entity.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.googlecode.objectify.ObjectifyService.ofy;

public class CreateStudent extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/student/form.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String rollnumber =req.getParameter("rollnumber");
        Student student = new Student();
        student.setUsername(username);
        student.setRollnumber(rollnumber);
        ofy().save().entity(student).now();

        resp.sendRedirect("/student/list");
        System.out.println("Create student success!!!");
    }
}
