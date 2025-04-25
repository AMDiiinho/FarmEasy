/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufmt.poo.FarmEasy.UI.DTOs;

/**
 *
 * @author arthurmarques
 */
public class GalinhaDTO {
    
    
    private String id;
    private String nome;
    private Double valorVenda;
    private String raca;
    
    
    public GalinhaDTO(String id, String nome, String raca, Double valorVenda) {
      
        this.id = id;
        this.nome = nome;
        this.valorVenda = valorVenda;
        this.raca = raca;
        
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
    
     public String getRaca() {
        return raca;
    }
    
    public void setRaca(String raca) {
        this.raca = raca;
    }
    
    public Double getValor() {
        return valorVenda;
    }
    
    public void setValor(Double valorVenda){
        this.valorVenda = valorVenda;
    }

}
