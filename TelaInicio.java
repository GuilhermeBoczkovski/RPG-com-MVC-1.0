package rpgcommvc;

import java.util.Scanner;

public class TelaInicio {
    
    private String nome;
    private Scanner teclado;
    private ControladorGeral controladorGeral;
    
    public TelaInicio(ControladorGeral controladorGeral){
        this.teclado = new Scanner(System.in);
        this.controladorGeral = controladorGeral;
    }
    
    public void mostraTelaInicio(){
        System.out.println("Seja Bem Vindo, Herói");
        System.out.println("Você é um feiticeiro, estudou por anos na escola "
                + "de magia e agora chegou a hora de colocar seus conhecimentos"
                + " em prática. Primeiramente, qual o seu nome?");
        this.nome = this.teclado.nextLine();
        System.out.println("Aqui começa a aventura de " + this.nome + "! Está "
                + "preparado? [ENTER]");
        this.teclado.nextLine();
        this.controladorGeral.play(nome);
    }
    
}
