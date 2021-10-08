public class Wizard extends Character {
    //Classe représentant les personnages mages

    //Constructeur
    public Wizard(int player, int level, int strength, int agility, int intelligence){
        super(player,level,strength,agility,intelligence);
        System.out.println("Abracadabra je suis le mage Joueur "+this.player+" niveau "+this.level+" je possède "+this.life+" de vitalité, "+this.strength+" de force, "+this.agility+" d'agilité et "+this.intelligence+" d'intelligence !");
    }

    //Méthode de combat
    @Override
    public void basicAttack(Character playerDefense){
        System.out.println("Joueur "+this.player+" utilise Boule de Feu et inflige "+this.intelligence+" dommages.");
        System.out.println("Joueur "+playerDefense.player+" perd "+this.intelligence+" points de vie");
        playerDefense.life -= this.intelligence;
        if(playerDefense.life<=0){
            System.out.println("Joueur "+playerDefense.player+" est mort");
        }
    }

    @Override
    public void specialAttack(Character playerDefense){
        if(this.intelligence*2 + this.life < this.level*5){
            this.life += this.intelligence*2;
        } 
        else{
            this.resetLife();
        }
        System.out.println("Joueur "+this.player+" utilise Soin et gagne "+this.intelligence*2+" point de vie.");
    } 
}