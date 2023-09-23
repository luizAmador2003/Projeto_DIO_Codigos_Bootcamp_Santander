package usecases.menu;

import java.util.InputMismatchException;
import java.util.Scanner;

import entities.Menu;
import usecases.conta.useCaseCadastrar;
import usecases.conta.useCaseConsultar;

public class MenuInicial {
    public static Scanner scan = new Scanner(System.in);

    public static void menuInicial() {
        boolean finalizado = false;
        while (!finalizado) { // enquanto o usuario não selecionar a opção de finalizar

            System.out.println("Digite uma das opçoes abaixo:");
            for (String value : Menu.getMenu())
                System.out.println(value);
            int opcao;
            try { // verificação e correção da entrada do usuário
                opcao = scan.nextInt();
                if (scan.hasNextLine())
                    scan.nextLine();
            } catch (InputMismatchException e) {
                System.err.println("Por favor, digite uma opção numérica de acordo com o menu");
                continue;
            }
            switch (opcao) {
                case 1:
                    useCaseCadastrar.cadastrar();
                    break;
                case 2:
                    useCaseConsultar.consultar();
                    break;
                case 3:
                    finalizado = true;
                    break;
                default:
                    break;
            }
        }
        scan.close();
    }
}
