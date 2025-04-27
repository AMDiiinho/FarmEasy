/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufmt.poo.FarmEasy.persistencias.impl;

import br.ufmt.poo.FarmEasy.persistencias.AbrigoPersistencia;
import br.ufmt.poo.FarmEasy.persistencias.entidade.Abrigo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aluno
 */
public class AbrigoPersistenciaImpl implements AbrigoPersistencia {

    private BancoDeDados bd = new BancoDeDados();
    
    @Override
    public void executar(Abrigo abrigo) {               
        
        String sql = "INSERT INTO tb_abrigos (tipo, capacidade) VALUES (?,?);";
        List parametros = new ArrayList();
        parametros.add(abrigo.getTipo());
        parametros.add(abrigo.getCapacidade());
        bd.inserir(sql, parametros);  
        
    }

    @Override
    public void remover(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void atualizar(Abrigo abrigo) {
        
        String sql = "UPDATE tb_abrigos SET tipo = ?, capacidade = ? WHERE id = ?";
        List parametros = new ArrayList();
        parametros.add(abrigo.getTipo());
        parametros.add(abrigo.getCapacidade());
        parametros.add(abrigo.getId());
        bd.inserir(sql, parametros);    
    
    }

    @Override
    public List<Abrigo> buscar(String tipoAbrigo) {
        
        List<Abrigo> lista = new ArrayList();
        String sql = "SELECT * FROM tb_abrigos WHERE tipo = '" + tipoAbrigo + "';";
        ResultSet rs = bd.executarQuery(sql);
        
        try {
            while(rs.next()){
                
                int id = rs.getInt("id");
                String tipo = rs.getString("tipo");
                int capacidade = rs.getInt("capacidade");
                Abrigo abrigo = new Abrigo(id, tipo, capacidade);
                lista.add(abrigo);
                
                
            }
        } catch (SQLException erro) {
            erro.printStackTrace();
            throw new RuntimeException("Não foi possível recuperar os dados do banco!");
        }
            
        return lista;  
    }
    
}
