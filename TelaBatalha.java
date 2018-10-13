package rpgcommvc;

import java.util.ArrayList;
import java.util.Scanner;

public class TelaBatalha extends TelaEncontro{
    
    private ControladorBatalha controladorBatalha;
    private Scanner teclado;
    
    public TelaBatalha(ControladorBatalha controladorBatalha){
        this.teclado = new Scanner(System.in);
        this.controladorBatalha = controladorBatalha;
    }
    
    public void mostraMenuBatalha(){
        System.out.println("=============================");
        System.out.println("Qual a sua próxima ação?");
        System.out.println("1- Atacar Monstro (escolher feitiço)");
        System.out.println("2- Analizar Monstro");
        System.out.println("3- Ver Feitiços");
        System.out.println("4- Ver Itens");
        System.out.println("5- Usar Item");
        System.out.println("6- Meus Atributos");
        int opcao = teclado.nextInt();
        this.controladorBatalha.executaOpcao(opcao);
    }
    
    public void mostraAtaque(ConteudoTelaBatalha conteudoTelaAtaqueJogador, ConteudoTelaBatalha conteudoTelaAtaqueMonstro){
        System.out.println(conteudoTelaAtaqueJogador.atacante.getNome() + " ataca " + conteudoTelaAtaqueJogador.atacado.getNome() + " com " + conteudoTelaAtaqueJogador.feitico.getNome());
        System.out.println("Dano causado: " + conteudoTelaAtaqueJogador.danoAtaque);
        System.out.println("A vida do " + conteudoTelaAtaqueJogador.atacado.getNome() + " é: " + conteudoTelaAtaqueJogador.atacado.getVidaAtual() + "/" + conteudoTelaAtaqueJogador.atacado.getVidaTotal());
        System.out.println(conteudoTelaAtaqueMonstro.atacante.getNome() + " ataca " + conteudoTelaAtaqueMonstro.atacado.getNome());
        System.out.println("Dano causado: " + conteudoTelaAtaqueMonstro.danoAtaque);
        System.out.println("A vida do " + conteudoTelaAtaqueMonstro.atacado.getNome() + " é: " + conteudoTelaAtaqueMonstro.atacado.getVidaAtual() + "/" + conteudoTelaAtaqueMonstro.atacado.getVidaTotal());
        if(conteudoTelaAtaqueMonstro.atacado.getVidaAtual()>0){
            this.mostraMenuBatalha();
        }else{
            this.controladorBatalha.gameOver();
        }        
    }
    
    public void mostraFimBatalha(ConteudoTelaBatalha conteudoTela){
        System.out.println("O herói defere um último feitiço de misericórdia no monstro!");
        System.out.println("Dano causado: " + conteudoTela.danoAtaque);
        System.out.println("O poderoso " + conteudoTela.atacado.getNome() + " finalmente cai ao chão!");
        System.out.println("Você então segue seu caminho...");
        System.out.println("");
    }

    public void mostraAnalise(ConteudoTelaBatalha monstro){
        System.out.println("--ANÁLISE DO MONSTRO--");
        System.out.println("VIDA: " + monstro.monstro.getVidaAtual() + "/" +
                monstro.monstro.getVidaTotal());
        System.out.println("ELEMENTO: " + monstro.monstro.getTipoElemento());
        System.out.println("FORÇA: " + monstro.monstro.getForca());
        System.out.println("ESQUIVA: " + monstro.monstro.getEsquiva() + "%");
        this.mostraMenuBatalha();
    }

    public void mostraItens(ArrayList<ConteudoTelaBatalha> conteudoTelaS, ConteudoTelaBatalha conteudoTela){
        System.out.println("=============================");
        if(conteudoTelaS.size()>0){
            System.out.println("Os Consumíveis são:");
            for(int i = 0; i < conteudoTelaS.size(); i++){
                System.out.println("Índice:        " + i);
                System.out.println("Nome:          " + conteudoTelaS.get(i).consumivel.getNome());
                System.out.println("Ação:          " + conteudoTelaS.get(i).consumivel.getAcao());
                System.out.println("Valor da ação: +" + conteudoTelaS.get(i).consumivel.getValorAcao());
            }
        }else{
            System.out.println("Você não possui consumiveis");
        }
        System.out.println("Sua arma é: ");
        System.out.println("Nome: " + conteudoTela.arma.getNome());
        System.out.println("Dano: +" + conteudoTela.arma.getDano());
        this.mostraMenuBatalha();
    }

    public void mostraFeiticos(ArrayList<ConteudoTelaBatalha> conteudoTelaS){
        System.out.println("=============================");
        System.out.println("Os Feitiços são:");
        for(int i = 0; i < conteudoTelaS.size(); i++){
            System.out.println("Índice:   " + conteudoTelaS.get(i).feitico.getIndice());
            System.out.println("Nome:     " + conteudoTelaS.get(i).feitico.getNome());
            System.out.println("Dano:     " + conteudoTelaS.get(i).feitico.getDano());
            System.out.println("Elemento: " + conteudoTelaS.get(i).feitico.getTipoElemento());
        }
        this.mostraMenuBatalha();
    }

    public void mostraMenuFeitico(){
        System.out.println("=============================");
        System.out.println("Escolha o tipo de feitico para ver:");
        System.out.println("1 - FOGO");
        System.out.println("2 - AGUA");
        System.out.println("3 - GRAMA");
        System.out.println("4 - PEDRA");
        int opcao = teclado.nextInt();
        teclado.nextLine();
        ConteudoTelaBatalha conteudoTela = new ConteudoTelaBatalha();
        conteudoTela.tipoInt = opcao;
        this.controladorBatalha.verFeiticos(conteudoTela);
    }

    public void mostraMenuAtaque(){
        System.out.println("=============================");
        System.out.println("Qual feitiço gostaria de usar?");
        System.out.println("(digite o indice do feitiço)");
        int indiceFeitico = teclado.nextInt();
        ConteudoTelaBatalha conteudoTela = new ConteudoTelaBatalha();
        conteudoTela.indiceFeitico = indiceFeitico;
        this.controladorBatalha.atacar(conteudoTela);
    }
    
    public void mostraMenuItens(){
        System.out.println("=============================");
        System.out.println("Qual item gostaria de usar?");
        System.out.println("(digite o indice do item)");
        int indiceItem = teclado.nextInt();
        ConteudoTelaBatalha conteudoTela = new ConteudoTelaBatalha();
        conteudoTela.indiceItem = indiceItem;
        this.controladorBatalha.usarItem(indiceItem);
    }
    
    public void mostraMeusAtributos(Jogador jogador){
        System.out.println("--ATRIBUTOS DO JOGADOR--");
        System.out.println("NIVEL: " + jogador.getNivelInt());
        System.out.println("VIDA: " + jogador.getVidaAtual() + "/" + jogador.getVidaTotal());
        System.out.println("ESQUIVA: " + jogador.getEsquiva() + "%");
        this.mostraMenuBatalha();
    }

    void mostraInicioBatalha() {
        System.out.println("");
        System.out.println("Você entra numa sala escura...");
        System.out.println("Começa a entrar mais afundo na sala quando de repente");
        System.out.println("um monstro do tamanho de dois homens aparece na sua frente!!");
        System.out.println("Imediatamente você pega seu cajado e se prepara para a batalha");
        this.mostraMenuBatalha();
    }
}
