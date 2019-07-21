package controller;

import entity.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static com.googlecode.objectify.ObjectifyService.ofy;

public class ListStudent extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> list = ofy().load().type(Student.class).filter("status",1).list(); //get theo filter các student có status =1
        req.setAttribute("list",list);
        req.getRequestDispatcher("/student/list.jsp").forward(req,resp);
        System.out.println("get list success");
    }
}
