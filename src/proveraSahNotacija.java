package com.example.igrasah;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class proveraSahNotacija {

    Igra igra;


    public boolean jeLiSahNotacijaDobra(String filePath) {
        igra = new Igra();
        try {
            String notacija = Files.readAllLines(Paths.get(filePath)).get(0);
            String[] parseNotacija = notacija.split(" ");
            int trPotezBrojac = 0;
            while(trPotezBrojac < parseNotacija.length) {


                String potezBelog = "", potezCrnog = "";
                potezBelog = parseNotacija[trPotezBrojac].substring(2);
                potezCrnog = parseNotacija[trPotezBrojac + 1];

                if(Character.isLowerCase(potezBelog.charAt(0))) {

                }


                trPotezBrojac += 2;
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}
