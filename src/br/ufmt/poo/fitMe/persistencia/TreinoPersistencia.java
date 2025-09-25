package br.ufmt.poo.fitMe.persistencia;

import br.ufmt.poo.fitMe.persistencia.entidade.ItemTreino;
import br.ufmt.poo.fitMe.persistencia.entidade.Treino;
import java.util.List;


public interface TreinoPersistencia {
    
    public int cadastrar(Treino treino);
    
    public List<Treino> buscarTodosPorUsuario(int usuarioId);
    
    public List<ItemTreino> buscarItensDoTreino(int treinoId);
    
}
