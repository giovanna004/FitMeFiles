package br.ufmt.poo.fitMe.persistencia;

import br.ufmt.poo.fitMe.persistencia.entidade.ItemDieta;
import java.util.List;


public interface ItemDietaPersistencia {
    
    public void adicionarItem(ItemDieta item);
    
    public void removerItem(int dietaId);
    
    public List<ItemDieta> buscarItensPorDieta (int dietaId);
    
}
