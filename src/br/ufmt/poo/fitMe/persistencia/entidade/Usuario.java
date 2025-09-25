package br.ufmt.poo.fitMe.persistencia.entidade;

public class Usuario{
    
    private int id;
    private String nome;
    private String email;
    private String senha;
    private double pesoAtual;
    private double altura;
    private double imcAtual;
    private String objetivo;

    public Usuario(int id, String nome, String email, String senha, double pesoAtual, double altura, double imcAtual, String objetivo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.pesoAtual = pesoAtual;
        this.altura = altura;
        this.imcAtual = imcAtual;
        this.objetivo = objetivo;
    }

    public Usuario() {
        
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public double getPesoAtual() {
        return pesoAtual;
    }

    public void setPesoAtual(double pesoAtual) {
        this.pesoAtual = pesoAtual;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getImcAtual() {
        return imcAtual;
    }

    public void setImcAtual(double imcAtual) {
        this.imcAtual = imcAtual;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    
    
}
