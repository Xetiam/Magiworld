public abstract class Character {
    //Classe représentant les personnages avant le choix de leur spécialisation
    //Attribut
    protected int player;
    protected int level;
    protected int life;
    protected int strength;
    protected int agility;
    protected int intelligence;

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
    public abstract void basicAttack(Character playerDefense);

    public abstract void specialAttack(Character playerDefense);

    //Getter/Setter
    //LIFE
    public int getLife(){
        return this.life;
    }

    public void resetLife(){
        this.life = this.level*5;
    }
 
    //PLAYER
    public int getPlayer(){
        return this.player;
    }

}