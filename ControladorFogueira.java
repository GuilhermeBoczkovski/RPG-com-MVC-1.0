package rpgcommvc;
import java.util.ArrayList;

public class ControladorFogueira {
    private TelaFogueira telaFogueira;
    private ArrayList<Consumivel> itens;
    private ControladorPrincipal ctrlEncontro;
    private ArrayList<TipoEvento> eventos;
    private ArrayList<Feitico> feiticos;
    
    public ControladorFogueira(ControladorPrincipal ctrlEncontro){
        this.ctrlEncontro = ctrlEncontro;
        telaFogueira = new TelaFogueira(this);
        this.itens = ctrlEncontro.getJogador().getBolsa().verConsumiveis();
        this.eventos = ctrlEncontro.getJogador().getDiario().verEventos();
        feiticos = ctrlEncontro.getJogador().getFeiticos();
    }
    
    
    public void executaOpcao(String opcao){
        try{
            switch(opcao){
                case "0": telaFogueira.mostraFimFogueira();
                        break;
                case "1": verDiario();
                        break;
                case "2": verItens();
                        break;
                case "3": telaFogueira.mostraMenuDescartarItem(compactarItem());
                        break;
                case "4": telaFogueira.mostraMenuVerFeiticos();
                        break;
                case "5": telaFogueira.mostraMenuCriarFeitico();
                        break;
                case "6": telaFogueira.mostraMenuEsquecerFeiticos(compactarFeitico());
                        break;
                case "7": if(ctrlEncontro.getJogador().getPossuiChave()){irParaBoss();}
                        else{throw new NumeroInvalidoException();}
                        break;
                default: throw new NumeroInvalidoException();
            }
        } catch(Exception e){
            System.out.println(e.getMessage());
            telaFogueira.mostraMenuFogueira();
        }
    }
    
    public void iniciaEncontro(){
        ctrlEncontro.getJogador().setVidaAtual(ctrlEncontro.getJogador().getVidaTotal());
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
            case 1: feitico = new Feitico(ctrlEncontro.getJogador().getNivelInt(), nome, TipoElemento.FOGO);
                    ctrlEncontro.getJogador().addFeitico(feitico);
                    break;
            case 2: feitico = new Feitico(ctrlEncontro.getJogador().getNivelInt(), nome, TipoElemento.AGUA);
                    ctrlEncontro.getJogador().addFeitico(feitico);
                    break;
            case 3: feitico = new Feitico(ctrlEncontro.getJogador().getNivelInt(), nome, TipoElemento.GRAMA);
                    ctrlEncontro.getJogador().addFeitico(feitico);
                    break;
            case 4: feitico = new Feitico(ctrlEncontro.getJogador().getNivelInt(), nome, TipoElemento.PEDRA);
                    ctrlEncontro.getJogador().addFeitico(feitico);
                    break;
        }
        telaFogueira.mostraCriarFeitico();
    }
    
    public void verFeiticos(String tipo){
        try{
            switch(tipo){
                case "1": telaFogueira.mostraFeiticos(compactarFeiticoPorTipo(TipoElemento.FOGO));
                        break;
                case "2": telaFogueira.mostraFeiticos(compactarFeiticoPorTipo(TipoElemento.AGUA));
                        break;
                case "3": telaFogueira.mostraFeiticos(compactarFeiticoPorTipo(TipoElemento.GRAMA));
                        break;
                case "4": telaFogueira.mostraFeiticos(compactarFeiticoPorTipo(TipoElemento.PEDRA));
                        break;
                default: throw new NumeroInvalidoException();
            }
        } catch(Exception e){
            System.out.println(e.getMessage());
            telaFogueira.mostraMenuVerFeiticos();
        }
    }
    
    public void esquecerFeitico(String escolha){
        int escolhaInt = Integer.parseInt(escolha);
        ctrlEncontro.getJogador().delFeitico(escolhaInt);
    }
    
    public void descartarItem(int escolha){
        ctrlEncontro.getJogador().getBolsa().dellConsumivel(escolha);
    }
    
    public void finalizaFogueira(){
        ctrlEncontro.getJogador().getDiario().addEvento(TipoEvento.FOGUEIRA);
        ctrlEncontro.escolheEncontro();
    }
    
    public void irParaBoss(){
        ctrlEncontro.irParaBoss();
    }
    
    public ConteudoTelaFogueira compactaJogador(){
        ConteudoTelaFogueira conteudo = new ConteudoTelaFogueira();
        conteudo.jogador = ctrlEncontro.getJogador();
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























