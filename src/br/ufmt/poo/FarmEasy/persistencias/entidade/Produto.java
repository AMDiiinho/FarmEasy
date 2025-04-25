/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufmt.poo.FarmEasy.persistencias.entidade;

/**
 *
 * @author arthurmarques
 */
public class Produto {

      
    private int id;
    private String nome;
    private int estoque;
    private double valor;
   
    
    
    public Produto(int id, String nome, int estoque, double valor) {
        this.id = id;
        this.nome = nome;
        this.estoque = estoque;
        this.valor = valor;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
