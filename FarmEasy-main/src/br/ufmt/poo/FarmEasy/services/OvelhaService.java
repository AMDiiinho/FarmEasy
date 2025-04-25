/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.ufmt.poo.FarmEasy.services;

import java.util.*;
import br.ufmt.poo.FarmEasy.UI.DTOs.OvelhaDTO;

/**
 *
 * @author arthurmarques
 */
public interface OvelhaService {
    
    public void salvar(OvelhaDTO dto);
    
    public void remover(OvelhaDTO dto);
    
    public List <OvelhaDTO> listar();
    
}
