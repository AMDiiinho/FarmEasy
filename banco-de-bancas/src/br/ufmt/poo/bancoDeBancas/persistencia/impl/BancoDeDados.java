/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufmt.poo.bancoDeBancas.persistencia.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.sql.ResultSet;

/**
 *
 * @author aluno
 */
public class BancoDeDados {
    
    public Connection conectar() throws SQLException {
        String url = "jdbc:postgresql://localhost:5433/banco_de_bancas";
        Connection con = DriverManager.getConnection(url, "postgres", "123");
        return con;
    }
    
    public void fecharConexao(Connection con) throws SQLException {
        con.close();
    }
    
    public void executar(String sql, List parametros) {
        
        try {
            Connection con = conectar();
            PreparedStatement pstmt = con.prepareStatement(sql);
            for (int i = 0; i < parametros.size(); i++) {
                pstmt.setObject(i + 1, parametros.get(i));
            }
            pstmt.execute();

            fecharConexao(con);
        } catch (SQLException erro){
            erro.printStackTrace();
            throw new RuntimeException("Erro ao inserir/atualizar no banco de dados!");
        }
    }
    
    public ResultSet executarQuery(String sql) {
        try {
            Connection con = conectar();
            return con.createStatement().executeQuery(sql);
        } catch (SQLException erro){
            erro.printStackTrace();
            throw new RuntimeException("Erro ao consultar no banco de dados!");
        }
    }
}
