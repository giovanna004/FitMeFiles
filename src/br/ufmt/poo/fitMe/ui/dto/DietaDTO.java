package br.ufmt.poo.fitMe.ui.dto;

import java.util.List;

public class DietaDTO {
    
    private int id;
    private String nome;
    private int usuarioId;
    private List<ItemDietaDTO> itens;

    public DietaDTO(int id, String nome, int usuarioId) {
        this.id = id;
        this.nome = nome;
        this.usuarioId = usuarioId;
    }

    public DietaDTO() {
    }

    public List<ItemDietaDTO> getItens() {
        return itens;
    }

    public void setItens(List<ItemDietaDTO> itens) {
        this.itens = itens;
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


    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }
    
    
    
}
