/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufmt.poo.FarmEasy.services.impl;

import java.util.List;
import br.ufmt.poo.FarmEasy.services.PorcoService;
import br.ufmt.poo.FarmEasy.UI.DTOs.PorcoDTO;

/**
 *
 * @author arthurmarques
 */
public class PorcoServiceImpl implements PorcoService {

    @Override
    public void salvar(PorcoDTO dto) {
        if(dto.getNome().equals("")){
            throw new RuntimeException("O campo nome não pode estar vazio!"); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        } else if (dto.getRaca().equals("<Nenhum>")){
            throw new RuntimeException("Por favor, selecione a raça do porco!");
        }
    }
        
    @Override
    public void remover(PorcoDTO dto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<PorcoDTO> listar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

 
    
  
}
