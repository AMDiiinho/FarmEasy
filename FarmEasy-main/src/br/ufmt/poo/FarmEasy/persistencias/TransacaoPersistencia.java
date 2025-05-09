/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufmt.poo.FarmEasy.persistencias;

import br.ufmt.poo.FarmEasy.persistencias.entidade.Transacao;
import java.util.List;

/**
 *
 * @author arthurmarques
 */
public interface TransacaoPersistencia {
    
    public void remover(int id);
        
    public List<Transacao> buscar(int idUsuario);
    
    public List<Transacao> buscarFiltros(int idUsuario, List<String> filtros);
    
}
