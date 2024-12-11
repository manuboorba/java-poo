package aula05;

public class Conta01 {
    public static void main(String[] args) {
        ContaBanco c1 = new ContaBanco("Gabriel");
        c1.abrirConta();
        c1.depositar();
        c1.sacar(300);
        c1.pagarMensalidade();

    }
}
