package rpgcommvvc;

import java.util.ArrayList;

class ControladorBatalhaBoss {

    private ControladorPrincipal controladorPrincipal;
    private Monstro monstro;
    private TelaBatalha telaBatalha;

    public ControladorBatalhaBoss(ControladorPrincipal controladorPrincipal) {
        this.controladorPrincipal = controladorPrincipal;
        TipoElemento tipoElemento = TipoElemento.PEDRA;
        this.monstro = new Monstro(10, tipoElemento);
        
    }
    
    public void atacar(ConteudoTelaBatalha conteudoTela){
        ConteudoTelaBatalha conteudoTelaAtaqueJogador = new ConteudoTelaBatalha();
        Feitico feitico = this.controladorPrincipal.getJogador().getFeitico(conteudoTelaAtaqueJogador.indiceFeitico);
        conteudoTelaAtaqueJogador.feitico = feitico;
        int danoDoJogador = feitico.getDano();
        danoDoJogador += this.controladorPrincipal.getJogador().getArma().getDano();
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
        conteudoTelaAtaqueJogador.atacante = this.controladorPrincipal.getJogador();
        conteudoTelaAtaqueJogador.atacado = this.monstro;
        this.monstro.setVidaAtual(this.monstro.getVidaAtual()-danoDoJogador);
        if(this.monstro.getVidaAtual()<=0){
            this.finalizaBatalha(conteudoTelaAtaqueJogador);
        }else{
            ConteudoTelaBatalha conteudoTelaAtaqueMonstro = new ConteudoTelaBatalha();
            int danoDoMonstro = this.monstro.getForca();
            conteudoTelaAtaqueMonstro.danoAtaque = danoDoMonstro;
            conteudoTelaAtaqueMonstro.atacado = this.controladorPrincipal.getJogador();
            conteudoTelaAtaqueMonstro.atacante = this.monstro;
            this.controladorPrincipal.getJogador().setVidaAtual(this.controladorPrincipal.getJogador().getVidaAtual()-danoDoMonstro);
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
        Arma arma = this.controladorPrincipal.getJogador().getArma();
        ArrayList<Consumivel> consumiveis = this.controladorPrincipal.getJogador().getBolsa().verConsumiveis();
        ArrayList<ConteudoTelaBatalha> conteudoTelaS = new ArrayList();
        for(int i = 0; i < consumiveis.size(); i++){
            conteudoTelaS.add(compactar(consumiveis.get(i)));
        }
        ConteudoTelaBatalha conteudoTela = compactar(arma);
        this.telaBatalha.mostraItens(conteudoTelaS, conteudoTela);
    }

    public void verFeiticos(ConteudoTelaBatalha conteudoTela){
        try{
            TipoElemento tipoElemento;
            switch(conteudoTela.tipoInt){
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
                default :
                    throw new NumeroInvalidoException();
            }
            this.controladorPrincipal.getJogador().verFeiticos(tipoElemento);
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void executaOpcao(int opcao1){
        switch(opcao1){
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

    public ConteudoTelaBatalha compactar(Consumivel consumivel) {
        ConteudoTelaBatalha conteudoTela = new ConteudoTelaBatalha();
        conteudoTela.consumivel = consumivel;
        return conteudoTela;
    }
    
    public ConteudoTelaBatalha compactar(Arma arma) {
        ConteudoTelaBatalha conteudoTela = new ConteudoTelaBatalha();
        conteudoTela.arma = arma;
        return conteudoTela;
    }
    
    public ConteudoTelaBatalha compactar(Monstro monstro) {
        ConteudoTelaBatalha conteudoTela = new ConteudoTelaBatalha();
        conteudoTela.monstro = monstro;
        return conteudoTela;
    }
    
    public void usarItem(int indice){
        this.controladorPrincipal.getJogador().usarItem(indice);
        this.telaBatalha.mostraMenuBatalha();
    }
    
    public void verMeusAtributos(){
        Jogador jogador = this.controladorPrincipal.getJogador();
        ConteudoTelaBatalha conteudoTela = new ConteudoTelaBatalha();
        conteudoTela.jogador = jogador;
        this.telaBatalha.mostraMeusAtributos(jogador);
    }

    public void gameOver() {
        this.controladorPrincipal.gameOver();
    }
    
}
