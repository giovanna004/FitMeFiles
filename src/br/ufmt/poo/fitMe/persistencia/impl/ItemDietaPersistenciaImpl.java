package br.ufmt.poo.fitMe.persistencia.impl;

import br.ufmt.poo.fitMe.persistencia.ItemDietaPersistencia;
import br.ufmt.poo.fitMe.persistencia.entidade.ItemDieta;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDietaPersistenciaImpl implements ItemDietaPersistencia{
    
    private BancoDeDados bd = new BancoDeDados();

    @Override
    public void adicionarItem(ItemDieta item) {
       String sql = "INSERT INTO dieta_item (porcao, calorias, concluido, FK_alimento_id, FK_dieta_id) VALUES (?, ?, ?, ?, ?)";
       List<Object> parametros = new ArrayList<>();
       parametros.add(item.getPorcao());
       parametros.add(item.getCalorias());
       parametros.add(item.isConsumido());
       parametros.add(item.getAlimentoId());
       parametros.add(item.getDietaId());

       bd.executarUpdate(sql, parametros);
    }

    @Override
    public void removerItem(int dietaId) {
        String sql = "DELETE FROM dieta_item WHERE id = ?";
        List parametros = new ArrayList<>();
        parametros.add(dietaId);
        bd.executarUpdate(sql, parametros);
    }

    @Override
    public List<ItemDieta> buscarItensPorDieta(int dietaId) {
        List<ItemDieta> lista = new ArrayList();
        String sql = "SELECT di.*, a.nome AS nome_alimento " +
                    "FROM dieta_item di " +
                    "JOIN alimento a ON di.FK_alimento_id = a.id " +
                    "WHERE di.FK_dieta_id = ?";
        
        List<Object> parametros = List.of(dietaId);
        
        ResultSet rs = bd.executarQuery(sql, parametros);
        try {
            while(rs.next()){
                int id = rs.getInt("id");
                double porcao = rs.getInt("porcao");
                double calorias = rs.getInt("calorias");
                int alimentoId = rs.getInt("FK_alimento_id");
                boolean consumido = rs.getBoolean("concluido");
                String alimento = rs.getString("nome_alimento");
                ItemDieta item = new ItemDieta(id, dietaId, alimentoId, porcao, calorias, consumido, alimento);
                lista.add(item);
            }
        } catch (SQLException erro) {
            erro.printStackTrace();
            throw new RuntimeException("Não foi possível recuperar os dados do banco!");
        }
        return lista;
    }
    
    public void atualizarConsumido(ItemDieta item) {
        String sql = "UPDATE dieta_item SET concluido = ? WHERE id = ?";
        List<Object> parametros = List.of(item.isConsumido(), item.getId());
        bd.executarUpdate(sql, parametros);
    }
    
}
