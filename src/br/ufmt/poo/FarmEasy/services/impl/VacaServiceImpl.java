/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufmt.poo.FarmEasy.services.impl;

import java.util.List;
import br.ufmt.poo.FarmEasy.services.VacaService;
import br.ufmt.poo.FarmEasy.UI.DTOs.VacaDTO;

/**
 *
 * @author arthurmarques
 */
public class VacaServiceImpl implements VacaService {

    @Override
    public void salvar(VacaDTO dto) {
        if(dto.getNome().equals("")){
            throw new RuntimeException("O campo nome não pode estar vazio!"); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        } else if (dto.getRaca().equals("<Nenhum>")){
            throw new RuntimeException("Por favor forneça a raça da vaca!");
        }
    }
        
    @Override
    public void remover(VacaDTO dto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<VacaDTO> listar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

 
    
  
}
