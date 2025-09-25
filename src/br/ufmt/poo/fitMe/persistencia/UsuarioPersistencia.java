package br.ufmt.poo.fitMe.persistencia;

import br.ufmt.poo.fitMe.persistencia.entidade.Usuario;
import br.ufmt.poo.fitMe.ui.dto.UsuarioDTO;


public interface UsuarioPersistencia {
    
    public void cadastrar(Usuario usuario);
        
    public void atualizar(Usuario usuario);
    
    public Usuario buscarPorEmail(String email);
}
