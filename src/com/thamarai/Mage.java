package com.thamarai;

public class Mage extends Personnage{

    public Mage(int gamerNumber, int level, int force, int agility, int intelligence) {
        super(gamerNumber, level, force, agility, intelligence);
    }

    /**
     * Method to attack the adversary with a basic attack
     * @param perso
     */
    @Override
    public void basicAttack(Personnage perso) {
        System.out.println("Joueur "+this.getGamerNumber()+" utilise Boule de Feu et inflige "+this.getIntelligence()+ " dommages");
        System.out.println("Joueur "+perso.getGamerNumber()+" perd "+this.getIntelligence()+ " points de vie");
        perso.setLife(perso.getLife()-this.getIntelligence());

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
        int winLifePointDepart = this.getLevel()*5;
        int winLifePoint = this.getIntelligence()*2;

        System.out.println("Joueur "+this.getGamerNumber()+" utilise Soin");
        System.out.println("Joueur "+this.getGamerNumber()+" gagne "+winLifePoint+ " de vie");

        if((this.getLife() + winLifePoint) < winLifePointDepart){
            this.setLife(this.getLife() + winLifePoint);
        } else {
            this.setLife(winLifePointDepart - (this.getLife() + winLifePoint));
        }

        super.specialAttack(perso);
    }

    /**
     * Presentation of the personnage : Mage
     */
    @Override
    public void presentationMessage() {
        System.out.print("Abracadabra je suis le Magicien ");
        super.presentationMessage();
    }
}
