/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entidades.Post;
import models.PostDAO;

/**
 *
 * @author bruuh
 */
public class ControllerPostTeste {
    
    public static void main(String[] args) {
        
        PostDAO postdao = new PostDAO();
        
        Long i = new Long(1);
        
//        Post post = new Post("TESTE TITULO", "TESTE SUBTITULO", "TESTE TEXTO LOREM IPSUM SIAMET ET DOLOR WHATEVER",i);
//        Post post1 = new Post("ABACATE", "FRUTA", "TESTE TEXTO LOREM IPSUM SIAMET ET DOLOR WHATEVER",i);
//        Post post2 = new Post("BANANA", "FRUTA", "TESTE TEXTO LOREM IPSUM SIAMET ET DOLOR WHATEVER",i);
//        Post post3 = new Post("CAJU", "FRUTA", "TESTE TEXTO LOREM IPSUM SIAMET ET DOLOR WHATEVER",i);
//        Post post4 = new Post("DAMASCO", "FRUTA", "TESTE TEXTO LOREM IPSUM SIAMET ET DOLOR WHATEVER",i);
//        Post post5 = new Post("ESCAROLA", "VERDURA", "TESTE TEXTO LOREM IPSUM SIAMET ET DOLOR WHATEVER",i);
//        Post post6 = new Post("FEIJÃO", "LEGUME", "TESTE TEXTO LOREM IPSUM SIAMET ET DOLOR WHATEVER",i);
//        
//        
//        postdao.salvar(post);
//        postdao.salvar(post1);
//        postdao.salvar(post2);
//        postdao.salvar(post3);
//        postdao.salvar(post4);
//        postdao.salvar(post5);
//        postdao.salvar(post6);
//        postdao.removerPorID(1);

        postdao.listar().stream().forEach((p) -> {
             System.out.println("Titulo: " + p.getTitulo());
        });
        
        postdao.pesquisar("F").stream().forEach((p) -> {
            System.out.println("Titulo: " + p.getTitulo() + " - Subtítulo: " + p.getSubtitulo());
        });
        
        
    }
    
}
