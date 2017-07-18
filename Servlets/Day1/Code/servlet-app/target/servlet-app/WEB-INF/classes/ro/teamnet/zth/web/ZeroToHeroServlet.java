package ro.teamnet.zth.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Theodor.Toma on 7/18/2017.
 */
public class ZeroToHeroServlet extends HttpServlet{
    private String handleRequest(HttpServletRequest req) {
        String response;
        response = "Hello <b>" + req.getParameter("firstName")
                + " " + req.getParameter("lastName")+ "</b>!! ";
        return response;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.getWriter().write(handleRequest(req));
    }
}
