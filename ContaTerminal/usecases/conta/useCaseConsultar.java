package usecases.conta;

import entities.Conta;

public class useCaseConsultar {
    public static Conta conta = new Conta();

    public static Conta getConta() {
        return conta;
    }

    public static void consultar() {
        if (conta.getNome() == null) 
		    System.out.println("Sem registro");
		else{
            System.out.println("Cadastro atual: "+ conta.toString() + "\n");
            // o trecho abaixo deixa o terminal ocioso, ou seja, ele causa um delay até a próxima instrução
            // ser executada
            try { Thread.sleep (5000); } catch (InterruptedException ex) {}		            
        }
    }
}
