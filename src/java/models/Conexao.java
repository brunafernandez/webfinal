/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author bruuh
 */
 
public class Conexao {
 
   private static final String usuario = "root";
   private static final String senha = "root";
   private static final String urlDB = "jdbc:mysql://localhost:3306/apsweb";

   public static Connection createConnectionToMySQL() throws Exception{
      Class.forName("com.mysql.jdbc.Driver"); //Faz com que a classe seja carregada pela JVM
 
      //Cria a conexão com o banco de dados
      Connection connection = DriverManager.getConnection(urlDB, usuario, senha);
 
      return connection;
   }
   
   public static void main(String[] args) throws Exception{
 
      //Recupera uma conexão com o banco de dados
      Connection con = createConnectionToMySQL();
 
      //Testa se a conexão é nula
      if(con != null){
         System.out.println("Conexão obtida com sucesso!" + con);
         con.close();
      }
 
   }
}