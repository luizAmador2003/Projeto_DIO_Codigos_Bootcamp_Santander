import java.util.Scanner;
import java.util.InputMismatchException;

public class Main
{
	public static void main(String[] args) {
	    Scanner scan = new Scanner(System.in);
		System.out.println("Olá, seja bem vindo a sua conta bancária");
		String[] menu = {"1 - Cadastrar", "2 - Consultar", "3 - Finalizar"};
		boolean finalizado = false;
		int numeroConta;
        String agencia;
        String nome;
        double saldo;
        
        Conta conta = new Conta();
        
		while (!finalizado) { // enquanto o usuario não selecionar a opção de finalizar
		    Menu.menuInicial(menu);
		    int opcao;
		    try { // verificação e correção da entrada do usuário
		        opcao = scan.nextInt();
		    } catch(InputMismatchException e) {
		        System.err.println("Por favor, digite uma opção numérica de acordo com o menu");
		        continue;
		    }
		    
		    switch (opcao) {
		        case 1:
		            boolean controleLaco = true;
		            while (controleLaco) {
		            try {
		                System.out.print("Digite sua agência: ");
		                agencia = scan.next();
		                System.out.print("Digite sua conta: ");
		                numeroConta = scan.nextInt();
		                System.out.print("Digite seu nome: ");
		                scan.nextLine(); // limpa o buffer
		                nome = scan.nextLine();
		                System.out.print("Digite seu saldo: ");
		                saldo = scan.nextDouble();
		                
		                conta = new Conta(numeroConta, agencia, nome, saldo);
		                System.out.println("Cadastro realizado com sucesso! \nAVISO: realizar um novo cadastro excluira esse");
		                controleLaco = false;
		            } catch (InputMismatchException e) {
		                System.err.println("Formato inválido, digite seus dados novamente");
		            }
		            }   
		            break;
		        case 2:
		            if (conta.getNome() == null) 
		                System.out.println("Sem registro");
		            else
		                System.out.println(conta.toString());
		            break;
		        case 3:
		            finalizado = true;
		            break;
		        default:
		            break;
		    }
		}
	}
}

class Menu {
    public static void menuInicial (String[] menu){
        System.out.println("Digite uma das opçoes abaixo:");
        for (String value : menu)
            System.out.println(value);
    }
}

class Conta {
    private Integer numeroConta;
    private String agencia;
    private String nome;
    private Double saldo;
    
    public Conta() {
        this.numeroConta = null;
        this.agencia = null;
        this.nome = null;
        this.saldo = null;
    }
    
    public Conta (Integer conta, String agencia, String nome, Double saldo) {
        this.numeroConta = conta;
        this.agencia = agencia;
        this.nome = nome;
        this.saldo = saldo;
    }
    
    public Integer getNumeroConta() {
        return this.numeroConta;
    }
    
    public void setNumeroConta(Integer numeroConta) {
        this.numeroConta = numeroConta;
    }
    
    public String getAgencia() {
        return this.agencia;
    }
    
    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public Double getSaldo(){
        return this.saldo;
    }
    
    public void setSaldo(Double saldo){
        this.saldo = saldo;
    }
    
    @Override
    public String toString() {
        return String.format("Conta: %d \nAgencia: %s \nCliente: %s \nSaldo: %.2f ", numeroConta, agencia, nome, saldo);
    }
}