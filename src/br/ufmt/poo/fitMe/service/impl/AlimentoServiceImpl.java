package br.ufmt.poo.fitMe.service.impl;

import br.ufmt.poo.fitMe.persistencia.AlimentoPersistencia;
import br.ufmt.poo.fitMe.persistencia.entidade.Alimento;
import br.ufmt.poo.fitMe.persistencia.impl.AlimentoPersistenciaImpl;
import br.ufmt.poo.fitMe.service.AlimentoService;
import java.util.List;

public class AlimentoServiceImpl implements AlimentoService{
    AlimentoPersistencia persistencia = new AlimentoPersistenciaImpl();

    @Override
    public List<Alimento> buscarTodos() {
        return persistencia.buscarTodos();
    }

    @Override
    public List<Alimento> buscarPorNomeEFiltro(String nome, String tipo) {
        if (nome == null || nome.isBlank()) {
            return persistencia.buscarTodos();
        }
        return persistencia.buscarPorNomeEFiltro(nome, tipo);
    }
    
}
