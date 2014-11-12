package garog.controller;

import garog.model.GarogModel;
import garog.view.GarogViewerGraph;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class GarogLoadFile implements ActionListener {

    GarogViewerGraph system;
    GarogModel m;

    public GarogLoadFile(GarogViewerGraph system,GarogModel m) {
        this.system = system;
        this.m = m;
    }

    private void loadFile() {
            //Dateipfad angeben
            File file = selectFile();
            if(!file.exists()) {
                JOptionPane.showMessageDialog(null, "Path not valid");
                return;
            }
            try {
                BufferedReader in = new BufferedReader(new FileReader(file));
                String zeile = null;
                String werte[];
                m.resetListen();
                while ((zeile = in.readLine()) != null) {
                    werte = zeile.split(";");
                    //System.out.println("Gelesene Zeile: " + zeile);
                    try {
                        int testparse = Integer.parseInt(werte[0]);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "File not valid");
                        return;
                    }
                    m.setMesswerte(Integer.parseInt(werte[0]),Integer.parseInt(werte[1]));
                }
                system.refresh();
            } catch (IOException e) {

                e.printStackTrace();
            }
    }

    //Den Ordner angeben
    private File selectFile() {
        File folderpath;

        //Ordnerauswahl treffen
        folderpath = new GarogFolder().selectOrdner();

        return folderpath;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        loadFile();
    }
}
