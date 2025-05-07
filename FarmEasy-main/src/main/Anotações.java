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
            entrada_saida VARCHAR(7) NOT NULL,
            entidade VARCHAR(7) NOT NULL,
            tipo_entidade VARCHAR(40) NOT NULL,
            quantidade INT NOT NULL,
            id_armazenamento INT NOT NULL,
            data_hora TIMESTAMP DEFAULT CURRENT_TIMESTAMP 
        );
    

    
    String sqlHistTransacao = "INSERT INTO log_transacoes (idUsuario, entrada_saida, entidade, tipo_entidade, quantidade,"
    + " id_armazenamento) VALUES ('entrada', '" + tipoAnimal + "', '"
    + racaAnimal + "', '" + qtdAnimais + "', '" + idAbrigo + "');";
    bd.executarQuery(sqlLogTransacao);
        
    CREATE TRIGGER trg_historico_transacoes
    AFTER UPDATE ON tb_animais
    FOR EACH ROW
       
        new.usuarioId
        new.tipo
        new.raca
        new.quantidade
        new.valor

        INSERT INTO tb_historico_transacoes (
            usuarioId, entrada_saida, entidade, tipo_entidade, id_armazenamento, quantidade
        ) VALUES (
            'new.usuarioId', 'new.tipo', 'new.raca', 'new.quantidade','0' 'new.valor'
        );

    */
}
