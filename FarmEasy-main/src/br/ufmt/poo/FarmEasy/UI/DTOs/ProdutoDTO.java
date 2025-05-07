/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufmt.poo.FarmEasy.UI.DTOs;

/**
 *
 * @author arthurmarques
 */
public class ProdutoDTO {

    
    private String id;
    private String usuarioId;
    private String nome;
    private String estoque;
    private String valor;
    
    
    public ProdutoDTO(String id, String usuarioId, String nome, String estoque, String valor) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.nome = nome;
        this.estoque = estoque;
        this.valor = valor;
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
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getEstoque(){
        return estoque;
    }
    
    public void setEstoque(String estoque){
        this.estoque = estoque;
    }
    
    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
    
}
