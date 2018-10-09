package rpg_jaaj;

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
    
    public String aumentaDano(){
        return "vai mesmo ser usado?";
    }
}
