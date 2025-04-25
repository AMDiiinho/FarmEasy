/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.ufmt.poo.FarmEasy.services;

import java.util.*;
import br.ufmt.poo.FarmEasy.UI.DTOs.PorcoDTO;

/**
 *
 * @author arthurmarques
 */
public interface PorcoService {
    
    public void salvar(PorcoDTO dto);
    
    public void remover(PorcoDTO dto);
    
    public List <PorcoDTO> listar();
    
}
