package br.ufmt.poo.fitMe.persistencia;

import br.ufmt.poo.fitMe.persistencia.entidade.Exercicio;
import java.util.List;


public interface ExercicioPersistencia {
    
    public List<Exercicio> buscarTodos();
    public List<Exercicio> buscarPorNomeEFiltro(String nome, String grupoMuscular);
    
}
