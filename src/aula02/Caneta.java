package aula02;

public class Caneta {
    String modelo;
    String cor;
    float ponta;
    int carga;
    boolean tampada;

    void mostrarStatus(){
        System.out.print("Essa caneta é modelo: " + this.modelo);
        System.out.print(", a cor é " + this.cor);
        System.out.print(", tem a ponta " + this.ponta);
        System.out.print(", a carga está em " + this.carga + "%");
        System.out.println(" e está tampada? " + this.tampada + " ");
    }

    void rabiscar(){
        if(this.tampada == true){
            System.out.println("Erro! Não posso rabiscar :(");
        } else {
        this.carga --;
        String msg = String.format("""
                rabiscando...
                depois do rabisco a carga agora está em %d%%
                """, carga);
        System.out.println(msg);
        }
    }

    void tampar(){
        this.tampada = true;
    }

    void destampar(){
        this.tampada = false;
    }
}


