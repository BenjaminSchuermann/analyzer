package garog.controller;

import garog.model.GarogModel;
import garog.view.GarogViewerGraph;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Benjamin on 12.11.2014.
 */
public class GarogSwitchView implements ActionListener{

    GarogViewerGraph system;
    GarogModel m;

    public GarogSwitchView(GarogViewerGraph system,GarogModel m) {
        this.system = system;
        this.m = m;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        m.setDisplaytype(((JToggleButton) e.getSource()).isSelected());
        system.refresh();
    }
}
