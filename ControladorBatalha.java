package rpgcommvc;

import java.util.ArrayList;

class ControladorBatalha {
    
    private ControladorEncontro controladorEncontro;
    private Monstro monstro;
    private TelaBatalha telaBatalha;

    public ControladorBatalha(ControladorEncontro controladorEncontro) {
        this.controladorEncontro = controladorEncontro;
        
        this.monstro = new Monstro(this.controladorEncontro.getJogador().getNivel(), tipoElemento);
        
    }
    
    public void atacar(ConteudoTelaBatalha conteudoTela){
        ConteudoTelaBatalha conteudoTelaAtaqueJogador = new ConteudoTelaBatalha();
        Feitico feitico = this.controladorEncontro.getJogador().getFeitico(conteudoTelaAtaqueJogador.indiceFeitico());
        conteudoTelaAtaqueJogador.feitico = feitico;
        int danoDoJogador = feitico.getDano();
        danoDoJogador += this.controladorEncontro.getJogador().getArma().getDano();
        TipoElemento elementoFeitico = feitico.getTipoElemento();
        TipoElemento elementoMonstro = this.monstro.getTipoElemento();
        if(!(elementoMonstro.equals(elementoFeitico))){
            if((elementoMonstro.equals(TipoElemento.FOGO) && elementoFeitico.equals(TipoElemento.AGUA)) || (elementoMonstro.equals(TipoElemento.AGUA) && elementoFeitico.equals(TipoElemento.GRAMA)) || (elementoMonstro.equals(TipoElemento.GRAMA) && elementoFeitico.equals(TipoElemento.FOGO))){
                danoDoJogador = (int)(danoDoJogador*1.15);
            }else{
                danoDoJogador = (int)(danoDoJogador*0.85);
            }
        }
        conteudoTelaAtaqueJogador.danoAtaque = danoDoJogador;
        conteudoTelaAtaqueJogador.atacante = this.controladorEncontro.getJogador();
        conteudoTelaAtaqueJogador.atacado = this.monstro;
        this.monstro.setVidaAtual(this.monstro.getVidaAtual()-danoDoJogador);
        if(this.monstro.getVidaAtual()<=0){
            this.finalizaBatalha(conteudoTelaAtaqueJogador);
        }else{
            ConteudoTelaBatalha conteudoTelaAtaqueMonstro = new ConteudoTelaBatalha();
            int danoDoMonstro = this.monstro.getForca();
            conteudoTelaAtaqueMonstro.danoAtaque = danoDoMonstro;
            conteudoTelaAtaqueMonstro.atacado = this.controladorEncontro.getJogador();
            conteudoTelaAtaqueMonstro.atacante = this.monstro;
            this.controladorEncontro.getJogador().setVidaAtual(this.controladorEncontro.getJogador().getVidaAtual()-danoDoMonstro);
            this.telaBatalha.mostraAtaque(conteudoTelaAtaqueJogador, conteudoTelaAtaqueMonstro);
        }
    }
    
    public void finalizaBatalha(ConteudoTelaBatalha conteudoTelaAtaqueJogador) {
        this.telaBatalha.mostraFimBatalha(conteudoTelaAtaqueJogador);
    }

    public void analisarMonstro() {
        ConteudoTelaBatalha conteudoTela = compactar(this.monstro);
        this.telaBatalha.mostraAnalise(conteudoTela);
    }

    public void verItens(){
        Arma arma = this.controladorEncontro.getJogador().getArma();
        ArrayList<Consumivel> consumiveis = this.controladorEncontro.getJogador().getBolsa().verConsumiveis();
        ArrayList<ConteudoTelaBatalha> conteudoTelaS = new ArrayList();
        for(int i = 0; i < consumiveis.size(); i++){
            conteudoTelaS.add(compactar(consumiveis.get(i)));
        }
        ConteudoTelaBatalha conteudoTela = compactar(arma);
        this.telaBatalha.mostraItens(conteudoTelaS, conteudoTela);
    }

    public void verFeiticos(ConteudoTelaBatalha tipoInt){
        TipoElemento tipoElemento;
        switch(tipoInt){
            case 1 :
                tipoElemento = TipoElemento.FOGO;
                break;
            case 2 :
                tipoElemento = TipoElemento.AGUA;
                break;
            case 3 :
                tipoElemento = TipoElemento.GRAMA;
                break;
            case 4 :
                tipoElemento = TipoElemento.PEDRA;
                break;
        }
        this.controladorEncontro.getJogador().verFeiticos(tipoElemento);
    }

    public void executaOpcao(int opcao1) {
        switch(tipoInt){
            case 1 :
                this.telaBatalha.mostraMenuAtaque();
                break;
            case 2 :
                this.analisarMonstro();
                break;
            case 3 :
                this.telaBatalha.mostraMenuFeitico();
                break;
            case 4 :
                this.verItens();
                break;
            case 5 :
                this.telaBatalha.mostraMenuItens();
                break;
            case 6 :
                this.verMeusAtributos();
                break;
        }
    }
    
    public void iniciaEncontro() {
        this.telaBatalha.mostraMenuBatalha();
    }

    public ConteudoTelaBatalha compactar(Ser atacado, Ser atacante, int danoAtaque) {
        ConteudoTelaBatalha conteudoTela = new ConteudoTelaBatalha();
        conteudoTela.atacado = atacado;
        conteudoTela.atacante = atacante;
        return conteudoTela;
    }

    public ConteudoTelaBatalha compactar(Item item) {
        ConteudoTelaBatalha conteudoTela = new ConteudoTelaBatalha();
        conteudoTela.item = item;
        return conteudoTela;
    }
    
    public ConteudoTelaBatalha compactar(Monstro monstro) {
        ConteudoTelaBatalha conteudoTela = new ConteudoTelaBatalha();
        conteudoTela.monstro = monstro;
        return conteudoTela;
    }
    
    public void usarItem(int indice){
        this.controladorEncontro.getJogador().getBolsa().usarItem(indice);
        this.telaBatalha.mostraMenuBatalha();
    }
    
    public void verMeusAtributos(){
        Jogador jogador = this.controladorEncontro.getJogador();
        ConteudoTelaBatalha conteudoTela = new ConteudoTelaBatalha();
        conteudoTela.jogador = jogador;
        this.telaBatalha.mostraMeusAtributos(jogador);
    }

    public void gameOver() {
        this.controladorEncontro.gameOver();
    }
    
}
