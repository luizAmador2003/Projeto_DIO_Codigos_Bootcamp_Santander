import java.util.Scanner;
import java.util.InputMismatchException;
import ContaTerminal.Menu;

public class Main
{
	public static void main(String[] args) {
	    
		System.out.println("Olá, seja bem vindo a conta bancária");
		Menu.menuInicial(); 
	}
}



class Cadastro {    
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
		    agencia = Menu.scan.nextLine();
		    System.out.print("Digite sua conta: ");
		    numeroConta = Menu.scan.nextInt();   
            Menu.scan.nextLine();         
		    System.out.print("Digite seu nome: ");
            nome = Menu.scan.nextLine();
		    System.out.print("Digite seu saldo (use ',' para decimal): ");
            saldo = Menu.scan.nextDouble();
            if (Menu.scan.hasNextLine()) Menu.scan.nextLine();
            
		    conta = new Conta(numeroConta, agencia, nome, saldo);
		    System.out.println("Cadastro realizado com sucesso! \nAVISO: realizar um novo cadastro excluira esse");
		    controleLaco = false;
		} catch (InputMismatchException e) {
		    System.err.println("Formato inválido, digite seus dados novamente");
		}
		}
    }

    public static void Consultar() {
        if (conta.getNome() == null) 
		    System.out.println("Sem registro");
		else{
            System.out.println("Cadastro atual: "+ conta.toString() + "\n");
            // o trecho abaixo deixa o terminal ocioso, ou seja, ele causa um delay até a próxima instrção
            // ser executada
            try { Thread.sleep (5000); } catch (InterruptedException ex) {}		            
        }
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