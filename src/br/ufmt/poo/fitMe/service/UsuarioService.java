package br.ufmt.poo.fitMe.service;

import br.ufmt.poo.fitMe.persistencia.entidade.Usuario;
import br.ufmt.poo.fitMe.ui.dto.UsuarioDTO;


public interface UsuarioService {
    
    public void atualizarDadosUsuario(double peso, double altura, String objetivo);
    
    public void registrar(UsuarioDTO dto);
    
    public Usuario entrar(String email, String senha);
}
