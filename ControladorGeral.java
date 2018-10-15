package rpgcommvc;

public class ControladorGeral {
    
    private TelaInicio telaInicio;
    private ControladorPrincipal controladorPrincipal;
    
    public ControladorGeral(){
        this.telaInicio = new TelaInicio(this);
    }
    
    public ControladorGeral(int i){
        this.telaInicio = new TelaInicio(this);
    }
    
    public void inicio(){
        telaInicio.mostraTelaInicio();
    }

    void play(String nome){
        this.controladorPrincipal = new ControladorPrincipal(nome, 1);
        this.controladorPrincipal.escolheEncontro();
    }
    
}
