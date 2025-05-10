/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufmt.poo.FarmEasy.persistencias.impl;

import br.ufmt.poo.FarmEasy.persistencias.AnimalPersistencia;
import br.ufmt.poo.FarmEasy.persistencias.entidade.Animal;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

/**
 *
 * @author arthurmarques
 */
public class AnimalPersistenciaImpl implements AnimalPersistencia {

    BancoDeDados bd = new BancoDeDados();
    
    @Override
    public void executar(Animal animal) {
        
        String sql = "INSERT INTO tb_animais (usuarioId, tipo, raca, valor) VALUES (?, ?, ?, ?);";
        List parametros = new ArrayList();
        parametros.add(animal.getUsuarioId());
        parametros.add(animal.getTipo());
        parametros.add(animal.getRaca());
        parametros.add(animal.getValor());
        bd.executar(sql, parametros);    
    }

    @Override
    public void remover(int id) {                
        String sql = "DELETE FROM tb_animais WHERE id = ?;";       
        List parametros = new ArrayList();
        parametros.add(id);
        bd.executar(sql, parametros);      
    }

    @Override
    public void atualizar(Animal animal) {
        String sql = "UPDATE tb_animais valor = ? WHERE id = ?;";
        List parametros = new ArrayList();
        parametros.add(animal.getValor());
        bd.executar(sql, parametros);    
    }

    @Override
    public List<Animal> buscar(int idUsuario, String tipoAnimal) {
        List<Animal> lista = new ArrayList();
        String sql = "SELECT * FROM tb_animais WHERE usuarioId = '" + idUsuario + "' AND tipo = '" + tipoAnimal + "';";
        ResultSet rs = bd.executarQuery(sql);
        
        
        try{
            while(rs.next()){
                
                int id = rs.getInt("id");
                int usuarioId = rs.getInt("usuarioId");
                String tipo = rs.getString("tipo");
                String raca = rs.getString("raca");
                int quantidade = rs.getInt("quantidade");
                double valor = rs.getDouble("valor");
                Animal animal = new Animal(id, usuarioId, tipo, raca, quantidade, valor);
                lista.add(animal);
        }
            
        } catch (SQLException erro){
            erro.printStackTrace();
            throw new RuntimeException("Falha ao recuperar os dados do banco!");
        }
        
        return lista;
    }
    
    @Override
    public void atualizarQtdAnimais(String racaAnimal, int quantidade, String operacao){
        
        String sqlSelect = "SELECT quantidade FROM tb_animais WHERE raca = '" + racaAnimal + "';";
        ResultSet rs = bd.executarQuery(sqlSelect);
        
        try {
            
            if(rs.next()){
                
                int qtdAtual = rs.getInt("quantidade");
                
                if(operacao.equals("Entrou")){
                    int qtdNova = qtdAtual + quantidade;

                    String sqlUpdate = "UPDATE tb_animais SET quantidade = '" + qtdNova + "' WHERE raca = '" + racaAnimal + "';";
                    bd.executarQuery(sqlUpdate);
                } else {
                    int qtdNova = qtdAtual - quantidade;

                    String sqlUpdate = "UPDATE tb_animais SET quantidade = '" + qtdNova + "' WHERE raca = '" + racaAnimal + "';";
                    bd.executarQuery(sqlUpdate);
                }
            }
            
        } catch (Exception erro){
            
        }
       
        
    }
    
}
