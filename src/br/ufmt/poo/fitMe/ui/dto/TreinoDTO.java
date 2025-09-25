package br.ufmt.poo.fitMe.ui.dto;

import java.util.List;

public class TreinoDTO {
   
    private String nome;
    private int usuarioId;
    private List<ItemTreinoDTO> itens;

    public TreinoDTO() {
        
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

    public List<ItemTreinoDTO> getItens() {
        return itens;
    }

    public void setItens(List<ItemTreinoDTO> itens) {
        this.itens = itens;
    }

    
    
    
    
}
