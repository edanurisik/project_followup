/**
 *
 * @author Edanur Işık
 */
package sources;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sources.ConnectionDB;

//@WebServlet("/")
@WebServlet(name = "UserLoginServlet", urlPatterns = {"/UserLoginServlet"})
public class UserLoginServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            
            UserLoginDao ado = new UserLoginDao(ConnectionDB.getCon());
            User user = ado.logUser(email, password);
            if(user!=null) {
                HttpSession session = request.getSession();
                session.setAttribute("loggedUser", user);
                response.sendRedirect("userpanel.jsp");
                
            } else {
                HttpSession session = request.getSession();
                session.setAttribute("loggedUser", user);
                response.sendRedirect("userlogin.jsp");
                out.println("Kullanıcı Tanımlı Değil");
            }
                  
            
            out.println(email +" "+password);
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UserLoginServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UserLoginServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
