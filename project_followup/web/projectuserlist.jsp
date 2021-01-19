
<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="sources.Admin"%>
<%@page import="sources.ConnectionDB"%>
<% 
    Admin admin = (Admin) session.getAttribute("loggedAdmin"); 
    if(admin==null) {
        response.sendRedirect("adminlogin.jsp");
    }
%>
<!DOCTYPE html>
        <html>

        <head>
            <title>Proje Personel İşlemleri</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        </head>

        <body>

            <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: orange">
                    <div>
                        <a href="" class="navbar-brand"> Proje Personel İşlemleri </a>
                    </div>


                </nav>
            </header>
            <br>

            <div class="row">
                <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

                <div class="container">
                    <h3 class="text-center">Proje Personel İlişkisi Listesi</h3>
                    <hr>
                    <div class="container text-left">

                        <a href="<%=request.getContextPath()%>/newp" class="btn btn-success">Projeye Personel Atama</a>
                    </div>
                    <br>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                        
                                <th>Personel</th>
                                <th>Proje</th>
                                <th>İşlemler</th>
                            </tr>
                        </thead>
                        <tbody>
  <c:forEach var="projectuser" items="${listProjectUser}">

                                <tr>
                                    <td>
                                        <c:out value="${projectuser.id}" />
                                    </td>
                                    <td>
                                        <c:out value="${projectuser.project_id}" />
                                    </td>
                                    <td>
                                        <c:out value="${projectuser.user_id}" />
                                    </td>
                          
                    
                                    <td><a href="editpu?id=<c:out value='${projectuser.id}' />">Düzenle</a> &nbsp;&nbsp;&nbsp;&nbsp; <a href="deletepu?id=<c:out value='${projectuser.id}' />">Sil</a></td>
                                </tr>
                            </c:forEach>  
                        </tbody>

                    </table>
                </div>
            </div>
        </body>

        </html>
