package br.ufmt.poo.fitMe.persistencia.impl;

import br.ufmt.poo.fitMe.persistencia.AlimentoPersistencia;
import br.ufmt.poo.fitMe.persistencia.entidade.Alimento;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlimentoPersistenciaImpl implements AlimentoPersistencia{
    
    private BancoDeDados bd = new BancoDeDados();

    @Override
    public List<Alimento> buscarTodos() {
        List<Alimento> lista = new ArrayList<>();
        String sql = "SELECT * FROM alimento;";
        ResultSet rs = bd.executarQuery(sql);
        try {
            while(rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                double calorias = rs.getDouble("calorias");
                double porcaoPadrao = rs.getDouble("porcao_padrao");
                String unidadeDeMedida = rs.getString("unidade_medida");
                String tipo = rs.getString("tipo");
                Alimento alimento = new Alimento(id, nome, calorias, porcaoPadrao, unidadeDeMedida, tipo);
                lista.add(alimento);
            }
        } catch (SQLException erro) {
            erro.printStackTrace();
            throw new RuntimeException("Não foi possível recuperar os dados do banco!");
        }
        return lista;
    }

    @Override
    public List<Alimento> buscarPorNomeEFiltro(String nome, String tipo) {
        List<Alimento> lista = new ArrayList<>();
        String sql = "SELECT * FROM alimento WHERE 1=1";
        List<Object> parametros = new ArrayList<>();
        
        if (!nome.isEmpty()) {
            sql += " AND nome ILIKE ?";
            parametros.add("%" + nome + "%");
        }
        if (!tipo.isEmpty() && !tipo.equalsIgnoreCase("Todos")) {
            sql += " AND tipo = ?";
            parametros.add(tipo);
        }
        
        ResultSet rs = bd.executarQuery(sql, parametros);
        try {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nomeBanco = rs.getString("nome");
                String tipoBanco = rs.getString("tipo");
                double calorias = rs.getDouble("calorias");
                double porcao = rs.getDouble("porcao_padrao");
                String unidadeMedida = rs.getString("unidade_medida");
                Alimento alimento = new Alimento(id, nomeBanco, calorias, porcao, unidadeMedida, tipoBanco);
                lista.add(alimento);
            }

        } catch (SQLException erro) {
            erro.printStackTrace();
            throw new RuntimeException("Erro ao buscar alimentos!");
        }

        return lista;
    }
    
}
