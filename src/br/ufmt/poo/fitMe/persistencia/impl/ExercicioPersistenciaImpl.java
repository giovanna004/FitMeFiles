package br.ufmt.poo.fitMe.persistencia.impl;

import br.ufmt.poo.fitMe.persistencia.ExercicioPersistencia;
import br.ufmt.poo.fitMe.persistencia.entidade.Exercicio;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExercicioPersistenciaImpl implements ExercicioPersistencia{
    
    private BancoDeDados bd = new BancoDeDados();

    @Override
    public List<Exercicio> buscarTodos() {
        List<Exercicio> lista = new ArrayList<>();
        String sql = "SELECT * FROM exercicio;";
        ResultSet rs = bd.executarQuery(sql);
        try {
            while(rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String grupoMuscular = rs.getString("grupo_muscular");
                String execucao = rs.getString("execucao");
                String equipamento = rs.getString("equipamento");
                Exercicio exercicio = new Exercicio(id, nome, grupoMuscular, execucao, equipamento);
                lista.add(exercicio);
            }
        } catch (SQLException erro) {
            erro.printStackTrace();
            throw new RuntimeException("Não foi possível recuperar os dados do banco!");
        }
        return lista;
    }

    @Override
    public List<Exercicio> buscarPorNomeEFiltro(String nome, String grupoMuscular) {
        List<Exercicio> lista = new ArrayList<>();
        String sql = "SELECT * FROM exercicio WHERE 1=1";
        List<Object> parametros = new ArrayList<>();

        if (!nome.isEmpty()) {
            sql += " AND nome ILIKE ?";
            parametros.add("%" + nome + "%");
        }
        if (!grupoMuscular.isEmpty() && !grupoMuscular.equalsIgnoreCase("Todos")) {
            sql += " AND grupo_muscular = ?";
            parametros.add(grupoMuscular);
        }
        
        ResultSet rs = bd.executarQuery(sql, parametros);
        try {

            while (rs.next()) {
                int id = rs.getInt("id");
                String execucao = rs.getString("execucao");
                String equipamento = rs.getString("equipamento");
                String nomeBanco = rs.getString("nome");
                String grupoBanco = rs.getString("grupo_muscular");
                Exercicio exercicio = new Exercicio(id, nomeBanco, grupoBanco, execucao, equipamento);
                lista.add(exercicio);
            }

        } catch (SQLException erro) {
            erro.printStackTrace();
            throw new RuntimeException("Erro ao buscar exercicios!");
        }

        return lista;
    }

   
}
