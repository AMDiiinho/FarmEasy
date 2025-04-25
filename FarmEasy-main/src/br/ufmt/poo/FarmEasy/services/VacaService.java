/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.ufmt.poo.FarmEasy.services;

import java.util.*;
import br.ufmt.poo.FarmEasy.UI.DTOs.VacaDTO;

/**
 *
 * @author arthurmarques
 */
public interface VacaService {
    
    public void salvar(VacaDTO dto);
    
    public void remover(VacaDTO dto);
    
    public List <VacaDTO> listar();
    
}
