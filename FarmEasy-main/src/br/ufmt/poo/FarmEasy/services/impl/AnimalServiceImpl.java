/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufmt.poo.FarmEasy.services.impl;

import br.ufmt.poo.FarmEasy.UI.DTOs.AnimalDTO;
import br.ufmt.poo.FarmEasy.persistencias.AnimalPersistencia;
import br.ufmt.poo.FarmEasy.persistencias.entidade.Animal;
import br.ufmt.poo.FarmEasy.persistencias.impl.AnimalPersistenciaImpl;
import br.ufmt.poo.FarmEasy.services.AnimalService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author arthurmarques
 */
public class AnimalServiceImpl implements AnimalService {

    @Override
    public void salvar(AnimalDTO dto) {
        
        if(dto.getRaca().equals("")){
            throw new RuntimeException("O campo nome da raça não pode ser vazio!");        
        } else if(dto.getValor().equals("") || Double.parseDouble(dto.getValor()) <= 0){ 
            
            throw new RuntimeException("O campo valor não pode ser vazio e nem menor ou igual a zero!");        
              
        } else { 
            int id = 0;
            int usuarioId = 0;
            int quantidade = Integer.parseInt(dto.getQuantidade());
            double valor = Double.parseDouble(dto.getValor());

            if(!dto.getId().equals("")){

                id = Integer.parseInt(dto.getId());            
            }
            
            if(!dto.getUsuarioId().equals("")){

                usuarioId = Integer.parseInt(dto.getUsuarioId());            
            }

            Animal animal = new Animal (id, usuarioId, dto.getTipo(), dto.getRaca(), quantidade, valor);

            AnimalPersistencia persistencia = new AnimalPersistenciaImpl();

            if(id == 0){
                persistencia.executar(animal);
            } else {
                persistencia.atualizar(animal);
            }    
        }
    }

    @Override
    public void remover(AnimalDTO dto) {
        AnimalPersistencia persistencia = new AnimalPersistenciaImpl();
        int id = Integer.parseInt(dto.getId());
        persistencia.remover(id);     
    }

    @Override
    public List<AnimalDTO> listar(int idUsuario, String tipoAnimal) {
        
        AnimalPersistencia persistencia = new AnimalPersistenciaImpl();
        
        List<AnimalDTO> lista = new ArrayList<>();
        List<Animal> animais = persistencia.buscar(idUsuario, tipoAnimal);
        for (Animal animal : animais) {
            
            String id = animal.getId() + "";
            String usuarioId = animal.getUsuarioId() + "";
            String tipo = animal.getTipo();
            String raca = animal.getRaca();
            String quantidade = animal.getQuantidade() + "";
            String valor = animal.getValor() + "";
            AnimalDTO dto = new AnimalDTO(id, usuarioId, tipo, raca, quantidade, valor);
            lista.add(dto);
            
            
        }
        
        return lista;    
    }
    
    
    
}
