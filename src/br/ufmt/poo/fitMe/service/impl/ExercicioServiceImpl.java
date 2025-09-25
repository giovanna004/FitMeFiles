package br.ufmt.poo.fitMe.service.impl;

import br.ufmt.poo.fitMe.persistencia.ExercicioPersistencia;
import br.ufmt.poo.fitMe.persistencia.entidade.Exercicio;
import br.ufmt.poo.fitMe.persistencia.impl.ExercicioPersistenciaImpl;
import br.ufmt.poo.fitMe.service.ExercicioService;
import java.util.List;

public class ExercicioServiceImpl implements ExercicioService{
    
    ExercicioPersistencia persistencia = new ExercicioPersistenciaImpl();

    @Override
    public List<Exercicio> buscarTodos() {
        return persistencia.buscarTodos();
    }

    @Override
    public List<Exercicio> buscarPorNomeEFiltro(String nome, String grupoMuscular) {
        if (nome == null || nome.isBlank()) {
            return persistencia.buscarTodos();
        }
        return persistencia.buscarPorNomeEFiltro(nome, grupoMuscular);
    }
    
}
