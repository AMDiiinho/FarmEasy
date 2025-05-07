/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.ufmt.poo.FarmEasy.services;

import br.ufmt.poo.FarmEasy.UI.DTOs.AnimalDTO;
import java.util.List;

/**
 *
 * @author arthurmarques
 */
public interface AnimalService {
    
    public void salvar(AnimalDTO dto);
    
    public void remover(AnimalDTO dto);
    
    public List<AnimalDTO> listar(int usuarioId, String tipoAnimal);
    
}
