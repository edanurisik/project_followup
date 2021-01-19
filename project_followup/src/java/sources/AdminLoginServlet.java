/**
 *
 * @author Edanur
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
@WebServlet(name = "AdminLoginServlet", urlPatterns = {"/AdminLoginServlet"})
public class AdminLoginServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
                        out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel=\'stylesheet\' href=\'https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css\'>");
            out.println("<link href=\"css/style.css\" rel=\"stylesheet\" type=\"text/css\"/>");
            out.println("<title>Personel Proje Takip Sistemi</title>");            
            out.println("</head>");
            out.println("<body>");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            
            AdminDao ado = new AdminDao(ConnectionDB.getCon());
            Admin admin = ado.logAdmin(email, password);
            if(admin!=null) {
                HttpSession session = request.getSession();
                session.setAttribute("loggedAdmin", admin);
                response.sendRedirect("adminpanel.jsp");
                
            } else {           
                out.println("<section class=\"text\">\n" +
                    "            <div style=\"text-align: center\">\n" +
                    "                <span style=\"font-size: 20px; color: black;\">Admin Kullanıcısı Bulunamadı...</span><br>\n" +
                    "                <a href='adminlogin.jsp'><button  style=\"background-color: orange\" type='button'>Lütfen Tekrar Deneyiniz...</button></a>\n" +
                    "            </div>\n" +
                    "        </section>");
            
            out.println("</body>");
            out.println("</html>");
        }
            /*
                HttpSession session = request.getSession();
                session.setAttribute("loggedAdmin", admin);
                response.sendRedirect("adminlogin.jsp");
                out.println("Kullanıcı Tanımlı Değil");*/
    
                 
            
          /*  out.println(email +" "+password);
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AdminLoginServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdminLoginServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");*/
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
