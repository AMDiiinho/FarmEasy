/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.ufmt.poo.FarmEasy.services;

import java.util.*;
import br.ufmt.poo.FarmEasy.UI.DTOs.GalinhaDTO;


/**
 *
 * @author arthurmarques
 */
public interface GalinhaService {
    
    public void salvar(GalinhaDTO dto);
    
    public void remover(GalinhaDTO dto);
    
    public List <GalinhaDTO> listar();
    
}
