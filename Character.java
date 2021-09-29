public class Character {
    //Classe représentant les personnages avant le choix de leur spécialisation

    //Attribut
    private int player;
    private int level;
    private int life;
    private int strength;
    private int agility;
    private int intelligence;

    //Constructeur
    public Character(int player, int level, int strength, int agility, int intelligence){
        this.player = player;
        this.level = level;
        this.life = level * 5;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    //Méthode de combat
    public void basicAttack(Character player_defense){
        System.out.println("Je donne un coup de poing.\n");
    }

    public void specialAttack(Character player_defense){
        System.out.println("Je laboure le sol.\n");
    }

    //Getter/Setter
    //LEVEL
    public int getLevel(){
        return this.level;
    }
    
    //LIFE
    public int getLife(){
        return this.life;
    }

    public void setDamage(int newValue){
        this.life = this.life - newValue;
    }

    public void resetLife(){
        this.life = this.level*5;
    }

    //STRENGTH
    public int getStrength(){
        return this.strength;
    }

    public void setStrength(int newValue){
        this.strength = newValue;
    }

    
    public void setPlayer(int newValue){
        this.player = newValue;
    }
    
    //AGILITY
    public int getAgility(){
        return this.agility;
    }
    
    public void setAgility(int newValue){
        this.agility = newValue;
    }
    
    //INTELLIGENCE
    public int getIntelligence(){
        return this.intelligence;
    }
    
    public void setIntelligence(int newValue){
        this.intelligence = newValue;
    }

    //PLAYER
    public int getPlayer(){
       return this.player;
    }
}