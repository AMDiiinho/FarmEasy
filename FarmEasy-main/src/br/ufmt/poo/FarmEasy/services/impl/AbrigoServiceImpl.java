/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufmt.poo.FarmEasy.services.impl;


import br.ufmt.poo.FarmEasy.persistencias.AbrigoPersistencia;
import br.ufmt.poo.FarmEasy.persistencias.entidade.Abrigo;
import br.ufmt.poo.FarmEasy.persistencias.impl.AbrigoPersistenciaImpl;
import java.util.List;
import br.ufmt.poo.FarmEasy.services.AbrigoService;
import java.util.ArrayList;
import br.ufmt.poo.FarmEasy.UI.DTOs.AbrigoDTO;

/**
 *
 * @author arthurmarques
 */

public class AbrigoServiceImpl implements AbrigoService {

    @Override
    public void salvar(AbrigoDTO dto) {
        if(Integer.parseInt(dto.getCapacidade()) <= 0){
            throw new RuntimeException("O campo capacidade não pode ser menor ou igual a zero!"); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
        
        int id = 0;
        int capacidade = Integer.parseInt(dto.getCapacidade());
        
        if(!dto.getId().equals("")){
            
            id = Integer.parseInt(dto.getId());            
        }
        
        Abrigo abrigo = new Abrigo (id, dto.getTipo(), capacidade);
        
        AbrigoPersistencia persistencia = new AbrigoPersistenciaImpl();
        
        if(id == 0){
            persistencia.executar(abrigo);
        } else {
            persistencia.atualizar(abrigo);
        }
    }

    @Override
    public void remover(AbrigoDTO dto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<AbrigoDTO> listar(String tipoAbrigo) {
        
        AbrigoPersistencia persistencia = new AbrigoPersistenciaImpl();
        
        List<AbrigoDTO> lista = new ArrayList<>();
        List<Abrigo> abrigos = persistencia.buscar(tipoAbrigo);
        for (Abrigo abrigo : abrigos) {
            String id = abrigo.getId() + "";
            String tipo = abrigo.getTipo();
            String capacidade = abrigo.getCapacidade() + "";
            AbrigoDTO dto = new AbrigoDTO(id, tipo, capacidade);
            lista.add(dto);
            
            
        }
        
        return lista;
    }        
    
}

    

