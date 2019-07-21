package filter;

import com.googlecode.objectify.ObjectifyService;
import entity.Music;
import entity.Student;

import javax.servlet.*;
import java.io.IOException;

public class ObjectifyRegister implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        ObjectifyService.register(Student.class);
        ObjectifyService.register(Music.class);
        chain.doFilter(request,response);
    }

    public void destroy() {

    }
}
