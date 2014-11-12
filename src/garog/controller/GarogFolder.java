package garog.controller;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.io.File;

public class GarogFolder extends JComponent {

    private JFileChooser fc;

    public GarogFolder() {
        //FileChooser anlegen
        fc = new JFileChooser();
        //und nur auf Ordner beschränken
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);

        FileFilter filter = new FileFilter() {
            @Override
            public boolean accept(File f) {
                //measured values.csv
                return f.isDirectory() || f.getName().equals("measuredvalues.csv");
            }

            @Override
            public String getDescription() {
                return null;
            }
        };

        fc.setFileFilter((FileFilter) filter);
    }

    public File selectOrdner() {
        //Auswahl anzeigen
        int returnVal = fc.showOpenDialog(GarogFolder.this);
        //und prüfen ob ok
        File folder;
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            //wenn ok, Ordnerpfad übergeben
            folder = fc.getSelectedFile();
        } else {
            //wenn nicht, todo später im Linux
            folder = new File("/exit/");
        }
        return folder;
    }
}
