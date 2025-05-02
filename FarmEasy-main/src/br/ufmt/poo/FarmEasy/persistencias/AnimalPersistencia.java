/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.ufmt.poo.FarmEasy.persistencias;

import br.ufmt.poo.FarmEasy.persistencias.entidade.Animal;
import java.util.List;

/**
 *
 * @author arthurmarques
 */
public interface AnimalPersistencia {
    
    public void executar(Animal animal);
    
    public void remover(int id);
    
    public void atualizar(Animal animal);
    
    public List<Animal> buscar(String tipoAnimal);
    
    public void atualizarQtdAnimais(String racaAnimal, int quantidade);
    
}
