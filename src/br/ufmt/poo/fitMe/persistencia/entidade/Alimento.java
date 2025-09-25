package br.ufmt.poo.fitMe.persistencia.entidade;


public class Alimento {
    
    private int id;
    private String nome;
    private double calorias;
    private double porcao_padrao;
    private String unidade_de_medida;
    private String tipo;

    public Alimento(int id, String nome, double calorias, double porcao_padrao, String unidade_de_medida, String tipo) {
        this.id = id;
        this.nome = nome;
        this.calorias = calorias;
        this.porcao_padrao = porcao_padrao;
        this.unidade_de_medida = unidade_de_medida;
        this.tipo = tipo;
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

    public double getCalorias() {
        return calorias;
    }

    public void setCalorias(double calorias) {
        this.calorias = calorias;
    }

    public double getPorcao_padrao() {
        return porcao_padrao;
    }

    public void setPorcao_padrao(double porcao_padrao) {
        this.porcao_padrao = porcao_padrao;
    }

    public String getUnidadeMedida() {
        return unidade_de_medida;
    }

    public void setUnidadeMedida(String unidade_de_medida) {
        this.unidade_de_medida = unidade_de_medida;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
    
    
}
