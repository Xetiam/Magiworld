import java.util.Scanner;
public class Fight {
    public static void startGame(){
        //Création des personnages
        Character player_one = createCharacter(1);
        Character player_two = createCharacter(2);
        //COMBAT
        while((player_one.getLife() > 0 )&( player_two.getLife() > 0)){
            useSkill(player_one,player_two);
            if(player_two.getLife()>0){
                useSkill(player_two,player_one);
            }
        }
        if(player_one.getLife()<=0){
            System.out.println("Joueur "+player_one.getPlayer()+" a perdu !");
        }
        else{
            System.out.println("Joueur "+player_two.getPlayer()+" a perdu !");
        }
    }
    
    //Création d'un personnage
    public static Character createCharacter (int num){
        //Initialisation des variables
        Scanner sc = new Scanner(System.in);
        int character_strength = 0, character_agility = 0, character_intelligence = 0, character_class = 0;
        while(character_class != 1 && character_class != 2 && character_class != 3){
            System.out.println("Création du personnage du Joueur " + num +"\nVeuillez choisir la classe de votre personnage (1 : Guerrier, 2 : Rôdeur, 3 : Mage)");
            character_class = sc.nextInt();
            if(character_class != 1 && character_class != 2 && character_class != 3){
                System.out.println("Vous devez entrer une valeur comprise entre 1 et 3 pour choisir votre classe.");
            }
        }
        System.out.println("Niveau du personnage ?");
        int character_level = sc.nextInt();
        //Attribution des différentes valeur + vérification de respect des règles de créations
        while(character_level != character_strength + character_agility + character_intelligence){
            System.out.println("Force du personnage ?");
            character_strength = sc.nextInt();
            System.out.println("Agilité du personnage ?");
            character_agility = sc.nextInt();
            System.out.println("Intelligence du personnage ?");
            character_intelligence = sc.nextInt();
            if(character_level != character_strength + character_agility + character_intelligence){
                System.out.println("Vous ne respectez pas les règles de création. Rappel :\n Niveau = Force + Agilité + Intelligence");
            }
        }
        sc.close();
        return initCharacter(character_class, num,character_level, character_strength, character_agility, character_intelligence);
    }

    
    //Instanciation du personnage
    public static Character initCharacter(int character_class,int num,int character_level,int character_strength,int character_agility,int character_intelligence){
        Character character;
        switch (character_class) {
            case 1:
                character = new Warrior(num,character_level, character_strength, character_agility, character_intelligence);         
                break;
            case 2:
                character = new Rogue(num,character_level, character_strength, character_agility, character_intelligence);
                break;
            case 3:
                character = new Wizard(num,character_level, character_strength, character_agility, character_intelligence);
                break;
            default:
                character = new Warrior(0,0,0,0,0);
                break;
        }
        return character;
    }

    //Utilisation d'une compétence
    public static void useSkill(Character player_attack, Character player_defense){
        //Initialisation des variables
        Scanner sc = new Scanner(System.in);
        //Choix de compétence
        System.out.println("Joueur "+player_attack.getPlayer()+" ("+player_attack.getLife()+" Vitalité) veuillez choisir votre action (1 : Attaque Basique, 2 : Attaque Spécial)");
        int choice = sc.nextInt();
        //Résolution de l'effet
        if(choice == 1){
            player_attack.basicAttack(player_defense);
        }
        else if(choice == 2){
            player_attack.specialAttack(player_defense);
        }
        else{
            System.out.println("Joueur "+player_attack.getPlayer()+" rate son attaque");
        }
        sc.close();
    }
}

