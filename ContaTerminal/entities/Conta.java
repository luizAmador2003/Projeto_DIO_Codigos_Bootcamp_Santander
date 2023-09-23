package entities;

public class Conta {
    private Integer conta;
    private String agencia;
    private String nome;
    private Double saldo;
    
    public Conta() {
        conta = null;
        agencia = null;
        nome = null;
        saldo = null;
    }
    
    public Conta (Integer numeroConta, String agenc, String nomeConta, Double valor) {
        conta = numeroConta;
        agencia = agenc;
        nome = nomeConta;
        saldo = valor;
    }
    
    public Integer getNumeroConta() {
        return conta;
    }
    
    public void setNumeroConta(Integer numeroConta) {
        conta = numeroConta;
    }
    
    public String getAgencia() {
        return agencia;
    }
    
    public void setAgencia(String agenc) {
        agencia = agenc;
    }
    
    public String getNome(){
        return nome;
    }
    
    public void setNome(String nomeConta) {
        nome = nomeConta;
    }
    
    public Double getSaldo(){
        return saldo;
    }
    
    public void setSaldo(Double valor){
        saldo = valor;
    }
    
    @Override
    public String toString() {
        return String.format("Conta: %d \nAgencia: %s \nCliente: %s \nSaldo: %.2f ", conta, agencia, nome, saldo);
    }
}