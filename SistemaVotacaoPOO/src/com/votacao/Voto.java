package com.votacao;

import java.util.Map;

public abstract class Voto {
    protected int idEleitor;
    protected int idCandidato;

    public Voto(int idEleitor, int idCandidato) {
        this.idEleitor = idEleitor;
        this.idCandidato = idCandidato;
    }

    public abstract void registrarVoto(Map<Integer, Integer> votos);

    public int getIdCandidato() {
        return idCandidato;
    }
}
