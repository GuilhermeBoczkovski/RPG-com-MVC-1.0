package rpg_jaaj;
import java.util.ArrayList;
import java.util.Scanner;

public class TelaFogueira extends TelaEncontro{
    private ControladorFogueira ctrlFogueira;
    private Scanner input = new Scanner(System.in);
    
    public TelaFogueira(ControladorFogueira ctrlFogueira){
        this.ctrlFogueira = ctrlFogueira;
    }
    
    public void mostraMenuFogueira(){
        System.out.println("1 - ver Diario");
        System.out.println("2 - ver itens");
        System.out.println("3 - descartar itens");
        System.out.println("4 - ver feiticos");
        System.out.println("5 - criar feitico");
        System.out.println("6 - esquecer feitico");
        System.out.println("7 - sair");
        if(ctrlFogueira.jogador.isPossuiChave()){
            System.out.println("8 - ir para a sala do boss");
        }
        int opcao = input.nextInt();
        input.nextLine();
        ctrlFogueira.executaOpcao(opcao);
    }
    
    public void mostraInicioFogueira(){
        System.out.println("Voce encontrou uma fogueira...");
        System.out.println("voce se sente regenerado...");
        System.out.println("Jogador: " + ctrlFogueira.jogador.getNome());
        System.out.println("==========================================");
        mostraMenuFogueira();
    }
    
    public void mostraDiario(ArrayList<ConteudoTelaFogueira> eventos){
        System.out.println("=========================");
        int contador = 0;
        for(ConteudoTelaFogueira conteudo: eventos){
            System.out.println("Evento " + contador + ": " + conteudo.evento);
            contador++;
        }
        System.out.println("=========================");
        mostraMenuFogueira();
    }
    
    public void mostraItens(ArrayList<ConteudoTelaFogueira> itens){
        System.out.println("=========================");
        int contador = 0;
        for(ConteudoTelaFogueira conteudo: itens){
            System.out.println(contador + "- " + conteudo.item.getNome());
            contador++;
        }
        System.out.println("=========================");
        mostraMenuFogueira();
    }
    
    public void mostraMenuVerFeiticos(){
        System.out.println("escolha o tipo de feitico para ver:");
        System.out.println("1 - FOGO");
        System.out.println("2 - AGUA");
        System.out.println("3 - GRAMA");
        System.out.println("4 - PEDRA");
        int escolha = input.nextInt();
        input.nextLine();
        ctrlFogueira.verFeiticos(escolha);
    }
    
    public void mostraFeiticos(ArrayList<ConteudoTelaFogueira> feiticos){
        System.out.println("=========================");
        int contador = 0;
        for(ConteudoTelaFogueira conteudo: feiticos){
            System.out.println(contador + "- " + conteudo.feitico.getNome() + ", tipo:  " + conteudo.feitico.getTipoElemento());
            contador++;
        }
        System.out.println("=========================");
        mostraMenuFogueira();
    }
    
    public void mostraMenuEsquecerFeiticos(ArrayList<ConteudoTelaFogueira> feiticos){
        System.out.println("=========================");      
        int contador = 0;
        for(ConteudoTelaFogueira conteudo: feiticos){
            System.out.println("indice " + contador + ": " + conteudo.feitico.getNome() + ", tipo:  " + conteudo.feitico.getTipoElemento());
            contador++;
        }
        System.out.println("=========================");
        int retorno = contador++;
        System.out.println("Escolha o indice do feitico para esquecer, " + retorno + "para retornar ao menu");
        int escolha = input.nextInt();
        input.nextLine();
        if(escolha == retorno){
            mostraMenuFogueira();
        } else {
            ctrlFogueira.esquecerFeitico(escolha);
            System.out.println("feitico esquecido!");
            mostraMenuFogueira();
        }
    }
    
    public void mostraMenuDescartarItem(ArrayList<ConteudoTelaFogueira> itens){
        System.out.println("=========================");      
        int contador = 0;
        for(ConteudoTelaFogueira conteudo: itens){
            System.out.println("indice " + contador + ": " + conteudo.item.getNome());
            contador++;
        }
        System.out.println("=========================");
        int retorno = contador++;
        System.out.println("Escolha o indice do item para descartar, " + retorno + "para retornar ao menu");
        int escolha = input.nextInt();
        input.nextLine();
        if(escolha == retorno){
            mostraMenuFogueira();
        } else {
            ctrlFogueira.descartarItem(escolha);
            System.out.println("item descartado...");
            mostraMenuFogueira();
        }
        
    }
    
    public void mostraFimFogueira(){
        System.out.println("voce pega suas coisas e continua seu caminho...");
        ctrlFogueira.finalizaFogueira();
    }
    
    public void mostraMenuCriarFeitico(){
        if(ctrlFogueira.jogador.getGrimorios() > 0){
            System.out.print("Entre o nome do novo feitico: ");
            String nome = input.nextLine();
            System.out.println("Escolha o tipo do feitico");
            System.out.println("1 - FOGO");
            System.out.println("2 - AGUA");
            System.out.println("3 - GRAMA");
            System.out.println("4 - PEDRA");
            int tipo = input.nextInt();
            input.nextLine();
            ctrlFogueira.criarFeitico(nome, tipo);
        } else {
            mostraErroCriarFeitico();
        }
    }
    
    public void mostraErroCriarFeitico(){
        System.out.println("Voce nao possui um grimorio para criar um novo feitico");
        mostraMenuFogueira();
    }
    
    public void mostraCriarFeitico(){
        System.out.println("===========================");
        System.out.println("Feitico criado com sucesso!");
        System.out.println("===========================");
        System.out.println("                           ");
        mostraMenuFogueira();
    }
}
