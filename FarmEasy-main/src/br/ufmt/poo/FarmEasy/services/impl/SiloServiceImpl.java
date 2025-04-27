/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufmt.poo.FarmEasy.services.impl;

import java.util.List;
import br.ufmt.poo.FarmEasy.UI.DTOs.SiloDTO;
import br.ufmt.poo.FarmEasy.persistencias.SiloPersistencia;
import br.ufmt.poo.FarmEasy.persistencias.entidade.Silo;
import br.ufmt.poo.FarmEasy.persistencias.impl.SiloPersistenciaImpl;
import br.ufmt.poo.FarmEasy.services.SiloService;
import java.util.ArrayList;

/**
 *
 * @author arthurmarques
 */
public class SiloServiceImpl implements SiloService {
    
     @Override
    public void salvar(SiloDTO dto) {
        if(Integer.parseInt(dto.getCapacidade()) <= 0){
            throw new RuntimeException("O campo capacidade não pode ser menor ou igual a zero!"); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        } 
        
        int id = 0;
        int qtdProdutos = Integer.parseInt(dto.getQtdProdutos());
        int estoque = Integer.parseInt(dto.getCapacidade());
        
        if(!dto.getId().equals("")){
            
            id = Integer.parseInt(dto.getId());            
        }
        
        Silo silo = new Silo (id, qtdProdutos, estoque);
        
        SiloPersistencia persistencia = new SiloPersistenciaImpl();
        
        if(id == 0){
            persistencia.executar(silo);
        } else {
            persistencia.atualizar(silo);
        }
    }
        
    @Override
    public void remover(SiloDTO dto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<SiloDTO> listar() {
        
        SiloPersistencia persistencia = new SiloPersistenciaImpl();
        
        List<SiloDTO> lista = new ArrayList<>();
        List<Silo> silos = persistencia.buscar();
        for (Silo silo : silos) {
            String id = silo.getId() + "";
            String qtdProdutos = silo.getQtdProdutos() + "";
            String capacidade = silo.getCapacidade() + "";
            SiloDTO dto = new SiloDTO(id, qtdProdutos, capacidade);
            lista.add(dto);
            
        }
        
        return lista;    
    }
    
}
