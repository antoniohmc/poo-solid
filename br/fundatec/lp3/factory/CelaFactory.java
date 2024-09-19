package br.fundatec.lp3.factory;

import br.fundatec.lp3.model.cela.Cela;

import java.util.ArrayList;
import java.util.List;

public class CelaFactory {

    private static final List<Cela> celas = new ArrayList<>();

    public CelaFactory() {

    }

    static List<Cela> criarCela() {

        celas.add(new Cela("A", 10, List.of()));
        celas.add(new Cela("B", 20, List.of()));
        celas.add(new Cela("C", 5, List.of()));
        celas.add(new Cela("D", 7, List.of()));

        return celas;
    }

}
