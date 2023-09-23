package usecases.conta;

import java.util.InputMismatchException;
import java.util.Scanner;

import entities.Conta;
import usecases.menu.MenuInicial;

public class useCaseCadastrar {
	public static Conta conta = new Conta();
    
	public static Conta getConta() {
        return conta;
    }
    
	public static void cadastrar() {
        Scanner scan = new Scanner (System.in);
		int numeroConta;
        String agencia;
        String nome;
        double saldo;
        
        boolean controleLaco = true;
		while (controleLaco) {
		try {
            System.out.print("Digite sua agência: ");            
		    agencia = MenuInicial.scan.nextLine();
		    System.out.print("Digite sua conta: ");
		    numeroConta = MenuInicial.scan.nextInt();   
            MenuInicial.scan.nextLine();         
		    System.out.print("Digite seu nome: ");
            nome = MenuInicial.scan.nextLine();
		    System.out.print("Digite seu saldo (use ',' para decimal): ");
            saldo = MenuInicial.scan.nextDouble();
            if (MenuInicial.scan.hasNextLine()) MenuInicial.scan.nextLine();
		    conta = new Conta(numeroConta, agencia, nome, saldo);
		    System.out.println("Cadastro realizado com sucesso! \nAVISO: realizar um novo cadastro excluira esse");
		    controleLaco = false;
		} catch (InputMismatchException e) {
			System.err.println("Formato inválido, digite seus dados novamente");
		}
	}
	scan.close();
    }
}
