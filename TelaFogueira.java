package rpgcommvc;
import java.util.ArrayList;
import java.util.Scanner;

public class TelaFogueira extends TelaEncontro{
    private ControladorFogueira ctrlFogueira;
    private Scanner input = new Scanner(System.in);
    private Jogador jogador;
    
    public TelaFogueira(ControladorFogueira ctrlFogueira){
        this.ctrlFogueira = ctrlFogueira;
        this.jogador = ctrlFogueira.compactaJogador().jogador;
    }
    
    public void mostraMenuFogueira(){
        System.out.println("=======================");
        System.out.println("O que quer fazer?");
        System.out.println("1 - ver Diario");
        System.out.println("2 - ver itens");
        System.out.println("3 - descartar itens");
        System.out.println("4 - ver feiticos");
        System.out.println("5 - criar feitico");
        System.out.println("6 - esquecer feitico");
        System.out.println("7 - sair");
        if(jogador.getPossuiChave()){
            System.out.println("8 - ir para a sala do boss");
        }
        int opcao = input.nextInt();
        input.nextLine();
        ctrlFogueira.executaOpcao(opcao);
    }
    
    public void mostraInicioFogueira(){
        jogador.setGrimorios(2);
        System.out.println("Voce encontrou uma fogueira...");
        System.out.println("voce se sente regenerado...");
        System.out.println("Jogador: " + jogador.getNome() + " || Nivel: " + jogador.getNivelInt());
        //System.out.println("dano da arma: " + ctrlFogueira.jogador.getArma().getDano()); ha um problema ao pegar a forca da arma, favor olhar isso depois!!
        System.out.println("vida: " + jogador.getVidaTotal());
        mostraMenuFogueira();
    }
    
    public void mostraDiario(ArrayList<ConteudoTelaFogueira> eventos){
        if(eventos.isEmpty()){
            System.out.println("=======================");
            System.out.println("");
            System.out.println("Seu diario esta em branco...");
            System.out.println("");
            mostraMenuFogueira();
        } else {
            System.out.println("=========================");
            int contador = 0;
            for(ConteudoTelaFogueira conteudo: eventos){
                System.out.println("Evento " + contador + ": " + conteudo.evento);
                contador++;
            }
            System.out.println("=========================");
            mostraMenuFogueira();
        }
    }
    
    public void mostraItens(ArrayList<ConteudoTelaFogueira> itens){
        if(itens.isEmpty()){
            System.out.println("========================");
            System.out.println("");
            System.out.println("Sua bolsa esta vazia...");
            System.out.println("");
            mostraMenuFogueira();
        } else {
            System.out.println("=========================");
            int contador = 0;
            for(ConteudoTelaFogueira conteudo: itens){
                System.out.println(contador + "- " + conteudo.item.getNome());
                contador++;
            }
            mostraMenuFogueira();
        }
    }
    
    public void mostraMenuVerFeiticos(){
        System.out.println("Escolha o tipo de feitico para ver:");
        System.out.println("1 - FOGO");
        System.out.println("2 - AGUA");
        System.out.println("3 - GRAMA");
        System.out.println("4 - PEDRA");
        int escolha = input.nextInt();
        input.nextLine();
        ctrlFogueira.verFeiticos(escolha);
    }
    
    public void mostraFeiticos(ArrayList<ConteudoTelaFogueira> feiticos){
        if(feiticos.isEmpty()){
            System.out.println("=========================");
            System.out.println("");
            System.out.println("Voce nao possui feiticos desse tipo...");
            System.out.println("");
            mostraMenuFogueira();
        } else {
            System.out.println("=========================");
            int contador = 0;
            for(ConteudoTelaFogueira conteudo: feiticos){
                System.out.println(contador + "- " + conteudo.feitico.getNome() + ", tipo:  " + conteudo.feitico.getTipoElemento() + ", dano: " + conteudo.feitico.getDano());
                contador++;
            }
            mostraMenuFogueira();
        }
    }
    
