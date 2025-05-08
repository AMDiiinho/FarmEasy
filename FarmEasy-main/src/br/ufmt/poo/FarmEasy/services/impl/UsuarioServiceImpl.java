/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufmt.poo.FarmEasy.services.impl;

import br.ufmt.poo.FarmEasy.UI.DTOs.UsuarioDTO;
import br.ufmt.poo.FarmEasy.persistencias.UsuarioPersistencia;
import br.ufmt.poo.FarmEasy.persistencias.entidade.Usuario;
import br.ufmt.poo.FarmEasy.persistencias.impl.UsuarioPersistenciaImpl;
import br.ufmt.poo.FarmEasy.services.UsuarioService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author arthurmarques
 */
public class UsuarioServiceImpl implements UsuarioService {

    @Override
    public void salvar(UsuarioDTO dto) {
        
        if(dto.getNome().equals("") || dto.getCpf().equals("") || dto.getSenha().equals("") 
        || dto.getTelefone().equals("") || dto.getUsuario().equals("")){
            throw new RuntimeException("Por favor preencha todos os campos para finalizar seu cadastro");                 
        }
        
        int id = 0;
        String nome = dto.getNome();
        String telefone = dto.getTelefone();
        String cpf = dto.getCpf();
        String usuarioAcesso = dto.getUsuario();
        String senha = dto.getSenha();
        
        if(!dto.getId().equals("")){
            
            id = Integer.parseInt(dto.getId());            
        }
        
        Usuario usuario = new Usuario (id, nome, telefone, cpf, usuarioAcesso, senha);
        
        UsuarioPersistencia persistencia = new UsuarioPersistenciaImpl();
        
        if(id == 0){
            persistencia.executar(usuario);
        } else {
            persistencia.atualizar(usuario);
        }
    }

    @Override
    public void remover(UsuarioDTO dto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<UsuarioDTO> listar() {
        
        
        UsuarioPersistencia persistencia = new UsuarioPersistenciaImpl();
        
        List<UsuarioDTO> lista = new ArrayList<>();
        List<Usuario> usuarios = persistencia.buscar();
        for (Usuario usuario : usuarios) {
            String id = usuario.getId() + "";
            String nome = usuario.getNome();
            String telefone = usuario.getTelefone();
            String cpf = usuario.getCpf();
            String usuarioAcesso = usuario.getUsuario();
            String senha = usuario.getSenha();
            UsuarioDTO dto = new UsuarioDTO(id, nome, telefone, cpf, usuarioAcesso, senha);
            lista.add(dto);
            
        }
        
        return lista;        
    }
    
    
}
