package garog.view;

import garog.controller.GarogController;
import garog.controller.GarogLoadFile;
import garog.controller.GarogSwitchView;
import garog.model.GarogModel;

import javax.swing.*;
import java.awt.*;

import static javax.swing.SwingConstants.HORIZONTAL;

public class GarogViewerFrame extends JFrame {

    public GarogViewerFrame(GarogModel m) {
        setSize(1024, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(Color.LIGHT_GRAY);

        final GarogViewerGraph system = new GarogViewerGraph(m);
        setContentPane(system);

        //Überschrift
        JLabel ueberschift = new JLabel("Analyzer");
        ueberschift.setBounds(46, 10, 300, 28);
        ueberschift.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 24));
        add(ueberschift);

        // Slider anzeigen
        MySlider slider = new MySlider(HORIZONTAL, 0, 1000, 10);
        slider.setBounds(46, 401, 900, 20);
        slider.addChangeListener(new GarogController(system, m));
        add(slider);

        //Load Button anlegen
        MyButton loadfile = new MyButton("Open File");
        loadfile.setBounds(46, 460, 200, 60);
        loadfile.addActionListener(new GarogLoadFile(system, m));
        add(loadfile);

        //Ansicht wechseln Button anlegen
        MyToggle switchview = new MyToggle("Switch View");
        switchview.setBounds(746, 460, 200, 60);
        switchview.addActionListener(new GarogSwitchView(system, m));
        add(switchview);

        setVisible(true);
    }
}
