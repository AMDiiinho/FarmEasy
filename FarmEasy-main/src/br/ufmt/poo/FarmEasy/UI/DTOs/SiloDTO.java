/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufmt.poo.FarmEasy.UI.DTOs;

/**
 *
 * @author arthurmarques
 */
public class SiloDTO {

    
    private String id;
    private String usuarioId;
    private String qtdProdutos;
    private String capacidade;
        
    public SiloDTO(String id, String usuarioId, String qtdProdutos, String capacidade) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.qtdProdutos = qtdProdutos;
        this.capacidade = capacidade;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = id;
    }
    
    public String getQtdProdutos() {
        return qtdProdutos;
    }

    public void setQtdProdutos(String qtdProdutos) {
        this.qtdProdutos = qtdProdutos;
    }

    public String getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(String capacidade) {
        this.capacidade = capacidade;
    }

    
}
