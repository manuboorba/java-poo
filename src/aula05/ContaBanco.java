package aula05;
import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
public class ContaBanco {

    //ATRIBUTOS
    //public String numConta;
    protected String tipoDeConta;
    private String dono;
    private double saldo;
    private boolean contaAberta;
    public int mensalidadeCC = 12;
    public int mensalidadeCP = 20;

    //SCANNERS
    Scanner scanner = new Scanner(System.in);
    Scanner doubleScanner = new Scanner(System.in);

    //GERAR NÚMERO ALEATÓRIO PARA A CONTA
    int numeroConta = ThreadLocalRandom.current().nextInt(10000000, 100000000);
    int digitoVerificador = ThreadLocalRandom.current().nextInt(10);
    String numConta = numeroConta + "-" + digitoVerificador;

    //MÉTODO CONSTRUTOR
    public ContaBanco(String dono) {
        //this.numConta = numConta;
        this.tipoDeConta = tipoDeConta;
        this.dono = dono;
        this.saldo = 0;
        this.contaAberta = false;
    }

    //MÉTODOS GETTERS E SETTERS
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

    //MÉTODOS PERSONALIZADOS
    public void abrirConta() {
         System.out.println("Que tipo de conta você quer criar? " +
                 "Digite 'CC' para Conta Corrente e 'CP' para Conta Poupança");
         String tipoDeConta = scanner.nextLine();
         if (!Objects.equals(tipoDeConta, "CP") && !Objects.equals(tipoDeConta, "CC")){
             System.out.println("Opção inválida!");
             return;
         }
         if (Objects.equals(tipoDeConta, "CP")) {
             System.out.println("Parabéns! Abrindo conta poupança você recebe R$ 150,00");
             setSaldo(getSaldo() + 150);
             System.out.println("Número da sua conta: " + getNumConta() + "\nSaldo: " + getSaldo());
         } else {
             System.out.println("Parabéns! Abrindo a conta corrente você recebe R$ 50,00");
             setSaldo(getSaldo() + 50);
             System.out.println("Número da sua conta: " + getNumConta() + "\nSaldo: " + getSaldo());
         }
         setStatusConta(true);
    }

    public void fecharConta() {
        if(getSaldo() > 0){
            System.out.println("Conta com dinheiro. Retire o valor da conta para poder encerra-la.");
        }else if (getSaldo() < 0){
            System.out.println("Conta com pendências, não foi possível encerra-la.");
        }else {
            setStatusConta(false);
            System.out.println("Conta encerrada com sucesso!");
        }
    }
    public void depositar() {
        if (!getStatusConta()){
            System.out.println("Reative sua conta para prosseguir.");
        } else {
            System.out.println("Qual valor deseja depositar?");
            double valor = doubleScanner.nextDouble();
            setSaldo(getSaldo() + valor);
            System.out.println("Depósito feito com sucesso! Seu novo salvo é: " + getSaldo());
        }
    }

    public void sacar(double valor) {
        if (!this.contaAberta){
            System.out.println("Reative sua conta para prosseguir.");
            return;
        }
        if (valor <= getSaldo()){
            System.out.println("Saque feito com sucesso!");
            setSaldo(getSaldo() - valor);
            System.out.println("Novo saldo: " + getSaldo());
        } else{
            System.out.println("Saldo insuficiente!");
        }
    }
    public void pagarMensalidade() {
        if(!getStatusConta()){
            System.out.println("A conta não existe ou foi encerrada, entre em contato com o suporte para prosseguir.");
            return;
        }
        if(Objects.equals(getTipoDeConta(), "CC") && getSaldo() < mensalidadeCC){
            System.out.println("Saldo insuficiente!");
        }else if(Objects.equals(getTipoDeConta(), "CP") && getSaldo() < mensalidadeCP){
            System.out.println("Saldo insuficiente!");
            return;
        }
        if(Objects.equals(getTipoDeConta(), "CC") && getSaldo() > mensalidadeCC){
            setSaldo(getSaldo() - mensalidadeCC);
            System.out.println("Mensalidade paga com sucesso! \n Novo saldo: " + getSaldo());
        }else{
            setSaldo(getSaldo() - mensalidadeCP);
            System.out.println("Mensalidade paga com sucesso! \n Novo saldo: " + getSaldo());
        }
    }
}

