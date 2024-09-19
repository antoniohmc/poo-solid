package br.fundatec.lp3.factory;

import br.fundatec.lp3.model.preso.Preso;

import java.util.ArrayList;
import java.util.List;

public class PresoFactory {

    private static final List<Preso> listaDePresos = new ArrayList<>();

    public PresoFactory() {

    }

    static List<Preso> identificarPreso() {

        listaDePresos.add(new Preso("Z", 5, false, false));
        listaDePresos.add(new Preso("Y", 10, false, false));
        listaDePresos.add(new Preso("X", 3, false, false));
        listaDePresos.add(new Preso("M", 1, true, false));
        listaDePresos.add(new Preso("K", 5, false, false));
        listaDePresos.add(new Preso("L", 10, false, true));
        listaDePresos.add(new Preso("O", 5, false, true));

        return listaDePresos;
    }
}