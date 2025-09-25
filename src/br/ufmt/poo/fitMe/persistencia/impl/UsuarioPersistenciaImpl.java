package br.ufmt.poo.fitMe.persistencia.impl;

import br.ufmt.poo.fitMe.persistencia.UsuarioPersistencia;
import br.ufmt.poo.fitMe.persistencia.entidade.Usuario;
import br.ufmt.poo.fitMe.ui.dto.UsuarioDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UsuarioPersistenciaImpl implements UsuarioPersistencia {
    
    private BancoDeDados bd = new BancoDeDados();

    @Override
    public void cadastrar(Usuario usuario) {
        String sql = "INSERT INTO usuario (nome, email, senha) VALUES (?,?,?);";
        List<Object> parametros = new ArrayList<>();
        parametros.add(usuario.getNome());
        parametros.add(usuario.getEmail());
        parametros.add(usuario.getSenha());
        bd.executarUpdate(sql, parametros);
    }

    @Override
    public Usuario buscarPorEmail(String email) {
        Usuario usuario = null;
        String sql = "SELECT * FROM usuario WHERE email = ?";
        
        List<Object> parametros = new ArrayList<>();
        parametros.add(email);

        ResultSet rs = bd.executarQuery(sql, parametros);
        
        try {

            if(rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String senha = rs.getString("senha");
                double pesoAtual = rs.getDouble("peso_atual");
                double altura = rs.getDouble("altura");
                double imcAtual = rs.getDouble("imc_atual");
                String objetivo = rs.getString("objetivo");
                usuario = new Usuario(id, nome, email, senha, pesoAtual, altura, imcAtual, objetivo);
            }            
        } catch (SQLException erro) {
            erro.printStackTrace();
            throw new RuntimeException("Não foi possível recuperar os dados do banco!");
        }
        return usuario;
    }

    @Override
    public void atualizar(Usuario usuario) {
        
        String sql = "UPDATE usuario SET peso_atual = ?, altura = ?, imc_atual = ?, objetivo = ? WHERE id = ?";
        double imcAtual = usuario.getPesoAtual() / Math.pow((usuario.getAltura()), 2);
        System.out.println("Peso: " + usuario.getPesoAtual());
        System.out.println("Altura (m): " + usuario.getAltura());
        System.out.println("IMC calculado: " + imcAtual);
        List<Object> parametros = new ArrayList<>();
        parametros.add(usuario.getPesoAtual());
        parametros.add(usuario.getAltura());
        parametros.add(imcAtual);
        parametros.add(usuario.getObjetivo());
        parametros.add(usuario.getId());
        bd.executarUpdate(sql, parametros);
    }
    
}
