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
import javax.swing.JOptionPane;

/**
 *
 * @author arthurmarques
 */
public class SiloPersistenciaImpl extends javax.swing.JFrame implements SiloPersistencia {

    BancoDeDados bd = new BancoDeDados();
    
    @Override
    public void executar(Silo silo) {
        
        String sql = "INSERT INTO tb_silos (usuarioId, capacidade) VALUES (?,?);";
        List parametros = new ArrayList();
        parametros.add(silo.getUsuarioId());
        parametros.add(silo.getCapacidade());
        bd.executar(sql, parametros);   
    }

    @Override
    public void remover(int id) {
        String sql = "DELETE FROM tb_silos WHERE id = ?;";
        List parametros = new ArrayList();
        parametros.add(id);
        bd.executar(sql, parametros);       
    }

    @Override
    public void atualizar(Silo silo) {

        String sql = "UPDATE tb_silos qtdProdutos = ? WHERE id = ?;";
        List parametros = new ArrayList();
        parametros.add(silo.getQtdProdutos());
        parametros.add(silo.getId());
        bd.executar(sql, parametros);
        
    }

    @Override
    public List<Silo> buscar(int idUsuario) {
        
        List<Silo> lista = new ArrayList();
        String sql = "SELECT * FROM tb_silos WHERE usuarioId = '" + idUsuario + "';";
        ResultSet rs = bd.executarQuery(sql);
        
        
        try{
            while(rs.next()){
                
                int id = rs.getInt("id");
                int usuarioId = rs.getInt("usuarioId");
                int qtdProdutos = rs.getInt("qtdProdutos");
                int capacidade = rs.getInt("capacidade");
                Silo silo = new Silo(id, usuarioId, qtdProdutos, capacidade);
                lista.add(silo);
            }
            
        } catch (SQLException erro){
            erro.printStackTrace();
            throw new RuntimeException("Falha ao recuperar os dados do banco!");
        }
        
        return lista;    
    }
    
    @Override
    public String entradaSaidaEstoque(int idSilo, int qtdProdutos, String operacao){
        
        String entrouSaiu = "";
               
        try {
            
            if(qtdProdutos <= 0){
                JOptionPane.showMessageDialog(rootPane, "O campo quantidade não pode zer menor ou igual a zero!");                
            } else {
                String sqlSelect  = "SELECT qtdProdutos, capacidade FROM tb_silos WHERE id = '" + idSilo + "';";
                ResultSet rs = bd.executarQuery(sqlSelect);

                while(rs.next()){

                    int qtdProdutosAtual = rs.getInt("qtdProdutos");
                    int capacidade = rs.getInt("capacidade");
                    
                    if(operacao.equals("Entrada")){

                        int qtdProdutosNova = qtdProdutosAtual + qtdProdutos;

                        if(qtdProdutosNova <= capacidade){
                            String sqlUpdate = "UPDATE tb_silos SET qtdProdutos = '" + qtdProdutosNova + "' WHERE id = '" + idSilo + "';";
                            JOptionPane.showMessageDialog(rootPane, "Entrada de produto registrada com sucesso!");
                            entrouSaiu = "Entrou";
                            bd.executarQuery(sqlUpdate);

                        } else {
                            JOptionPane.showMessageDialog(rootPane, "Espaço insuficiente no silo!");
                        }
                    } else {
                        
                        int qtdProdutosNova = qtdProdutosAtual - qtdProdutos;

                        if(qtdProdutosNova >= 0){
                            String sqlUpdate = "UPDATE tb_silos SET qtdProdutos = '" + qtdProdutosNova + "' WHERE id = '" + idSilo + "';";
                            JOptionPane.showMessageDialog(rootPane, "Saída de produto registrada com sucesso!");
                            entrouSaiu = "Saiu";
                            bd.executarQuery(sqlUpdate);

                        } else {
                            JOptionPane.showMessageDialog(rootPane, "A quantia de produtos a serem removidos"
                            + " é maior que a quantia que existe no silo!");
                        }
                        
                    }
                }
            }
        } catch (Exception erro){
          
        }
        return entrouSaiu;
    }
    
    
    
    
    
}
