package rpg_jaaj;
import java.util.Scanner;
import java.util.ArrayList;

public class TelaBau {
    private ControladorBau ctrlBau;
    private Scanner input;
    
    TelaBau(ControladorBau aThis) {
        ctrlBau = aThis;
        input = new Scanner(System.in);
    }
    
    public void mostraAcharBau(ConteudoTelaBau itens){
        System.out.println("  ");
        System.out.println("Voce encontrou um bau!");
        System.out.println("Voce o abre e eh isso que voce encontra:");
        if(itens.temArma){
            System.out.println("uma arma.");
        }
        if(itens.temConsumivel){
            System.out.println("um consumivel.");
        }
        if(itens.temGrimorio){
            System.out.println("um grimorio.");
        }
        System.out.println("========================================");
        mostraMenu(itens);
        
    }
    
    public void mostraMenu(ConteudoTelaBau itens) {
        System.out.println("Oque voce deseja fazer?");
        int contador = 2;
        System.out.println("0- sair da sala");
        System.out.println("1- Ver itens da bolsa");
        if(itens.temArma){
            System.out.println("2- trocar a sua arma atual com a do bau.");
        }
        if(itens.temConsumivel){
            System.out.println("3- pegar consumivel");
        }
        int escolha = input.nextInt();
        input.nextLine();
        ctrlBau.executaOpcao(escolha);
    }

    public void mostraFimBau(ConteudoTelaBau itens) {
        String mensagem = "";
        if(itens.temGrimorio){
            mensagem = "pega o grimorio e ";
        }
        System.out.println("voce " + mensagem + "sai da sala e continua a jornada...");
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
                    System.out.println("voce Pegou o consumivel..");
                    mostraMenu(itens);
                    break;
            case 2: mostraMenu(itens);
                    break;
        }
        
    }
    
    public void mostraComparacao(ConteudoTelaBau conteudo, ConteudoTelaBau itens){
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
                    mostraMenu(itens);
                    break;
            case 2: mostraMenu(itens);
                    break;
        }
    }
    

    public void mostraItens(ArrayList<ConteudoTelaBau> itens, ConteudoTelaBau itensBoolean) {
        System.out.println("==========BOLSA=========");
        int contador = 0;
        for(ConteudoTelaBau item: itens){
            String nome = item.item.getNome();
            System.out.println(contador + "-" + nome);
        }
        System.out.println("========================");
        mostraMenu(itensBoolean);
    }
    
}














