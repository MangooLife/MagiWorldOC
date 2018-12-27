package com.thamarai;

public class Warrior extends Personnage{

    public Warrior(int gamerNumber, int level, int force, int agility, int intelligence) {
        super(gamerNumber, level, force, agility, intelligence);
    }

    /**
     * Method to attack the adversary with a basic attack
     * @param perso
     */
    @Override
    public void basicAttack(Personnage perso) {
        System.out.println("Joueur "+this.getGamerNumber()+" utilise Coup d'Epée et inflige "+this.getForce()+ " dommages");
        System.out.println("Joueur "+perso.getGamerNumber()+" perd "+this.getForce()+ " point de vitalité");
        perso.setLife(perso.getLife()-this.getForce());

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
        int attackCoupDeRage = this.getForce()*2;
        int lostLifePoint = this.getForce()/2;

        System.out.println("Joueur "+this.getGamerNumber()+" utilise Coup de Rage et inflige "+attackCoupDeRage+ " dommages");
        System.out.println("Joueur "+perso.getGamerNumber()+" perd "+attackCoupDeRage+ " point de vitalité");
        perso.setLife(perso.getLife()-attackCoupDeRage);

        if(perso.getLife() <= 0){
            System.out.println("Joueur "+perso.getGamerNumber()+" est mort");
        }

        System.out.println("Joueur "+this.getGamerNumber()+" perd "+lostLifePoint+ " point de vitalité");
        this.setLife(this.getLife()-lostLifePoint);

        if(this.getLife() <= 0){
            System.out.println("Joueur "+perso.getGamerNumber()+" est mort");
        }

        super.specialAttack(perso);
    }

    /**
     * Presentation of the personnage : Warrior
     */
    @Override
    public void presentationMessage() {
        System.out.print("Woarg je suis le Guerrier ");
        super.presentationMessage();
    }
}
