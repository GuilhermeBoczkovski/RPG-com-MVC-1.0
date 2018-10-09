package rpg_jaaj;
import java.util.ArrayList;
import java.util.Random;

class ControladorBau extends TelaEncontro{
    private ControladorPrincipal ctrlPrincipal;
    private TelaBau telaBau;
    private Jogador jogador;
    private Arma armaBau;
    private Consumivel consumivelBau;
    private boolean temGrimorio;
    private boolean temArma;
    private boolean temConsumivel;

    public ControladorBau(ControladorPrincipal aThis) {
        temGrimorio = false;
        temArma = false;
        temConsumivel = false;
        telaBau = new TelaBau(this);
        ctrlPrincipal = aThis;
        jogador = ctrlPrincipal.getJogador();
    }

    public void iniciaEncontro() {
        geraItens();
        telaBau.mostraAcharBau(compactarItensBoolean());
    }
    
    public void geraItens(){
        Random randArma = new Random();
        int arma = randArma.nextInt(2);
        Random randConsumivel = new Random();
        int consumivel = randConsumivel.nextInt(2);
        Random randGrimorio = new Random();
        int grimorio = randGrimorio.nextInt(2);
        switch(arma){
            case 0: break;
            case 1: Arma armaBau = new Arma(jogador.getNivel());
                    this.armaBau = armaBau;
                    temArma = true;
                    break;
        }
        
        switch(consumivel){
            case 0: break;
            case 1: Consumivel consumivelBau = new Consumivel("Pocao");
                    this.consumivelBau = consumivelBau;
                    temConsumivel = true;
                    break;
        }
        
        switch(grimorio){
            case 0: break;
            case 1: temGrimorio = true;
                    break;
        }
        if(!temArma && !temConsumivel && !temGrimorio){
            Consumivel consumivelBau = new Consumivel("Pocao");
            this.consumivelBau = consumivelBau;
            this.temConsumivel = true;
        }
    }

    public void executaOpcao(int escolha) {
        switch(escolha){
            case 0: telaBau.mostraFimBau(compactarItensBoolean());
                    break;
            case 1: telaBau.mostraItens(compactarItensJogador(), compactarItensBoolean());
                    break;
            case 2: compararArmas();
                    break;
            case 3: verItens();
                    break;
        }

    }
    
    public void finalizaBau(){
        ctrlPrincipal.escolheEncontro();
    }
    
    public void verItens() {
        telaBau.mostraColetaConsumivel(compactarItensJogador(), compactarConsumivelBau(), compactarItensBoolean());
    }
    
    public void compararArmas() {
        telaBau.mostraComparacao(compactarArmas(), compactarItensBoolean());
    }
    
    public void trocarArma(){
        this.jogador.setArma(armaBau);
        telaBau.mostraMenu(compactarItensBoolean());
    }
    
    public void pegarConsumivel(){
        this.jogador.getBolsa().addConsumivel(consumivelBau);
    }
    
    public ConteudoTelaBau compactarItensBoolean(){
        ConteudoTelaBau conteudo = new ConteudoTelaBau();
        conteudo.temArma = this.temArma;
        conteudo.temConsumivel = this.temConsumivel;
        conteudo.temGrimorio = this.temGrimorio;
        return conteudo;
    }
    
    public ConteudoTelaBau compactarConsumivelBau(){
        ConteudoTelaBau conteudo = new ConteudoTelaBau();
        conteudo.item = consumivelBau;
        return conteudo;
    }
    
    public ArrayList<ConteudoTelaBau> compactarItensJogador(){
        ArrayList<ConteudoTelaBau> conteudos = new ArrayList();
        ArrayList<Consumivel> consumiveis = jogador.getBolsa().verConsumiveis();
        for(Consumivel consumivel: consumiveis){
            ConteudoTelaBau conteudo = new ConteudoTelaBau();
            conteudo.item = consumivel;
        }
        return conteudos;
    }
    
    public ConteudoTelaBau compactarArmas(){
        ConteudoTelaBau conteudo = new ConteudoTelaBau();
        conteudo.armaJogador = jogador.getArma();
        conteudo.armaBau = this.armaBau;
        return conteudo;
    }
}














