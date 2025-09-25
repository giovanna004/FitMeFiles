package br.ufmt.poo.fitMe.persistencia.entidade;


public class ItemDieta {
    
    private int id;
    private int dietaId;
    private int alimentoId;
    private double porcao;
    private double calorias;
    private boolean consumido;
    private String alimento;

    public ItemDieta(int id, int dietaId, int alimentoId, double porcao, double calorias, boolean consumido, String alimento) {
        this.id = id;
        this.dietaId = dietaId;
        this.alimentoId = alimentoId;
        this.porcao = porcao;
        this.calorias = calorias;
        this.consumido = consumido;
        this.alimento = alimento;
    }

    public ItemDieta() {
    }
    
    

    public String getNomeAlimento() {
        return alimento;
    }

    public void setAlimento(String alimento) {
        this.alimento = alimento;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDietaId() {
        return dietaId;
    }

    public void setDietaId(int dietaId) {
        this.dietaId = dietaId;
    }

    public int getAlimentoId() {
        return alimentoId;
    }

    public void setAlimentoId(int alimentoId) {
        this.alimentoId = alimentoId;
    }

    public double getPorcao() {
        return porcao;
    }

    public void setPorcao(double porcao) {
        this.porcao = porcao;
    }

    public double getCalorias() {
        return calorias;
    }

    public void setCalorias(double calorias) {
        this.calorias = calorias;
    }

    public boolean isConsumido() {
        return consumido;
    }

    public void setConsumido(boolean consumido) {
        this.consumido = consumido;
    }
    
    
    
}
