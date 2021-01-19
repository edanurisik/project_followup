<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <html>

        <head>
            <title>Personel İşlemleri</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        </head>

        <body>

            <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: orange">
                    <div>
                        <a href="" class="navbar-brand"> Personel İşlemleri </a>
                    </div>

            
                </nav>
            </header>
            <br>
            <div class="container col-md-5">
                <div class="card">
                    <div class="card-body">
                        <c:if test="${user != null}">
                            <form action="update" method="post">
                        </c:if>
                        <c:if test="${user == null}">
                            <form action="insert" method="post">
                        </c:if>

                        <caption>
                            <h2>
                                <c:if test="${user != null}">
                                    Personeli Düzenleme
                                </c:if>
                                <c:if test="${user == null}">
                                    Yeni Personel Ekleme
                                </c:if>
                            </h2>
                        </caption>

                        <c:if test="${user != null}">
                            <input type="hidden" name="id" value="<c:out value='${user.id}'/>" />
                        </c:if>

                        <fieldset class="form-group">
                            <label>Adı</label> <input type="text" value="<c:out value='${user.name}'/>" class="form-control" name="name" required="required">
                        </fieldset>
                        
                        <fieldset class="form-group">
                            <label>Soyadı</label> <input type="text" value="<c:out value='${user.surname}'/>" class="form-control" name="surname" required="required">
                        </fieldset>
                        
                     
                        <fieldset class="form-group">
                            <label>Email</label> <input type="text" value="<c:out value='${user.email}'/>" class="form-control" name="email" required="required">
                        </fieldset>

                        <c:if test="${user == null}">
                        <fieldset class="form-group">
                            <label>Şifre</label> <input type="password" value="<c:out value='${user.password}'/>" class="form-control" name="password" required="required">
                        </fieldset>
                        </c:if>
                        <button type="submit" class="btn btn-success">Kaydet</button>
                        </form>
                    </div>
                </div>
            </div>
        </body>

        </html>