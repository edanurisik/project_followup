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
@WebServlet(name = "ProjectAddServlet", urlPatterns = {"/ProjectAddServlet"})
public class ProjectAddServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private ProjectDao projectDAO;

    public void init() {
        projectDAO = new ProjectDao();
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
                case "/newp":
                    showNewFormProject(request, response);
                    break;
                case "/insertp":
                    insertProject(request, response);
                    break;
                case "/deletep":
                    deleteProject(request, response);
                    break;
                case "/editp":
                    showEditFormProject(request, response);
                    break;
                case "/updatep":
                    updateProject(request, response);
                    break;
                default:
                    listProject(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listProject(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        List <Project> listProject = projectDAO.selectAllProjects();
        request.setAttribute("listProject", listProject);
        RequestDispatcher dispatcher = request.getRequestDispatcher("projectlist.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewFormProject(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("projectform.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditFormProject(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Project existingProject = projectDAO.selectProject(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("projectform.jsp");
        request.setAttribute("project", existingProject);
        dispatcher.forward(request, response);

    }

    private void insertProject(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        //int id = Integer.parseInt(request.getParameter("id"));
 
        String subject = request.getParameter("subject");
        String description = request.getParameter("description");  
        Date start_date = Date.valueOf(request.getParameter("start_date"));
        Date end_date = Date.valueOf(request.getParameter("end_date"));
        
        Project newProject = new Project(subject,description, start_date, end_date);
        projectDAO.insertProject(newProject);
        response.sendRedirect("liste");
    }
    private void updateProject(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String subject = request.getParameter("subject");
        String description = request.getParameter("description");    
        Date start_date = Date.valueOf(request.getParameter("start_date"));
        Date end_date = Date.valueOf(request.getParameter("end_date"));

        Project book = new Project(id, subject, description, start_date, end_date);
        projectDAO.updateProject(book);
        response.sendRedirect("liste");
    }

    private void deleteProject(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        projectDAO.deleteProject(id);
        response.sendRedirect("liste");

    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProjectAddServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProjectAddServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
    
