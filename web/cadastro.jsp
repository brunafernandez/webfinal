<%-- 
Document   : cadastro
Created on : 22/10/2016, 16:29:51
Author     : Diego Vilella Rodrigues 
--%>

<%@page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Cadastro</title>   
        <link rel='stylesheet prefetch' href='http://netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.min.css'>
        <link rel='stylesheet prefetch' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css'>
        <link rel="stylesheet" type="text/css" href="css/styleLogin.css">
        <!-- Adicionando JQuery -->
        <script src="//code.jquery.com/jquery-3.1.1.min.js"></script>

        <!-- Adicionando Javascript -->
        <script type="text/javascript" >
            function limpa_formulário_cep() {
                //Limpa valores do formulário de cep.
                document.getElementById('rua').value = ("");
                document.getElementById('bairro').value = ("");
                document.getElementById('cidade').value = ("");
                document.getElementById('uf').value = ("");
            }

            function meu_callback(conteudo) {
                if (!("erro" in conteudo)) {
                    //Atualiza os campos com os valores.
                    document.getElementById('rua').value = (conteudo.logradouro);
                    document.getElementById('bairro').value = (conteudo.bairro);
                    document.getElementById('cidade').value = (conteudo.localidade);
                    document.getElementById('uf').value = (conteudo.uf);
                } //end if.
                else {
                    //CEP não Encontrado.
                    limpa_formulário_cep();
                    alert("CEP não encontrado.");
                }
            }

            function pesquisacep(valor) {

                //Nova variável "cep" somente com dígitos.
                var cep = valor.replace(/\D/g, '');

                //Verifica se campo cep possui valor informado.
                if (cep != "") {

                    //Expressão regular para validar o CEP.
                    var validacep = /^[0-9]{8}$/;

                    //Valida o formato do CEP.
                    if (validacep.test(cep)) {

                        //Preenche os campos com "..." enquanto consulta webservice.
                        document.getElementById('rua').value = "...";
                        document.getElementById('bairro').value = "...";
                        document.getElementById('cidade').value = "...";
                        document.getElementById('uf').value = "...";

                        //Cria um elemento javascript.
                        var script = document.createElement('script');

                        //Sincroniza com o callback.
                        script.src = '//viacep.com.br/ws/' + cep + '/json/?callback=meu_callback';

                        //Insere script no documento e carrega o conteúdo.
                        document.body.appendChild(script);

                    } //end if.
                    else {
                        //cep é inválido.
                        limpa_formulário_cep();
                        alert("Formato de CEP inválido.");
                    }
                } //end if.
                else {
                    //cep sem valor, limpa formulário.
                    limpa_formulário_cep();
                }
            };
        </script>
    </head>
    <body>
        <a href="/webfinal/index.jsp" class="logo">
            <img src="imagens/nasa-logo.svg">   
        </a>            
        <div class="wrapper">  
            <form class="form-signin" method="post" action="cadastro">
                <h2 class="form-signin-heading">Cadastro</h2>
                <input type="text" class="form-control"  name="Nome" placeholder="Nome" required="" autofocus="" />                
                <input type="text" class="form-control" name="Email" placeholder="Email" required="" autofocus="" />
                <input type="password" class="form-control" name="Senha" placeholder="Senha" required="" />               
                <input type="text" class="form-control" name="Complemento" placeholder="Complemento" required="" />
                <input type="text" class="form-control" id="cep" name="CEP" placeholder="CEP" required="" onblur="pesquisacep(this.value);" />
                <input type="text" class="form-control" id="rua" name="Rua" placeholder="Rua" required="" autofocus="" />
                <input type="text" class="form-control" id="bairro" name="Bairro" placeholder="Bairro" required="" autofocus="" /> 
                <input type="text" class="form-control" id="cidade" name="Cidade" placeholder="Cidade" required="" />
                <input type="text" class="form-control" id="uf" name="UF" placeholder="UF" required="" />
                <input type="text" class="form-control" id="numero" name="Numero" placeholder="Numero" required="" autofocus="" />
                <button type="submit" class="form-control">Cadastrar</button>
                <span id="mensagens" class="form-control"></span>
            </form>
            <script type="text/javascript" charset="utf-8">
                var mensagens = document.querySelector("#mensagens");
                document.querySelector("input").addEventListener("keyup", function (ev) {
                    if (ev.keyCode != 13)
                        return;
                    var xhr = new XMLHttpRequest(),
                            self = this;
                    xhr.open("POST", "cadastro", true);
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
                    xhr.send("Nome=" + this.value, "Email=" + this.value, "Senha=" + this.value, "Rua=" + this.value, "Complemento=" + this.value, "Cidade=" + this.value, "UF=" + this.value, "Numero=" + this.value, "Bairro=" + this.value);

                });

            </script>
        </div>
    </body>
</html>
