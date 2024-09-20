package br.fundatec.lp3.service;

import br.fundatec.lp3.exeptions.*;
import br.fundatec.lp3.model.cela.Cela;
import br.fundatec.lp3.model.preso.Preso;

import java.util.List;

public class CelaService {

    public CelaService() {
    }


    public void alocarPresoNaCela(Cela cela, Preso preso, List<Preso> presosExistentes) throws Exception {

        validarPresoDeficiente(cela, preso);
        validarChefeDeGang(cela, preso);
        validarPresoComum(cela, preso);
        validarOcupacao(cela, preso);


        cela.getPresosExistentes().add(preso);

        int novoTamanho = cela.getTamanho() - preso.getPericulosidade();
        cela.setTamanho(novoTamanho);

        presosExistentes.remove(preso);

        System.out.println("Preso " + preso.getNome() + " alocado na cela " + cela.getNome());
    }

    public List<Boolean> verificarCelasDisponiveis(List<Cela> celas, Preso preso) {
        return celas.stream()
                .map(cela -> {
                    try {

                        validarPresoDeficiente(cela, preso);
                        validarChefeDeGang(cela, preso);
                        validarPresoComum(cela, preso);
                        validarOcupacao(cela, preso);
                        return true;
                    } catch (Exception e) {
                        System.out.println("Erro: " + e.getMessage());
                        return false;
                    }
                }).toList();
    }

    public void listaDeCelas(List<Cela> celas) {
        celas.forEach(cela -> System.out.println("Nome: " +
                cela.getNome() +
                ", Tamanho: " + cela.getTamanho() +
                ", Presos: " + cela.getPresosExistentes()));
    }

    private void validarPresoComum(Cela cela, Preso preso) throws PresoComumExeption {
        if (!preso.isChefeGang() && cela.getPresosExistentes().stream().anyMatch(Preso::isChefeGang)) {
            throw new PresoComumExeption("Um preso comum não pode ser alocado com chefes de gangue");
        }
    }

    private void validarChefeDeGang(Cela cela, Preso preso) throws ChefeDeGangExeption {
        if (preso.isChefeGang() && (cela.getPresosExistentes().stream().noneMatch(Preso::isChefeGang) && !cela.getPresosExistentes().isEmpty())) {
            throw new ChefeDeGangExeption("Um chefe de gangue só pode ser alocado com outros chefes ou em uma cela vazia");
        }
    }

    private void validarPresoDeficiente(Cela cela, Preso preso) throws DeficenteExeption {
        if (preso.isDeficiencia() && cela.getPresosExistentes().isEmpty()) {
            throw new DeficenteExeption("Um preso com deficiência não pode ser alocado em uma cela vazia!");
        }
    }

    private void validarOcupacao(Cela cela, Preso preso) throws PericulosidadeExeption {

        int somaPericulosidade = cela.getPresosExistentes()
                .stream()
                .mapToInt(Preso::getPericulosidade)
                .sum();

        if (somaPericulosidade + preso.getPericulosidade() > cela.getTamanho()) {
            throw new PericulosidadeExeption("A cela não suporta um preso com essa periculosidade.");
        }
    }
}
