package br.fundatec.lp3.factory;

import br.fundatec.lp3.model.preso.Preso;

import java.util.List;

public class PresoFactory {

    public PresoFactory() {

    }

    static List<Preso> identificarPreso() {

        return List.of(presoZ(), presoY(), presoX(), presoM(), presoK(), presoL(), presoO());
    }

    private static Preso presoZ() {

        return new Preso("Z", 5, false, false);
    }

    private static Preso presoY() {

        return new Preso("Y", 10, false, false);
    }

    private static Preso presoX() {

        return new Preso("X", 3, true, false);
    }

    private static Preso presoM() {

        return new Preso("M", 1, true, false);
    }

    private static Preso presoK() {

        return new Preso("K", 5, false, false);
    }

    private static Preso presoL() {

        return new Preso("L", 10, false, true);
    }

    private static Preso presoO() {

        return new Preso("O", 5, false, true);
    }


}