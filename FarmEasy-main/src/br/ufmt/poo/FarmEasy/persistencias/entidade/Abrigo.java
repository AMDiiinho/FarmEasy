/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufmt.poo.FarmEasy.persistencias.entidade;

/**
 *
 * @author aluno
 */
public class Abrigo {

    
    private int id;
    private String tipo;
    private int qtdAnimais;
    private int capacidade;
    
    public Abrigo(int id, String tipo, int qtdAnimais, int capacidade) {
        this.id = id;
        this.tipo = tipo;
        this.qtdAnimais = qtdAnimais;
        this.capacidade = capacidade;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getQtdAnimais() {
        return qtdAnimais;
    }

    public void setQtdAnimais(int qtdAnimais) {
        this.qtdAnimais = qtdAnimais;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }
    
}
