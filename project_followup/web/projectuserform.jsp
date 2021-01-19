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
            <div class="container col-md-5">
                <div class="card">
                    <div class="card-body">
                        <c:if test="${projectuser != null}">
                            <form action="updatepu" method="post">
                        </c:if>
                        <c:if test="${projectuser == null}">
                            <form action="insertpu" method="post">
                        </c:if>

                        <caption>
                            <h2>
                                <c:if test="${projectuser != null}">
                                    Proje Personel Atamasını Düzenleme
                                </c:if>
                                <c:if test="${projectuser == null}">
                                    Proje Personel Atama
                                </c:if>
                            </h2>
                        </caption>

                        <c:if test="${projectuser != null}">
                            <input type="hidden" name="id" value="<c:out value='${projectuser.id}'/>" />
                        </c:if>

                        <fieldset class="form-group">
                            <label>Proje Tanımı</label> <input type="text" value="<c:out value='${projectuser.project_id}'/>" class="form-control" name="subject" required="required">
                        </fieldset>
                        
                        <fieldset class="form-group">
                            <label>Personel</label> <input type="text" value="<c:out value='${projectuser.user_id}'/>" class="form-control" name="description" required="required">
                        </fieldset>

                        
                        <c:if test="${projectuser == null}">
                        <fieldset class="form-group">
                            <label>Proje Tanımı</label> <input type="text" value="<c:out value='${projectuser.project_id}'/>" class="form-control" name="subject" required="required">
                        </fieldset>
                        
                        <fieldset class="form-group">
                            <label>Personel</label> <input type="text" value="<c:out value='${projectuser.user_id}'/>" class="form-control" name="description" required="required">
                        </fieldset>
                        </c:if>
                        <button type="submit" class="btn btn-success">Kaydet</button>
                        </form>
                    </div>
                </div>
            </div>
        </body>

        </html>