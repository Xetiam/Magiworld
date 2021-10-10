import java.util.Scanner;
public class Fight {
    //Lance le jeu
    public static void startGame(){
        //Création des personnages
        Character playerOne = createCharacter(1);
        Character playerTwo = createCharacter(2);
        //COMBAT
        while((playerOne.getLife() > 0 )&&( playerTwo.getLife() > 0)){
            useSkill(playerOne,playerTwo);
            if(playerTwo.getLife()>0){
                useSkill(playerTwo,playerOne);
            }
        }
        if(playerOne.getLife()<=0){
            System.out.println("Joueur "+playerOne.getPlayer()+" a perdu !");
        }
        else{
            System.out.println("Joueur "+playerTwo.getPlayer()+" a perdu !");
        }
    }
    
    //Création d'un personnage
    public static Character createCharacter (int num){
        //Initialisation des variables
        int characterStrength = 0, characterAgility = 0, characterIntelligence = 0, characterClass = 0;
        while(characterClass != 1 && characterClass != 2 && characterClass != 3){
            System.out.println("Création du personnage du Joueur " + num +"\nVeuillez choisir la classe de votre personnage (1 : Guerrier, 2 : Rôdeur, 3 : Mage)");
            characterClass = myScanInt();
            if(characterClass != 1 && characterClass != 2 && characterClass != 3){
                System.out.println("Vous devez entrer une valeur comprise entre 1 et 3 pour choisir votre classe.");
            }
        }
        System.out.println("Niveau du personnage ?");
        int characterLevel = myScanInt();
        //Attribution des différentes valeur + vérification de respect des règles de créations
        while(characterLevel != characterStrength + characterAgility + characterIntelligence){
            System.out.println("Force du personnage ?");
            characterStrength = myScanInt();
            System.out.println("Agilité du personnage ?");
            characterAgility = myScanInt();
            System.out.println("Intelligence du personnage ?");
            characterIntelligence = myScanInt();                
            if(characterLevel != characterStrength + characterAgility + characterIntelligence){
                System.out.println("Vous ne respectez pas les règles de création. Rappel :\n Niveau = Force + Agilité + Intelligence");
            }
        }
        return initCharacter(characterClass, num,characterLevel, characterStrength, characterAgility, characterIntelligence);
    }
    
    //Instanciation du personnage
    public static Character initCharacter(int characterClass,int num,int characterLevel,int characterStrength,int characterAgility,int characterIntelligence){
        Character character;
        switch (characterClass) {
            case 1:
                character = new Warrior(num,characterLevel, characterStrength, characterAgility, characterIntelligence);         
                break;
            case 2:
                character = new Rogue(num,characterLevel, characterStrength, characterAgility, characterIntelligence);
                break;
            case 3:
                character = new Wizard(num,characterLevel, characterStrength, characterAgility, characterIntelligence);
                break;
            default:
                throw new IllegalStateException("Classe non valide");
        }
        return character;
    }

    //Utilisation d'une compétence
    public static void useSkill(Character playerAttack, Character playerDefense){
        //Initialisation des variables
        if(playerDefense.getLife()>0){    
            int choice = 0;
            //Choix de compétence
            System.out.println("Joueur "+playerAttack.getPlayer()+" ("+playerAttack.getLife()+" Vitalité) veuillez choisir votre action (1 : Attaque Basique, 2 : Attaque Spécial)");
            choice = myScanInt();
            //Résolution de l'effet
            if(choice == 1){
                playerAttack.basicAttack(playerDefense);
            }
            else if(choice == 2){
                playerAttack.specialAttack(playerDefense);
            }
            else{
                System.out.println("Joueur "+playerAttack.getPlayer()+" rate son attaque");
            }
        }
    }

    //Vérification de l'entrée utilisateur
    public static int myScanInt(){
        int val = 0;
        boolean error = true;
        Scanner sc = new Scanner(System.in);
        while(error){
            try {
                val = sc.nextInt();
                error = false;
            } catch (Exception e) {
                System.out.println("Vous n'avez pas entré une valeur valide. Veuillez saisir un nombre entier :");
                sc.next();
            }
        }
        //sc.close();
        return val;
    }
}

