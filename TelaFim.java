package rpgcommvc;

import java.util.Scanner;

public class TelaFim {

    private Scanner teclado;
    private ControladorEncontro controladorEncontro;
    
    public TelaFim(ControladorEncontro controladorEncontro){
        //this.teclado = new Scanner(System.in);
        this.controladorEncontro = controladorEncontro;
    }
    
    public void mostraTelaFim(){
        System.out.println("O seu herói não foi páreo para os poderosos monstros"
                + " que habitam a masmorra!");
        //System.out.println("Deseja tentar novamente ?");
        //System.out.println("1- TENTAR NOVAMENTE");
        //System.out.println("2- SAIR DO JOGO");
        //int opcao = this.teclado.nextInt();
    }
    
}
