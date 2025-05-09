/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufmt.poo.bancoDeBancas.persistencia.impl;

import br.ufmt.poo.bancoDeBancas.persistencia.PessoaPersistencia;
import br.ufmt.poo.bancoDeBancas.persistencia.entidade.Pessoa;
import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;

/**
 *
 * @author aluno
 */
public class PessoaPersistenciaImpl implements PessoaPersistencia {
    
    private BancoDeDados bd = new BancoDeDados();

    @Override
    public void inserir(Pessoa pessoa) {
        String sql = "INSERT INTO pessoa (nome, cpf) VALUES (?,?);";
        List parametros = new ArrayList();
        parametros.add(pessoa.getNome());
        parametros.add(pessoa.getCpf());
        bd.executar(sql, parametros);
    }

    @Override
    public void remover(int id) {
        String sql = "DELETE FROM pessoa WHERE id = ?;";
        List parametros = new ArrayList();
        parametros.add(id);
        bd.executar(sql, parametros);
    }

    @Override
    public void atualizar(Pessoa pessoa) {
        String sql = "UPDATE pessoa SET nome = ?, cpf = ? WHERE id = ?";
        List parametros = new ArrayList();
        parametros.add(pessoa.getNome());
        parametros.add(pessoa.getCpf());
        parametros.add(pessoa.getId());
        bd.executar(sql, parametros);
    }

    @Override
    public List<Pessoa> buscar() {
        List<Pessoa> lista = new ArrayList();
        String sql = "SELECT * FROM pessoa;";
        ResultSet rs = bd.executarQuery(sql);
        try {
            while(rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                Pessoa pessoa = new Pessoa(id, nome, cpf);
                lista.add(pessoa);
            }
        } catch (SQLException erro) {
            erro.printStackTrace();
            throw new RuntimeException("Não foi possível recuperar os dados do banco!");
        }
        return lista;
    }
    
}
