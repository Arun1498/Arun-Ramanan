package TechM;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class HelloServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pwriter = response.getWriter();
        pwriter.println("<html><body>");
        pwriter.println("<h2>Html file from Servlet!</h2>");
        pwriter.println("</body></html>");
        pwriter.close();
    }
}
