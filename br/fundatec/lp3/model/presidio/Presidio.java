package br.fundatec.lp3.model.presidio;

import br.fundatec.lp3.model.cela.Cela;

import java.util.List;

public class Presidio {

    private final List<Cela> celas;

    public Presidio(List<Cela> celas) {
        this.celas = celas;
    }

    public List<Cela> getCelas() {
        return celas;
    }


}
