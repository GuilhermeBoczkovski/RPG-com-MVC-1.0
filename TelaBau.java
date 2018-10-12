package rpgcommvc;
import java.util.Scanner;
import java.util.ArrayList;

public class TelaBau {
    private ControladorBau ctrlBau;
    private Scanner input;
    private boolean temArma;
    private boolean temGrimorio;
    private boolean temConsumivel;
    
    TelaBau(ControladorBau aThis) {
        ctrlBau = aThis;
        input = new Scanner(System.in);
    }
    
    public void mostraAcharBau(){
        ConteudoTelaBau itens = ctrlBau.compactarItensBoolean();
        this.temArma = itens.temArma;
        this.temGrimorio = itens.temGrimorio;
        this.temConsumivel = itens.temConsumivel;
        System.out.println("  ");
        System.out.println("Voce encontrou um bau!");
        System.out.println("Voce o abre e eh isso que voce encontra:");
        System.out.println("");
        if(this.temArma){
            System.out.println("uma arma.");
        }
        if(this.temConsumivel){
            System.out.println("um consumivel.");
        }
        if(this.temGrimorio){
            System.out.println("um grimorio.");
        }
        mostraMenu();
        
    }
    
    public void mostraMenu() {
        System.out.println("=====================");
        System.out.println("Oque voce deseja fazer?");
        int contador = 2;
        System.out.println("0- sair da sala");
        System.out.println("1- Ver itens da bolsa");
        if(temArma){
            System.out.println("2- trocar a sua arma atual com a do bau.");
        }
        if(temConsumivel){
            System.out.println("3- pegar consumivel");
        }
        
        int escolha = input.nextInt();
        input.nextLine();
        ctrlBau.executaOpcao(escolha);
    }

    public void mostraFimBau() {
        String mensagem = "";
        if(temGrimorio){
            mensagem = "pega o grimorio e ";
        }
        System.out.println("Voce " + mensagem + "sai da sala e continua a jornada...");
        System.out.println("========================================");
        ctrlBau.finalizaBau();
    }
    
    public void mostraColetaConsumivel(ArrayList<ConteudoTelaBau> itensJogador, ConteudoTelaBau consumivelBau, ConteudoTelaBau itens){
        System.out.println("===========BOLSA==========");
        int contador = 0;
        for(ConteudoTelaBau item: itensJogador){
            String nome = item.item.getNome();
            System.out.println(contador + "-" + nome);
        }
        System.out.println("========CONSUMIVEL========");
        System.out.println(consumivelBau.item.getNome());
        System.out.println("                          ");
        System.out.println("Deseja Pegar o consumivel?");
        System.out.println("1- SIM");
        System.out.println("2- NAO");
        int escolha = input.nextInt();
        input.nextLine();
        
        switch(escolha){
            case 1: ctrlBau.pegarConsumivel();
                    System.out.println("Voce Pegou o consumivel..");
                    mostraMenu();
                    break;
            case 2: mostraMenu();
                    break;
        }
        
    }
    
    public void mostraComparacao(ConteudoTelaBau conteudo){
        System.out.println("=====COMPARANDO ARMAS=====");
        System.out.println("Arma jogador: "+ conteudo.armaJogador.getNome() + ", dano:" +conteudo.armaJogador.getDano());
        System.out.println("Arma bau: "+ conteudo.armaBau.getNome() + ", dano:" + conteudo.armaBau.getDano());
        System.out.println("==========================");
        System.out.println("deseja trocar sua arma?");
        System.out.println("1- SIM");
        System.out.println("2- NAO");
        int escolha = input.nextInt();
        input.nextLine();
        switch(escolha){
            case 1: ctrlBau.trocarArma();
                    System.out.println("trocou de arma!");
                    mostraMenu();
                    break;
            case 2: mostraMenu();
                    break;
        }
    }
    

    public void mostraItens(ArrayList<ConteudoTelaBau> itens) {
        System.out.println("==========BOLSA=========");
        int contador = 0;
        for(ConteudoTelaBau item: itens){
            String nome = item.item.getNome();
            System.out.println(contador + "-" + nome);
        }
        System.out.println("========================");
        mostraMenu();
    }
    
}














