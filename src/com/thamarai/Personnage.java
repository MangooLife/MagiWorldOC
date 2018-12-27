package com.thamarai;

public abstract class Personnage {

    protected int gamerNumber;
    protected int level;
    protected int life;
    protected int force;
    protected int agility;
    protected int intelligence;

    public int getGamerNumber() {
        return gamerNumber;
    }

    public int getLevel() {
        return level;
    }

    public int getLife() {
        return life;
    }

    public int getForce() {
        return force;
    }

    public int getAgility() {
        return agility;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public Personnage(int gamerNumber, int level, int force, int agility, int intelligence){
        this.gamerNumber = gamerNumber;
        this.level = level;
        this.life = this.level * 5;
        this.force = force;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    /**
     * Method to attack the adversary with a basic attack
     * @param perso
     */
    public void basicAttack(Personnage perso){
        if(perso.getLife() <= 0){
            System.out.println("Joueur "+perso.getGamerNumber()+" a perdu !");
        }
        if(this.getLife() <= 0){
            System.out.println("Joueur "+this.getGamerNumber()+" a perdu !");
        }
    }

    /**
     * Method to attack the adversary with a special attack
     * @param perso
     */
    public void specialAttack(Personnage perso){
        if(perso.getLife() <= 0){
            System.out.println("Joueur "+perso.getGamerNumber()+" a perdu !");
        }
        if(this.getLife() <= 0){
            System.out.println("Joueur "+this.getGamerNumber()+" a perdu !");
        }
    }

    /**
     * Presentation message when gamers create their personnages
     */
    public void presentationMessage(){
        System.out.println("Joueur "+this.gamerNumber+" niveau "+this.level+" je possède "+this.life+" de vitalité, "+this.force+" de force, "+this.agility+" d'agilité et "+this.intelligence+" d'intelligence !");
    }
}
