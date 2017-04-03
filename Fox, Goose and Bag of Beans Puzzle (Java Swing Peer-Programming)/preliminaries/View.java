package preliminaries;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.DefaultCaret;

public class View implements Observer{

    private JFrame window;
    private JTextArea output;
    private JPanel controls;

    public JSlider getX() {
        return x;
    }

    public JSlider getY() {
        return y;
    }

    private JSlider x;
    private JSlider y;
    private JButton reset;

    // Constructor for the GUI that takes in a plane and runway
    public View(Controller controller, Dimension runway, Model model){

        window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Setting the size of the window
        window.setSize(600, 800);
        window.setLayout(new GridLayout(2,1));

        // setting a text area to output so that we can update the user on how the plane is doing
        output = new JTextArea();
        output.setEditable(false);

        // Caret acts like a pointer that points to the next line of text
        DefaultCaret caret = (DefaultCaret)output.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

        // Used this to create a scrollpane.
        JScrollPane scroll = new JScrollPane(output);

        controls = new JPanel();
        controls.setLayout(new BorderLayout(10,10));

        // Creating sliders and their listeners that update the plane speed and x position.
        x = new JSlider(JSlider.HORIZONTAL, 0, (int) runway.getWidth(), model.getX());
        y = new JSlider(JSlider.VERTICAL, 0, model.getMaxSpeed(), model.getSpeed());

        x.addChangeListener(controller);

        reset = new JButton("reset");

        // adding everything to the gui.
        controls.add(reset, BorderLayout.PAGE_END);
        controls.add(x, BorderLayout.PAGE_START);
        controls.add(y, BorderLayout.CENTER);

        window.add(scroll);
        window.add(controls);
        window.setVisible(true);



        x.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                model.setX(x.getValue());

            }
        });

        y.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                model.setSpeed(y.getValue());

            }
        });

    }



    public JTextArea getTextArea() {
        return output;
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
