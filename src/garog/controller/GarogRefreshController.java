package garog.controller;

import garog.view.GarogViewerGraph;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GarogRefreshController implements ActionListener

{
    private GarogViewerGraph vg;


    public GarogRefreshController(GarogViewerGraph vg)
    {
        this.vg = vg;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        // Je nach Zustand den Text des Buttons ändern und den Timer
        // starten/stoppen
        vg.refresh();
    }
}