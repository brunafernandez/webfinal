<%-- 
    Document   : index
    Created on : 22/10/2016, 16:29:25
    Author     : Diego Vilella Rodrigues
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>PROJETO 1 - NASA</title>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, user-scalable=no">
        <link type="text/css" rel="stylesheet" href="css/ProjetoManual1.css" />
    </head>
    <body>
        <div class="MenuDropdown">
            <a href="/webfinal/index.jsp" class="logo">
                <img src="imagens/nasa-logo.svg">
            </a>

            <div class="centralizaMenu">
                <div class="Menu1">
                    <ul>
                        <li id="drop" class="dropdown">
                            <a class="dropbtn" href="/webfinal/index.jsp"><span>Lista Postagem</span></a>
                        </li>
                        <li id="drop" class="dropdown">
                            <a class="dropbtn" href="/webfinal/post.jsp">Nova Postagem</a>
                        </li>
                        <li id="drop" class="dropdown">
                            <a class="dropbtn" href="/webfinal/cadastro.jsp">Novo Usuário</a>
                        </li>
                        <li id="drop" class="dropdown">
                            <a href="/webfinal/logar.jsp" class="dropbtn" id="fica">Login</a>
                        </li>
                    </ul>
                </div>	
            </div>
        </div>
        ::before
        <div style="background-color:white;" id="Corpo">
        <ul id="container" style="color:white">
        </ul>
        <script type="text/javascript" charset="utf-8">
            //this.value
            var container = document.querySelector("#container");
            var divSelecionada = document.querySelector("#Corpo");
            document.querySelector("input")
                    .addEventListener("keyup", function () {
                var xmlhttp = new XMLHttpRequest();
                xmlhttp.open("GET", "post?titulo=" + "" , true);
                xmlhttp.onreadystatechange = function () {
                    if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                        var post = xmlhttp.responseText.split(',');
                            container.innerHTML = ""; 
                            divSelecionada.innerHTML = ""; 
                        for (var i = 0; i < (post.length - 1);) {
                            var divTitulo = document.createElement("div");
                            var div = document.createElement("div");
                            var x = document.createElement("A");
                            var t = document.createTextNode(post[i]);
                            x.appendChild(t);                           
                            x.appendChild(t);
                            divTitulo.setAttribute("id", "titulo-noticia");
                            divTitulo.appendChild(x);
                            
                            div.setAttribute("id", "noticia-principal");
                            div.setAttribute("style","background-image: url("+ post[++i]+")");
                            div.appendChild(divTitulo);
                            document.body.appendChild(div);
                            post[i++];
                        }
                    }
                };
                xmlhttp.send();
            });
            setInterval(function () {
                var xhr = new XMLHttpRequest();
                xhr.open("GET", "busca?titulo=" + "" , true);
                xhr.onreadystatechange = function () {
                    container.innerHTML = "";
                    if (xhr.readyState === 4 && xhr.status === 200) {
                        var post = xhr.responseText.split(",");
                        for (var i = 0; i < (post.length - 1);) {
                            var divTitulo = document.createElement("div");
                            var div = document.createElement("div");
                            var x = document.createElement("A");
                            var t = document.createTextNode(post[i]);
                            x.appendChild(t);                           
                            x.appendChild(t);
                            divTitulo.setAttribute("id", "titulo-noticia");
                            divTitulo.appendChild(x);
                            
                            div.setAttribute("id", "noticia-principal");
                            div.setAttribute("style","background-image: url("+ post[++i]+")");
                            div.appendChild(divTitulo);
                            document.body.appendChild(div);
                            post[i++];
                        }
                    }
                };
                xhr.send();
            }, 10000);
        </script>
       </div>
    </body>
</html>