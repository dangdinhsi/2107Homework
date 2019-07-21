package controller;

import entity.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.googlecode.objectify.ObjectifyService.ofy;


public class EditStudent extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/student/edit.jsp").forward(req,resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Student existStudent = ofy().load().type(Student.class).id(Long.parseLong(id)).now();
        existStudent.setUsername(req.getParameter("updatename"));
        existStudent.setRollnumber(req.getParameter("updaterollnumber"));
        ofy().save().entity(existStudent).now();
        System.out.println("edit success");
        resp.sendRedirect("/student/list");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPut(req,resp);
    }
}
