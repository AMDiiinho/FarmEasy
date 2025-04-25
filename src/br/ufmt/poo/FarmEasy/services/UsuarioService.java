/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.ufmt.poo.FarmEasy.services;

import java.util.*;
import br.ufmt.poo.FarmEasy.UI.DTOs.UsuarioDTO;

/**
 *
 * @author arthurmarques
 */
public interface UsuarioService {
    
    public void salvar(UsuarioDTO dto);
    
    public void remover(UsuarioDTO dto);
    
    public List<UsuarioDTO> listar();
    
}
