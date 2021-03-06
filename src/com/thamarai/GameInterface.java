package com.thamarai;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameInterface {

    /**
     * Method to start the game
     */
    public void gameBegin(){
        List<Personnage> personnages = new ArrayList<Personnage>();

        for(int i=1; i<3; i++){
            System.out.println("Création du personnage du Joueur "+i);
            personnages.add(personnageClassChoice(i));
        }

        do{
            if(personnages.get(0).getLife() > 1 && personnages.get(1).getLife() > 1){
                fight(personnages.get(0),personnages.get(1));
            }
            if(personnages.get(0).getLife() > 1 && personnages.get(1).getLife() > 1){
                fight(personnages.get(1), personnages.get(0));
            }
        }while((personnages.get(0).getLife() > 1) && (personnages.get(1).getLife() > 1));
    }

    /**
     * Method where personnage1 choose his attack to fight personnage2
     * @param personnage1
     * @param personnage2
     */
    public void fight(Personnage personnage1, Personnage personnage2){
        int choiceAttack = 0;
        System.out.println("Joueur "+personnage1.getGamerNumber()+" ("+personnage1.getLife()+" Vitalité) veuillez choisir votre action (1: Attaque Basique, 2: Attaque Spéciale)");
        do{
            try {
                Scanner scChoiceAttack = new Scanner(System.in);
                choiceAttack = scChoiceAttack.nextInt();
            } catch (Exception e){
                System.out.println("Ce n'est pas une entrée acceptée. Veuillez réessayer.");
            }
        }while(choiceAttack < 1 || choiceAttack > 2);

        attackChoice(personnage1, personnage2, choiceAttack);
    }

    /**
     * Method where personnage1 attack personnage2
     * @param personnage1
     * @param personnage2
     * @param choiceAttack
     */
    public void attackChoice(Personnage personnage1, Personnage personnage2, int choiceAttack){
        switch(choiceAttack){
            case 1:
                personnage1.basicAttack(personnage2);
                break;
            case 2:
                personnage1.specialAttack(personnage2);
                break;
        }
    }

    /**
     * Ask gamer to choice his Personnage class and his differents features
     * @param gamerNumber
     * @return personnage(Personnage)
     */
    public Personnage personnageClassChoice(int gamerNumber){
        int classChoice = 0;
        do{
            try {
                System.out.println("Veuillez choisir la classe de votre personnage (1: Guerrier, 2: Rôdeur, 3: Mage)");
                Scanner scClassChoice = new Scanner(System.in);
                classChoice = scClassChoice.nextInt();
            } catch (Exception e){
                System.out.println("Ce n'est pas une entrée acceptée. Veuillez réessayer.");
            }
        }while(classChoice < 1 || classChoice > 3);

        return setPersonnageParameters(gamerNumber, classChoice);
    }

    /**
     * Set all features of the personnage
     * @param gamerNumber
     * @param classChoice
     * @return Personnage
     */
    public Personnage setPersonnageParameters(int gamerNumber, int classChoice){
        System.out.println("Niveau du personnage ?");
        int choiceLevel = choiceNumber();
        int levelPoints = choiceLevel;
        System.out.println("Force du personnage ?");
        int choiceForce = choiceNumberByLevelPoint(levelPoints);
        levelPoints = levelPoints - choiceForce;
        System.out.println("Agilité du personnage ?");
        int choiceAgility = choiceNumberByLevelPoint(levelPoints);
        levelPoints = levelPoints - choiceAgility;
        System.out.println("Intélligence du personnage ?");
        int choiceIntelligence = choiceNumberByLevelPoint(levelPoints);

        return createPersonnageClass(gamerNumber, classChoice, choiceLevel, choiceForce, choiceAgility, choiceIntelligence);
    }

    /**
     * Create Personnage class by the classChoice of the gamer
     * @param gamerNumber
     * @param classChoice
     * @param choiceLevel
     * @param choiceForce
     * @param choiceAgility
     * @param choiceIntelligence
     * @return personnage(Personnage)
     */
    public Personnage createPersonnageClass(int gamerNumber, int classChoice, int choiceLevel, int choiceForce, int choiceAgility, int choiceIntelligence){
        switch (classChoice) {
            case 1:
                Personnage warrior = new Warrior(gamerNumber, choiceLevel, choiceForce, choiceAgility, choiceIntelligence);
                warrior.presentationMessage();
                return warrior;
            case 2:
                Personnage prowler = new Prowler(gamerNumber, choiceLevel, choiceForce, choiceAgility, choiceIntelligence);
                prowler.presentationMessage();
                return prowler;
            case 3:
                Personnage mage = new Mage(gamerNumber, choiceLevel, choiceForce, choiceAgility, choiceIntelligence);
                mage.presentationMessage();
                return mage;
            default:
                System.out.println("Cette classe n'existe pas, voici un personnage par défaut");
                Personnage byDefault = new Warrior(gamerNumber, choiceLevel, choiceForce, choiceAgility, choiceIntelligence);
                byDefault.presentationMessage();
                return  byDefault;
        }
    }

    /**
     * @return feat(int) the number of choices by the gamer
     */
    public int choiceNumber(){
        int feat = 0;
        do{
            try {
                Scanner choiceNumber = new Scanner(System.in);
                feat = choiceNumber.nextInt();
            } catch (Exception e){
                System.out.println("Vous devez saisir un nombre > 0 ou nombre < 100");
            }
        }while(feat <= 0 || feat > 100);

        return feat;
    }

    /**
     * @param levelPoints
     * @return feat(int) the number of feat choices by the gamer
     */
    public int choiceNumberByLevelPoint(int levelPoints){
        int feat = 0;
        do{
            if(levelPoints > 0){
                try {
                    Scanner choiceNumber = new Scanner(System.in);
                    feat = choiceNumber.nextInt();
                    if (levelPoints - feat < 0) {
                        feat = levelPoints;
                    }
                }
                catch(Exception e){
                    System.out.println("Vous devez saisir un nombre >= 0 ou nombre < 100");
                }
            } else{
                System.out.println("0");
                feat = 0;
            }
        }while(feat < 0 || feat > 100);

        return feat;
    }
}