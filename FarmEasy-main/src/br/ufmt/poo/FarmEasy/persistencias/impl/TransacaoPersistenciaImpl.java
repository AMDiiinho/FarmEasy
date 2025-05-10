/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufmt.poo.FarmEasy.persistencias.impl;

import br.ufmt.poo.FarmEasy.persistencias.TransacaoPersistencia;
import br.ufmt.poo.FarmEasy.persistencias.entidade.Transacao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

/**
 *
 * @author arthurmarques
 */
public class TransacaoPersistenciaImpl implements TransacaoPersistencia {

    @Override
    public void remover(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Transacao> buscar(int idUsuario) {
        
        BancoDeDados bd = new BancoDeDados();               
        
        List<Transacao> lista = new ArrayList();
        String sql = "SELECT * FROM tb_historico_transacoes WHERE idUsuario = '" + idUsuario + "';";
        ResultSet rs = bd.executarQuery(sql);
        
        
        
        try{
            while(rs.next()){
                
                int id = rs.getInt("id");
                int usuarioId = rs.getInt("idUsuario");
                String entradaSaida = rs.getString("entrada_saida");
                String entidadade = rs.getString("entidade");
                String tipoEntidade = rs.getString("tipo_entidade");
                int quantidade = rs.getInt("quantidade");
                int idArmazenamento = rs.getInt("id_armazenamento");
                String data = rs.getString("data");
                Transacao Transacao = new Transacao(id, usuarioId, entradaSaida, entidadade, tipoEntidade, quantidade,
                                      idArmazenamento, data);
                lista.add(Transacao);
        }
            
        } catch (SQLException erro){
            erro.printStackTrace();
            throw new RuntimeException("Falha ao recuperar os dados do banco!");
        }
        
        return lista;        
    }

    @Override
    public List<Transacao> buscarFiltros(int idUsuario, List<String> filtros) {
        
        boolean filtroEntradaSaida = false;
        String entradaSaida = "";
        
        if (filtros.get(0).equals("saida")){
           filtroEntradaSaida = true;
           entradaSaida = "saida";
        } else if (filtros.get(0).equals("entrada")){
           filtroEntradaSaida = true;
           entradaSaida = "entrada";
        }
        
        boolean filtroEntidade = false;
        String entidade = "";
        
        if (!filtros.get(1).equals("<Nenhum>")){
            filtroEntidade = true;
            entidade += filtros.get(1);
        } 
        
        boolean filtroTipoEntidade = false;
        String tipoEntidade = "";
        
        if (!filtros.get(2).equals("<Nenhum>")){
            filtroTipoEntidade = true;
            tipoEntidade += filtros.get(2);
        }
        
        boolean filtroIdArmazenamento = false;
        String idArmazenamento = "";
        
        if (!filtros.get(3).equals("<Nenhum>")){
            filtroIdArmazenamento = true;
            idArmazenamento += filtros.get(3);
        }
        
        boolean filtroData = false;
        String data = "";
        
        if(!filtros.get(4).equals("<Nenhum>")){           
            filtroData = true;
            
            LocalDate dataAtual = LocalDate.now();
            int anoAtual = dataAtual.getYear();
            int mesAtual = dataAtual.getMonthValue();

            data += anoAtual + "-" + "0" + mesAtual + "-0" + filtros.get(4);
        }

        
        BancoDeDados bd = new BancoDeDados();
        
        String sqlFiltros = "SELECT * FROM tb_historico_transacoes WHERE idUsuario = '" + idUsuario + "'";
        
        if (filtroEntradaSaida){
            sqlFiltros += " AND entrada_saida = '" + entradaSaida + "'";
        }
        
        if (filtroEntidade){
            sqlFiltros += " AND entidade = '" + entidade + "'";
        }
        
        if (filtroTipoEntidade){
            sqlFiltros += " AND tipo_entidade = '" + tipoEntidade + "'";
        }
        
        if (filtroIdArmazenamento){
            sqlFiltros += " AND id_armazenamento = '" + idArmazenamento + "'";
        }
        
        if (filtroData){                    
            
            
            sqlFiltros += " AND data = '" + data + "'";
        }
        sqlFiltros += ";";
        
        
        List<Transacao> lista = new ArrayList();
        ResultSet rs = bd.executarQuery(sqlFiltros);
        
        try{
            while(rs.next()){
                                
                int _id = rs.getInt("id");
                int _usuarioId = rs.getInt("idUsuario");
                String _entradaSaida = rs.getString("entrada_saida");
                String _entidade = rs.getString("entidade");
                String _tipoEntidade = rs.getString("tipo_entidade");
                int _quantidade = rs.getInt("quantidade");
                int _idArmazenamento = rs.getInt("id_armazenamento");
                String _data = rs.getString("data");
                
                Transacao Transacao = new Transacao(_id, _usuarioId, _entradaSaida, _entidade, _tipoEntidade, _quantidade,
                                      _idArmazenamento, _data);
                lista.add(Transacao);
            }
        } catch (Exception erro){
            
        }
        return lista;
    }
    
}
