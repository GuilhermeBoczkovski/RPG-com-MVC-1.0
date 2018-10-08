package rpgcommvc;

import java.util.Scanner;

public class TelaInicio {
    
    private String nome;
    private Scanner teclado;
    private ControladorEncontro controladorEncontro;
    
    public TelaInicio(ControladorEncontro controladorEncontro){
        this.teclado = new Scanner(System.in);
        this.controladorEncontro = controladorEncontro;
    }
    
    public void mostraInicio(){
        System.out.println("Seja Bem Vindo, Herói");
        System.out.println("Você é um feiticeiro, estudou por anos na escola "
                + "de magia e agora chegou a hora de colocar seus conhecimentos"
                + " em prática. Primeiramente, qual o seu nome?");
        this.nome = this.teclado.nextLine();
        this.controladorEncontro.criaJogador(this.nome);
        System.out.println("Aqui começa a aventura de " + this.nome + "! Está "
                + "preparado? [ENTER]");
        this.teclado.nextLine();
        this.controladorEncontro.escolheEncontro();
    }
    
}
