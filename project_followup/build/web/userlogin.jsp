<%-- 
    Document   : userlogin
    Created on : 07.Oca.2021, 13:40:47
    Author     : Edanur Işık
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Personel Proje Takip Sistemi</title>
        <!-- Compiled and minified CSS -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
        <style>
            #userlogin {
                position: absolute;
                width: 350px;
                height: 500px;
                padding: 20px;
                top: 50%;
                left: 50%;
                transform: translate(-50%,-50%);
            }
        
            .form {
                padding: 20px;
            }
            .pt-1{
                padding-top: 1rem;
            }
            body {text-align: center; background-image: url("image/background.jpg");}
        </style>
    </head>
    <body>
        <section id="userlogin">
            <div class="card z-depth-3">
                <div class="card-panel center orange accent-2">
                    <span class="card-title">Personel Girişi</span>
                </div>
                    <form class="form" action="UserLoginServlet" method="post">  
                    <div class="input-field"><br></br>
                        <input type="email" class="validate" name="email" required>
                        <label>E-mail Adres</label> 
                    </div>
                    <div class="input-field"><br></br>
                        <input type="password" class="validate" name="password" required>
                        <label>Şifre</label>
                    </div>
                    <div class="center">
                        <button type="submit" class="btn-large orange accent-2">
                            Giriş
                        </button>
                    </div>

                </form>
            </div>
        </section>
    <!-- Compiled and minified JavaScript -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
    </body>
</html>

