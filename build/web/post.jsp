<%-- 
    Document   : post
    Created on : 03/07/2017, 01:48:03
    Author     : bruuh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet prefetch" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.min.css">
        <link rel="stylesheet prefetch" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="css/styleLogin.css">
        <title>Postagem</title>
    </head>
    <body>
        <a href="/index.jsp" class="logo">
            <img src="imagens/nasa-logo.svg">   
        </a>   
        <div>
            <form action="post" class="form-signin" method="post">
                <h2>Postagem</h2>
                <input type="text" class="form-control" name="titulo" placeholder="Titulo" required="" />
                <input type="text" class="form-control" name="subtitulo" placeholder="Subtitulo" required="" />
                <h4>Texto</h4>
                <textarea cols="40" name="texto" placeholder="Insira o texto aqui" rows="10"></textarea>
                <span id="mensagem"></span>
                <input type="submit" name="submit" value="Enviar" class="form-control" />
                <script type="text/javascript" charset="utf-8">
                    var container = document.querySelector("#mensagem");
                    document.querySelector("submit")
                            .addEventListener("onclick", function () {
                                var xmlhttp = new XMLHttpRequest();
                                xmlhttp.open("GET", "cidade?nome=" + this.value, true);
                                xmlhttp.onreadystatechange = function () {
                                    if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                                        var cidades = xmlhttp.responseText.split(',');
                                        container.innerHTML = "";
                                        for (var i = 0; i < (cidades.length - 1); i++) {
                                            var li = document.createElement("li");
                                            li.innerHTML = cidades[i];
                                            li.className = "";
                                            container.appendChild(li);
                                        }
                                    }
                                };
                                xmlhttp.send();
                            });
                </script>
            </form>
        </div>
    </body>
</html>