package ro.teamnet.zth.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Theodor.Toma on 7/19/2017.
 */
public class HelloWorldServletForward extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Set the response type
        response.setContentType("text/html");

        // TODO: Complete the steps from RequestDispatcher Workshop

        Object attrib = request.getAttribute("someAttribute");
        response.getWriter().write("Hello <b>" + request.getParameter("user") + " </b> from the Forward Servlet! " + attrib);
    }
}
