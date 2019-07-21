package controller;

import entity.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.googlecode.objectify.ObjectifyService.ofy;

public class DeleteStudent extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /* //Xóa cứng khỏi database
        String id = req.getParameter("id");
        ofy().delete().type(Student.class).id(Long.parseLong(id)).now();
        System.out.println("delete success");
        resp.sendRedirect("/student/list");*/

        //Xóa mềm setstatus =-1;
        String id = req.getParameter("id");
        Student student = ofy().load().type(Student.class).id(Long.parseLong(id)).now();
        student.setStatus(Student.Status.delete);
        ofy().save().entity(student).now();
        System.out.println("delete success");
        resp.sendRedirect("/student/list");
    }
}
