package br.ufmt.poo.fitMe.ui.dto;

public class ItemTreinoDTO {
    
    private int exercicioId;
    private int series;
    private int repeticoes;
    private int descanso;
    private String exercicio;

    public ItemTreinoDTO(int exercicioId, int series, int repeticoes, int descanso, String exercicio) {
        this.exercicioId = exercicioId;
        this.series = series;
        this.repeticoes = repeticoes;
        this.descanso = descanso;
        this.exercicio = exercicio;
    }

    public int getExercicioId() {
        return exercicioId;
    }

    public void setExercicioId(int exercicioId) {
        this.exercicioId = exercicioId;
    }

    
    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public int getRepeticoes() {
        return repeticoes;
    }

    public void setRepeticoes(int repeticoes) {
        this.repeticoes = repeticoes;
    }

    public int getDescanso() {
        return descanso;
    }

    public void setDescanso(int descanso) {
        this.descanso = descanso;
    }


    public String getExercicio() {
        return exercicio;
    }

    public void setExercicio(String exercicio) {
        this.exercicio = exercicio;
    }
    
    
    
}
