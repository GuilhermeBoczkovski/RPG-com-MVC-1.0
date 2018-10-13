package rpgcommvc;

import java.util.ArrayList;
import java.util.Scanner;

public class TelaBatalhaBoss {

    private ControladorBatalhaBoss controladorBatalhaBoss;
    private Scanner teclado;
    
    public TelaBatalhaBoss(ControladorBatalhaBoss controladorBatalhaBoss){
        this.teclado = new Scanner(System.in);
        this.controladorBatalhaBoss = controladorBatalhaBoss;
    }
    
    public void mostraMenuBatalha(){
        System.out.println("Qual a sua próxima ação?");
        System.out.println("1- Atacar Demogorgon (escolher feitiço)");
        System.out.println("2- Analizar Demogorgon");
        System.out.println("3- Ver Feitiços");
        System.out.println("4- Ver Itens");
        System.out.println("5- Usar Item");
        int opcao = teclado.nextInt();
        this.controladorBatalhaBoss.executaOpcao(opcao);
    }
    
    public void mostraAtaque(ConteudoTelaBatalha conteudoTela){
        System.out.println(conteudoTela.atacante.getNome() + " ataca " + conteudoTela.atacado.getNome());
        System.out.println("Dano causado: " + conteudoTela.danoAtaque);
        System.out.println("A vida do " + conteudoTela.atacado.getNome() + " é: " + conteudoTela.atacado.getVidaAtual() + "/" + conteudoTela.atacado.getVidaTotal());
        System.out.println("continuar... [ENTER]");
        this.teclado.nextLine();
        this.mostraMenuBatalha();
    }
    
    public void mostraFimBatalha(ConteudoTelaBatalha conteudoTela){
        System.out.println("O herói defere um último feitiço matando de uma vez por todas o Demogorgon!");
        System.out.println("Dano causado: " + conteudoTela.danoAtaque);
        System.out.println("O poderoso Demogorgon, mostro que aterrorizou por décadas todo o reino, finalmente cai ao chão!");
        System.out.println("continuar... [ENTER]");
        this.teclado.nextLine();
        this.controladorBatalhaBoss.gameOver();
    }

    public void mostraAnalise(ConteudoTelaBatalha monstro){
        System.out.println("--ANÁLISE DO MONSTRO--");
        System.out.println("VIDA: " + monstro.monstro.getVidaAtual() + "/" +
                monstro.monstro.getVidaTotal());
        System.out.println("ELEMENTO: " + monstro.monstro.getTipoElemento());
        System.out.println("FORÇA: " + monstro.monstro.getForca());
        System.out.println("ESQUIVA: " + monstro.monstro.getEsquiva());
        System.out.println("continuar... [ENTER]");
        this.teclado.nextLine();
        this.mostraMenuBatalha();
    }

    public void mostraItens(ArrayList<ConteudoTelaBatalha> conteudoTelaS, ConteudoTelaBatalha conteudoTela){
        System.out.println("Os Consumíveis são:");
        for(int i = 0; i < conteudoTelaS.size(); i++){
            System.out.println("Índice:        " + i);
            System.out.println("Nome:          " + conteudoTelaS.get(i).consumivel.getNome());
        }
        System.out.println("Sua arma é: ");
        System.out.println("Nome: " + conteudoTela.arma.getNome());
        System.out.println("Dano: +" + conteudoTela.arma.getDano());
        this.mostraMenuBatalha();
    }

    public void mostraFeiticos(ArrayList<ConteudoTelaBatalha> conteudoTelaS){
        System.out.println("Os Feitiços são:");
        for(int i = 0; i < conteudoTelaS.size(); i++){
            System.out.println("Índice:   " + i);
            System.out.println("Nome:     " + conteudoTelaS.get(i).feitico.getNome());
            System.out.println("Dano:     " + conteudoTelaS.get(i).feitico.getDano());
            System.out.println("Elemento: " + conteudoTelaS.get(i).feitico.getTipoElemento());
        }
        this.mostraMenuBatalha();
    }

    public void mostraMenuFeitico(){
        System.out.println("1- Feitiços elemento FOGO");
        System.out.println("2- Feitiços elemento ÁGUA");
        System.out.println("3- Feitiços elemento GRAMA");
        System.out.println("4- Feitiços elemento PEDRA");
        int opcao = teclado.nextInt();
        ConteudoTelaBatalha tipoInt = new ConteudoTelaBatalha();
        tipoInt.tipoInt = opcao;
        this.controladorBatalhaBoss.verFeiticos(tipoInt);
    }

    public void mostraMenuAtaque(){
        System.out.println("Qual feitiço gostaria de usar?");
        System.out.println("(digite o indice do feitiço)");
        int indiceFeitico = teclado.nextInt();
        ConteudoTelaBatalha conteudoTela = new ConteudoTelaBatalha();
        conteudoTela.indiceFeitico = indiceFeitico;
        this.controladorBatalhaBoss.atacar(conteudoTela);
    }
    
}
