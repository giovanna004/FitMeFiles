package br.ufmt.poo.fitMe.persistencia;

import br.ufmt.poo.fitMe.persistencia.entidade.Alimento;
import java.util.List;


public interface AlimentoPersistencia {
    
    public List<Alimento> buscarTodos();
    public List<Alimento> buscarPorNomeEFiltro(String nome, String tipo);
    
}
