public class Warrior extends Character {
    //Classe représentant les personnages guerriers

    //Constructeur
    public Warrior(int player, int level, int strength, int agility, int intelligence){
        super(player, level,strength,agility,intelligence);
        System.out.println("Woarg je suis le Guerrier Joueur "+this.player+" niveau "+this.level+" je possède "+this.life+" de vitalité, "+this.strength+" de force, "+this.agility+" d'agilité et "+this.intelligence+" d'intelligence !");
    }

    //Méthode de combat
    @Override
    public void basicAttack(Character player_defense){
        System.out.println("Joueur "+this.player+" utilise Coup d'Épée et inflige "+this.strength+" dommages.");
        System.out.println("Joueur "+player_defense.player+" perd "+this.strength+" points de vie");
        player_defense.life -= this.strength;
        if(player_defense.life<=0){
            System.out.println("Joueur "+player_defense.player+" est mort");
        }
    }

    @Override
    public void specialAttack(Character player_defense){
        System.out.println("Joueur "+this.player+" utilise Coup de Rage et inflige "+this.strength*2+" dommages.");
        player_defense.life -= this.strength*2;
        System.out.println("Joueur "+player_defense.player+" perd "+this.strength*2+" points de vie");
        if(player_defense.life<=0){
            System.out.println("Joueur "+player_defense.player+" est mort");
        }
        System.out.println("Joueur "+this.player+" perd "+this.strength/2+" points de vie");
        this.life -= this.strength/2; 
    } 
}