package exercicio.pratico;
import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
public class ContaBanco {
    //public String numConta;
    protected String tipoDeConta;
    private String dono;
    private double saldo;
    private boolean contaAberta;
    public float mensalidade = 10;

    Scanner scanner = new Scanner(System.in);
    Scanner doubleScanner = new Scanner(System.in);

    int numeroConta = ThreadLocalRandom.current().nextInt(10000000, 100000000);
    int digitoVerificador = ThreadLocalRandom.current().nextInt(10);
    String numConta = numeroConta + "-" + digitoVerificador;

    public ContaBanco(String dono) {
        //this.numConta = numConta;
        this.tipoDeConta = tipoDeConta;
        this.dono = dono;
        this.saldo = 0;
        this.contaAberta = false;
    }

    public String getNumConta() {return this.numConta;}
    public void setNumConta(String numConta) {this.numConta = numConta;}

    public String getTipoDeConta() {return this.tipoDeConta;}
    public void setTipoDeConta(String tipoDeConta) {this.tipoDeConta = tipoDeConta;}

    public String getDono() {return this.dono;}
    public void setDono(String dono) {this.dono = dono;}

    public double getSaldo() {return this.saldo;}
    public void setSaldo(double saldo) {this.saldo = saldo;}

    public boolean getStatusConta() {return this.contaAberta;}
    public void setStatusConta(boolean status) {this.contaAberta = status;}

    public void abrirConta() {
         System.out.println("Que tipo de conta você quer criar? " +
                 "Digite 'CC' para Conta Corrente e 'CP' para Conta Poupança");
         String tipoDeConta = scanner.nextLine();
         if (!Objects.equals(tipoDeConta, "CP") && !Objects.equals(tipoDeConta, "CC")){
             System.out.println("Opção inválida!");
             return;
         }
         if (tipoDeConta.equals("CP")) {
             System.out.println("Parabéns! Abrindo conta poupança você recebe R$ 150,00");
             saldo += 150;
             System.out.println("Número da sua conta: " + numConta + "\nSaldo: " + saldo);
         } else {
             System.out.println("Parabéns! Abrindo a conta corrente você recebe R$ 50,00");
             saldo += 50;
             System.out.println("Número da sua conta: " + numConta + "\nSaldo: " + saldo);
         }
         this.contaAberta = true;
    }

    public void fecharConta() {
        this.contaAberta = false;
        System.out.println("Conta encerrada com sucesso!");
    }
    public void depositar() {
        if (!this.contaAberta){
            System.out.println("Reative sua conta para prosseguir.");
        } else {
            System.out.println("Qual valor deseja depositar?");
            double valor = doubleScanner.nextDouble();
            this.saldo += valor;
            System.out.println("Depósito feito com sucesso! Seu novo salvo é: " + saldo);
        }
    }

    public void sacar(double valor) {
        if (!this.contaAberta){
            System.out.println("Reative sua conta para prosseguir.");
            return;
        }
        if (valor <= saldo){
            System.out.println("Saque feito com sucesso!");
            saldo -= valor;
            System.out.println("Novo saldo: " + saldo);
        } else{
            System.out.println("Saldo insuficiente!");
        }
    }
    public void pagarMensalidade() {this.saldo -= mensalidade;}
}

