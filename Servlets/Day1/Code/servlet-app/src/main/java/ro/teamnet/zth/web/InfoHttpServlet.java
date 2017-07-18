package ro.teamnet.zth.web;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by Theodor.Toma on 7/18/2017.
 */
public class InfoHttpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Enumeration<String> headers = req.getHeaderNames();
        resp.getWriter().write("<div><table style=\"width:100%\" border=\"1\">");
        resp.getWriter().write("<tr><th> Header </th><th> Value <th></tr>");
        while (headers.hasMoreElements()) {
            String header = headers.nextElement();
            resp.getWriter().write("<tr><th>" + header + "</th><th>" + req.getHeader(header) + "</th></tr>" );
        }
        resp.getWriter().write("<div></table></div>");

        resp.getWriter().write("<div> Http method: " + req.getMethod() + "</div>");
        resp.getWriter().write("<div> Http querry: " + req.getQueryString() + "</div>");

        Cookie cookie2 = new Cookie("ceva","ceva");
        //Cookie[] cookies = req.getCookies();
        Cookie[] cookies = new Cookie[1];
        cookies[0] = cookie2;
        //resp.getWriter().write(String.valueOf(req.getCookies()));
        resp.getWriter().write("<table style=\"width:100%\" border=\"1\">");
        resp.getWriter().write("<tr><th> Cookie name </th><th> Cookie value <th></tr>");
        for (Cookie cookie : cookies) {
            resp.getWriter().write("<tr><th>" + cookie.getName() + "</th><th>" + cookie.getValue() + "</th></tr>" );
        }
        resp.getWriter().write("</table></div>");


        if (req.getParameterNames() != null) {
            Enumeration<String> params = req.getParameterNames();
            resp.getWriter().write("<div><table style=\"width:100%\" border=\"1\">");
            resp.getWriter().write("<tr><th> Parameter name </th><th> Parameter value <th></tr>");
            while (params.hasMoreElements()) {
                String param = params.nextElement();
                resp.getWriter().write("<tr><th>" + param + "</th><th>" + req.getParameter(param) + "</th></tr>");
            }
            resp.getWriter().write("</table></div>");
        }
    }
}
