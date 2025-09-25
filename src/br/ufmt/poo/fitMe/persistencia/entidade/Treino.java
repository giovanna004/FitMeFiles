package br.ufmt.poo.fitMe.persistencia.entidade;

import java.util.Date;


public class Treino {
    
    private int id;
    private String nome;
    private Date dataCriacao;
    private int usuarioId;

    public Treino(int id, String nome, Date dataCriacao, int usuarioId) {
        this.id = id;
        this.nome = nome;
        this.dataCriacao = dataCriacao;
        this.usuarioId = usuarioId;
    }
    
    public Treino() {
        
    }
    
    @Override
    public String toString() {
        return nome; 
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }
    
    
}
