/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufmt.poo.FarmEasy.services;

import br.ufmt.poo.FarmEasy.UI.DTOs.TransacaoDTO;
import java.util.List;

/**
 *
 * @author arthurmarques
 */
public interface TransacaoService {
       
    public List <TransacaoDTO> listar(int idUsuario);
    
    public List <TransacaoDTO> listarFiltros(int idUsuario, List<String> filtros);
    
}
