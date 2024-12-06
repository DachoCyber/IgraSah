package com.example.igrasah;

import java.util.ArrayList;
import java.util.Scanner;

public class Pesak extends Figura {

    public Pesak(Boja boja, Figura[] sahovskaTabla) {
        super(boja, sahovskaTabla);
    }

    @Override
    public boolean daLiJePotezMoguc(int indexStart, int indexKraj) {
        if (!unutarTablePotez(indexKraj)) return false;

        int[] start = hashIndex(indexStart);
        int[] end = hashIndex(indexKraj);

        int direction = this.getBoja().equals(Boja.BELI) ? 1 : -1; // Forward direction for white or black pawns
        int startRow = this.getBoja().equals(Boja.BELI) ? 1 : 6;   // Starting row for white or black pawns

        // Forward move (1 step)
        if (end[0] == start[0] && end[1] == start[1] + direction) {
            return sahovskaTabla[indexKraj] == null;
        }

        // Forward move (2 steps from starting position)
        if (end[0] == start[0] && end[1] == start[1] + 2 * direction && start[1] == startRow) {
            return sahovskaTabla[indexKraj] == null && sahovskaTabla[hashKoord(start[0], start[1] + direction)] == null;
        }

        // Diagonal attack
        if (Math.abs(end[0] - start[0]) == 1 && end[1] == start[1] + direction) {
            return sahovskaTabla[indexKraj] != null && !sahovskaTabla[indexKraj].getBoja().equals(this.getBoja());
        }

        return false;
    }

    @Override
    public ArrayList<Integer> napadnutaPolja(int trPozicijaIndex) {
        ArrayList<Integer> napadnutaPoljaNiz = new ArrayList<>();
        int[] start = hashIndex(trPozicijaIndex);

        int direction = this.getBoja().equals(Boja.BELI) ? 1 : -1;

        // Add both diagonal attack positions if valid
        if (unutarTablePotez(hashKoord(start[0] - 1, start[1] + direction))) {
            napadnutaPoljaNiz.add(hashKoord(start[0] - 1, start[1] + direction));
        }
        if (unutarTablePotez(hashKoord(start[0] + 1, start[1] + direction))) {
            napadnutaPoljaNiz.add(hashKoord(start[0] + 1, start[1] + direction));
        }

        return napadnutaPoljaNiz;
    }
    public Figura promocija(int indexKraj, boolean jePromocija) {
        if(!unutarTablePotez(indexKraj)) return null;
        if(indexKraj >= 56 || indexKraj <= 7) {
            jePromocija = true;
            System.out.println("Za promociju pesaka u Damu pritisnite slovo D.\n" +
                    "Za promociju pesaka u Skakaca pritisnite slovo S.\n" +
                    "Za promociju pesaka u Topa pritisnite slovo T.\n" +
                    "Za promociju pesaka u Lovca pritisnite slovo L.\n");
            Scanner scanner = new Scanner(System.in);
            char figuraChar = scanner.next().charAt(0);
            Figura promocijaFigura;
            Boja boja = (indexKraj >= 56) ? Boja.BELI : Boja.CRNI;
            switch(figuraChar) {
                case 'D' :
                    promocijaFigura = new Kraljica(boja, sahovskaTabla);
                    break;
                case 'S' :
                    promocijaFigura = new Skakac(boja, sahovskaTabla);
                    break;
                case 'T' :
                    promocijaFigura = new Top(boja, sahovskaTabla, Strana.NEUTRALNA);
                case 'L' :
                    promocijaFigura = new Lovac(boja, sahovskaTabla);
                default:
                    throw new IllegalArgumentException("Unesite slovo D, S, T ili L!");
            }
            sahovskaTabla[indexKraj] = promocijaFigura;
        }
        jePromocija = false;
        return this;
    }
}
