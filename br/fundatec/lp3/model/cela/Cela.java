package br.fundatec.lp3.model.cela;

import br.fundatec.lp3.model.preso.Preso;

import java.util.List;

public class Cela {

    private final String nome;
    private final int tamanho;
    private final List<Preso> presosExistentes;

    public Cela(String nome, int tamanho, List<Preso> presos) {
        this.nome = nome;
        this.tamanho = tamanho;
        this.presosExistentes = presos;
    }

    public String getNome() {
        return nome;
    }

    public int getTamanho() {
        return tamanho;
    }

    public List<Preso> getPresosExistentes() {
        return presosExistentes;
    }


    private void validarChefeDeGang(Preso preso) {

        if ((preso.isChefeGang() && presosExistentes.stream().anyMatch(Preso::isChefeGang)) || presosExistentes.isEmpty()) {

        }


    }

    private void validarPresoDeficiente(List<Cela> celas, Preso preso) {

        if (preso.isDeficiencia() && celas.isEmpty()) {
            System.out.println("Um preso com deficiência nao pode ser alocado em uma cela sozinho!");
        }

        System.out.println("Preso alocado!");
    }

    private boolean validarOcupacao (Preso preso, Cela cela) {

        return preso.getPericulosidade() >= cela.getTamanho();
    }


}
