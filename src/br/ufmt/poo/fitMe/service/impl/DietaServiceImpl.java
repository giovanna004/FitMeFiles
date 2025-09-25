package br.ufmt.poo.fitMe.service.impl;

import br.ufmt.poo.fitMe.persistencia.DietaPersistencia;
import br.ufmt.poo.fitMe.persistencia.ItemDietaPersistencia;
import br.ufmt.poo.fitMe.persistencia.entidade.Dieta;
import br.ufmt.poo.fitMe.persistencia.entidade.ItemDieta;
import br.ufmt.poo.fitMe.persistencia.impl.DietaPersistenciaImpl;
import br.ufmt.poo.fitMe.persistencia.impl.ItemDietaPersistenciaImpl;
import br.ufmt.poo.fitMe.service.DietaService;
import br.ufmt.poo.fitMe.ui.dto.DietaDTO;
import br.ufmt.poo.fitMe.ui.dto.ItemDietaDTO;
import java.util.List;

public class DietaServiceImpl implements DietaService {
    
    private final DietaPersistencia persistenciaDieta = new DietaPersistenciaImpl();
    private final ItemDietaPersistencia persistenciaItem = new ItemDietaPersistenciaImpl();

    @Override
    public void cadastrar(DietaDTO dto) {
        java.util.Date data = new java.util.Date();
        Dieta dieta = new Dieta();
        dieta.setNome(dto.getNome());
        dieta.setDataCriacao(data); 
        dieta.setUsuarioId(dto.getUsuarioId());
        
        int idDieta = persistenciaDieta.cadastrar(dieta);
        
        for (ItemDietaDTO itemDto : dto.getItens()) {
            ItemDieta item = new ItemDieta();
            item.setDietaId(idDieta);
            item.setAlimento(itemDto.getAlimento());
            item.setAlimentoId(itemDto.getAlimentoId());
            item.setCalorias(itemDto.getCalorias());
            item.setConsumido(false);
            item.setPorcao(itemDto.getPorcao());
            

            persistenciaItem.adicionarItem(item);
        }
    }

    @Override
    public List<Dieta> buscarTodosPorUsuario(int usuarioId) {
        return persistenciaDieta.buscarTodosPorUsuario(usuarioId);
    }

    @Override
    public Dieta buscarPeloNome(String nome, int usuarioId) {
        List<Dieta> treinos = buscarTodosPorUsuario(usuarioId);
        for (Dieta d : treinos) {
            if (d.getNome().equals(nome)) {
                return d;
            }
        }
        return null;
    }
    
}
