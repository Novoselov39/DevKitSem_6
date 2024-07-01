package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        HashMap<Integer, Boolean> result = new HashMap<>();
        int chekVinChange =0;
        int chekVinNoChange=0;


        for (int i = 0; i < 1000; i++) {

            Boolean resultGame = game(true);
            result.put(i, resultGame);
            if (resultGame) {
                chekVinChange++;
            }

        }
        for (int i = 1000; i <= 2000; i++) {

            Boolean resultGame = game(false);
            result.put(i, resultGame);
            if (resultGame) {
                chekVinNoChange++;
            }

        }

        System.out.println("со сменой двери победило: " + chekVinChange +" человек из 1000");
        System.out.println("без смены двери победило: " + chekVinNoChange +" человек из 1000");


    }

    public static Boolean game(Boolean change){
        int[] door = {1,2,3};
        Random random = new Random();
        int playerСhoice =random.nextInt(1,4);
        int doorCar = random.nextInt(1,4);
        //boolean change = random.nextBoolean();


        if (change) {

            if (changeDoor(playerСhoice,doorCar,door)==doorCar){
                return  true;
            }else {
                return false;
            }

        }else
        {

            if (changeDoor(playerСhoice,doorCar,door)==doorCar){
                return true;
            }else {
                return false;
            }
        }



    }

    public static int changeDoor(int playerСhoice, int doorCar, int[] door){
        int doorOpen = Arrays.stream(door).filter(c->c!=playerСhoice & c!=doorCar).toArray()[0];
        for (int i:door){
            if (playerСhoice!=i & doorOpen!=i)
                return i;
        }

        return 0;
    }
}