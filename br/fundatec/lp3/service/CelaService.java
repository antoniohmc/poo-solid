package br.fundatec.lp3.service;

import br.fundatec.lp3.model.cela.Cela;
import java.util.List;

public class CelaService {

    public void listaDeCelas(List<Cela> celas) {

        celas.forEach(cela -> System.out.println("Nome: " + cela.getNome() +
                        ", Tamanho: " + cela.getTamanho() +
                        ", Presos: " + cela.getPresosExistentes()));
    }


}
