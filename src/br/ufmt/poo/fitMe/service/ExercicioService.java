package br.ufmt.poo.fitMe.service;

import br.ufmt.poo.fitMe.persistencia.entidade.Exercicio;
import java.util.List;

public interface ExercicioService {
    
    public List<Exercicio>buscarTodos();
    
    public List<Exercicio> buscarPorNomeEFiltro(String nome, String grupoMuscular);
    
}
