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
            <a href="/index.jsp" class="logo">
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
                        <li id="drop" class="p-fica">

                            <div style="height:35px;">
                                <input class="procura"  placeholder=" Search" tabindex="1" autocomplete="off">
                                <li id="drop">
                                    <input class="busca" type="submit" disabled value ="Search"/>
                                </li>
                            </div>
                        </li>
                    </ul>
                    <div class="procurar">
                    </div>
                </div>
                <div class="menu2">
                    <ul class="menu-cinza">
                        <li id="drop"><a href="#">International Space Station</a></li>
                        <li id="drop"><a href="#">Journey to Mars</a></li>
                        <li id="drop"><a href="#">Earth</a></li>
                        <li id="drop"><a href="#">Techonology</a></li>
                        <li id="drop"><a href="#">Aeronatics</a></li>
                        <li id="drop"><a href="#">Solar System and Beyond</a></li>
                        <li id="drop"><a href="#">Education</a></li>
                        <li id="drop"><a href="#">History</a></li>
                        <li id="drop"><a href="#">Benefits to You</a></li>
                    </ul>	
                </div>	
            </div>
        </div>
        ::before
        <!--Pra 9**
        <div id="crop-navegation"> </div>
        <c:forEach items="${lista}" var="lista">
            <li>${post.titulo}</li>
            <div id="ex-notice-other">
            <div>
                <div id="Notice-other">
                    <div id="title-notice">
                        <a>${post.titulo}</a>
                        <div>${post.subtitulo}</div>
                    </div>
                </div>
            </div>
        </div>
        </c:forEach>
    
        9** rever-->
        <div style="background-color:white;" id="Corpo">
            <ul id="container" style="color:white">
                <script type="text/javascript">
                    var container = document.querySelector("#container");
                    var divSelecionada = document.querySelector("#Corpo");
                    document.querySelector("input")
                            .addEventListener("keyup", function () {
                                var xmlhttp = new XMLHttpRequest();
                                xmlhttp.open("GET", "busca?titulo=" + this.value, true);
                                xmlhttp.onreadystatechange = function () {
                                    if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
                                        var post = xmlhttp.responseText.split(',');
                                        container.innerHTML = "";
                                        for (var i = 0; i < (post.length - 1); ) {
                                            var divTitulo = null;
                                            var div = null;
                                            var x = null;
                                            var t = null;
                                            var divTitulo = document.createElement("div");
                                            var div = document.createElement("div");
                                            var x = document.createElement("A");
                                            var t = document.createTextNode(post[i]);
                                            x.appendChild(t);
                                            x.appendChild(t);
                                            divTitulo.setAttribute("id", "titulo-noticia");
                                            divTitulo.appendChild(x);

                                            div.setAttribute("id", "noticia-principal");
                                            div.setAttribute("style", "background-image: url(" + post[++i] + ")");
                                            div.appendChild(divTitulo);
                                            document.body.appendChild(div);
                                            post[i++];
                                        }
                                    }
                                };
                                xmlhttp.send();
                            });
                </script>
            </ul>
        </div>
    </body>
</html>