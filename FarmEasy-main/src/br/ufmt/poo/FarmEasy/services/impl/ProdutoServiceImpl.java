/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufmt.poo.FarmEasy.services.impl;

import br.ufmt.poo.FarmEasy.services.ProdutoService;
import java.util.List;
import br.ufmt.poo.FarmEasy.UI.DTOs.ProdutoDTO;
import br.ufmt.poo.FarmEasy.persistencias.ProdutoPersistencia;
import br.ufmt.poo.FarmEasy.persistencias.entidade.Produto;
import br.ufmt.poo.FarmEasy.persistencias.impl.ProdutoPersistenciaImpl;
import java.util.ArrayList;

/**
 *
 * @author arthurmarques
 */
public class ProdutoServiceImpl implements ProdutoService{

    @Override
    public void salvar(ProdutoDTO dto) {
        if(dto.getNome().equals("")){
            throw new RuntimeException("O campo nome não pode estar vazio!"); 
        }
        
        int id = 0;
        int estoque = Integer.parseInt(dto.getEstoque());
        double valor = Double.parseDouble(dto.getValor());
        
        if(!dto.getId().equals("")){
            
            id = Integer.parseInt(dto.getId());            
        }
        
        Produto produto = new Produto (id, dto.getNome(), estoque, valor);
        
        ProdutoPersistencia persistencia = new ProdutoPersistenciaImpl();
        
        if(id == 0){
            persistencia.executar(produto);
        } else {
            persistencia.atualizar(produto);
        }
    }

    @Override
    public void remover(ProdutoDTO dto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ProdutoDTO> listar() {
        
        ProdutoPersistencia persistencia = new ProdutoPersistenciaImpl();
        
        List<ProdutoDTO> lista = new ArrayList<>();
        List<Produto> produtos = persistencia.buscar();
        for (Produto produto : produtos) {
            String id = produto.getId() + "";
            String nome = produto.getNome();
            String estoque = produto.getEstoque() + "";
            String valor = produto.getValor() + "";
            ProdutoDTO dto = new ProdutoDTO(id, nome, estoque, valor);
            lista.add(dto);
            
        }
        
        return lista;
    }
    
}
