/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.ufmt.poo.bancoDeBancas.persistencia;

import br.ufmt.poo.bancoDeBancas.persistencia.entidade.Pessoa;
import java.util.List;

/**
 *
 * @author aluno
 */
public interface PessoaPersistencia {
    
    public void inserir(Pessoa pessoa);
    
    public void remover(int id);
    
    public void atualizar(Pessoa pessoa);
    
    public List<Pessoa> buscar();
    
}
