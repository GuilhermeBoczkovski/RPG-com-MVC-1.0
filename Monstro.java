package rpg_jaaj;

public class Monstro extends Ser{
    private int vidaAtual;
    private int forca;
    private int vidaMaxima;
    private double esquiva;
    private TipoElemento tipoElemento;

    public Monstro(int nivel /*, tipo elemento?*/) {
        super("Monstro nivel: " + nivel);
        this.vidaAtual = vidaMaxima;
        this.forca = (int)(Math.random()*((0.2 * vidaMaxima - 0.10*vidaMaxima) + 1));
        this.vidaMaxima = 10+(10*nivel);
        this.esquiva = 1.5 * nivel;
        this.tipoElemento = tipoElemento;
    }

    public TipoElemento getTipoElemento() {
        return tipoElemento;
    }

    public void setTipoElemento(TipoElemento tipoElemento) {
        this.tipoElemento = tipoElemento;
    }

    public int getVidaAtual() {
        return vidaAtual;
    }

    public void setVidaAtual(int vidaAtual) {
        this.vidaAtual = vidaAtual;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    public void setVidaMaxima(int vidaMaxima) {
        this.vidaMaxima = vidaMaxima;
    }

    public double getEsquiva() {
        return esquiva;
    }

    public void setEsquiva(int esquiva) {
        this.esquiva = esquiva;
    }
    
    
}
