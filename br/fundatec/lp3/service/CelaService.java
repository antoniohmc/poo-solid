package br.fundatec.lp3.service;

import br.fundatec.lp3.exeptions.*;
import br.fundatec.lp3.model.cela.Cela;
import br.fundatec.lp3.model.preso.Preso;

import java.util.List;


public class CelaService {

    private final Cela cela;
    private final Preso preso;

    public CelaService(Cela cela, Preso preso) {
        this.cela = cela;
        this.preso = preso;
    }

    public void validarAlocacao() throws Exception {
        validarPresoDeficiente(cela, preso);
        validarChefeDeGang(preso);
        validarPresoComum(preso);
        validarOcupacao(preso, cela);

        alocarPreso();
    }

    public void listaDeCelas(List<Cela> celas) {
        celas.forEach(cela -> System.out.println("Nome: " +
                cela.getNome() +
                ", Tamanho: " + cela.getTamanho() +
                ", Presos: " + cela.getPresosExistentes()));
    }

    private void alocarPreso() {
        validarOcupacao(preso, cela);
    }

    private void validarPresoComum(Preso preso) throws PresoComumExeption {
        if (preso.isChefeGang() && cela.getPresosExistentes().stream().noneMatch(Preso::isChefeGang)) {
            throw new PresoComumExeption("Um preso comum não pode ser alocado com um Chefe de Gang!");
        }
    }

    private void validarChefeDeGang(Preso preso) throws ChefeDeGangExeption {
        if (preso.isChefeGang() && cela.getPresosExistentes().stream().anyMatch(Preso::isChefeGang) && !cela.getPresosExistentes().isEmpty()) {
            throw new ChefeDeGangExeption("Um chefe de gang só pode ser alocado em uma cela vazia");
        }
    }

    private void validarPresoDeficiente(Cela cela, Preso preso) throws DeficenteExeption {
        if (preso.isDeficiencia() && cela.getPresosExistentes().isEmpty()) {
            throw new DeficenteExeption("Um preso com deficiência não pode ser alocado em uma cela vazia!");
        }
    }

    private void validarOcupacao(Preso preso, Cela cela) throws PericulosidadeExeption {

        int somaPericulosidade = cela.getPresosExistentes().stream().
                mapToInt(Preso::getPericulosidade).
                sum();

        int ocupacaoAtual = somaPericulosidade;

        if (ocupacaoAtual + preso.getPericulosidade() < cela.getTamanho()) {

        }
        throw new PericulosidadeExeption("A cela não suporta um preso com essa periculosidade.");
    }
}
