/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufmt.poo.FarmEasy.persistencias.impl;

import br.ufmt.poo.FarmEasy.persistencias.SiloPersistencia;
import br.ufmt.poo.FarmEasy.persistencias.entidade.Silo;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author arthurmarques
 */
public class SiloPersistenciaImpl implements SiloPersistencia {

    BancoDeDados bd = new BancoDeDados();
    
    @Override
    public void executar(Silo silo) {
        
        String sql = "INSERT INTO tb_silos (capacidade) VALUES (?);";
        List parametros = new ArrayList();
        parametros.add(silo.getCapacidade());
        bd.inserir(sql, parametros);   
    }

    @Override
    public void remover(int id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void atualizar(Silo silo) {
            
        String sql = "UPDATE tb_silos qtdProdutos = ? capacidade = ? WHERE id = ?;";
        List parametros = new ArrayList();
        parametros.add(silo.getQtdProdutos());
        parametros.add(silo.getCapacidade());
        parametros.add(silo.getId());
        bd.inserir(sql, parametros);
        
    }

    @Override
    public List<Silo> buscar() {
        
        List<Silo> lista = new ArrayList();
        String sql = "SELECT * FROM tb_silos";
        ResultSet rs = bd.executarQuery(sql);
        
        
        try{
            while(rs.next()){
                
                int id = rs.getInt("id");
                int capacidade = rs.getInt("capacidade");
                Silo silo = new Silo(id, capacidade);
                lista.add(silo);
            }
            
        } catch (SQLException erro){
            erro.printStackTrace();
            throw new RuntimeException("Falha ao recuperar os dados do banco!");
        }
        
        return lista;    
    }
    
}
