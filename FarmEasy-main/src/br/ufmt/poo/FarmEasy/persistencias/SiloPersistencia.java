/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.ufmt.poo.FarmEasy.persistencias;

import br.ufmt.poo.FarmEasy.persistencias.entidade.Silo;
import java.util.List;

/**
 *
 * @author arthurmarques
 */
public interface SiloPersistencia {
    
    public void executar(Silo silo);
    
    public void remover(int id);
    
    public void atualizar(Silo silo);
    
    public List<Silo> buscar(int idUsuario);
    
    public String entradaSaidaEstoque(int idSilo, int qtdProdutos, String operacao);
    
}
