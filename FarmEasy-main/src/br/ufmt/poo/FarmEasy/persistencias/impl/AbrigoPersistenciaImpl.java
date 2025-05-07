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
import javax.swing.JOptionPane;

/**
 *
 * @author aluno
 */
public class AbrigoPersistenciaImpl extends javax.swing.JFrame implements AbrigoPersistencia {

    private BancoDeDados bd = new BancoDeDados();
    
    @Override
    public void executar(Abrigo abrigo) {               
        
        String sql = "INSERT INTO tb_abrigos (usuarioId, tipo, capacidade) VALUES (?,?,?);";
        List parametros = new ArrayList();
        parametros.add(abrigo.getUsuarioId());
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
    public List<Abrigo> buscar(int idUsuario, String tipoAbrigo) {
        
        List<Abrigo> lista = new ArrayList();
        String sql = "SELECT * FROM tb_abrigos WHERE usuarioId = '" + idUsuario + "' AND tipo = '" + tipoAbrigo + "';";
        ResultSet rs = bd.executarQuery(sql);
        
        try {
            while(rs.next()){
                
                int id = rs.getInt("id");
                int usuarioId = rs.getInt("usuarioId");
                String tipo = rs.getString("tipo");
                int qtdAnimais = rs.getInt("qtdAnimais");
                int capacidade = rs.getInt("capacidade");
                Abrigo abrigo = new Abrigo(id, usuarioId, tipo, qtdAnimais, capacidade);
                lista.add(abrigo);
                
                
            }
        } catch (SQLException erro) {
            erro.printStackTrace();
            throw new RuntimeException("Não foi possível recuperar os dados do banco!");
        }
            
        return lista;  
    }
    
    @Override
    public boolean entradaAnimais(int idAbrigo, int qtdAnimais){
                       
        try {
                      
            if(qtdAnimais <= 0){
                JOptionPane.showMessageDialog(rootPane, "O campo quantidade não pode zer menor ou igual a zero!");
            } else {
            
                String sqlSelect  = "SELECT qtdAnimais, capacidade FROM tb_abrigos WHERE id = '" + idAbrigo + "';";
                ResultSet rs = bd.executarQuery(sqlSelect);
                
                if(rs.next()){

                    int qtdAnimaisAtual = rs.getInt("qtdAnimais");
                    int capacidade = rs.getInt("capacidade");

                    int qtdAnimaisNova = qtdAnimaisAtual + qtdAnimais;
          
                    if(qtdAnimaisNova <= capacidade){                                             
                        String sqlUpdate = "UPDATE tb_abrigos SET qtdAnimais = '" + qtdAnimaisNova + "' WHERE id = '" + idAbrigo + "';";
                        JOptionPane.showMessageDialog(rootPane, "Entrada de animais registrada!");
                        bd.executarQuery(sqlUpdate);

                        } else {                       
                        JOptionPane.showMessageDialog(rootPane, "Espaço insuficiente no abrigo!");
                        return false;
                    }
                }               
            } 
        } catch (Exception erro) {
  
        }
        return true;
    }
    
}
