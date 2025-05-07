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
            throw new RuntimeException("O campo capacidade não pode ser menor ou igual a zero!"); 
        }
        
        int id = 0;
        int usuarioId = 0;
        int qtdAnimais = Integer.parseInt(dto.getQtdAnimais());
        int capacidade = Integer.parseInt(dto.getCapacidade());
        
        if(!dto.getId().equals("")){
            
            id = Integer.parseInt(dto.getId());            
        }
        
        if(!dto.getUsuarioId().equals("")){
            
            usuarioId = Integer.parseInt(dto.getUsuarioId());            
        }
        
        Abrigo abrigo = new Abrigo (id, usuarioId, dto.getTipo(), qtdAnimais, capacidade);
        
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
    public List<AbrigoDTO> listar(int idUsuario, String tipoAbrigo) {
        
        AbrigoPersistencia persistencia = new AbrigoPersistenciaImpl();
        
        List<AbrigoDTO> lista = new ArrayList<>();
        List<Abrigo> abrigos = persistencia.buscar(idUsuario, tipoAbrigo);
        for (Abrigo abrigo : abrigos) {
            String id = abrigo.getId() + "";
            String usuarioId = abrigo.getUsuarioId() + "";
            String tipo = abrigo.getTipo();
            String qtdAnimais = abrigo.getQtdAnimais() + "";
            String capacidade = abrigo.getCapacidade() + "";
            AbrigoDTO dto = new AbrigoDTO(id, usuarioId, tipo, qtdAnimais, capacidade);
            lista.add(dto);
            
            
        }
        
        return lista;
    }        
    
}

    

