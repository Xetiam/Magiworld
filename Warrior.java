public class Warrior extends Character {
    //Classe représentant les personnages guerriers

    //Constructeur
    public Warrior(int player, int level, int strength, int agility, int intelligence){
        super(player, level,strength,agility,intelligence);
        System.out.println("Woarg je suis le Guerrier Joueur "+this.player+" niveau "+this.level+" je possède "+this.life+" de vitalité, "+this.strength+" de force, "+this.agility+" d'agilité et "+this.intelligence+" d'intelligence !");
    }

    //Méthode de combat
    @Override
    public void basicAttack(Character playerDefense){
        System.out.println("Joueur "+this.player+" utilise Coup d'Épée et inflige "+this.strength+" dommages.");
        System.out.println("Joueur "+playerDefense.player+" perd "+this.strength+" points de vie");
        playerDefense.life -= this.strength;
        if(playerDefense.life<=0){
            System.out.println("Joueur "+playerDefense.player+" est mort");
        }
    }

    @Override
    public void specialAttack(Character playerDefense){
        System.out.println("Joueur "+this.player+" utilise Coup de Rage et inflige "+this.strength*2+" dommages.");
        playerDefense.life -= this.strength*2;
        System.out.println("Joueur "+playerDefense.player+" perd "+this.strength*2+" points de vie");
        if(playerDefense.life<=0){
            System.out.println("Joueur "+playerDefense.player+" est mort");
        }
        System.out.println("Joueur "+this.player+" perd "+this.strength/2+" points de vie");
        this.life -= this.strength/2;
        if(this.life<=0){
            System.out.println("Joueur "+this.player+" est mort");
        } 
    } 
}