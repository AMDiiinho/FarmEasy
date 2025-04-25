/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.ufmt.poo.FarmEasy.persistencias;

import br.ufmt.poo.FarmEasy.persistencias.entidade.Usuario;
import java.util.List;

/**
 *
 * @author arthurmarques
 */
public interface UsuarioPersistencia {
    
    public void executar(Usuario usuario);
    
    public void remover(int id);
    
    public void atualizar(Usuario usuario);
    
    public boolean login(String usuarioAcesso, String senhaAcesso);
    
    public List<Usuario> buscar();
    
    
}
