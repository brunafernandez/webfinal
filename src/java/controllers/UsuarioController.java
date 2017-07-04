/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entidades.Usuario;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.UsuarioDAO;

/**
 *
 * @author bruuh
 */
@WebServlet(name = "cadastro", urlPatterns = {"/cadastro"})
public class UsuarioController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nome, email, senha, logradouro, complemento, cep, cidade, uf, pais, numero, bairro;

        nome = request.getParameter("Nome").toUpperCase();
        email = request.getParameter("Email");
        senha = request.getParameter("Senha");
        logradouro = request.getParameter("Rua").toUpperCase();
        complemento = request.getParameter("Complemento").toUpperCase();
        cep = request.getParameter("CEP").toUpperCase();
        cidade = request.getParameter("Cidade").toUpperCase();
        uf = request.getParameter("UF").toUpperCase();
        numero = request.getParameter("Numero").toUpperCase();
        bairro = request.getParameter("Bairro").toUpperCase();

        Usuario usuario = new Usuario(nome, email, senha, logradouro, numero, complemento, bairro, cep, cidade, uf);
        UsuarioDAO usu = new UsuarioDAO();

        RequestDispatcher index = request.getRequestDispatcher("/webfinal/index.jsp");

        try {
            if (usu.salvar(usuario)) {
                HttpSession sessao = request.getSession();
                if (usuario.getNome().toUpperCase().equals("admin")) {
                    System.out.println("Colocou atributo de sessão de adm");
                    sessao.setAttribute("admin", usuario);
                } else {
                    System.out.println("Colocou atributo de sessão de usuario");
                    sessao.setAttribute("usuario", usuario);
                }
                sessao.setAttribute("statusLogin", true);
                response.sendRedirect("/webfinal/index.jsp");
            } else {
                request.setAttribute("erro", "Erro ao cadastrar usuário");
                index.forward(request, response);
            }
        } catch (IOException | ServletException e) {
            request.setAttribute("erro", "Erro de Conexão com o Banco: " + e.toString());
            index.forward(request, response);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
