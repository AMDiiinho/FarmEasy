/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.ufmt.poo.FarmEasy.services;

import java.util.*;
import br.ufmt.poo.FarmEasy.UI.DTOs.AbrigoDTO;

/**
 *
 * @author arthurmarques
 */
public interface AbrigoService {
    
    public void salvar(AbrigoDTO dto);
    
    public void remover(AbrigoDTO dto);
    
    public List<AbrigoDTO> listar(int usuarioId, String tipoAbrigo);
    
}
