package br.ufmt.poo.fitMe.persistencia.impl;

import br.ufmt.poo.fitMe.persistencia.DietaPersistencia;
import br.ufmt.poo.fitMe.persistencia.entidade.Dieta;
import br.ufmt.poo.fitMe.persistencia.entidade.ItemDieta;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class DietaPersistenciaImpl implements DietaPersistencia{
    
    private BancoDeDados bd = new BancoDeDados();

    @Override
    public int cadastrar(Dieta dieta) {
        String sql = "INSERT INTO dieta (nome, data_criacao, FK_id_usuario) VALUES (?,?,?) RETURNING id;";
        List<Object> parametros = List.of(
            dieta.getNome(),
            new java.sql.Date(dieta.getDataCriacao().getTime()),
            dieta.getUsuarioId()
        );

        return bd.executarInsertRetornandoId(sql, parametros);
    }

    @Override
    public List<Dieta> buscarTodosPorUsuario(int usuarioId) {
        List<Dieta> lista = new ArrayList<>();
        String sql = "SELECT * FROM dieta WHERE FK_id_usuario = ?;";
        ResultSet rs = bd.executarQuery(sql, List.of(usuarioId)); 

        try {
            while(rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                Date dataCriacao = rs.getDate("data_criacao");
                Dieta dieta = new Dieta(id, nome, dataCriacao, usuarioId);
                lista.add(dieta);
            }
        } catch (SQLException erro) {
            erro.printStackTrace();
            throw new RuntimeException("Não foi possível recuperar os dados do banco!");
        }
        return lista;
    }

    @Override
    public List<ItemDieta> buscarItensDaDieta(int dietaId) {
        String sql = "SELECT * FROM dieta_item WHERE fk_dieta_id = ?";
        ResultSet rs = bd.executarQuery(sql, List.of(dietaId));

        List<ItemDieta> lista = new ArrayList<>();
        try {
            while (rs.next()) {
                ItemDieta item = new ItemDieta();
                item.setId(rs.getInt("id"));
                item.setDietaId(rs.getInt("fk_dieta_id"));
                item.setAlimentoId(rs.getInt("fk_alimento_id"));
                item.setCalorias(rs.getDouble("calorias"));
                item.setPorcao(rs.getDouble("porcao"));
                item.setConsumido(rs.getBoolean("concluido"));
                lista.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    
}
