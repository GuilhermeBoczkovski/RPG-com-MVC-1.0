package rpg_jaaj;
import java.util.Random;

public class ControladorPrincipal {
    
    private Jogador jogador;
    private ControladorBatalha ctrlBatalha;
    private ControladorFogueira ctrlFogueira;
    private ControladorBau ctrlBau;
    private ControladorBatalhaBoss ctrlBatBoss;
    private TelaInicio telaInicio;
    private TelaFim telaFim;
    
    public ControladorPrincipal(String nome){
        criaJogador(nome);
        ctrlBatalha = new ControladorBatalha(this); 
        ctrlFogueira = new ControladorFogueira(this);
        ctrlBau = new ControladorBau(this);
        ctrlBatBoss = new ControladorBatalhaBoss(this);
        telaInicio = new TelaInicio(this);
        telaFim = new TelaFim(this);

    }

    Jogador getJogador() {
        return this.jogador;
    }

    public void escolheEncontro() {
        Random rand = new Random();
        int escolha = rand.nextInt(3);
        switch(escolha){
            case 0:
                    ctrlBatalha.iniciaEncontro();
                    break;
            case 1: 
                    ctrlFogueira.iniciaEncontro();
                    break;
            case 2: 
                    ctrlBau.iniciaEncontro();
                    break;
        }
        
    }

    public void irParaBoss() {
        ctrlBatBoss.iniciaEncontro();
    }
    
    public void gameOver(){
        telaFim.mostraTelaFim();
    }
    
    public void inicio(){
        telaInicio.mostraTelaInicio();
    }
    
    public void criaJogador(String nome){
        Jogador jogador = new Jogador(nome);
        this.jogador = jogador;
    }
    
}
