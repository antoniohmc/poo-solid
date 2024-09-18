package br.fundatec.lp3.factory;

import br.fundatec.lp3.model.cela.Cela;

import java.util.List;

public class CelaFactory {

    public CelaFactory() {

    }

    static List<Cela> criarCela() {

        return List.of(criarCelaA(), criarCelaB(), criarCelaC(), criarCelaD());
    }

    private static Cela criarCelaA() {

        return new Cela("A", 10, List.of());
    }

    private static Cela criarCelaB() {

        return new Cela("B",20, List.of());
    }

    private static Cela criarCelaC() {

        return new Cela("C", 5, List.of());
    }

    private static Cela criarCelaD() {

        return new Cela("D", 7, List.of());
    }

}
