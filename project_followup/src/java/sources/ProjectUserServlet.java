/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sources;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Edanur Işık
 */
//@WebServlet("/")
@WebServlet(name = "ProjectUserServlet", urlPatterns = {"/ProjectUserServlet"})
public class ProjectUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProjectUserDao projectuserDAO;

    public void init() {
        projectuserDAO = new ProjectUserDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {       
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String action = request.getServletPath();
    
        try {
            switch (action) {
                case "/newpu":
                    showNewFormProjectUser(request, response);
                    break;
                case "/insertpu":
                    insertProjectUser(request, response);
                    break;
                case "/deletep":
                    deleteProjectUser(request, response);
                    break;
                case "/editpu":
                    showEditFormProjectUser(request, response);
                    break;
                case "/updatepu":
                    updateProjectUser(request, response);
                    break;
                default:
                    listProjectUser(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listProjectUser(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        List <ProjectRelationship> listProject = projectuserDAO.selectAllProjectUsers();
        request.setAttribute("listProjectUser", listProject);
        RequestDispatcher dispatcher = request.getRequestDispatcher("projectuserlist.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewFormProjectUser(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("projectuserform.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditFormProjectUser(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ProjectRelationship existingProject = projectuserDAO.selectProjectUser(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("projectuserform.jsp");
        request.setAttribute("projectuser", existingProject);
        dispatcher.forward(request, response);

    }

    private void insertProjectUser(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        //int id = Integer.parseInt(request.getParameter("id"));
 
        int project_id = Integer.parseInt(request.getParameter("project_id"));
        int user_id = Integer.parseInt(request.getParameter("user_id"));  

        
        ProjectRelationship newProjectUser = new ProjectRelationship(project_id,user_id);
        projectuserDAO.insertProjectUser(newProjectUser);
        response.sendRedirect("listepu");
    }
    private void updateProjectUser(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int project_id = Integer.parseInt(request.getParameter("project_id"));
        int user_id = Integer.parseInt(request.getParameter("user_id")); 

        ProjectRelationship book = new ProjectRelationship(id, project_id, user_id);
        projectuserDAO.updateProjectUser(book);
        response.sendRedirect("listepu");
    }

    private void deleteProjectUser(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        projectuserDAO.deleteProjectUser(id);
        response.sendRedirect("listepu");

    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProjectUserServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProjectUserServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
