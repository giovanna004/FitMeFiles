package br.ufmt.poo.fitMe.service;

import br.ufmt.poo.fitMe.persistencia.entidade.Treino;
import br.ufmt.poo.fitMe.ui.dto.TreinoDTO;
import java.util.List;

public interface TreinoService {
    
    public void cadastrar(TreinoDTO treino);
    
    public List<Treino> buscarTodosPorUsuario(int usuarioId);
    
    public Treino buscarPeloNome (String nome, int usuarioId);
    
}
