/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufmt.poo.FarmEasy.persistencias.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author aluno
 */
public class BancoDeDados {
    
    static Connection con;

    public BancoDeDados() {
        try{
            if (con == null){
                con = conectar();
            }
        } catch (Exception erro){
            
        }
    }
    
    
    
    public Connection conectar() throws SQLException {
        
        String url = "jdbc:postgresql://localhost:5432/farmeasydb";
        Connection con = DriverManager.getConnection(url, "postgres", "123456");
        return con;
                
    }
    
    public void fecharConexao(Connection con) throws SQLException {
        con.close();
    }
    
    public void executar(String sql, List parametros) {
               
        try {
            Connection con = conectar();
            PreparedStatement pstmt = con.prepareStatement(sql);
            for (int i = 0; i < parametros.size(); i++){
                pstmt.setObject(i + 1, parametros.get(i));
            }
            
            pstmt.execute();
            
            fecharConexao(con); 
            
            } catch(SQLException erro) {
                erro.printStackTrace();
                throw new RuntimeException("Erro ao inserir no banco de dados");
        }
    }
    
    public ResultSet executarQuery(String sql){
        
        try {
            
            return con.createStatement().executeQuery(sql);
            
            } catch(SQLException erro) {
                erro.printStackTrace();
                throw new RuntimeException("Erro ao inserir no banco de dados");
        }
    }
    
    
    
}
