<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet prefetch" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.min.css">
        <link rel="stylesheet prefetch" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="css/styleLogin.css">
        <title>Post</title>
    </head>
    <body>
        <a href="/webfinal/index.jsp" class="logo">
            <img src="imagens/nasa-logo.svg">   
        </a>   
        <div>
            <form id="postagem" action="post" class="form-signin" method="post">
                <h2>Post</h2>
                <input id="titulo" type="text" class="form-control" name="titulo" placeholder="Titulo" required="" />
                <input id="subtitulo" type="text" class="form-control" name="subtitulo" placeholder="Subtitulo" required="" />
                <h4>Texto</h4>
                <textarea id="texto" cols="40" name="texto" placeholder="Insira o texto aqui" rows="10"></textarea>
                <input type="submit" name="submit" value="Enviar" class="form-control"/> 
                <span id="mensagens" class="form-control"></span>
            </form>
            <script type="text/javascript" charset="utf-8">
                var mensagens = document.querySelector("#mensagens");
                    document.querySelector("input").addEventListener("keyup", function (ev) {
                        if (ev.keyCode != 13)
                            return;
                        var xhr = new XMLHttpRequest(),
                            self = this;
                        xhr.open("POST", "post", true);
                        xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
                        xhr.onreadystatechange = function () {
                            if (xhr.readyState < 4) {
                                mensagens.innerHTML = "carregando...";
                            }
                            if (xhr.readyState === 4 && xhr.status === 200) {
                                mensagens.innerHTML = "sucesso.";
                                self.value = "";
                            }
                            if (xhr.readyState === 4 && xhr.status != 200) {
                                mensagens.innerHTML = "erro";
                            }
                        };
                        xhr.send("titulo=" + this.value, "subtitulo=" + this.value, "texto=" + this.value);
                       
                    });

            </script>
        </div>
    </body>
</html>
