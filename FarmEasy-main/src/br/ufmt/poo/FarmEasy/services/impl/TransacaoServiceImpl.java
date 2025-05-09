/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufmt.poo.FarmEasy.services.impl;

import br.ufmt.poo.FarmEasy.UI.DTOs.TransacaoDTO;
import br.ufmt.poo.FarmEasy.persistencias.TransacaoPersistencia;
import br.ufmt.poo.FarmEasy.persistencias.entidade.Transacao;
import br.ufmt.poo.FarmEasy.persistencias.impl.TransacaoPersistenciaImpl;
import java.util.List;
import br.ufmt.poo.FarmEasy.services.TransacaoService;
import java.util.ArrayList;

/**
 *
 * @author arthurmarques
 */
public class TransacaoServiceImpl implements TransacaoService {

    @Override
    public List<TransacaoDTO> listar(int idUsuario) {
        
        TransacaoPersistencia persistencia = new TransacaoPersistenciaImpl();
        
        List<TransacaoDTO> lista = new ArrayList<>();
        List<Transacao> transacoes = persistencia.buscar(idUsuario);
        for (Transacao transacao : transacoes) {
            String id = transacao.getId() + "";
            String usuarioId = transacao.getUsuarioId() + "";
            String entradaSaida = transacao.getEntradaSaida();
            String entidade = transacao.getEntidade();
            String tipoEntidade = transacao.getTipoEntidade();
            String quantidade = transacao.getQuantidade() + "";
            String idArmazenamento = transacao.getIdArmazenamento() + "";
            String data = transacao.getData();
            TransacaoDTO dto = new TransacaoDTO(id, usuarioId, entradaSaida, entidade, tipoEntidade, quantidade,
                             idArmazenamento, data);
            lista.add(dto);
            
        }
        
        return lista;  
    }

    @Override
    public List<TransacaoDTO> listarFiltros(int idUsuario, List<String> filtros) {
        
        TransacaoPersistencia persistencia = new TransacaoPersistenciaImpl();
        
        List<TransacaoDTO> lista = new ArrayList<>();
        List<Transacao> transacoes = persistencia.buscarFiltros(idUsuario, filtros);
        for (Transacao transacao : transacoes) {
            String id = transacao.getId() + "";
            String usuarioId = transacao.getUsuarioId() + "";
            String entradaSaida = transacao.getEntradaSaida();
            String entidade = transacao.getEntidade();
            String tipoEntidade = transacao.getTipoEntidade();
            String quantidade = transacao.getQuantidade() + "";
            String idArmazenamento = transacao.getIdArmazenamento() + "";
            String data = transacao.getData();
            TransacaoDTO dto = new TransacaoDTO(id, usuarioId, entradaSaida, entidade, tipoEntidade, quantidade,
                             idArmazenamento, data);
            lista.add(dto);
            
        }
        
        return lista;      
    }

    
}
