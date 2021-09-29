public class Rogue extends Character {
    //Classe représentant les personnages guerrier

    //Constructeur
    public Rogue(int player, int level, int strength, int agility, int intelligence){
        super(player, level,strength,agility,intelligence);
        System.out.println("*Bruit d'un arc qui se bande* je suis le rôdeur Joueur "+this.getPlayer()+" niveau "+this.getLevel()+" je possède "+this.getLife()+" de vitalité, "+this.getStrength()+" de force, "+this.getAgility()+" d'agilité et "+this.getIntelligence()+" d'intelligence !");
    }

    //Méthode de combat
    @Override
    public void basicAttack(Character player_defense){
        System.out.println("Joueur "+this.getPlayer()+" utilise Tire à l'Arc et inflige "+this.getAgility()+" dommages.");
        System.out.println("Joueur "+player_defense.getPlayer()+" perd "+this.getAgility()+" points de vie");
        player_defense.setDamage(this.getAgility());
        if(player_defense.getLife()<=0){
            System.out.println("Joueur "+player_defense.getPlayer()+" est mort");
        }
    }

    @Override
    public void specialAttack(Character player_defense){
        System.out.println("Joueur "+this.getPlayer()+" utilise Concentration "+this.getLevel()/2+" en agilité.");
        this.setAgility(this.getAgility()+this.getLevel()/2);
    } 
}