/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/AnnotationType.java to edit this template
 */
package main;

/**
 *
 * @author arthurmarques
 */
public @interface Anotações {
    /*
        TABELAS
        
    
        CREATE TABLE tb_abrigos (
            id SERIAL PRIMARY KEY,
            usuarioId int NOT NULL,
            tipo varchar(30),
            qtdAnimais int DEFAULT 0,
            capacidade int NOT NULL
        );
    
        CREATE TABLE tb_animais (
            id SERIAL PRIMARY KEY,
            usuarioId int NOT NULL,
            tipo varchar(30),
            raca varchar(30),
            quantidade int DEFAULT 0,
            valor float NOT NULL
        );
        
        CREATE TABLE tb_produtos (
            id SERIAL PRIMARY KEY,
            usuarioId int NOT NULL,
            nome varchar(40),
            estoque int DEFAULT 0,
            valor float NOT NULL
        );
        
    
        CREATE TABLE tb_silos(
            id SERIAL PRIMARY KEY,
            usuarioId int NOT NULL,
            qtdProdutos int DEFAULT 0,
            capacidade int NOT NULL    
        );
        
        CREATE TABLE tb_usuarios(
            id SERIAL PRIMARY KEY,
            nome varchar(40),
            telefone varchar(14),
            cpf varchar(14),
            usuario varchar(40),
            senha varchar(20),
        );
    
    
        CREATE TABLE tb_historico_transacoes (
            id SERIAL PRIMARY KEY,
            idUsuario int NOT NULL,
            entrada_saida varchar(7) NOT NULL,
            entidade varchar(7) NOT NULL,
            tipo_entidade varchar(40) NOT NULL,
            quantidade int NOT NULL,
            id_armazenamento int NOT NULL,
            data DATE DEFAULT CURRENT_DATE 
        );
    
    
    
        
        
    */
}
