public class Wizard extends Character {
    //Classe représentant les personnages guerrier

    //Constructeur
    public Wizard(int player, int level, int strength, int agility, int intelligence){
        super(player,level,strength,agility,intelligence);
        System.out.println("Abracadabra je suis le mage Joueur "+this.getPlayer()+" niveau "+this.getLevel()+" je possède "+this.getLife()+" de vitalité, "+this.getStrength()+" de force, "+this.getAgility()+" d'agilité et "+this.getIntelligence()+" d'intelligence !");
    }

    //Méthode de combat
    @Override
    public void basicAttack(Character player_defense){
        System.out.println("Joueur "+this.getPlayer()+" utilise Boule de Feu et inflige "+this.getIntelligence()+" dommages.");
        System.out.println("Joueur "+player_defense.getPlayer()+" perd "+this.getIntelligence()+" points de vie");
        player_defense.setDamage(this.getIntelligence());
        if(player_defense.getLife()<=0){
            System.out.println("Joueur "+player_defense.getPlayer()+" est mort");
        }
    }

    @Override
    public void specialAttack(Character player_defense){
        if(this.getIntelligence()*2 + this.getLife() < this.getLevel()*5){
            this.setDamage(-this.getIntelligence()*2);
        } 
        else{
            this.resetLife();
        }
        System.out.println("Joueur "+this.getPlayer()+" utilise Soin et gagne "+this.getIntelligence()*2+" point de vie.");
    } 
}