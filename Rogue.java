public class Rogue extends Character {
    //Classe représentant les personnages rôdeurs

    //Constructeur
    public Rogue(int player, int level, int strength, int agility, int intelligence){
        super(player, level,strength,agility,intelligence);
        System.out.println("*Bruit d'un arc qui se bande* je suis le rôdeur Joueur "+this.player+" niveau "+this.level+" je possède "+this.life+" de vitalité, "+this.strength+" de force, "+this.agility+" d'agilité et "+this.intelligence+" d'intelligence !");
    }

    //Méthode de combat
    @Override
    public void basicAttack(Character player_defense){
        System.out.println("Joueur "+this.player+" utilise Tire à l'Arc et inflige "+this.agility+" dommages.");
        System.out.println("Joueur "+player_defense.player+" perd "+this.agility+" points de vie");
        player_defense.life += this.agility;
        if(player_defense.life<=0){
            System.out.println("Joueur "+player_defense.player+" est mort");
        }
    }

    @Override
    public void specialAttack(Character player_defense){
        System.out.println("Joueur "+this.player+" utilise Concentration "+this.level/2+" en agilité.");
        this.agility+=this.level/2;
    } 
}