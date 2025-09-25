package br.ufmt.poo.fitMe.persistencia.impl;

import br.ufmt.poo.fitMe.persistencia.TreinoPersistencia;
import br.ufmt.poo.fitMe.persistencia.entidade.ItemTreino;
import br.ufmt.poo.fitMe.persistencia.entidade.Treino;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class TreinoPersistenciaImpl implements TreinoPersistencia {
    
    private BancoDeDados bd = new BancoDeDados();

    @Override
    public int cadastrar(Treino treino) {
        String sql = "INSERT INTO treino (nome, data_criacao, FK_usuario_id) VALUES (?,?,?) RETURNING id;";
        List<Object> parametros = List.of(
            treino.getNome(),
            new java.sql.Date(treino.getDataCriacao().getTime()),
            treino.getUsuarioId()
        );

        return bd.executarInsertRetornandoId(sql, parametros);
    }

    @Override
    public List<Treino> buscarTodosPorUsuario(int usuarioId) {
        List<Treino> lista = new ArrayList<>();
        String sql = "SELECT * FROM treino WHERE FK_usuario_id = ?;";
        ResultSet rs = bd.executarQuery(sql, List.of(usuarioId)); 

        try {
            while(rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                Date dataCriacao = rs.getDate("data_criacao");
                Treino treino = new Treino(id, nome, dataCriacao, usuarioId);
                lista.add(treino);
            }
        } catch (SQLException erro) {
            erro.printStackTrace();
            throw new RuntimeException("Não foi possível recuperar os dados do banco!");
        }
        return lista;
    }
    
    @Override
    public List<ItemTreino> buscarItensDoTreino(int treinoId) {
        String sql = "SELECT * FROM treino_item WHERE fk_treino_id = ?";
        ResultSet rs = bd.executarQuery(sql, List.of(treinoId));

        List<ItemTreino> lista = new ArrayList<>();
        try {
            while (rs.next()) {
                ItemTreino item = new ItemTreino();
                item.setId(rs.getInt("id"));
                item.setTreinoId(rs.getInt("fk_treino_id"));
                item.setExercicioId(rs.getInt("fk_exercicio_id"));
                item.setSeries(rs.getInt("series"));
                item.setRepeticoes(rs.getInt("repeticoes"));
                item.setDescanso(rs.getInt("descanso"));
                item.setConcluido(rs.getBoolean("concluido"));
                lista.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    
}
