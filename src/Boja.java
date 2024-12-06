package com.example.igrasah;

public enum Boja {
    BELI, CRNI;
    public boolean equals(Boja boja) {
        return boja.ordinal() == this.ordinal();
    }
    public String toString() {
        if(this.equals(BELI)) {
            return "Beli";
        } return "Crni";
    }
}
