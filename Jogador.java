package rpgcommvc;

import java.util.ArrayList;

public class Jogador {
    
    private int nivel;
    private String nome;
    private int vidaAtual;
    private int vidaTotal;
    private boolean possuiChave;
    private int esquiva;
    private int grimorios;
    private Diario diario;
    private ArrayList<Feitico> feiticos = new ArrayList<>();
    private Arma arma;
    private Bolsa bolsa;

    public Jogador(String nome) {
        this.nivel = 1;
        this.nome = nome;
        this.vidaAtual = 20;
        this.vidaTotal = 20;
        this.possuiChave = false;
        this.esquiva = 10;
        this.grimorios = 0;
        this.diario = new Diario();
        this.feiticos.add(new Feitico(nome, nivel));
    }

    public Jogador(int nivel, String nome) {
        this.nivel = nivel;
        this.nome = nome;
        
    }
    
    public ArrayList<Feitico> verFeiticos(TipoElemento tipo){
        return new ArrayList<Feitico>();
    }
    
    public void addFeitico(String nome, int tipo){
        
    }
    
    public void delFeitico(String nome){
        
    }
    
    public void trocaArma(Arma arma){
        
    }
    
}
