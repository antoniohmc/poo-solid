package br.fundatec.lp3.model.cela;

import br.fundatec.lp3.model.preso.Preso;
import br.fundatec.lp3.service.CelaService;

import java.util.ArrayList;
import java.util.List;

public class Cela {

    private String nome;
    private int tamanho;
    private List<Preso> presosExistentes;

    private CelaService celaService;

    public Cela(String nome, int tamanho, List<Preso> presosExistentes) {
        this.nome = nome;
        this.tamanho = tamanho;
        this.presosExistentes = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public List<Preso> getPresosExistentes() {
        return presosExistentes;
    }


    @Override
    public String toString() {
        return "Cela{" + "nome='" + nome + '\'' + ", tamanho=" + tamanho + ", presosExistentes=" + presosExistentes + '}';
    }
}
