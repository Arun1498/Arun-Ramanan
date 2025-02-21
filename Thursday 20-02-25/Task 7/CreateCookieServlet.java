package TechM;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class CreateCookieServlet
 */
@WebServlet("/CreateCookieServlet")
public class CreateCookieServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
    response.setContentType("text/html"); 
    PrintWriter out = response.getWriter();
  
    String userName = request.getParameter("userName").trim();
    String password = request.getParameter("password").trim();
    
 
    if(userName == null || userName.equals("") || password == null || password.equals("")){
        out.print("Please enter both username " + "and password. <br><br>");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login.html");
        requestDispatcher.include(request, response);
    }
    else if(userName.equals("jai") && password.equals("1234")){

        Cookie cookie1 = new Cookie("userName",userName);
        Cookie cookie2 = new Cookie("password",password);
       
        response.addCookie(cookie1);
        response.addCookie(cookie2);
        out.print("<h3>Cookies are created. Click on the " + "below button to get cookies."); 
        out.print("<form action=\"GetCookieServlet\"method=\"POST\">"); 
        out.print("<input type=\"submit\" value=\"Get Cookie\">");
        out.print("</form>");  
              
        out.close();  
    }
    else{
        out.print("Wrong username or password. <br><br>");
        RequestDispatcher requestDispatcher =   request.getRequestDispatcher("/login.html");
        requestDispatcher.include(request, response);
        }}}