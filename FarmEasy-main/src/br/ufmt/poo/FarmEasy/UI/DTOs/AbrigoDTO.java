/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufmt.poo.FarmEasy.UI.DTOs;

/**
 *
 * @author arthurmarques
 */
public class AbrigoDTO {

    
    private String id;
    private String usuarioId;
    private String tipo;
    private String qtdAnimais;
    private String capacidade;
    

    public AbrigoDTO(String id, String usuarioId, String tipo, String qtdAnimais, String capacidade) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.tipo = tipo;
        this.qtdAnimais = qtdAnimais;
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
        this.usuarioId = usuarioId;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getQtdAnimais() {
        return qtdAnimais;
    }

    public void setQtdAnimais(String qtdAnimais) {
        this.qtdAnimais = qtdAnimais;
    }

    public String getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(String capacidade) {
        this.capacidade = capacidade;
    }
    
}
