/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufmt.poo.FarmEasy.persistencias.entidade;

/**
 *
 * @author arthurmarques
 */
public class Animal {
    
    private int id;
    private int usuarioId;
    private String tipo;
    private String raca;
    private int quantidade;
    private double valor;
    
    public Animal(int id, int usuarioId, String tipo, String raca, int quantidade, double valor){
        
        this.id = id;
        this.usuarioId = usuarioId;
        this.tipo = tipo;
        this.raca = raca;
        this.quantidade = quantidade;
        this.valor = valor;
        
    }
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public int getUsuarioId(){
        return usuarioId;
    }
    
    public void setUsuarioId(int usuarioId){
        this.usuarioId = usuarioId;
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
    
    public int getQuantidade(){
        return quantidade;
    }
    
    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }
    
    public double getValor(){
        return valor;
    }
    
    public void setValor(double valor){
        this.valor = valor;
    }
    
}
