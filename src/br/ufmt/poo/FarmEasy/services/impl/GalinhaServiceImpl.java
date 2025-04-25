/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufmt.poo.FarmEasy.services.impl;

import java.util.List;
import br.ufmt.poo.FarmEasy.services.GalinhaService;
import br.ufmt.poo.FarmEasy.UI.DTOs.GalinhaDTO;

/**
 *
 * @author arthurmarques
 */
public class GalinhaServiceImpl implements GalinhaService {

    @Override
    public void salvar(GalinhaDTO dto) {
        if(dto.getNome().equals("")){
            throw new RuntimeException("O campo nome não pode estar vazio!"); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        } else if (dto.getRaca().equals("<Nenhum>")){
            throw new RuntimeException("Por favor forneça a raça da galinha!");
        }
    }
        
    @Override
    public void remover(GalinhaDTO dto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<GalinhaDTO> listar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

 
    
  
}
