package exercicio.pratico;

public class ContaBanco {
    public int numConta;
    protected String tipo;
    private String dono;
    private float saldo;
    private boolean contaAberta;
    public float mensalidade = 10;

    public ContaBanco(int numConta, String tipo, String dono) {
        this.numConta = numConta;
        this.tipo = tipo;
        this.dono = dono;
        this.saldo = 0;
        this.contaAberta = false;
    }

    public int getNumConta() {return this.numConta;}
    public void setNumConta(int numConta) {this.numConta = numConta;}

    public String getTipo() {return this.tipo;}
    public void setTipo(String tipo) {this.tipo = tipo;}

    public String getDono() {return this.dono;}
    public void setDono(String dono) {this.dono = dono;}

    public float getSaldo() {return this.saldo;}
    public void setSaldo(float saldo) {this.saldo = saldo;}

    public boolean getStatusConta() {return this.contaAberta;}
    public void setStatusConta(boolean status) {this.contaAberta = contaAberta;}

    public void abrirConta() {this.contaAberta = true;}
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

