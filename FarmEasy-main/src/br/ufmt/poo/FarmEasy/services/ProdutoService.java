/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufmt.poo.FarmEasy.services;

import java.util.List;
import br.ufmt.poo.FarmEasy.UI.DTOs.ProdutoDTO;

/**
 *
 * @author arthurmarques
 */
public interface ProdutoService {
    
    public void salvar(ProdutoDTO dto);
    
    public void remover(ProdutoDTO dto);
    
    List <ProdutoDTO> listar();
    
}
