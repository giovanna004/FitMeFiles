package br.ufmt.poo.fitMe.ui.dto;

public class ItemDietaDTO {
    
    
    private int alimentoId;
    private double porcao;
    private double calorias;
    private String unidadeMedida;
    private String alimento;

    public ItemDietaDTO(int alimentoId, double porcao, double calorias, String unidadeMedida, String alimento) {
        this.alimentoId = alimentoId;
        this.porcao = porcao;
        this.calorias = calorias;
        this.unidadeMedida = unidadeMedida;
        this.alimento = alimento;
    }

    public ItemDietaDTO() {
    }

    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
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

    public String getAlimento() {
        return alimento;
    }

    public void setAlimento(String alimento) {
        this.alimento = alimento;
    }
    
    
    
}
