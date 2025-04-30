/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufmt.poo.FarmEasy.persistencias.impl;

import br.ufmt.poo.FarmEasy.persistencias.UsuarioPersistencia;
import br.ufmt.poo.FarmEasy.persistencias.entidade.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author arthurmarques
 */
public class UsuarioPersistenciaImpl extends javax.swing.JFrame implements UsuarioPersistencia {
    
    BancoDeDados bd = new BancoDeDados();
    
    @Override
    public void executar(Usuario usuario) {
        
        String sql = "INSERT INTO tb_usuarios (nome, telefone, cpf, usuario, senha) VALUES (?, ?, ?, ?, ?);";
        List parametros = new ArrayList();
        parametros.add(usuario.getNome());
        parametros.add(usuario.getTelefone());
        parametros.add(usuario.getCpf());
        parametros.add(usuario.getUsuario());
        parametros.add(usuario.getSenha());
        bd.inserir(sql, parametros);    
        
    }

    @Override
    public void remover(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void atualizar(Usuario usuario) {
        
        String sql = "UPDATE tb_usuarios nome = ? telefone = ? usuario = ?, senha = ? WHERE id = ?;";
        List parametros = new ArrayList();
        parametros.add(usuario.getNome());
        parametros.add(usuario.getTelefone());
        parametros.add(usuario.getUsuario());
        parametros.add(usuario.getSenha());
        bd.inserir(sql, parametros);    
    
    }

    @Override
    public List<Usuario> buscar() {
        
        List<Usuario> lista = new ArrayList();
        String sql = "SELECT * FROM tb_usuarios";
        ResultSet rs = bd.executarQuery(sql);
        
        
        try{
            while(rs.next()){
                
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String telefone = rs.getString("telefone");
                String cpf = rs.getString("cpf");
                String usuarioAcesso = rs.getString("usuario");
                String senha = rs.getString("senha");
                Usuario usuario = new Usuario(id, nome, telefone, cpf, usuarioAcesso, senha);
                lista.add(usuario);
        }
            
        } catch (SQLException erro){
            erro.printStackTrace();
            throw new RuntimeException("Falha ao recuperar os dados do banco!");
        }
        
        return lista;    
    }
    
    @Override
    public boolean login(String usuarioAcesso, String senhaAcesso){
        
        String sql = "SELECT usuario, senha FROM tb_usuarios WHERE usuario = '"+ usuarioAcesso +"' AND senha = '"+ senhaAcesso +"';";
        ResultSet rs = bd.executarQuery(sql);

        try {
              
            if(rs.next()){
  
                String usuario = rs.getString("usuario");
                String senha = rs.getString("senha");         

                if(senha.equals(senhaAcesso) && usuario.equals(usuarioAcesso)){
                    return true;
                }
            }             
        } catch (Exception erro) {
            erro.printStackTrace();
        }
        JOptionPane.showMessageDialog(rootPane, "Usuario e/ou senha incorretos!");
        throw new RuntimeException("Usuario e/ou senha incorretos!");
    }
    
}
