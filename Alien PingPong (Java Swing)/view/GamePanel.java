package view;

import model.Model;
import controller.Controller;
import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class GamePanel extends JPanel implements Observer {

    private Model model;
    private Controller controller;
    private Timer tm;
    private JLabel p1Label;
    private JDialog p1Dialog;
    private JLabel p2Label;
    private JDialog p2Dialog;
    private boolean showStatus;

    public GamePanel(Model model, Controller controller){

        this.model = model;
        this.controller = controller;

        p1Label = new JLabel(new ImageIcon("src/images/statusImage.gif"));
        p1Dialog = new JDialog();
        p1Dialog.setUndecorated(false);
        p1Dialog.add(p1Label);
        p1Dialog.pack();

        p2Label = new JLabel(new ImageIcon("src/images/statusImage2.gif"));
        p2Dialog = new JDialog();
        p2Dialog.setUndecorated(false);
        p2Dialog.add(p2Label);
        p2Dialog.pack();

        showStatus = false;

        tm = new Timer(5, controller);

        setLayout(new BorderLayout());
        setVisible(true);
    }

    public void paintComponent(Graphics m){

        super.paintComponents(m);

        ImageIcon backgroundImage = new ImageIcon("src/images/finalBackground.png");
        ImageIcon rocketLeft = new ImageIcon("src/images/alienLeft.png");
        ImageIcon rocketRight = new ImageIcon("src/images/alienRight.png");
        ImageIcon scoreRight = new ImageIcon(model.getScoreLeft());
        ImageIcon scoreLeft = new ImageIcon(model.getScoreRight());
        ImageIcon planetImage = new ImageIcon("src/images/mars.png");

        backgroundImage.paintIcon(this, m, 0, 0);
        scoreRight.paintIcon(this, m, 505, 70);
        scoreLeft.paintIcon(this, m, 395, 70);
        rocketLeft.paintIcon(this, m,  model.getXposLeftPlayer(), model.getYposLeftPlayer());
        rocketRight.paintIcon(this, m, model.getXposRightPlayer(), model.getYposRightPlayer());
        planetImage.paintIcon(this, m, model.getX(), model.getY());

        tm.start();
    }

    @Override
    public void update(Observable o, Object arg) {

        if(showStatus == false){

            if(model.getWinP1() == true){
                p1Dialog.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
                p1Dialog.setVisible(true);
                showStatus = true;
            }
        }




        if(showStatus == false){

            if(model.getWinP2() == true){
                p2Dialog.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
                p2Dialog.setVisible(true);
                showStatus = true;
            }
        }

        revalidate();
        repaint();
    }
}