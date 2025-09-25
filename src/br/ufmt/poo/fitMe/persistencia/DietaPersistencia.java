package br.ufmt.poo.fitMe.persistencia;

import br.ufmt.poo.fitMe.persistencia.entidade.Dieta;
import br.ufmt.poo.fitMe.persistencia.entidade.ItemDieta;
import java.util.List;

public interface DietaPersistencia {
    
    public int cadastrar(Dieta dieta);
    
    public List<Dieta> buscarTodosPorUsuario(int usuarioId);
    
    public List<ItemDieta> buscarItensDaDieta(int dietaId);
    
}
