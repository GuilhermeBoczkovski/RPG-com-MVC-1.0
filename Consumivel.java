package rpgcommvc;

public class Consumivel extends Item{
    
    public Consumivel(String nome){
        super(nome);
    }
    
    /**
     * retorna um valor que sera adicionado a vida do jogador
     * ideia:
     * receber o nivel do jogador e calcular a vida a ser restaurada apartir disso
     * @return int = valor a restaurar
     */
    public int restauraVida(){
        return 10;
    }
    
    /*
    public void restauraMana(){
        mana removido do projeto
    }
    */
    
    
    /**
     * retorna o dano a somar no jogador, vai ser usado?
     * ideia:
     * similar ao de vida, receber o dano do jogador
     * @return int = valor a aumentar o dano
     */
    public int aumentaDano(){
        return 10;
    }
    
    
    String getAcao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    String getValorAcao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
