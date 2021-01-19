<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
           
        <title>Personel Proje Takip Sistemi</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" integrity="sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ==" crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css" integrity="sha384-aUGj/X2zp5rLCbBxumKTCw2Z50WgIr1vs/PFN4praOTvYXWlVyh2UtNUU0KAUhAX" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js" integrity="sha512-K1qjQ+NcF2TYO/eI3M6v8EiNYZfA95pQumfvcVrTHtwQVDG+aHRqLi/ETn2uB+1JqwYqVG3LIvdm9lj6imS/pQ==" crossorigin="anonymous"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
        
    </head>
    <style>
        .form-group label {width: 200px;}
        .form-horizontal {width: 50%; margin: 20px auto; text-align: center; border-radius: 30px; padding: 20px 0;}
        .form-group .form-control {width: auto; display: inline-block;}
        p {color:red; font-size:200%;}
        h1 {color:black; border: 3px solid #ffa500;}
        h2 {color:white;}
        label {color:orange;}
         body {text-align: center; background-image: url("image/background.jpg");}
    </style>
    <body>
        <h1><b>Personel Proje Takip Sistemi</b></h1><br>  
        <div class="container">
            <form class="form-horizontal" role="form" action="adminlogin.jsp" method="post"><br>
                <button type="submit" class="btn btn-warning" style="height:50px;width:200px"><b>Yönetici Girişi</b></button><br><br>
            </form>
        </div><br>
        <div class="container">
            <form class="form-horizontal" role="form" action="userlogin.jsp" method="post"><br>
                <button type="submit" class="btn btn-warning" style="height:50px;width:200px"><b>Personel Girişi</b></button><br><br>
            </form>
        </div><br>
    </body>
</html>