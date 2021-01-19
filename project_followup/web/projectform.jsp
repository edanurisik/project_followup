<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
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
            <div class="container col-md-5">
                <div class="card">
                    <div class="card-body">
                        <c:if test="${project != null}">
                            <form action="updatep" method="post">
                        </c:if>
                        <c:if test="${project == null}">
                            <form action="insertp" method="post">
                        </c:if>

                        <caption>
                            <h2>
                                <c:if test="${project != null}">
                                    Proje Düzenleme
                                </c:if>
                                <c:if test="${project == null}">
                                    Yeni Proje Ekleme
                                </c:if>
                            </h2>
                        </caption>

                        <c:if test="${project != null}">
                            <input type="hidden" name="id" value="<c:out value='${project.id}'/>" />
                        </c:if>

                        <fieldset class="form-group">
                            <label>Konusu</label> <input type="text" value="<c:out value='${project.subject}'/>" class="form-control" name="subject" required="required">
                        </fieldset>
                        
                        <fieldset class="form-group">
                            <label>Tanımı</label> <input type="text" value="<c:out value='${project.description}'/>" class="form-control" name="description" required="required">
                        </fieldset>
                        
                     
                        <fieldset class="form-group">
                            <label>Başlama Tarihi</label> <input type="date" value="<c:out value='${project.start_date}'/>" class="form-control" name="start_date" required="required">
                        </fieldset>

                        <c:if test="${project == null}">
                        <fieldset class="form-group">
                            <label>Bitiş Tarihi</label> <input type="date" value="<c:out value='${project.end_date}'/>" class="form-control" name="end_date" required="required">
                        </fieldset>
                        </c:if>
                        <button type="submit" class="btn btn-success">Kaydet</button>
                        </form>
                    </div>
                </div>
            </div>
        </body>

        </html>