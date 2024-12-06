package com.example.igrasah;

import java.util.List;

public class Testovi {


    private class Polje {
        char x;
        int y;
    }

    Igra igra;
    List<Polje> potezi;
    public Testovi(Igra igra) {
        this.igra = igra;
    }
    public boolean dvaPutaBeli() {
        return false;
    }
}
