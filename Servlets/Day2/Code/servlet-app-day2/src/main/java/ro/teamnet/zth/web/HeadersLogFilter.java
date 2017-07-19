package ro.teamnet.zth.web;

import ro.teamnet.zth.file.LogFileWriter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by Theodor.Toma on 7/19/2017.
 */
public class HeadersLogFilter implements Filter {

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println(System.getenv("M2_HOME"));
        Enumeration<String> headerNames = ((HttpServletRequest)req).getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            LogFileWriter.logHeader(headerName,((HttpServletRequest) req).getHeader(headerName));
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
    }

}
