package aula02;

public class Caneta {
    public String modelo;
    public String cor;
    private float ponta;
    protected int carga;
    private boolean tampada;

    void mostrarStatus(){
        System.out.print("Essa caneta é modelo: " + this.modelo);
        System.out.print(", a cor é " + this.cor);
        System.out.print(", tem a ponta " + this.ponta);
        System.out.print(", a carga está em " + this.carga + "%");
        System.out.println(" e está tampada? " + this.tampada + " ");
    }

   public void rabiscar(){
        if(this.tampada == true){
            System.out.println("Erro! Não posso rabiscar, pois a caneta está tampada :(");
        } else {
        this.carga --;
        String msg = String.format("""
                rabiscando...
                depois do rabisco a carga agora está em %d%%
                """, carga);
        System.out.println(msg);
        }
    }

   public void tampar(){  //métodos públicos dão acesso ao atributo privado (tampada)

        this.tampada = true;
    }

   public void destampar(){

        this.tampada = false;
    }
}


