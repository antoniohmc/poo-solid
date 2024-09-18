package br.fundatec.lp3.factory;

import br.fundatec.lp3.model.presidio.Presidio;

public class PresidioFactory {

    public PresidioFactory() {

    }

    public static Presidio criar() {

        return new Presidio(CelaFactory.criarCela());
    }
}
