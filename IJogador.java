package rpgcommvc;

import java.util.ArrayList;

public interface IJogador {
    
    public ArrayList<Feitico> verFeiticos(TipoElemento tipo);
    
    public void addFeitico(String nome, int tipo);
    
    public void delFeitico(String nome);
    
    public void trocaArma(Arma arma);
}
