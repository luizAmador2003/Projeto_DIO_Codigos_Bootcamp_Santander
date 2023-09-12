package ContaTerminal;

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
