package br.ufmt.poo.fitMe.persistencia.entidade;


public class ItemTreino {
    
    private int id;
    private int series;
    private int repeticoes;
    private int descanso;
    private int treinoId;
    private int exercicioId;
    private boolean concluido;
    private String exercicio;

    public ItemTreino(int id, int series, int repeticoes, int descanso, int treinoId, int exercicioId, boolean concluido, String exercicio) {
        this.id = id;
        this.series = series;
        this.repeticoes = repeticoes;
        this.descanso = descanso;
        this.treinoId = treinoId;
        this.exercicioId = exercicioId;
        this.concluido = concluido;
        this.exercicio = exercicio;
    }

    public ItemTreino() {
        
    }

    public String getNomeExercicio() {
        return exercicio;
    }

    public void setExercicio(String exercicio) {
        this.exercicio = exercicio;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getTreinoId() {
        return treinoId;
    }

    public void setTreinoId(int treinoId) {
        this.treinoId = treinoId;
    }

    public int getExercicioId() {
        return exercicioId;
    }

    public void setExercicioId(int exercicioId) {
        this.exercicioId = exercicioId;
    }

    public boolean isConcluido() {
        return concluido;
    }

    public void setConcluido(boolean concluido) {
        this.concluido = concluido;
    }
    
    
    
}
