package br.ufmt.poo.fitMe.service;

import br.ufmt.poo.fitMe.persistencia.entidade.Dieta;
import br.ufmt.poo.fitMe.ui.dto.DietaDTO;
import java.util.List;


public interface DietaService {
     public void cadastrar(DietaDTO dieta);
    
    public List<Dieta> buscarTodosPorUsuario(int usuarioId);
    
    public Dieta buscarPeloNome (String nome, int usuarioId);
    
}
