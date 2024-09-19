package br.fundatec.lp3.model.cela;

import br.fundatec.lp3.exeptions.ChefeDeGangExeption;
import br.fundatec.lp3.exeptions.DeficenteExeption;
import br.fundatec.lp3.exeptions.PresoComumExeption;
import br.fundatec.lp3.model.preso.Preso;
import br.fundatec.lp3.service.CelaService;

import java.util.List;

public class Cela {

    private final String nome;
    private final int tamanho;
    private final List<Preso> presosExistentes;

    private CelaService celaService;

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

    public void alocarPresoNaCela() throws Exception {
        celaService.validarAlocacao();
    }

    @Override
    public String toString() {
        return "Cela{" +
                "nome='" + nome + '\'' +
                ", tamanho=" + tamanho +
                ", presosExistentes=" + presosExistentes +
                '}';
    }
}
