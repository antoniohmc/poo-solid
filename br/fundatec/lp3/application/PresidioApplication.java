package br.fundatec.lp3.application;

import br.fundatec.lp3.exeptions.ChefeDeGangExeption;
import br.fundatec.lp3.exeptions.DeficenteExeption;
import br.fundatec.lp3.exeptions.PericulosidadeExeption;
import br.fundatec.lp3.exeptions.PresoComumExeption;
import br.fundatec.lp3.factory.CelaFactory;
import br.fundatec.lp3.factory.PresidioFactory;
import br.fundatec.lp3.factory.PresoFactory;
import br.fundatec.lp3.model.cela.Cela;
import br.fundatec.lp3.model.presidio.Presidio;
import br.fundatec.lp3.model.preso.Preso;
import br.fundatec.lp3.service.CelaService;

import java.util.List;
import java.util.Scanner;

public class PresidioApplication {

    public static void main(String[] args) {
        CelaService celaService = new CelaService();
        List<Preso> presosDisponiveis = PresoFactory.identificarPreso();
        List<Cela> celas = CelaFactory.criarCela();

        while (true) {
            try {
                var scanner = new Scanner(System.in);

                System.out.println("Presos disponíveis: ");
                for (int i = 0; i < presosDisponiveis.size(); i++) {
                    System.out.println((i + 1) + ". " + presosDisponiveis.get(i).getNome());
                }
                System.out.print("Escolha um preso pelo número: ");
                int presoIndex = scanner.nextInt() - 1;
                Preso presoSelecionado = presosDisponiveis.get(presoIndex);


                List<Boolean> celasDisponiveis = celaService.verificarCelasDisponiveis(celas, presoSelecionado);
                System.out.println("Escolha a cela para alocar o preso " + presoSelecionado.getNome() + ":");
                for (int i = 0; i < celas.size(); i++) {
                    System.out.println((i + 1) + ". Cela " + celas.get(i).getNome() + " (" +
                            (celasDisponiveis.get(i) ? "Disponível" : "Indisponível") + ")");
                }
                System.out.print("Escolha uma cela pelo número: ");
                int celaIndex = scanner.nextInt() - 1;
                Cela celaSelecionada = celas.get(celaIndex);

                celaService.alocarPresoNaCela(celaSelecionada, presoSelecionado, presosDisponiveis);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}