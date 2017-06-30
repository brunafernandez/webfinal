/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Conexao;
import entidades.Post;

/**
 *
 * @author bruuh
 */
public class PostDAO {

    public boolean salvar(Post post) {


        String sql = "INSERT INTO post(titulo,subtitulo,texto,usuarioID)" + " VALUES(?,?,?,?)";

        Connection conn = null;
        PreparedStatement pstm = null;
        
        try {
            //conecta com o banco
            conn = Conexao.createConnectionToMySQL();

            //cria a execução da query
            pstm = conn.prepareStatement(sql);

            //Adiciona o valores
            pstm.setString(1, post.getTitulo());
            pstm.setString(2, post.getSubtitulo());
            pstm.setString(3, post.getTexto());
            pstm.setLong(4, post.getUsuarioID());

            //Executa a inserção dos dados
            pstm.execute();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            //Fecha as conexões
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    public void removerPorID(Long id) {

        String sql = "DELETE FROM post WHERE id = ?";
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = Conexao.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);
            pstm.setLong(1, id);
            pstm.execute();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void alterar(Post post) {

        String sql = "UPDATE post SET titulo = ?, subtitulo = ?, texto = ?, img = ?, video = ?, usuarioID = ?"
                + " WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            //Cria uma conexão com o banco
            conn = Conexao.createConnectionToMySQL();

            //Cria um PreparedStatment, classe usada para executar a query
            pstm = conn.prepareStatement(sql);

            //Adiciona o valor do primeiro parâmetro da sql
            pstm.setString(1, post.getTitulo());
            pstm.setString(2, post.getSubtitulo());
            pstm.setString(3, post.getTexto());
            pstm.setString(4, post.getImg());
            pstm.setString(5, post.getVideo());
            pstm.setLong(6, post.getUsuarioID());
            
            pstm.setLong(7, post.getId());

            //Executa a sql para inserção dos dados
            pstm.execute();

        } catch (Exception e) {

            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public List<Post> listar() {

        String sql = "SELECT * FROM post";

        List<Post> posts = new ArrayList<Post>();

        Connection conn = null;
        PreparedStatement pstm = null;
        //Classe que vai recuperar os dados do banco de dados
        ResultSet rset = null;

        try {
            conn = Conexao.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            //Enquanto existir dados no banco de dados, faça
            while (rset.next()) {

                Post post = new Post();

                //Recupera os itens e atibui ao objeto
                post.setId(rset.getLong("id"));
                post.setTitulo(rset.getString("titulo"));
                post.setSubtitulo(rset.getString("subtitulo"));
                post.setTexto(rset.getString("texto"));
                post.setImg(rset.getString("img"));
                post.setVideo(rset.getString("video"));
                post.setUsuarioID(rset.getLong("usuarioID"));

                //Adiciono os posts a list
                posts.add(post);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rset != null) {
                    rset.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return posts;
    }
    
    public List<Post> pesquisar(String busca){
        String sql = "SELECT * FROM post WHERE titulo like ? OR subtitulo like ?";        
        
        List<Post> posts = new ArrayList<Post>();

        Connection conn = null;
        PreparedStatement pstm = null;
        //Classe que vai recuperar os dados do banco de dados
        ResultSet rset = null;

        try {
            conn = Conexao.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            
            pstm.setString(1, busca + "%");
            pstm.setString(2, busca + "%");
            
            rset = pstm.executeQuery();

            //Enquanto existir dados no banco de dados, faça
            while (rset.next()) {

                Post post = new Post();

                //Recupera os itens e atibui ao objeto
                post.setId(rset.getLong("id"));
                post.setTitulo(rset.getString("titulo"));
                post.setSubtitulo(rset.getString("subtitulo"));
                post.setTexto(rset.getString("texto"));
                post.setImg(rset.getString("img"));
                post.setVideo(rset.getString("video"));
                post.setUsuarioID(rset.getLong("usuarioID"));

                //Adiciono os posts a list
                posts.add(post);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rset != null) {
                    rset.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return posts;
    }
}
