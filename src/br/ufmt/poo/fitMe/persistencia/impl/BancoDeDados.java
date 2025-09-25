package br.ufmt.poo.fitMe.persistencia.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.List;
import java.sql.ResultSet;

public class BancoDeDados {
    private static final String URL = "jdbc:postgresql://localhost:5432/db";
    private static final String USUARIO = "gigiq";
    private static final String SENHA = "123456";

    public static Connection conectar() throws SQLException {
        Connection con = DriverManager.getConnection(URL, USUARIO, SENHA);
        return con;
    }
           
    public void fecharConexao(Connection con) throws SQLException {
        con.close();
    }
    
    public void executarUpdate(String sql, List<Object> parametros) {
        
        try {
            Connection con = conectar();
            PreparedStatement pstmt = con.prepareStatement(sql);
            
            preencherParametros(pstmt, parametros);
            pstmt.executeUpdate();
            
            fecharConexao(con);
            System.out.println("Inserção concluída com sucesso.");
        } catch (SQLException erro) {
            erro.printStackTrace();
            throw new RuntimeException("Erro ao inserir/atualizar no banco de dados!");
        }
    }
    
    public ResultSet executarQuery(String sql, List<Object> parametros) {
        try {
            Connection con = conectar();
            PreparedStatement pstmt = con.prepareStatement(sql);
            preencherParametros(pstmt, parametros);
            return pstmt.executeQuery();
        } catch (SQLException erro) {
            erro.printStackTrace();
            throw new RuntimeException("Erro ao executar query no banco de dados!");
        }
    }
    
    public ResultSet executarQuery(String sql) {
        try {
            Connection con = conectar();
            return con.createStatement().executeQuery(sql);
        } catch (SQLException erro) {
            erro.printStackTrace();
            throw new RuntimeException("Erro ao executar query sem parâmetros no banco de dados!");
        }
    }
    
    public int executarInsertRetornandoId(String sql, List<Object> parametros) {
        try {
            Connection con = conectar();
            PreparedStatement pstmt = con.prepareStatement(sql);
            preencherParametros(pstmt, parametros);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt(1);
                fecharConexao(con);
                return id;
            } else {
                fecharConexao(con);
                throw new RuntimeException("Nenhum ID retornado.");
            }
        } catch (SQLException erro) {
            erro.printStackTrace();
            throw new RuntimeException("Erro ao executar INSERT com retorno de ID.");
        }
    }

    
    private void preencherParametros(PreparedStatement pstmt, List<Object> parametros) throws SQLException {
        if (parametros != null) {
            for (int i = 0; i < parametros.size(); i++) {
                pstmt.setObject(i + 1, parametros.get(i));
            }
        }
    }
}
