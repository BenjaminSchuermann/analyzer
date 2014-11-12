package garog.model;

import java.util.ArrayList;

//Die "Daten" welche an den unterschiedlichsten Stellen gebraucht werden
//per getter und setter zur Verfügung stellen inkl. extra Methoden wie dem leeren von Arrays

public class GarogModel
{
    private int value;

    private ArrayList<Integer> messwerte;

    private ArrayList<Integer> zeitstempel;

    private long startzeit;

    private boolean startstop;

    private int movegraph;

    private boolean displaytype;

    private String haifisch[] = {"0","30","60","90","120","150","180","210","240","270","300","330","360"};

    private String sinus[] = {"180","150","120","90","60","30","0","30","60","90","120","150","180"};

    public GarogModel()
    {
        value = 0; // init
        messwerte = new ArrayList<Integer>();
        zeitstempel = new ArrayList<Integer>();
        startzeit = 0;
        startstop = false;
        movegraph = 0;
        displaytype = false;
    }

    public void setMesswerte(int zeitstempel, int messwert)
    {
        this.zeitstempel.add(zeitstempel);
        this.messwerte.add(messwert);
    }

    public Integer getZeitstemple(int index)
    {
        return zeitstempel.get(index);
    }

    public Integer getMesserte(int index)
    {
        return messwerte.get(index);
    }

    public void resetListen()
    {
        messwerte.clear();
        zeitstempel.clear();
    }

    public int getListenLaenge()
    {
        return messwerte.size();
    }

    public int getValue()
    {
        return value;
    }

    public void setValue(int value)
    {
        this.value = value;
    }

    public long getStartzeit()
    {
        return startzeit;
    }

    public void setStartzeit(long startzeit)
    {
        this.startzeit = startzeit;
    }

    public boolean isStartstop() {
        return startstop;
    }

    public void setStartstop(boolean startstop) {
        this.startstop = startstop;
    }

    public int getMovegraph() {
        return movegraph;
    }

    public void setMovegraph(int movegraph) {
        this.movegraph = movegraph;
    }

    public void addMovegraph(int movegraph) {
        this.movegraph = this.movegraph + movegraph;
    }

    public boolean isDisplaytype() {
        return displaytype;
    }

    public void setDisplaytype(boolean displaytype) {
        this.displaytype = displaytype;
    }

    public String[] getHaifisch() {
        return haifisch;
    }

    public String[] getSinus() {
        return sinus;
    }
}
