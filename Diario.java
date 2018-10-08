package rpgcommvc;

import java.util.ArrayList;

public class Diario {
    
    private ArrayList<TipoEvento> eventos;
    
    public ArrayList<TipoEvento> verEventos(){
        return this.eventos;
    }

    public void addEvento(TipoEvento tipoEvento){
        this.eventos.add(tipoEvento);
    }

    public void delEventos(){
        this.eventos.clear();
    }
    
}