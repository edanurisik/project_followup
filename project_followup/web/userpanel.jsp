
<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

        <html>

        <head>
            <title>Projeler</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
            <style>
            #userpanel {
            }
            </style>
        </head>

        <body>
  <section id="userpanel">
            <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: orange">
                    <div>
                        <a href="" class="navbar-brand"> Projeler </a>
                    </div>

     
                </nav>
            </header>
            <br>

            <div class="row">
                <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

                <div class="container">
                    <h3 class="text-center">Proje Listesi</h3>
                    <hr>

                    <br>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                        
                                <th>Personel</th>
                                <th>Proje</th>
                                <th>Başlangıç Tarihi</th>
                                <th>Bitiş Tarihi</th>
                            </tr>
                        </thead>
                        <tbody>
                        <td>Edanur Işık</td>
                        <td>İnternet Mühendisliği Projesi</td>
                        <td>2020-01-01</td>
                        <td>2020-10-01</td>
                        </tbody>

                    </table>
                </div>
            </div>
             </section>
        </body>

        </html>
