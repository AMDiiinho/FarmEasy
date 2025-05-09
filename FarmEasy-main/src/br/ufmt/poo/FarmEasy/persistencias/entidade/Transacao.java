/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufmt.poo.FarmEasy.persistencias.entidade;

/**
 *
 * @author arthurmarques
 */
public class Transacao {
    
    int id;
    int usuarioId;
    String entradaSaida;
    String entidade;
    String tipoEntidade;
    int quantidade;
    int idArmazenamento;
    String data;
    
    public Transacao(int id, int usuarioId, String entradaSaida, String entidade, String tipoEntidade, 
           int quantidade, int idArmazenamento, String data) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.entradaSaida = entradaSaida;
        this.entidade = entidade;
        this.tipoEntidade = tipoEntidade;
        this.quantidade = quantidade;
        this.idArmazenamento = idArmazenamento;
        this.data = data;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
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

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getIdArmazenamento() {
        return idArmazenamento;
    }

    public void setIdArmazenamento(int idArmazenamento) {
        this.idArmazenamento = idArmazenamento;
    }

    public String getData() {
        return data;
    }

    public void setDataHora(String data) {
        this.data = data;
    }
    
}
