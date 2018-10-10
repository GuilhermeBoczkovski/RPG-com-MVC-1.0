package rpgcommvc;

import java.util.ArrayList;

public class Jogador extends Ser implements IJogador {
    
    private double nivel;
    private boolean possuiChave;
    private int esquiva;
    private int grimorios;
    private final Diario diario;
    private ArrayList<Feitico> feiticos = new ArrayList<>();
    private Arma arma;
    private final Bolsa bolsa = new Bolsa();

    public Jogador(String nome) {
        super(nome);
        this.nivel = 1.5;
        super.setVidaAtual(10+(this.getNivelInt()*10));
        super.setVidaTotal(10+(this.getNivelInt()*10));
        this.possuiChave = false;
        this.esquiva = 10;
        this.grimorios = 0;
        this.diario = new Diario();
        this.feiticos.add(new Feitico(this.getNivelInt(), "Pedregulhos Sinistros", TipoElemento.PEDRA));
    }

    public Jogador(int nivel, String nome){
        super(nome);
        this.nivel = nivel;
        super.setVidaAtual(10+(10*nivel));
        super.setVidaTotal(10+(10*nivel));
        this.possuiChave = false;
        this.esquiva = 10;
        this.grimorios = 0;
        this.diario = new Diario();
        this.feiticos.add(new Feitico(this.getNivelInt(), "Pedregulhos Sinistros", TipoElemento.PEDRA));
    }
    
    public ArrayList<Feitico> verFeiticos(TipoElemento tipo){
        return new ArrayList<Feitico>();
    }
    
    public void addFeitico(Feitico feitico){
        this.feiticos.add(feitico);
    }
    
    public void delFeitico(String nome) throws FeiticoNaoListadoException{
        boolean existe = false;
        for(Feitico feitico : feiticos){
            if(feitico.getNome().equals(nome)){
                existe = true;
                feiticos.remove(feitico);
                break;
            }
        }
        if(!existe){
            throw new FeiticoNaoListadoException();
        }
    }
    
    public void delFeitico(int indice){
        feiticos.remove(indice);
    }
    
    public void trocaArma(Arma arma){
        this.arma = arma;
    }
    
    public void ganhaExperiencia(){
        this.nivel = nivel + 2/nivel;
    }
/*------------GET-------------*/
    public double getNivel() {
        return this.nivel;
    }
    public int getNivelInt() {
        return (int)this.nivel;
    }
    public boolean getPossuiChave() {
        return this.possuiChave;
    }
    public int getEsquiva() {
        return this.esquiva;
    }
    public int getGrimorios() {
        return this.grimorios;
    }
    public Diario getDiario() {
        return this.diario;
    }
    public Arma getArma() {
        return this.arma;
    }
    public ArrayList<Feitico> getFeiticos() {
        return this.feiticos;
    }
    public Bolsa getBolsa(){
        return this.bolsa;
    }
    public Feitico getFeitico(int i){
        return this.feiticos.get(i);
    }
/*------------SET--------------*/
    public void setNivel(double nivel) {
        this.nivel = nivel;
    }
    public void setPossuiChave(boolean possuiChave) {
        this.possuiChave = possuiChave;
    }
    public void setEsquiva(int esquiva) {
        this.esquiva = esquiva;
    }
    public void setGrimorios(int grimorios) {
        this.grimorios = grimorios;
    }
    public void setArma(Arma arma) {
        this.arma = arma;
    }
    public void setFeiticos(ArrayList<Feitico> feiticos) {
        this.feiticos = feiticos;
    }

    void usarItem(int indice) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
