import java.util.Scanner;

public class Contador {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int par1 = scan.nextInt();
        int par2 = scan.nextInt();

        try {
            Contar.contar(par1, par2);
        } catch(ParametrosInvalidosException e) {
            System.out.println("O segundo parametro deve ser maior que o primeiro");
        }
        scan.close();
    }
}

class Contar {
    public static void contar(int parametro1, int parametro2) throws ParametrosInvalidosException{

        if (parametro2 < parametro1) {
            throw new ParametrosInvalidosException();
        }

        int contagem = parametro2 - parametro1;

        for (int i = 1; i <= contagem; i++) {
            System.out.print(i + " ");
        }
    }
}

class ParametrosInvalidosException extends Exception {}