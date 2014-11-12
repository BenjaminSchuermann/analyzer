package garog.controller;

import garog.model.GarogModel;
import garog.view.GarogViewerGraph;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class GarogController implements ChangeListener {

    private GarogModel m;
    private GarogViewerGraph system;

    public GarogController(GarogViewerGraph system, GarogModel m) {
        this.system = system;
        this.m = m;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if(m.getListenLaenge()>900)
            m.setMovegraph(m.getListenLaenge() / 1000 * ((JSlider) e.getSource()).getValue());
        //Wenn der Sliderwert sich verändert hat, dann den aktuellen Wert in die Daten schreiben
        system.refresh();
        //m.setValue(((JSlider) e.getSource()).getValue());
    }
}