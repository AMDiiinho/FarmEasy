/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufmt.poo.FarmEasy.persistencias.entidade;

/**
 *
 * @author arthurmarques
 */
public class Silo {
      
    private int id;
    private int usuarioId;
    private int qtdProdutos;
    private int capacidade;
    
    public Silo(int id, int usuarioId, int qtdProdutos, int capacidade) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.qtdProdutos = qtdProdutos;
        this.capacidade = capacidade;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.usuarioId = id;
    }
    
    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsarioId(int id) {
        this.id = id;
    }

    public int getQtdProdutos() {
        return qtdProdutos;
    }

    public void setQtdProdutos(int qtdProdutos) {
        this.qtdProdutos = qtdProdutos;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }
    
}
