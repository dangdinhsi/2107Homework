package endpoints;

import com.google.gson.Gson;
import com.googlecode.objectify.Key;
import entity.JsonObject;
import entity.Music;
import util.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import static com.googlecode.objectify.ObjectifyService.ofy;

public class HelloAPI extends HttpServlet {
    private static Gson gson = new Gson();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.setStatus(HttpServletResponse.SC_OK);
        List<Music> list =ofy().load().type(Music.class).filter("status",1).list();
        JsonObject jsonObject = new JsonObject(HttpServletResponse.SC_OK,"get list music ok",list);
        resp.getWriter().println(gson.toJson(jsonObject));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        String content = StringUtil.convertInputStreamToString(req.getInputStream());
        Music music = gson.fromJson(content,Music.class);
        Key<Music> musicKey = ofy().save().entity(music).now();
        resp.setStatus(HttpServletResponse.SC_CREATED);
        JsonObject jsonObject = new JsonObject(HttpServletResponse.SC_CREATED,"post music ok!!!",musicKey);
        resp.getWriter().println(gson.toJson(jsonObject));
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        String id = req.getParameter("id");
        if(id==null||id.length()==0){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            JsonObject jsonObject = new JsonObject(HttpServletResponse.SC_BAD_REQUEST,"id không thể bỏ trống",null);
            resp.getWriter().println(gson.toJson(jsonObject));
            return;
        }
        Music existMusic = ofy().load().type(Music.class).id(Long.parseLong(id)).now();
        if(existMusic==null ||existMusic.getStatus()==0){
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            JsonObject jsonObject = new JsonObject(HttpServletResponse.SC_NOT_FOUND,"Music không tồn tại hoặc đã bị xóa",null);
            resp.getWriter().println(gson.toJson(jsonObject));
            return;
        }
        String content = StringUtil.convertInputStreamToString(req.getInputStream());
        Music updateMusic = gson.fromJson(content,Music.class);
        existMusic.setName(updateMusic.getName());
        existMusic.setArtist(updateMusic.getArtist());
        existMusic.setUpdatedAt(Calendar.getInstance().getTime());
        ofy().save().entity(existMusic).now();
        resp.setStatus(HttpServletResponse.SC_OK);
        JsonObject jsonObject = new JsonObject(HttpServletResponse.SC_OK,"Update thành công!!",existMusic);
        resp.getWriter().println(gson.toJson(jsonObject));
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        String id = req.getParameter("id");
        if(id==null||id.length()==0){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            JsonObject jsonObject = new JsonObject(HttpServletResponse.SC_BAD_REQUEST,"id không thể bỏ trống",null);
            resp.getWriter().println(gson.toJson(jsonObject));
            return;
        }
        Music existMusic = ofy().load().type(Music.class).id(Long.parseLong(id)).now();
        if(existMusic==null ||existMusic.getStatus()==0){
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            JsonObject jsonObject = new JsonObject(HttpServletResponse.SC_NOT_FOUND,"Music không tồn tại hoặc đã bị xóa",null);
            resp.getWriter().println(gson.toJson(jsonObject));
            return;
        }
        existMusic.setStatus(Music.Status.detele);
        existMusic.setDeletedAt(Calendar.getInstance().getTime());
        ofy().save().entity(existMusic).now();
        resp.setStatus(HttpServletResponse.SC_OK);
        JsonObject jsonObject = new JsonObject(HttpServletResponse.SC_OK,"Xóa music thành công!!",null);
        resp.getWriter().println(gson.toJson(jsonObject));
    }
}
