/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufmt.poo.FarmEasy.UI.DTOs;

/**
 *
 * @author arthurmarques
 */
public class OvelhaDTO {

    
    private String id;
    private String nome;
    private Double valorVenda;
    private String cor;
    
    public OvelhaDTO(String id, String nome, String cor, Double valorVenda) {
      
        this.id = id;
        this.nome = nome;
        this.valorVenda = valorVenda;
        this.cor = cor;
        
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(Double valorVenda) {
        this.valorVenda = valorVenda;
    }
    
    public String getCor() {
        return cor;
    }
    
    public void setCor(String cor){
        this.cor = cor;
    }

}
