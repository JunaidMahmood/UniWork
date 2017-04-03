package preliminaries;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.ArrayList;

public class Controller implements ChangeListener{
    private Model model;
    private JSlider x;

    public Controller(Model model) {

        this.model = model;
        x = new JSlider();
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        model.setX(x.getValue());
    }
}
