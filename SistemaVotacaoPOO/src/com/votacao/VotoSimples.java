package com.votacao;

import java.util.Map;

public class VotoSimples extends Voto {
    public VotoSimples(int idEleitor, int idCandidato) {
        super(idEleitor, idCandidato);
    }

    @Override
    public void registrarVoto(Map<Integer, Integer> votos) {
        votos.put(idCandidato, votos.getOrDefault(idCandidato, 0) + 1);
    }
}
