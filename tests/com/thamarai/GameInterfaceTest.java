package com.thamarai;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameInterfaceTest {
    private GameInterface game = new GameInterface();


    @Test
    public void Given_Warrior_When_CreatePersonnageClass_Then_ReturnWarriorClass(){
        Personnage warrior1 =  game.createPersonnageClass(1,1,0,0,0,0);
        assertEquals(warrior1, warrior1);
    }

    @Test
    public void Given_Prowler_When_CreatePersonnageClass_Then_ReturnProwlerClass(){
        Personnage warrior1 =  game.createPersonnageClass(1, 2,0,0,0,0);
        assertEquals(warrior1, warrior1);
    }

    @Test
    public void Given_Mage_When_CreatePersonnageClass_Then_ReturnMageClass(){
        Personnage warrior1 =  game.createPersonnageClass(1, 3,0,0,0,0);
        assertEquals(warrior1, warrior1);
    }

    @Test
    public void Given_WrongNumber_When_CreatePersonnageClass_Then_ReturnWarriorClass(){
        Personnage warrior1 =  game.createPersonnageClass(1, 4,0,0,0,0);
        assertEquals(warrior1, warrior1);
    }

    @Test
    public void Given_Number_When_ChoiceNumber_Then_DisplayNumber(){
        String input = "60";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals(60, game.choiceNumber());
    }

    @Test
    public void Given_InputBiggerThanLevelPoint_When_ChoiceNumberByLevelPoint_Then_DisplayLevelPoint(){
        String input = "60";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals(20, game.choiceNumberByLevelPoint(20));
    }

    @Test
    public void Given_MinusLevelPoint_When_ChoiceNumberByLevelPoint_Then_DisplayZero(){
        String input = "60";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals(0, game.choiceNumberByLevelPoint(-20));
    }

    @Test
    public void Given_PositiveLevelPoint_When_ChoiceNumberByLevelPoint_Then_DisplayInputMinusLevelPoint(){
        String input = "10";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals(10, game.choiceNumberByLevelPoint(20));
    }

}
