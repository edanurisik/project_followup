
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
            <title>Proje İşlemleri</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        </head>

        <body>

            <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: orange">
                    <div>
                        <a href="" class="navbar-brand"> Proje İşlemleri </a>
                    </div>

                </nav>
            </header>
            <br>

            <div class="row">
                <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

                <div class="container">
                    <h3 class="text-center">Proje Listesi</h3>
                    <hr>
                    <div class="container text-left">

                        <a href="<%=request.getContextPath()%>/newp" class="btn btn-success">Yeni Proje Ekleme</a>
                    </div>
                    <br>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Konusu</th>
                                <th>Tanımı</th>
                                <th>Başlama Tarihi</th>          
                                <th>Bitiş Tarihi</th>
                                <th>İşlemler</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!--   for (Todo todo: todos) {  -->
                            <c:forEach var="project" items="${listProject}">

                                <tr>
                                    <td>
                                        <c:out value="${project.id}" />
                                    </td>
                                    <td>
                                        <c:out value="${project.subject}" />
                                    </td>
                                    <td>
                                        <c:out value="${project.description}" />
                                    </td>
                                    <td>
                                        <c:out value="${project.start_date}" />
                                    </td>
                                    <td>
                                        <c:out value="${project.end_date}" />
                                    </td>
                    
                                    <td><a href="editp?id=<c:out value='${project.id}' />" class="btn btn-primary">Düzenle</a> &nbsp;&nbsp;&nbsp;&nbsp; <a href="deletep?id=<c:out value='${project.id}' />"class="btn btn-primary">Sil</a></td>
                                </tr>
                            </c:forEach>
                            <!-- } -->
                        </tbody>

                    </table>
                </div>
            </div>
        </body>

        </html>
