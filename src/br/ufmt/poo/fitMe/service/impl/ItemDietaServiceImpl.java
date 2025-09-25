package br.ufmt.poo.fitMe.service.impl;

import br.ufmt.poo.fitMe.persistencia.impl.ItemDietaPersistenciaImpl;
import br.ufmt.poo.fitMe.persistencia.entidade.ItemDieta;
import br.ufmt.poo.fitMe.service.ItemDietaService;
import br.ufmt.poo.fitMe.ui.dto.ItemDietaDTO;
import java.util.ArrayList;
import java.util.List;

public class ItemDietaServiceImpl implements ItemDietaService{
    List<ItemDietaDTO> lista = new ArrayList<>();
    ItemDietaPersistenciaImpl persistencia = new ItemDietaPersistenciaImpl();

    @Override
    public List<ItemDietaDTO> adicionarItem(ItemDietaDTO item) {
        lista.add(item);
        return lista;
    }

    @Override
    public List<ItemDietaDTO> removerItem(int index) {
        if (index >= 0 && index < lista.size()) {
            lista.remove(index);
        }
        return lista;
    }

    @Override
    public List<ItemDieta> buscarItensPorDieta(int dietaId) {
        return persistencia.buscarItensPorDieta(dietaId);
    }

    @Override
    public void atualizarConsumido(ItemDieta item) {
        persistencia.atualizarConsumido(item);
    }
    
}
