/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufmt.poo.FarmEasy.services;

import java.util.List;
import br.ufmt.poo.FarmEasy.UI.DTOs.SiloDTO;

/**
 *
 * @author arthurmarques
 */
public interface SiloService {
    
    public void salvar(SiloDTO dto);
    
    public void remover(SiloDTO dto);
    
    public List <SiloDTO> listar(int idUsuario);
    
}
