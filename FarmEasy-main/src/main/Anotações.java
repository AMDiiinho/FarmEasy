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
            senha varchar(20)
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


        TRIGGERS E FUNCTIONS ANIMAIS/ABRIGOS
    
        CREATE OR REPLACE FUNCTION atualiza_qtd_animais()
        RETURNS TRIGGER AS $$
        DECLARE
            registro RECORD;
        BEGIN    
            UPDATE tb_animais t1
            SET quantidade = t1.quantidade - COALESCE((
                SELECT SUM(quantidade)
                FROM tb_historico_transacoes
                WHERE id_armazenamento = OLD.id 
                AND tipo_entidade = t1.raca 
                AND entrada_saida = 'entrada'), 0)
            + COALESCE((
                SELECT SUM(quantidade)
                FROM tb_historico_transacoes
                WHERE id_armazenamento = OLD.id
                AND tipo_entidade = t1.raca
                AND entrada_saida = 'saida'), 0);

            RETURN NEW;
        END;
        $$ LANGUAGE plpgsql;

        CREATE TRIGGER trg_atualiza_quantidade
        AFTER DELETE ON tb_abrigos        
        FOR EACH ROW       
        EXECUTE FUNCTION atualiza_qtd_animais();

        CREATE OR REPLACE FUNCTION atualiza_tb_abrigos()
        RETURNS TRIGGER AS $$
        BEGIN
    
            UPDATE tb_abrigos
            SET qtdAnimais = GREATEST(tb_abrigos.qtdAnimais - tb_animais.quantidade, 0)
            FROM tb_animais
            WHERE tb_animais.raca = OLD.raca;

            RETURN OLD;
        END;
        $$ LANGUAGE plpgsql;

        CREATE TRIGGER trg_atualiza_abrigos
        BEFORE DELETE ON tb_animais
        FOR EACH ROW
        EXECUTE FUNCTION atualiza_tb_abrigos();
    
        CREATE OR REPLACE FUNCTION registra_saida_animais_por_exclusao_de_abrigo()
        RETURNS TRIGGER AS $$
        DECLARE 
            registro RECORD;
        BEGIN
            FOR registro IN (
                SELECT idusuario, entidade, tipo_entidade, SUM(quantidade) as quantidade_somada, id_armazenamento
                FROM tb_historico_transacoes
                WHERE id_armazenamento = OLD.id AND entrada_saida = 'entrada'
                GROUP BY idusuario, entidade, tipo_entidade, id_armazenamento
            ) LOOP
                INSERT INTO tb_historico_transacoes(
                    idUsuario, 
                    entrada_saida, 
                    entidade, 
                    tipo_entidade, 
                    quantidade,
                    id_armazenamento                
                )
                VALUES (
                    registro.idUsuario,
                    'saida',
                    registro.entidade,
                    registro.tipo_entidade,
                    registro.quantidade_somada - COALESCE((
                        SELECT SUM(quantidade)
                        FROM tb_historico_transacoes
                        WHERE id_armazenamento = OLD.id
                        AND entrada_saida = 'saida'), 0),
                    registro.id_armazenamento
                );
            END LOOP;
            RETURN NEW;
        END;
        $$ LANGUAGE plpgsql;
    
        CREATE TRIGGER trg_registra_saida_ao_deletar_abrigo
        AFTER DELETE ON tb_abrigos
        FOR EACH ROW
        EXECUTE FUNCTION registra_saida_animais_por_exclusao_de_abrigo();
        
    
        CREATE OR REPLACE FUNCTION registra_saida_animais_por_exclusao_raca()
        RETURNS TRIGGER AS $$
        DECLARE 
            registro RECORD;
        BEGIN

            FOR registro IN (
                SELECT usuarioid, tipo, raca, quantidade
                FROM tb_animais
                WHERE raca = OLD.raca
            ) LOOP
                INSERT INTO tb_historico_transacoes(idUsuario, entrada_saida, 
                    entidade, tipo_entidade, 
                    quantidade, id_armazenamento                
                )
                VALUES (
                    registro.usuarioid, 'saida',
                    registro.tipo, registro.raca,
                    registro.quantidade, '0'
                );
            END LOOP;
            RETURN OLD;
        END;
        $$ LANGUAGE plpgsql;

        CREATE TRIGGER trg_registra_saida_animais_ao_deletar_raca
        BEFORE DELETE ON tb_animais
        FOR EACH ROW
        EXECUTE FUNCTION registra_saida_animais_por_exclusao_raca();
    
    
        CREATE OR REPLACE FUNCTION registra_saida_animais_por_exclusao_raca()
        RETURNS TRIGGER AS $$
        DECLARE 
            abrigo RECORD;
        BEGIN
            FOR abrigo IN (
                SELECT 
                    h.entidade,
                    h.tipo_entidade,
                    SUM(h.quantidade) as quantidade_total,
                    h.id_armazenamento
                FROM tb_historico_transacoes h
                WHERE h.tipo_entidade = OLD.raca
                AND h.entrada_saida = 'entrada'
                GROUP BY h.id_armazenamento, h.entidade, h.tipo_entidade
            ) LOOP
                -- Insere um registro de saída para cada abrigo
                INSERT INTO tb_historico_transacoes(
                    entrada_saida, 
                    entidade, 
                    tipo_entidade, 
                    quantidade,
                    id_armazenamento                
                )
                VALUES (
                    'saida',
                    abrigo.entidade,
                    abrigo.tipo_entidade,
                    abrigo.quantidade_total,
                    abrigo.id_armazenamento
                );
            END LOOP;

            RETURN OLD;
        END;
        $$ LANGUAGE plpgsql;
        
    

    
    
    
    
    
    
        
    
        TRIGGERS E FUNCTIONS PRODUTOS/SILOS
    
        CREATE OR REPLACE FUNCTION atualiza_estoque_produtos_ao_deletar_silo()
        RETURNS TRIGGER AS $$
        DECLARE
            registro RECORD;
        BEGIN
            UPDATE tb_produtos t1
            SET estoque = t1.estoque - COALESCE((
            SELECT SUM(quantidade)
            FROM tb_historico_transacoes
            WHERE id_armazenamento = OLD.id 
            AND tipo_entidade = t1.nome 
            AND entrada_saida = 'entrada'), 0)
            + COALESCE((   
            SELECT SUM(quantidade)
            FROM tb_historico_transacoes
            WHERE id_armazenamento = OLD.id
            AND tipo_entidade = t1.nome
            AND entrada_saida = 'saida'), 0);
        RETURN NEW;
        END;
        $$ LANGUAGE plpgsql;
            
        CREATE TRIGGER trg_atualiza_estoque
        AFTER DELETE ON tb_silos        
        FOR EACH ROW       
        EXECUTE FUNCTION atualiza_estoque_produtos_ao_deletar_silo();


    
        CREATE OR REPLACE FUNCTION registra_saida_produtos_por_exclusao_silo()
        RETURNS TRIGGER AS $$
        DECLARE 
            registro RECORD;
        BEGIN

            FOR registro IN (
                SELECT idusuario, entidade, tipo_entidade, SUM(quantidade) as quantidade_somada, id_armazenamento
                FROM tb_historico_transacoes
                WHERE id_armazenamento = OLD.id AND entrada_saida = 'entrada'
                GROUP BY idusuario, entidade, tipo_entidade, id_armazenamento
            ) LOOP
                INSERT INTO tb_historico_transacoes(
                    idUsuario, 
                    entrada_saida, 
                    entidade, 
                    tipo_entidade, 
                    quantidade,
                    id_armazenamento                
                )
                VALUES (
                    registro.idusuario,
                    'saida',
                    'Produto',
                    registro.tipo_entidade,
                    registro.quantidade_somada - COALESCE((   
                    SELECT SUM(quantidade)
                    FROM tb_historico_transacoes
                    WHERE id_armazenamento = OLD.id
                    AND entrada_saida = 'saida'), 0),
                    '0'
                );
            END LOOP;
            RETURN NEW;
        END;
        $$ LANGUAGE plpgsql;
                
        CREATE TRIGGER trg_registra_saida_produtos_ao_deletar_silo
        AFTER DELETE ON tb_silos
        FOR EACH ROW
        EXECUTE FUNCTION registra_saida_produtos_por_exclusao_silo();

    
        
    
    
        CREATE OR REPLACE FUNCTION atualiza_tb_silos_exclusao_tipo_produto()
        RETURNS TRIGGER AS $$
        BEGIN
    
            UPDATE tb_silos
            SET qtdProdutos = GREATEST(tb_silos.qtdProdutos - tb_produtos.estoque, 0)
            FROM tb_produtos
            WHERE tb_produtos.nome = OLD.nome;
   
    

            RETURN OLD;
        END;
        $$ LANGUAGE plpgsql;

        CREATE TRIGGER trg_atualiza_silos_ao_excluir_produto
        BEFORE DELETE ON tb_produtos
        FOR EACH ROW
        EXECUTE FUNCTION atualiza_tb_silos_exclusao_tipo_produto();
        
        
    
        
        
        CREATE OR REPLACE FUNCTION registra_saida_produtos_por_exclusao_de_produto()
        RETURNS TRIGGER AS $$
        DECLARE 
            abrigo RECORD;
        BEGIN
            FOR abrigo IN (
                SELECT 
                    h.idUsuario,
                    h.tipo_entidade,
                    SUM(h.quantidade) as quantidade_total,
                    h.id_armazenamento
                FROM tb_historico_transacoes h
                WHERE h.tipo_entidade = OLD.nome
                AND h.entidade = 'Produto'
                AND h.entrada_saida = 'entrada'
                GROUP BY h.id_armazenamento, h.idUsuario, h.tipo_entidade
            ) LOOP
                -- Insere um registro de saída para cada abrigo
                INSERT INTO tb_historico_transacoes(
                    idUsuario, 
                    entrada_saida, 
                    entidade, 
                    tipo_entidade, 
                    quantidade,
                    id_armazenamento                
                )
                VALUES (
                    abrigo.idUsuario,
                    'saida',
                    'Produto',
                    abrigo.tipo_entidade,
                    abrigo.quantidade_total,
                    abrigo.id_armazenamento
                );
            END LOOP;

            RETURN OLD;
        END;
        $$ LANGUAGE plpgsql;
    
        CREATE TRIGGER trg_registra_saida_ao_deletar_silo
        BEFORE DELETE ON tb_produtos
        FOR EACH ROW
        EXECUTE FUNCTION registra_saida_produtos_por_exclusao_de_produto();
        
 

    */
}
