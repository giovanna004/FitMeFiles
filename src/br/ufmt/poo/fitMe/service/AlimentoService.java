package br.ufmt.poo.fitMe.service;

import br.ufmt.poo.fitMe.persistencia.entidade.Alimento;
import java.util.List;

public interface AlimentoService {
    
    public List<Alimento>buscarTodos();
    
    public List<Alimento> buscarPorNomeEFiltro(String nome, String tipo);
    
}
