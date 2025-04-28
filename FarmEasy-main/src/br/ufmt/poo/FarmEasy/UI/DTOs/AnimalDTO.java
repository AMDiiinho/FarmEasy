/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufmt.poo.FarmEasy.UI.DTOs;

/**
 *
 * @author arthurmarques
 */
public class AnimalDTO {
    
    private String id;
    private String tipo;
    private String raca;
    private String quantidade;
    private String valor;
    
    public AnimalDTO(String id, String tipo, String raca, String quantidade, String valor){
        
        this.id = id;
        this.tipo = tipo;
        this.raca = raca;
        this.quantidade = quantidade;
        this.valor = valor;
        
    }
    
    public String getId(){
        return id;
    }
    
    public void setId(String id){
        this.id = id;
    }
    
    public String getTipo(){
        return tipo;
    }
    
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    
    public String getRaca(){
        return raca;
    }
    
    public void setRaca(String raca){
        this.raca = raca;
    }
    
    public String getQuantidade(){
        return quantidade;
    }
    
    public void setQuantidade(String quantidade){
        this.quantidade = quantidade;
    }
    
    public String getValor(){
        return valor;
    }
    
    public void setValor(String valor){
        this.valor = valor;
    }
    
    
    
    
    
    
}
