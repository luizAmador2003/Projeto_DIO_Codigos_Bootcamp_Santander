package ContaTerminal;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private static String[] menu = {"1 - Cadastrar", "2 - Consultar", "3 - Finalizar"};    
    public static Scanner scan = new Scanner(System.in);
    public static void menuInicial (){
        
        
        boolean finalizado = false;                
		while (!finalizado) { // enquanto o usuario não selecionar a opção de finalizar
            
            System.out.println("Digite uma das opçoes abaixo:");
            for (String value : menu)
                System.out.println(value);	    
		    int opcao;
		    try { // verificação e correção da entrada do usuário
                opcao = scan.nextInt();
                if (scan.hasNextLine()) scan.nextLine();
		    } catch(InputMismatchException e) {
		        System.err.println("Por favor, digite uma opção numérica de acordo com o menu");
		        continue;
		    }		    
		    switch (opcao) {
		        case 1:
		            Cadastro.cadastrar(); 
		            break;
		        case 2:
		            Cadastro.Consultar();
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