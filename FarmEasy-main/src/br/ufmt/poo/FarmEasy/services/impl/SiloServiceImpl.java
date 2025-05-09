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
        int usuarioId = 0;
        int qtdProdutos = Integer.parseInt(dto.getQtdProdutos());
        int estoque = Integer.parseInt(dto.getCapacidade());
        
        if(!dto.getId().equals("")){
            
            id = Integer.parseInt(dto.getId());            
        }
        
        if(!dto.getUsuarioId().equals("")){
            usuarioId = Integer.parseInt(dto.getUsuarioId());
        }            
        Silo silo = new Silo (id, usuarioId, qtdProdutos, estoque);
        
        SiloPersistencia persistencia = new SiloPersistenciaImpl();
        
        if(id == 0){
            persistencia.executar(silo);
        } else {
            persistencia.atualizar(silo);
        }
    }
        
    @Override
    public void remover(SiloDTO dto) {
        SiloPersistencia persistencia = new SiloPersistenciaImpl();
        int id = Integer.parseInt(dto.getId());
        persistencia.remover(id);    
    }

    @Override
    public List<SiloDTO> listar(int idUsuario) {
        
        SiloPersistencia persistencia = new SiloPersistenciaImpl();
        
        List<SiloDTO> lista = new ArrayList<>();
        List<Silo> silos = persistencia.buscar(idUsuario);
        for (Silo silo : silos) {
            String id = silo.getId() + "";
            String usuarioId = silo.getUsuarioId() + "";
            String qtdProdutos = silo.getQtdProdutos() + "";
            String capacidade = silo.getCapacidade() + "";
            SiloDTO dto = new SiloDTO(id, usuarioId, qtdProdutos, capacidade);
            lista.add(dto);
            
        }
        
        return lista;    
    }
    
}
