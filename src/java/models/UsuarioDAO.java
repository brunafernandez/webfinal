/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bruuh
 */
public class UsuarioDAO {

    public void salvar(Usuario usu) {

        String sql = "INSERT INTO usuario(nome, logradouro, numero, complemento, bairro, cep, cidade, uf, pais, email, senha)" + " VALUES(?,?,?,?,?,?,?,?,?,?,?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            //conecta com o banco
            conn = Conexao.createConnectionToMySQL();

            //cria a execução da query
            pstm = conn.prepareStatement(sql);

            //Adiciona o valores
            pstm.setString(1, usu.getNome());
            pstm.setString(2, usu.getLogradouro());
            pstm.setString(3, usu.getNumero());
            pstm.setString(4, usu.getComplemento());
            pstm.setString(5, usu.getBairro());
            pstm.setString(6, usu.getCep());
            pstm.setString(7, usu.getCidade());
            pstm.setString(8, usu.getUf());
            pstm.setString(9, usu.getPais());
            pstm.setString(10, usu.getEmail());
            pstm.setString(11, usu.getSenha());

            //Executa a inserção dos dados
            pstm.execute();

        } catch (Exception e) {
            e.printStackTrace();
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
            }
        }
    }

    public void removerPorID(Long id) {

        String sql = "DELETE FROM usuario WHERE id = ?";
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

    public void alterar(Usuario usu) {

        String sql = "UPDATE usuario SET nome = ?, logradouro = ?, numero = ?, complemento = ?, bairro = ?, cep = ?, cidade = ?, uf = ?, pais = ?, email = ?, senha = ?"
                + " WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            //Cria uma conexão com o banco
            conn = Conexao.createConnectionToMySQL();

            //Cria um PreparedStatment, classe usada para executar a query
            pstm = conn.prepareStatement(sql);

            //Adiciona o valor do primeiro parâmetro da sql
            pstm.setString(1, usu.getNome());
            pstm.setString(2, usu.getLogradouro());
            pstm.setString(3, usu.getNumero());
            pstm.setString(4, usu.getComplemento());
            pstm.setString(5, usu.getBairro());
            pstm.setString(6, usu.getCep());
            pstm.setString(7, usu.getCidade());
            pstm.setString(8, usu.getUf());
            pstm.setString(9, usu.getPais());
            pstm.setString(10, usu.getEmail());
            pstm.setString(11, usu.getSenha());

            pstm.setLong(12, usu.getId());

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

    public List<Usuario> listar() {

        String sql = "SELECT * FROM usuario";

        List<Usuario> usus = new ArrayList<Usuario>();

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

                Usuario usu = new Usuario();

                //Recupera os itens e atibui ao objeto
                usu.setId(rset.getLong("id"));
                usu.setNome(rset.getString("nome"));
                usu.setLogradouro(rset.getString("logradouro"));
                usu.setNumero(rset.getString("numero"));
                usu.setComplemento(rset.getString("complemento"));
                usu.setBairro(rset.getString("bairro"));
                usu.setCep(rset.getString("cep"));
                usu.setCidade(rset.getString("cidade"));
                usu.setUf(rset.getString("uf"));
                usu.setPais(rset.getString("pais"));
                usu.setEmail(rset.getString("email"));
                usu.setSenha(rset.getString("senha"));

                //Adiciono os posts a list
                usus.add(usu);
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
        return usus;
    }

    public List<Usuario> pesquisar(String busca) {
        String sql = "SELECT * FROM usuario WHERE nome like ? OR email like ?";

        List<Usuario> usus = new ArrayList<Usuario>();

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

                Usuario usu = new Usuario();

                //Recupera os itens e atibui ao objeto
                usu.setId(rset.getLong("id"));
                usu.setNome(rset.getString("nome"));
                usu.setLogradouro(rset.getString("logradouro"));
                usu.setNumero(rset.getString("numero"));
                usu.setComplemento(rset.getString("complemento"));
                usu.setBairro(rset.getString("bairro"));
                usu.setCep(rset.getString("cep"));
                usu.setCidade(rset.getString("cidade"));
                usu.setUf(rset.getString("uf"));
                usu.setPais(rset.getString("pais"));
                usu.setEmail(rset.getString("email"));
                usu.setSenha(rset.getString("senha"));

                //Adiciono os posts a list
                usus.add(usu);
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
        return usus;
    }

    public Usuario getUsuarioByID(Long id) {
        String sql = "SELECT * FROM usuario WHERE id = ?";
        
        Usuario usu = new Usuario();
        
        Connection conn = null;
        PreparedStatement pstm = null;
        
        ResultSet rset = null;

        try {
            conn = Conexao.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);

            pstm.setLong(1, id);

            rset = pstm.executeQuery();
            
            //Recupera os itens e atibui ao objeto
            usu.setId(rset.getLong("id"));
            usu.setNome(rset.getString("nome"));
            usu.setLogradouro(rset.getString("logradouro"));
            usu.setNumero(rset.getString("numero"));
            usu.setComplemento(rset.getString("complemento"));
            usu.setBairro(rset.getString("bairro"));
            usu.setCep(rset.getString("cep"));
            usu.setCidade(rset.getString("cidade"));
            usu.setUf(rset.getString("uf"));
            usu.setPais(rset.getString("pais"));
            usu.setEmail(rset.getString("email"));
            usu.setSenha(rset.getString("senha"));

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
        return usu;
    }

}
