package exercicio.pratico;
import java.util.Scanner;

public class ContaBanco {
    public int numConta;
    protected String tipoDeConta;
    private String dono;
    private float saldo;
    private boolean contaAberta;
    public float mensalidade = 10;

    Scanner scanner = new Scanner(System.in);

    public ContaBanco(int numConta, String tipoConta, String dono) {
        this.numConta = numConta;
        this.tipoDeConta = tipoDeConta;
        this.dono = dono;
        this.saldo = 0;
        this.contaAberta = false;
    }

    public int getNumConta() {return this.numConta;}
    public void setNumConta(int numConta) {this.numConta = numConta;}

    public String getTipoDeConta() {return this.tipoDeConta;}
    public void setTipoDeConta(String tipoDeConta) {this.tipoDeConta = tipoDeConta;}

    public String getDono() {return this.dono;}
    public void setDono(String dono) {this.dono = dono;}

    public float getSaldo() {return this.saldo;}
    public void setSaldo(float saldo) {this.saldo = saldo;}

    public boolean getStatusConta() {return this.contaAberta;}
    public void setStatusConta(boolean status) {this.contaAberta = contaAberta;}

    public void abrirConta() {
         System.out.println("Que tipo de conta você quer criar? " +
                 "Digite 'CC' para Conta Corrente e 'CP' para Conta Poupança");
         String tipoDeConta = scanner.nextLine();
         if (tipoDeConta == "CP") {
             System.out.println("Parabéns! Abrindo conta poupança você recebe R$ 150,00");
             saldo += 150;
         }

         this.contaAberta = true;}

    public void fecharConta() {this.contaAberta = false;}
    public void depositar(float valor) {this.saldo += valor;}
    public void sacar(float valor) {
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

