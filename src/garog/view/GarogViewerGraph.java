package garog.view;

import garog.model.GarogModel;

import javax.swing.*;
import java.awt.*;

public class GarogViewerGraph extends JComponent {
    private GarogModel m;

    private int[] graphValues;

    public GarogViewerGraph(GarogModel m) {
        // Daten initialisieren
        this.m = m;
        graphValues = new int[900];
    }

    public void refresh() {
        if (!(m.getListenLaenge() > 0))
            JOptionPane.showMessageDialog(null, "No valid file found");
        // Die Werte einen weiter schieben
        if (m.isDisplaytype()) {
            for (int i = 0; i < 899; i++) {
                if (i < m.getListenLaenge() - m.getMovegraph()) {
                    if (m.getMesserte(i + m.getMovegraph()) <= 90) {
                        graphValues[i] = m.getMesserte(i + m.getMovegraph()) * 2 + 180;
                    } else if (m.getMesserte(i + m.getMovegraph()) > 90 && m.getMesserte(i + m.getMovegraph()) <= 180) {
                        graphValues[i] = 540 - (m.getMesserte(i + m.getMovegraph()) * 2);
                    } else if (m.getMesserte(i + m.getMovegraph()) > 180 && m.getMesserte(i + m.getMovegraph()) <= 270) {
                        graphValues[i] = 180 - ((m.getMesserte(i + m.getMovegraph()) - 180) * 2);
                    } else if (m.getMesserte(i + m.getMovegraph()) > 270 && m.getMesserte(i + m.getMovegraph()) <= 360) {
                        graphValues[i] = ((m.getMesserte(i + m.getMovegraph()) - 270) * 2);
                    }
                } else
                    graphValues[i] = 0;
            }
        } else {
            for (int i = 0; i < 899; i++) {
                if (i < m.getListenLaenge() - m.getMovegraph())
                    graphValues[i] = m.getMesserte(i + m.getMovegraph());
                else
                    graphValues[i] = 0;
            }
        }

        repaint();
    }

    private void restart() {
        // zu Beginn alles zurücksetzen für die Kurve
        //m.resetListen();
        //m.setStartzeit(System.currentTimeMillis());
        //for (int i = 0; i < graphValues.length; i++)
        //{
        //    graphValues[i] = 0;
        // }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Weißes Tracefeld anlegen
        g.setColor(Color.DARK_GRAY);
        g.fillRect(46, 40, 900, 360);
        // schwarze Tracefeldumrand anlegen
        g.setColor(Color.BLACK);
        g.drawLine(45, 40, 45, 400);
        g.drawLine(45, 400, 945, 400);
        // Beschriftung erzeugen
        // Zeitleiste Achse x
        for (Double timeline = 0.0; timeline >= -9.0; timeline = timeline - 0.5) {
            //g.drawString(timeline.toString(), 930 + (int) (timeline * 100), 415);
        }
        // Gradleiste Achse y
        for (Integer degree = 0; degree <= 360; degree = degree + 30) {
            String textdegree[];
            if (m.isDisplaytype())
                textdegree = m.getSinus();
            else
                textdegree = m.getHaifisch();

            // Um den Text "rechtsbündig" darzustellen
            //g.drawString(degree.toString(), 20, 405 - degree);
            g.drawString(textdegree[degree / 30], 20, 405 - degree);
        }
        // Hilfslinienfarbe
        g.setColor(Color.GRAY);
        // Die Hilfslinien für Zeit (vertikal)
        for (int i = 0; i < 18; i++) {
            g.drawLine(95 + (i * 50), 40, 95 + (i * 50), 400);
        }
        // Die Hilfslinien für Grad (horizontal)
        for (int i = 0; i < 6; i++) {
            g.drawLine(45, 40 + (i * 60), 945, 40 + (i * 60));
        }
        // zu guter Letzt die schwarze Kurve zeichnen
        g.setColor(Color.GREEN);
        for (int i = 1; i < 900; i++) {
            g.drawLine(i + 46, (360 - graphValues[i - 1]) + 40, i + 46, (360 - graphValues[i]) + 40);
        }
    }
}
