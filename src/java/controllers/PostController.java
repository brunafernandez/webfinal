/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entidades.Post;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.PostDAO;

/**
 *
 * @author bruuh
 */
@WebServlet(name = "post", urlPatterns = {"/post"})
public class PostController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Post post = new Post();
        PostDAO pdao = new PostDAO();
        Long i = new Long(1);
        
        post.setTitulo(request.getParameter("titulo"));
        post.setSubtitulo(request.getParameter("subtitulo"));
        post.setTexto(request.getParameter("texto"));
        post.setUsuarioID(i);
        
        if (pdao.salvar(post)) {
            request.setAttribute("mensagem", "Post salvo com sucesso");
            response.sendRedirect("/webfinal/index.jsp");
        }else{
            request.setAttribute("mensagem", "O post não foi salvo");
            RequestDispatcher view = request.getRequestDispatcher("/webfinal/post.jsp");
            view.forward(request, response);
        }
        
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
