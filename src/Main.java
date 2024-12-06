package com.example.igrasah;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Igra igra = new Igra();



        /*String potez;
        String bojaTrenutnogIgraca;
        while(!igra.jeIgraZavrsena) {
            bojaTrenutnogIgraca = "beli";
            Scanner sc = new Scanner(System.in);

            potez = sc.nextLine();
            igra.handlePlayerMove(potez, );

            bojaTrenutnogIgraca = "crni";
        }*/

        igra.igrajSah();

        if(igra.jeCrniKraljMatiran) {
            System.out.println("Crni kralj je matiran!");
        } else if(igra.jeBeliKraljMatiran) {
            System.out.println("Beli kralj je matiran!");
        } else if(igra.jeRemi) {
            System.out.println("Igra je zavrsena remijem!");
        }
    }
}
