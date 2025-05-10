/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufmt.poo.FarmEasy.persistencias;

import br.ufmt.poo.FarmEasy.persistencias.entidade.Abrigo;
import java.util.List;

/**
 *
 * @author aluno
 */
public interface AbrigoPersistencia {
    
    public void inserir(Abrigo abrigo);
    
    public void remover(int id);
    
    public void atualizar(Abrigo abrigo);
    
    public List<Abrigo> buscar(int idUsuario, String tipoAbrigo);
    
    public String entradaSaidaAnimais(int idAbrigo, int qtdAnimais, String operacao);
    
}
