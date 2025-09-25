package br.ufmt.poo.fitMe.persistencia.entidade;


public class Exercicio {
    
    private int id;
    private String nome;
    private String grupoMuscular;
    private String execucao;
    private String equipamento;

    public Exercicio(int id, String nome, String grupoMuscular, String execucao, String equipamento) {
        this.id = id;
        this.nome = nome;
        this.grupoMuscular = grupoMuscular;
        this.execucao = execucao;
        this.equipamento = equipamento;
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

    public String getGrupoMuscular() {
        return grupoMuscular;
    }

    public void setGrupoMuscular(String grupoMuscular) {
        this.grupoMuscular = grupoMuscular;
    }

    public String getExecucao() {
        return execucao;
    }

    public void setExecucao(String execucao) {
        this.execucao = execucao;
    }

    public String getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(String equipamento) {
        this.equipamento = equipamento;
    }
    
    
}
