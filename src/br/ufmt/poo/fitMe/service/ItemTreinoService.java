package br.ufmt.poo.fitMe.service;

import br.ufmt.poo.fitMe.persistencia.entidade.ItemTreino;
import br.ufmt.poo.fitMe.ui.dto.ItemTreinoDTO;
import java.util.List;

public interface ItemTreinoService {
    
    public List<ItemTreinoDTO> adicionarItem(ItemTreinoDTO item);
    
    public List<ItemTreinoDTO> removerItem(int index);
    
    public List<ItemTreino> buscarItensPorTreino (int treinoId);
    
    public void atualizarConcluido(ItemTreino item);
    
}
