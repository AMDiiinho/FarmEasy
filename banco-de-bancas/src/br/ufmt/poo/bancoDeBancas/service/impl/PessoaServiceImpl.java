/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufmt.poo.bancoDeBancas.service.impl;

import br.ufmt.poo.bancoDeBancas.persistencia.PessoaPersistencia;
import br.ufmt.poo.bancoDeBancas.persistencia.entidade.Pessoa;
import br.ufmt.poo.bancoDeBancas.persistencia.impl.PessoaPersistenciaImpl;
import br.ufmt.poo.bancoDeBancas.service.PessoaService;
import br.ufmt.poo.bancoDeBancas.ui.dto.PessoaDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aluno
 */
public class PessoaServiceImpl implements PessoaService {

    @Override
    public void salvar(PessoaDTO dto) {
        if(dto.getNome().equals("")){
            throw new RuntimeException("Nome é obrigatório!");
        }
        int id = 0;
        
        if (!dto.getId().equals("")) {
            id = Integer.parseInt(dto.getId());
        }
        
        Pessoa pessoa = new Pessoa(id, dto.getNome(), dto.getCpf());
        
        PessoaPersistencia persistencia = new PessoaPersistenciaImpl();
        
        if (id == 0) {
            persistencia.inserir(pessoa);
        } else {
            persistencia.atualizar(pessoa);
        }
    }

    @Override
    public void remover(PessoaDTO dto) {
        PessoaPersistencia persistencia = new PessoaPersistenciaImpl();
        int id = Integer.parseInt(dto.getId());
        persistencia.remover(id);
    }

    @Override
    public List<PessoaDTO> listar() {
        PessoaPersistencia persistencia = new PessoaPersistenciaImpl();
        List<PessoaDTO> lista = new ArrayList<>();
        List<Pessoa> pessoas = persistencia.buscar();
        for (Pessoa pessoa : pessoas) {
            String id = Integer.toString(pessoa.getId());
            String nome = pessoa.getNome();
            String cpf = pessoa.getCpf();
            PessoaDTO dto = new PessoaDTO(id, nome, cpf);
            lista.add(dto);
        }
        return lista;
    }
    
}