    public void mostraMenuEsquecerFeiticos(ArrayList<ConteudoTelaFogueira> feiticos){
        if(feiticos.isEmpty()){
            System.out.println("=========================");
            System.out.println("");
            System.out.println("Voce nao tem feiticos para esquecer...");
            System.out.println("");
            mostraMenuFogueira();
        } else {
            System.out.println("=========================");      
            int contador = 0;
            for(ConteudoTelaFogueira conteudo: feiticos){
                System.out.println("indice " + contador + ": " + conteudo.feitico.getNome() + ", tipo:  " + conteudo.feitico.getTipoElemento() + ", Dano:  " + conteudo.feitico.getDano());
                contador++;
            }
            System.out.println("=========================");
            int retorno = contador++;
            System.out.println("Escolha o indice do feitico para esquecer, digite " + retorno + " para retornar ao menu");
            int escolha = input.nextInt();
            input.nextLine();
            if(escolha == retorno){
                mostraMenuFogueira();
            } else if(escolha > retorno){
                System.out.println("Numero invalido!");
                mostraMenuEsquecerFeiticos(feiticos);
            }else {
                ctrlFogueira.esquecerFeitico(escolha);
                System.out.println("feitico esquecido!");
                mostraMenuFogueira();
            }
        }
    }
    
    public void mostraMenuDescartarItem(ArrayList<ConteudoTelaFogueira> itens){
        if(itens.isEmpty()){
            System.out.println("=========================");
            System.out.println("");
            System.out.println("Sua bolsa esta vazia...");
            System.out.println("");
            mostraMenuFogueira();
                    
        } else {
            System.out.println("=========================");      
            int contador = 0;
            for(ConteudoTelaFogueira conteudo: itens){
                System.out.println("indice " + contador + ": " + conteudo.item.getNome());
                contador++;
            }
            System.out.println("=========================");
            int retorno = contador++;
            System.out.println("Escolha o indice do item para descartar, selecione " + retorno + " para retornar ao menu");
            int escolha = input.nextInt();
            input.nextLine();
            if(escolha == retorno){
                mostraMenuFogueira();
            } else if(escolha > retorno){
                System.out.println("O indice escolhido nao existe, tente denovo!");
                mostraMenuDescartarItem(itens);
            }else {
                ctrlFogueira.descartarItem(escolha);
                System.out.println("item descartado...");
                mostraMenuFogueira();
            }
        }
        
    }
    
    public void mostraFimFogueira(){
        System.out.println("=========================");
        System.out.println("Deseja mesmo sair?");
        System.out.println("1 - SIM");
        System.out.println("2 - NAO");
        System.out.println("");
        int escolha = input.nextInt();
        input.nextLine();
       
        switch(escolha){
            case 1 : System.out.println("Voce pega suas coisas e continua seu caminho...");
                     System.out.println("=========================");
                     ctrlFogueira.finalizaFogueira();
                     break;
            case 2 : mostraMenuFogueira();
                     break;
            default: System.out.println("Numero invalido, tente denovo");
                     mostraFimFogueira();
        }
        
    }
    
    public void mostraMenuCriarFeitico(){
        if(jogador.getGrimorios() > 0){
            System.out.print("Entre o nome do novo feitico: ");
            String nome = input.nextLine();
            System.out.println("Escolha o tipo do feitico");
            System.out.println("1 - FOGO");
            System.out.println("2 - AGUA");
            System.out.println("3 - GRAMA");
            System.out.println("4 - PEDRA");
            int tipo = input.nextInt();
            input.nextLine();
            if(tipo <= 4 && tipo >= 1){
                ctrlFogueira.criarFeitico(nome, tipo);
            } else {
                System.out.println("Numero invalido, tente denovo...");
                mostraMenuCriarFeitico();
            }
        } else {
            mostraErroCriarFeitico();
        }
    }
    
    public void mostraErroCriarFeitico(){
        System.out.println("=========================");
        System.out.println("");
        System.out.println("Voce nao possui um grimorio para criar um novo feitico");
        System.out.println("");
        mostraMenuFogueira();
    }
    
    public void mostraCriarFeitico(){
        System.out.println("===========================");
        System.out.println("");
        System.out.println("Feitico criado com sucesso!");
        System.out.println("                           ");
        mostraMenuFogueira();
    }
}
