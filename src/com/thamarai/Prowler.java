package com.thamarai;

public class Prowler extends Personnage{

    public Prowler(int gamerNumber, int level, int force, int agility, int intelligence) {
        super(gamerNumber, level, force, agility, intelligence);
    }

    /**
     * Method to attack the adversary with a basic attack
     * @param perso
     */
    @Override
    public void basicAttack(Personnage perso) {
        System.out.println("Joueur "+this.getGamerNumber()+" utilise Tir à l'Arc et inflige "+this.getAgility()+ " dommages");
        System.out.println("Joueur "+perso.getGamerNumber()+" perd "+this.getAgility()+ " points de vie");
        perso.setLife(perso.getLife()-this.getAgility());

        if(perso.getLife() <= 0){
            System.out.println("Joueur "+perso.getGamerNumber()+" est mort");
        }

        super.basicAttack(perso);
    }

    /**
     * Method to attack the adversary with a special attack
     * @param perso
     */
    @Override
    public void specialAttack(Personnage perso) {
        int winAgilityPoint = this.getLevel()/2;

        System.out.println("Joueur "+this.getGamerNumber()+" utilise Concentration");
        System.out.println("Joueur "+this.getGamerNumber()+" gagne "+winAgilityPoint+ " d'agilité");
        this.setAgility(this.getAgility()+winAgilityPoint);

        super.specialAttack(perso);
    }

    /**
     * Presentation of the personnage : Prowler
     */
    @Override
    public void presentationMessage() {
        System.out.print("Tssss je suis le Rôdeur ");
        super.presentationMessage();
    }
}
