package br.ufmt.poo.fitMe.service.impl;


import br.ufmt.poo.fitMe.persistencia.UsuarioPersistencia;
import br.ufmt.poo.fitMe.persistencia.entidade.Usuario;
import br.ufmt.poo.fitMe.persistencia.impl.UsuarioPersistenciaImpl;
import br.ufmt.poo.fitMe.service.UsuarioService;
import br.ufmt.poo.fitMe.ui.Sessao;
import br.ufmt.poo.fitMe.ui.dto.UsuarioDTO;

public class UsuarioServiceImpl implements UsuarioService{
    
    private UsuarioPersistencia usuarioRepo = new UsuarioPersistenciaImpl();

    @Override
    public void registrar(UsuarioDTO dto) {
        String nome = dto.getNome();
        String email = dto.getEmail();
        String senha = dto.getSenha();
        
        if(email.equals("") || senha.equals("") || nome.equals("")){
            throw new RuntimeException("Todos os dados são obrigatórios!");            
        } else {
            Usuario usuarioCadastro = new Usuario();
            usuarioCadastro.setNome(nome);
            usuarioCadastro.setEmail(email);
            usuarioCadastro.setSenha(senha);
            usuarioRepo.cadastrar(usuarioCadastro);
            
        }
        
    }

    @Override
    public Usuario entrar(String email, String senha) {
        
        if (email == null || email.isBlank() || senha == null || senha.isBlank()) {
        throw new RuntimeException("Email e senha são obrigatórios!");
    }

        Usuario usuario = usuarioRepo.buscarPorEmail(email);

        if (usuario == null) {
            throw new RuntimeException("Usuário não encontrado.");
        }

        if (!senha.equals(senha)) {
            throw new RuntimeException("Senha incorreta.");
        }
        
        return usuario;
    }

    @Override
    public void atualizarDadosUsuario(double peso, double altura, String objetivo) {
        Usuario usuario = Sessao.usuarioLogado;

        usuario.setPesoAtual(peso);
        usuario.setAltura(altura);

        double imc = peso / Math.pow((altura / 100), 2);
        usuario.setImcAtual(imc);
        usuario.setObjetivo(objetivo);
        
        usuarioRepo.atualizar(usuario);

        Sessao.usuarioLogado = usuario;
    }
    
}
