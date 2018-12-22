package com.thamarai;

public class Mage extends Personnage{

    public Mage(int gamerNumber, int level, int force, int agility, int intelligence) {
        super(gamerNumber, level, force, agility, intelligence);
    }

    @Override
    public void basicAttack(Personnage perso) {
        System.out.println("Joueur "+this.getGamerNumber()+" utilise Boule de Feu et inflige "+this.getIntelligence()+ " dommages");
        System.out.println("Joueur "+perso.getGamerNumber()+" perd "+this.getIntelligence()+ " point de vitalité");
        perso.setLife(perso.getLife()-this.getIntelligence());

        if(perso.getLife() <= 0){
            System.out.println("Joueur "+perso.getGamerNumber()+" est mort");
        }

        super.basicAttack(perso);
    }

    @Override
    public void specialAttack(Personnage perso) {
        int winLifePointDepart = this.getLevel()*5;
        int winLifePoint = this.getIntelligence()*2;

        System.out.println("Joueur "+this.getGamerNumber()+" utilise Soin");
        System.out.println("Joueur "+this.getGamerNumber()+" gagne "+winLifePoint+ " de vitalité");

        if((this.getLife() + winLifePoint) < winLifePointDepart){
            this.setLife(this.getLife() + winLifePoint);
        } else {
            this.setLife(winLifePointDepart - (this.getLife() + winLifePoint));
        }

        super.specialAttack(perso);
    }

    @Override
    public void presentationMessage() {
        System.out.print("Abracadabra je suis le Magicien ");
        super.presentationMessage();
    }
}
