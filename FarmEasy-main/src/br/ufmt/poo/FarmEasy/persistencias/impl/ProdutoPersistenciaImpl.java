/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufmt.poo.FarmEasy.persistencias.impl;

import br.ufmt.poo.FarmEasy.persistencias.ProdutoPersistencia;
import br.ufmt.poo.FarmEasy.persistencias.entidade.Produto;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author arthurmarques
 */
public class ProdutoPersistenciaImpl implements ProdutoPersistencia{
    
    private BancoDeDados bd = new BancoDeDados();
    
    @Override
    public void executar(Produto produto) {
        
        String sql = "INSERT INTO tb_produtos (nome, estoque, valor) VALUES (?, ?, ?);";
        List parametros = new ArrayList();
        parametros.add(produto.getNome());
        parametros.add(produto.getEstoque());
        parametros.add(produto.getValor());
        bd.inserir(sql, parametros);
    }

    @Override
    public void remover(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void atualizar(Produto produto) {
        String sql = "UPDATE tb_produtos nome = ? estoque = ? valor = ? WHERE id = ?;";
        List parametros = new ArrayList();
        parametros.add(produto.getNome());
        parametros.add(produto.getEstoque());
        parametros.add(produto.getValor());
        bd.inserir(sql, parametros);
    }

    @Override
    public List<Produto> buscar() {
        
        List<Produto> lista = new ArrayList();
        String sql = "SELECT * FROM tb_produtos";
        ResultSet rs = bd.executarQuery(sql);
        
        
        try{
            while(rs.next()){
                
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                int estoque = rs.getInt("estoque");
                double valor = rs.getDouble("valor");
                Produto produto = new Produto(id, nome, estoque, valor);
                lista.add(produto);
            }
            
        } catch (SQLException erro){
            erro.printStackTrace();
            throw new RuntimeException("Falha ao recuperar os dados do banco!");
        }
        
        return lista;
    }
    
    
    @Override
    public void atualizarEstoque(String nomeProduto, int quantidade){
        
        String sqlSelect = "SELECT estoque FROM tb_produtos WHERE nome = '" + nomeProduto + "';";
        ResultSet rs = bd.executarQuery(sqlSelect);
        
        try {
            
            while(rs.next()){
                
                int estoqueAtual = rs.getInt("estoque");
                
                int estoqueNovo = estoqueAtual + quantidade;
                
                String sqlUpdate = "UPDATE tb_produtos SET estoque = '" + estoqueNovo + "' WHERE nome = '" + nomeProduto + "';";
                bd.executarQuery(sqlUpdate);
                
            }
            
        } catch (Exception erro){
            
        }
        
        //String sql = "UPDATE tb_produtos SET estoque = '" + nomeProduto + "' WHERE nome = '" + nomeProduto + "';"; 
        //bd.executarQuery(sql);
        
    }
    
    
    
    
    

    
}
