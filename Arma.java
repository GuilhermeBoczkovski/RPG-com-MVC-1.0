package rpg_jaaj;

public class Arma extends Item{
    private int dano;
    
    public Arma(int nivel){
        super("Cajado magico de nivel " + nivel);
        this.dano = 5;
    }

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }
    
}
