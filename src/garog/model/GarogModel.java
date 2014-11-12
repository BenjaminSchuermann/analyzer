package garog.model;

import java.util.ArrayList;

//Die "Daten" welche an den unterschiedlichsten Stellen gebraucht werden
//per getter und setter zur Verfügung stellen inkl. extra Methoden wie dem leeren von Arrays

public class GarogModel {
    private ArrayList<Integer> messwerte;

    private int movegraph;

    private boolean displaytype;

    public GarogModel() {
        messwerte = new ArrayList<Integer>();
        movegraph = 0;
        displaytype = false;
    }

    public void setMesswerte(int messwert) {
        this.messwerte.add(messwert);
    }

    public Integer getMesserte(int index) {
        return messwerte.get(index);
    }

    public void resetListen() {
        messwerte.clear();
    }

    public int getListenLaenge() {
        return messwerte.size();
    }

    public int getMovegraph() {
        return movegraph;
    }

    public void setMovegraph(int movegraph) {
        this.movegraph = movegraph;
    }

    public boolean isDisplaytype() {
        return displaytype;
    }

    public void setDisplaytype(boolean displaytype) {
        this.displaytype = displaytype;
    }

}
