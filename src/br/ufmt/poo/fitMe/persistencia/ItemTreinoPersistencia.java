package br.ufmt.poo.fitMe.persistencia;

import br.ufmt.poo.fitMe.persistencia.entidade.ItemTreino;
import java.util.List;


public interface ItemTreinoPersistencia {
    
    public void adicionarItem(ItemTreino item);
    
    public void removerItem(int treinoId);
    
    public List<ItemTreino> buscarItensPorTreino (int treinoId);
    
    
}
