public class Warrior extends Character {
    //Classe représentant les personnages guerrier

    //Constructeur
    public Warrior(int player, int level, int strength, int agility, int intelligence){
        super(player, level,strength,agility,intelligence);
        System.out.println("Woarg je suis le Guerrier Joueur "+this.getPlayer()+" niveau "+this.getLevel()+" je possède "+this.getLife()+" de vitalité, "+this.getStrength()+" de force, "+this.getAgility()+" d'agilité et "+this.getIntelligence()+" d'intelligence !");
    }

    //Méthode de combat
    @Override
    public void basicAttack(Character player_defense){
        System.out.println("Joueur "+this.getPlayer()+" utilise Coup d'Épée et inflige "+this.getStrength()+" dommages.");
        System.out.println("Joueur "+player_defense.getPlayer()+" perd "+this.getStrength()+" points de vie");
        player_defense.setDamage(this.getStrength());
        if(player_defense.getLife()<=0){
            System.out.println("Joueur "+player_defense.getPlayer()+" est mort");
        }
    }

    @Override
    public void specialAttack(Character player_defense){
        System.out.println("Joueur "+this.getPlayer()+" utilise Coup de Rage et inflige "+this.getStrength()*2+" dommages.");
        player_defense.setDamage(this.getStrength()*2);
        System.out.println("Joueur "+player_defense.getPlayer()+" perd "+this.getStrength()*2+" points de vie");
        if(player_defense.getLife()<=0){
            System.out.println("Joueur "+player_defense.getPlayer()+" est mort");
        }
        System.out.println("Joueur "+this.getPlayer()+" perd "+this.getStrength()/2+" points de vie");
        this.setDamage(this.getStrength()/2); 
    } 
}