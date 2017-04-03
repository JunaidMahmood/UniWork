/**
 * This is the driver class which holds the GUI layout of the simulator and the widgets. The main loop, change listener and
 * conditional statements are also held here.
 */
package GUI;
import CW12.Plane;
import javax.swing.text.DefaultCaret;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JSlider;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import CW12.Runway;
import CW5.Coordinates;


public class Driver {

    // this is the main method
    public static void main(String[] args) {

        Coordinates coordinates = new Coordinates(5, 0); // Coordinates object to access the class

        JFrame myFrame = new JFrame("Flight Simulator"); // created new JFrame with the with its title

        myFrame.setLayout(new BorderLayout()); // set the layout of the frame with a border layout
        myFrame.setSize(500, 700); // we have set the default size of the frame when it is run

        JPanel main = new JPanel(new BorderLayout()); // created a new JPanel with a border layout
        JPanel jpCentre = new JPanel(new GridLayout(2, 1)); // created JPanel with a grid layout with two rows for the text area and sliders
        JPanel jpBottom = new JPanel(); // created JPanel for the bottom

        myFrame.add(jpCentre, BorderLayout.CENTER); // JPanel add to the center of the frame
        myFrame.add(jpBottom, BorderLayout.SOUTH); // JPanel add to the bottom of the frame

        JTextArea outputMessage = new JTextArea(2, 4); // this is the JTextArea were we output the status of the simulator and whether the flight was successful or not
        JButton resetButton = new JButton("Reset"); // this is the JButton for resetting the simulator
        JSlider stickSlider = new JSlider(JSlider.HORIZONTAL, 0, 10, 5); // this is the horizontal slider for controlling the x position of the plane
        JSlider throttleSlider = new JSlider(JSlider.VERTICAL, 0, 10, 0); // this is the vertical slider for controlling the speed of the plane
        JScrollPane jsp = new JScrollPane(outputMessage); // this is the JScrollPanel which includes the text area

        outputMessage.setEditable(false); // does not allow you to edit the text area
        jpCentre.add(jsp); // add the scroll panel with text area to the centre of the frame
        jpCentre.add(main); // add the main panel to the frame with the first border layout

        DefaultCaret autoScroll = (DefaultCaret)outputMessage.getCaret(); // allows auto scrolling of the scroll panel when the text hits the bottom of the text area
        autoScroll.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

        main.add(stickSlider, BorderLayout.NORTH); // add the horizontal slider to the top of the bottom panel
        main.add(throttleSlider, BorderLayout.CENTER); // add the vertical slider under the horizontal slider in the bottom panel
        jpBottom.add(resetButton); // add the reset button to the bottom of the frame in the bottom panel

        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exits simulator and ends process when app is closed
        myFrame.setVisible(true); // allows the frame to be seen

        Plane plane = new Plane(); // plane object to access class
        Runway runway = new Runway(); // runway object to access the class

        /**
         * change listener for the throttle slider which checks if the slider has been changed and returns the value, it then sets the speed
         * in the plane class so that the updated value is appended in the text area
         */
        throttleSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider) e.getSource();
                if(source.getValueIsAdjusting())
                    return;

                plane.setSpeed(source.getValue());
            }
        });

        /**
         * change listener for the horizontal/x-coordinate slider  which checks if the slider has been changed and returns the value, it then sets the x coordinate
         * in the plane class so that the updated value is appended in the text area
         */
        stickSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider) e.getSource();
                if(source.getValueIsAdjusting())
                    return;

                plane.setX(source.getValue());
            }
        });

        /**
         * These are our if statements that control the output from our textarea
         * If the plane's speed is at 10, then we wait for 5 seconds to lift the elevation by 1
         * If the plane's elevation is greater or equal to 1 and the plane's speed is less than 10, then the plane crashes due to lack of speed
         * If the plane's y coordinate is greater than length of the runway and the elevation is greater than 1, the plane doesn't take-off
         * If the plane's y coordinate is greater than the length of the runway and the x coordinate is not 5, meaning it is not in the center, the plane fails to take off
         * If the plane's y coordinate is greater than the length of the runway and the plane's elevation is zero, the plane fails to take off
         * But if the plane's elevation is greater than 5 and the x coordinate is also 5 in the center, take-off is succeessful
         */
        while (true) {

            outputMessage.append(plane.toString());

            if (plane.getSpeed() == 10) {
                plane.setTimePassed(plane.getTimePassed());

                if (plane.getTimePassed() >= 5) {
                    plane.setElevation( 1 + plane.getElevation());
                }
            }

            if (plane.getElevation() >= 1 &&  plane.getSpeed() < 10) {

                outputMessage.append("Plane crashed :(");
                break;
            }

            if ((plane.getSprint() > runway.getHeight() && (plane.getElevation() > 1))) {

                outputMessage.append("Failed take-off");
                break;
            }

            if (plane.getSprint() > runway.getHeight()  && coordinates.getX() != 5) {

                outputMessage.append("Failed take-off");
                break;
            }

            if (plane.getSprint() > runway.getHeight() && plane.getElevation() == 0) {

                outputMessage.append("Failed take-off");
                break;
            }

            if (plane.getElevation() >= 6 && coordinates.getX() == 5) {

                outputMessage.append("Take-off successful");
                break;
            }

            try {

                Thread.sleep(1000);

            } catch (Exception e) {

                System.out.println(e);
            }
        }

    }

}