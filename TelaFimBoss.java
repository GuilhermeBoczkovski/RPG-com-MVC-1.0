package rpgcommvc;

import java.util.Scanner;

public class TelaFimBoss {
    
    private Scanner teclado;
    private ControladorPrincipal controladorPrincipal;
    
    public TelaFimBoss(ControladorPrincipal controladorPrincipal){
        //this.teclado = new Scanner(System.in);
        this.controladorPrincipal = controladorPrincipal;
    }
    
    public void mostraTelaFim(boolean venceu){
        if(venceu){
            System.out.println("PARABÉNS!!");
            System.out.println("Você derrotou o Monstro mais poderoso e "
                    + "completou a masmorra!");
            System.out.println("Você é mesmo um herói e sua história será "
                    + "contada por gerações!!");
        }else{
            System.out.println("O seu herói não foi páreo para o monstro mais "
                    + "poderoso dessa masmorra.");
            System.out.println("Histórias serão contadas sobre o seu sacrifício!");
        //System.out.println("Deseja tentar novamente ?");
        //System.out.println("1- TENTAR NOVAMENTE");
        //System.out.println("2- SAIR DO JOGO");
        //int opcao = this.teclado.nextInt();
        }
    }
}
