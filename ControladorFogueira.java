package rpgcommvc;
import java.util.ArrayList;

public class ControladorFogueira {
    private TelaFogueira telaFogueira;
    private Jogador jogador;
    private ArrayList<Consumivel> itens;
    private ControladorPrincipal ctrlEncontro;
    private ArrayList<TipoEvento> eventos;
    private ArrayList<Feitico> feiticos;
    
    public ControladorFogueira(ControladorPrincipal ctrlEncontro){
        this.ctrlEncontro = ctrlEncontro;
        this.jogador = ctrlEncontro.getJogador();
        telaFogueira = new TelaFogueira(this);
        this.itens = jogador.getBolsa().verConsumiveis();
        this.eventos = jogador.getDiario().verEventos();
        feiticos = jogador.getFeiticos();
    }
    
    
    public void executaOpcao(int opcao){
        try{
            switch(opcao){
                case 1: verDiario();
                        break;
                case 2: verItens();
                        break;
                case 3: telaFogueira.mostraMenuDescartarItem(compactarItem());
                        break;
                case 4: telaFogueira.mostraMenuVerFeiticos();
                        break;
                case 5: telaFogueira.mostraMenuCriarFeitico();
                        break;
                case 6: telaFogueira.mostraMenuEsquecerFeiticos(compactarFeitico());
                        break;
                case 7: telaFogueira.mostraFimFogueira();
                        break;
                case 8: if(jogador.getPossuiChave()){irParaBoss();}
                        else{telaFogueira.mostraMenuFogueira();}
                        break;
                default: throw new NumeroInvalidoException();
            }
        } catch(Exception e){
            System.out.println(e.getMessage());
            telaFogueira.mostraMenuFogueira();
        }
    }
    
    public void iniciaEncontro(){
        jogador.setVidaAtual(jogador.getVidaTotal());
        telaFogueira.mostraInicioFogueira();
    }
    
    public void verDiario(){
        telaFogueira.mostraDiario(compactarEvento());
    }
    
    public void verItens(){
        telaFogueira.mostraItens(compactarItem());
    }
    
    public void criarFeitico(String nome, int tipo){
        Feitico feitico;
        switch(tipo){
            case 1: feitico = new Feitico(jogador.getNivelInt(), nome, TipoElemento.FOGO);
                    jogador.addFeitico(feitico);
                    break;
            case 2: feitico = new Feitico(jogador.getNivelInt(), nome, TipoElemento.AGUA);
                    jogador.addFeitico(feitico);
                    break;
            case 3: feitico = new Feitico(jogador.getNivelInt(), nome, TipoElemento.GRAMA);
                    jogador.addFeitico(feitico);
                    break;
            case 4: feitico = new Feitico(jogador.getNivelInt(), nome, TipoElemento.PEDRA);
                    jogador.addFeitico(feitico);
                    break;
        }
        telaFogueira.mostraCriarFeitico();
    }
    
    public void verFeiticos(int tipo){
        try{
            switch(tipo){
                case 1: telaFogueira.mostraFeiticos(compactarFeiticoPorTipo(TipoElemento.FOGO));
                        break;
                case 2: telaFogueira.mostraFeiticos(compactarFeiticoPorTipo(TipoElemento.AGUA));
                        break;
                case 3: telaFogueira.mostraFeiticos(compactarFeiticoPorTipo(TipoElemento.GRAMA));
                        break;
                case 4: telaFogueira.mostraFeiticos(compactarFeiticoPorTipo(TipoElemento.PEDRA));
                        break;
                default: throw new NumeroInvalidoException();
            }
        } catch(Exception e){
            System.out.println(e.getMessage());
            telaFogueira.mostraMenuVerFeiticos();
        }
    }
    
    public void esquecerFeitico(int escolha){
        jogador.delFeitico(escolha);
    }
    
    public void descartarItem(int escolha){
        jogador.getBolsa().dellConsumivel(escolha);
    }
    
    public void finalizaFogueira(){
        jogador.getDiario().addEvento(TipoEvento.FOGUEIRA);
        ctrlEncontro.escolheEncontro();
    }
    
    public void irParaBoss(){
        ctrlEncontro.irParaBoss();
    }
    
    public ConteudoTelaFogueira compactaJogador(){
        ConteudoTelaFogueira conteudo = new ConteudoTelaFogueira();
        conteudo.jogador = this.jogador;
        return conteudo;
    }
    
    public ArrayList<ConteudoTelaFogueira> compactarFeiticoPorTipo(TipoElemento tipo){
        ArrayList<ConteudoTelaFogueira> feiticosCompactados = new ArrayList();
        for(Feitico feitico: feiticos){
            if(feitico.getTipoElemento() == tipo){
                ConteudoTelaFogueira novoConteudo = new ConteudoTelaFogueira();
                novoConteudo.feitico = feitico;
                feiticosCompactados.add(novoConteudo);
            }
        }
        return feiticosCompactados;
    }
    
    public ArrayList<ConteudoTelaFogueira> compactarFeitico(){
        ArrayList<ConteudoTelaFogueira> feiticosCompactados = new ArrayList();
        for(Feitico feitico: feiticos){
            ConteudoTelaFogueira novoConteudo = new ConteudoTelaFogueira();
            novoConteudo.feitico = feitico;
            feiticosCompactados.add(novoConteudo);
        }
        return feiticosCompactados;
    }
    
    public ArrayList<ConteudoTelaFogueira> compactarItem(){
        ArrayList<ConteudoTelaFogueira> itensCompactados = new ArrayList();
        for(Consumivel item: itens){
            ConteudoTelaFogueira novoConteudo = new ConteudoTelaFogueira();
            novoConteudo.item = item;
            itensCompactados.add(novoConteudo);
        }
        return itensCompactados;
    }
    
    public ArrayList<ConteudoTelaFogueira> compactarEvento(){
        ArrayList<ConteudoTelaFogueira> eventosCompactados = new ArrayList();
        for(TipoEvento evento: eventos){
            ConteudoTelaFogueira novoConteudo = new ConteudoTelaFogueira();
            novoConteudo.evento = evento;
            eventosCompactados.add(novoConteudo);
        }
        return eventosCompactados;
    }
}























