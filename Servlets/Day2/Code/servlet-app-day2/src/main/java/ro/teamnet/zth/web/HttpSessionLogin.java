package ro.teamnet.zth.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Theodor.Toma on 7/19/2017.
 */
public class HttpSessionLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Cookie[] cookies = request.getCookies();

        if (username.equals("admin") && password.equals("admin")) {
            response.getWriter().write("Welcome back " + username + "! \n");
            for (Cookie cookie : cookies) {
                response.getWriter().write(cookie.getName() + ":" + cookie.getValue() + "\n");
            }
            response.getWriter().write(request.getSession().getId());
        }
        else {
            request.getSession().setAttribute("user",username);
            request.getSession().setAttribute("session",request.getSession());
            String redirectURL = "/servlet-app-day2/views/loginFail.jsp";
            response.sendRedirect(redirectURL);
        }
    }

}
