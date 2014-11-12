package garog;

import garog.model.GarogModel;
import garog.view.GarogViewerFrame;

public class GarogMain
{
    public static void main(String[] args)
    {
        GarogModel m = new GarogModel();
        new GarogViewerFrame(m);
    }
}
