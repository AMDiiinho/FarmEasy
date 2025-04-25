/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufmt.poo.FarmEasy.services.impl;

import java.util.List;
import br.ufmt.poo.FarmEasy.services.OvelhaService;
import br.ufmt.poo.FarmEasy.UI.DTOs.OvelhaDTO;

/**
 *
 * @author arthurmarques
 */
public class OvelhaServiceImpl implements OvelhaService {

    @Override
    public void salvar(OvelhaDTO dto) {
        if(dto.getNome().equals("")){
            throw new RuntimeException("O campo nome não pode estar vazio!"); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        } else if (dto.getCor().equals("<Nenhum>")){
            throw new RuntimeException("Por favor forneça a cor da ovelha");
        }
    }
        
    @Override
    public void remover(OvelhaDTO dto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<OvelhaDTO> listar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

 
    
  
}
