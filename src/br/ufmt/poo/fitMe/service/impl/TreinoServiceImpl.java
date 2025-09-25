
package br.ufmt.poo.fitMe.service.impl;

import br.ufmt.poo.fitMe.persistencia.ItemTreinoPersistencia;
import br.ufmt.poo.fitMe.persistencia.TreinoPersistencia;
import br.ufmt.poo.fitMe.persistencia.entidade.ItemTreino;
import br.ufmt.poo.fitMe.persistencia.entidade.Treino;
import br.ufmt.poo.fitMe.persistencia.impl.ItemTreinoPersistenciaImpl;
import br.ufmt.poo.fitMe.persistencia.impl.TreinoPersistenciaImpl;
import br.ufmt.poo.fitMe.service.TreinoService;
import br.ufmt.poo.fitMe.ui.dto.ItemTreinoDTO;
import br.ufmt.poo.fitMe.ui.dto.TreinoDTO;
import java.util.List;

public class TreinoServiceImpl implements TreinoService {
    
    private final TreinoPersistencia persistenciaTreino = new TreinoPersistenciaImpl();
    private final ItemTreinoPersistencia persistenciaItem = new ItemTreinoPersistenciaImpl();

    @Override
    public void cadastrar(TreinoDTO dto) {
        java.util.Date data = new java.util.Date();
        Treino treino = new Treino();
        treino.setNome(dto.getNome());
        treino.setDataCriacao(data); 
        treino.setUsuarioId(dto.getUsuarioId());
        
        int idTreino = persistenciaTreino.cadastrar(treino);
        
        for (ItemTreinoDTO itemDto : dto.getItens()) {
            ItemTreino item = new ItemTreino();
            item.setTreinoId(idTreino);
            item.setExercicioId(itemDto.getExercicioId());
            item.setSeries(itemDto.getSeries());
            item.setRepeticoes(itemDto.getRepeticoes());
            item.setDescanso(itemDto.getDescanso());
            item.setConcluido(false);

            persistenciaItem.adicionarItem(item);
        }
    }
        

    @Override
    public List<Treino> buscarTodosPorUsuario(int usuarioId) {
        return persistenciaTreino.buscarTodosPorUsuario(usuarioId);
    }
    
    @Override
    public Treino buscarPeloNome (String nome, int usuarioId) {
        List<Treino> treinos = buscarTodosPorUsuario(usuarioId);
        for (Treino t : treinos) {
            if (t.getNome().equals(nome)) {
                return t;
            }
        }
        return null;
    }
}

    
