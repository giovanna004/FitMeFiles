package br.ufmt.poo.fitMe.service;

import br.ufmt.poo.fitMe.persistencia.entidade.ItemDieta;
import br.ufmt.poo.fitMe.ui.dto.ItemDietaDTO;
import java.util.List;

public interface ItemDietaService {
    
    public List<ItemDietaDTO> adicionarItem(ItemDietaDTO item);
    
    public List<ItemDietaDTO> removerItem(int index);
    
    public List<ItemDieta> buscarItensPorDieta (int dietaId);
    
    public void atualizarConsumido(ItemDieta item);
    
}
