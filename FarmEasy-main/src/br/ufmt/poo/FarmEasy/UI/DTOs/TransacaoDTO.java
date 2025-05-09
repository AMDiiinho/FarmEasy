/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufmt.poo.FarmEasy.UI.DTOs;

/**
 *
 * @author arthurmarques
 */
public class TransacaoDTO {

    String id;
    String usuarioId;
    String entradaSaida;
    String entidade;
    String tipoEntidade;
    String quantidade;
    String idArmazenamento;
    String data;
    
    public TransacaoDTO(String id, String usuarioId, String entradaSaida, String entidade,
           String tipoEntidade, String quantidade, String idArmazenamento, String data) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.entradaSaida = entradaSaida;
        this.entidade = entidade;
        this.tipoEntidade = tipoEntidade;
        this.quantidade = quantidade;
        this.idArmazenamento = idArmazenamento;
        this.data = data;
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

    public String getEntradaSaida() {
        return entradaSaida;
    }

    public void setEntradaSaida(String entradaSaida) {
        this.entradaSaida = entradaSaida;
    }

    public String getEntidade() {
        return entidade;
    }

    public void setEntidade(String entidade) {
        this.entidade = entidade;
    }

    public String getTipoEntidade() {
        return tipoEntidade;
    }

    public void setTipoEntidade(String tipoEntidade) {
        this.tipoEntidade = tipoEntidade;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getIdArmazenamento() {
        return idArmazenamento;
    }

    public void setIdArmazenamento(String idArmazenamento) {
        this.idArmazenamento = idArmazenamento;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
}
