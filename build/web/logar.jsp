<%-- 
    Document   : login
    Created on : 22/10/2016, 16:29:40
    Author     : Diego Vilella Rodrigues
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login NASA</title>   
        <link rel="stylesheet prefetch" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.min.css">
        <link rel="stylesheet prefetch" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="css/styleLogin.css">
        <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
        <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
        <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
        <style>
            .ui-progressbar {
              position: relative;
            }
            .progress-label {
              position: absolute;
              left: 1%;
              top: 4px;
              font-weight: bold;
              text-shadow: 1px 1px 0 #fff;
           }
        </style>
        <script>
            var pval = 0;
            $(function() {
              var progressbar = $( "#progressbar" ),
                progressLabel = $( ".progress-label" );

              progressbar.progressbar({
                value: false,
                change: function() {
                  progressLabel.text( progressbar.progressbar( "value" ) + "%" );
                 
                },
                complete: function() {
                  progressLabel.text( "Pronto Conecte-se a NASA");
                 event.preventDefault();
                    $("#camadaefeitos").show(3000);
                  
                }
              });
            progress();

          function progress() {
           var xmlhttp;
          if (window.XMLHttpRequest)
            {
            xmlhttp=new XMLHttpRequest();
            }
          else
            {
            xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
            }
          xmlhttp.onreadystatechange=function()
            {
            if (xmlhttp.readyState==4 && xmlhttp.status==200)
              {
                pval=xmlhttp.responseText;//getting result from servlet
                progressbar.progressbar( "value",parseInt(pval));//converting string result to integer
              }
            }
              xmlhttp.open("GET","logar?pval="+pval,true);//value sending to servlet
              xmlhttp.send();   
               var val = parseInt(pval);
               if ( val < 100 ) {
                  setTimeout( progress, 1000 );
                }
              }

            });
        </script>
    </head>
    <body>
        <a href="/index.jsp" class="logo">
            <img src="imagens/nasa-logo.svg">     
        </a>            
        <div class="wrapper">  
            <section ng-controller="UsuarioController as controller" ng-init="form_login = true"> 
                <form class="form-signin" method="post" action="logar">
                    <div id="camadaefeitos" style="display:none;">
                    <h2 class="form-signin-heading">Faça o login</h2>
                    <input  type="text" class="form-control" name="email"  placeholder="Email" required="" autofocus="" data-error="Usuário e/ou senha incorretos" />
                    <input  type="password" class="form-control" name="senha" placeholder="Senha" required="" data-error="Usuário e/ou senha incorretos"/>
                    <button class="botao" id="button" type="submit">Login</button>
                    </div>
                    <span id="display"></span>                             
                    <a href="\cadastro.jsp" type="submit">Cadastrar</a>
                    <br>
                    <br>
                    <div id="progressbar"><div class="progress-label"></div></div>
                </form>
            </section>
        </div>
    </body>
</html>
