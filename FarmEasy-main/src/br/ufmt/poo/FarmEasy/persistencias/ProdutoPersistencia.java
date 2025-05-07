/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.ufmt.poo.FarmEasy.persistencias;

import br.ufmt.poo.FarmEasy.persistencias.entidade.Produto;
import java.util.List;

/**
 *
 * @author arthurmarques
 */
public interface ProdutoPersistencia {
    
    public void executar(Produto produto);
    
    public void remover(int id);
    
    public void atualizar(Produto produto);
    
    public List<Produto> buscar(int idUsuario);
    
    public void atualizarEstoque(String nomeProduto, int quantidade);
}
