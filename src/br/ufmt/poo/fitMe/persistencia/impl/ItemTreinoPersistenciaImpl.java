package br.ufmt.poo.fitMe.persistencia.impl;

import br.ufmt.poo.fitMe.persistencia.ItemTreinoPersistencia;
import br.ufmt.poo.fitMe.persistencia.entidade.ItemTreino;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ItemTreinoPersistenciaImpl implements ItemTreinoPersistencia {
    
    private BancoDeDados bd = new BancoDeDados();


    @Override
    public void adicionarItem(ItemTreino item) {
       String sql = "INSERT INTO treino_item (series, repeticoes, descanso, concluido, FK_exercicio_id, FK_treino_id) VALUES (?, ?, ?, ?, ?, ?);";
       List<Object> parametros = new ArrayList<>();
       parametros.add(item.getSeries());
       parametros.add(item.getRepeticoes());
       parametros.add(item.getDescanso());
       parametros.add(item.isConcluido());
       parametros.add(item.getExercicioId());
       parametros.add(item.getTreinoId());

       bd.executarUpdate(sql, parametros);
       
    }

    @Override
    public void removerItem(int treinoId) {
        String sql = "DELETE FROM treino_item WHERE id = ?;";
        List parametros = new ArrayList();
        parametros.add(treinoId);
        bd.executarUpdate(sql, parametros);

    }

    @Override
    public List<ItemTreino> buscarItensPorTreino(int treinoId) {
        List<ItemTreino> lista = new ArrayList();
        String sql = "SELECT ti.*, e.nome AS nome_exercicio " +
                    "FROM treino_item ti " +
                    "JOIN exercicio e ON ti.FK_exercicio_id = e.id " +
                    "WHERE ti.FK_treino_id = ?;";
        
        List<Object> parametros = List.of(treinoId);
        
        ResultSet rs = bd.executarQuery(sql, parametros);
        try {
            while(rs.next()){
                int id = rs.getInt("id");
                int series = rs.getInt("series");
                int repeticoes = rs.getInt("repeticoes");
                int descanso = rs.getInt("descanso");
                int exercicioId = rs.getInt("FK_exercicio_id");
                boolean concluido = rs.getBoolean("concluido");
                String exercicio = rs.getString("nome_exercicio");
                
                ItemTreino item = new ItemTreino(id, series, repeticoes, descanso, exercicioId,  treinoId, concluido, exercicio);
                lista.add(item);
            }
        } catch (SQLException erro) {
            erro.printStackTrace();
            throw new RuntimeException("Não foi possível recuperar os dados do banco!");
        }
        return lista;
    }
    
    public void atualizarConsumido(ItemTreino item) {
        String sql = "UPDATE treino_item SET concluido = ? WHERE id = ?";
        List<Object> parametros = List.of(item.isConcluido(), item.getId());
        bd.executarUpdate(sql, parametros);
    }

    
}
