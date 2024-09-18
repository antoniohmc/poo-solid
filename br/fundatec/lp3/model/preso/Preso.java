
package br.fundatec.lp3.model.preso;

public class Preso {

    private String nome;
    private int periculosidade;
    private boolean deficiencia;
    private boolean chefeGang;

    public Preso(String nome, int periculosidade, boolean deficiencia, boolean chefeGang) {
        this.nome = nome;
        this.periculosidade = periculosidade;
        this.deficiencia = deficiencia;
        this.chefeGang = chefeGang;
    }

    public String getNome() {
        return nome;
    }

    public int getPericulosidade() {
        return periculosidade;
    }

    public boolean isDeficiencia() {
        return deficiencia;
    }

    public boolean isChefeGang() {
        return chefeGang;
    }

    @Override
    public String toString() {
        return "Preso " +
                "nome ='" + nome + '\'' + "\n" +
                ", periculosidade=" + periculosidade + "\n" +
                ", deficiencia=" + deficiencia + "\n" +
                ", chefeGang=" + chefeGang + "\n";
    }
}
