package br.ufmt.poo.fitMe.service.impl;

import br.ufmt.poo.fitMe.persistencia.entidade.ItemTreino;
import br.ufmt.poo.fitMe.persistencia.impl.ItemTreinoPersistenciaImpl;
import br.ufmt.poo.fitMe.service.ItemTreinoService;
import br.ufmt.poo.fitMe.ui.dto.ItemTreinoDTO;
import java.util.ArrayList;
import java.util.List;

public class ItemTreinoServiceImpl implements ItemTreinoService{
    List<ItemTreinoDTO> lista = new ArrayList<>();
    ItemTreinoPersistenciaImpl persistencia = new ItemTreinoPersistenciaImpl();
    
    @Override
    public List<ItemTreinoDTO> adicionarItem(ItemTreinoDTO item) {
        lista.add(item);
        return lista;
    }

    @Override
    public List<ItemTreinoDTO> removerItem(int index) {
        if (index >= 0 && index < lista.size()) {
            lista.remove(index);
        }
        return lista;
    }

    @Override
    public List<ItemTreino> buscarItensPorTreino(int treinoId) {
        return persistencia.buscarItensPorTreino(treinoId);
    }

    @Override
    public void atualizarConcluido(ItemTreino item) {
        persistencia.atualizarConsumido(item);
    }
    
}
