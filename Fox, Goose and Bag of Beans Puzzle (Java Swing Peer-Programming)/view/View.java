/**
 * this is the view class, which holds the gui and displays changes to the user
 */

package view;

import controller.Controller;
import model.*;
import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

// view is an observer class, observing the model class
public class View implements Observer {

    private JFrame myFrame;
    private JPanel jpBottom;
    private Water water;
    private GrassRight grassRight;
    private GrassLeft grassLeft;
    private JLabel foxIcon, gooseIcon, beansIcon, farmerIcon, boatIcon, farmerAndBoatIcon, farmerAndFoxIcon, farmerAndGooseIcon, farmerAndBeansIcon;
    private JLabel boatLabel, gooseLabel, beansLabel, farmerLabel, foxLabel;
    private JButton boatLeft, boatRight, foxLeft, foxRight, gooseLeft, gooseRight, beansLeft, beansRight, farmerLeft, farmerRight;
    private Model model;
    private Controller controller;

    public View(Controller controller, Model model) {

        myFrame = new JFrame("Fox, Goose and Bag of Beans"); // title of the jframe

        jpBottom = new JPanel(); // jpanel at the bottom for the buttons
        myFrame.add(jpBottom, BorderLayout.SOUTH); // panel added to south of frame
        myFrame.setSize(1400, 800); // size set for the frame

        this.model = model;
        this.controller = controller;

        water = new Water(); // object of water class
        water.setLayout(new BorderLayout());
        grassRight = new GrassRight(); // object of the right grass class
        grassRight.setLayout(new GridLayout(4, 1)); // gridlayout for icons
        grassLeft = new GrassLeft(); // object of the left grass class
        grassLeft.setLayout(new GridLayout(4, 1)); // gridlayout for icons

        grassRight.setPreferredSize(new Dimension(200, 800));
        grassLeft.setPreferredSize(new Dimension(200, 800));

        myFrame.add(water); // add water to the frame
        myFrame.add(grassRight, BorderLayout.EAST); // position grass to right
        myFrame.add(grassLeft, BorderLayout.WEST); // position grass to left

        // fox ImageIcon, added to jLabel and then to the right grass
        ImageIcon fox = new ImageIcon("src/Images/fox.png");
        foxIcon = new JLabel(fox);
        grassRight.add(foxIcon);

        // goose ImageIcon, added to jLabel and then to the right grass
        ImageIcon goose = new ImageIcon("src/Images/goose.png");
        gooseIcon = new JLabel(goose);
        grassRight.add(gooseIcon);

        // beans ImageIcon, added to jLabel and then to the right grass
        ImageIcon beans = new ImageIcon("src/Images/beans.png");
        beansIcon = new JLabel(beans);
        grassRight.add(beansIcon);

        // farmer ImageIcon, added to jLabel and then to the right grass
        ImageIcon farmer = new ImageIcon("src/Images/farmer.png");
        farmerIcon = new JLabel(farmer);
        grassRight.add(farmerIcon);

        // boat ImageIcon, added to jLabel and then to the water, positioned east in the centre
        ImageIcon boat= new ImageIcon("src/Images/boat.png");
        boatIcon = new JLabel(boat);
        water.add(boatIcon, BorderLayout.EAST);

        // farmer and boat ImageIcon, added to jLabel
        ImageIcon farmerAndBoat = new ImageIcon("src/Images/farmerAndBoat.png");
        farmerAndBoatIcon = new JLabel(farmerAndBoat);

        // farmer and fox ImageIcon, added to jLabel
        ImageIcon farmerAndFox = new ImageIcon("src/Images/farmerAndFox.png");
        farmerAndFoxIcon = new JLabel(farmerAndFox);

        // farmer and goose ImageIcon, added to jLabel
        ImageIcon farmerAndGoose = new ImageIcon("src/Images/farmerAndDuck.png");
        farmerAndGooseIcon = new JLabel(farmerAndGoose);

        // farmer and beans ImageIcon, added to jLabel
        ImageIcon farmerAndBeans = new ImageIcon("src/Images/farmerAndBean.png");
        farmerAndBeansIcon = new JLabel(farmerAndBeans);

        // labels for he buttons
        boatLabel = new JLabel("Boat: ");
        foxLabel = new JLabel("Fox: ");
        gooseLabel = new JLabel("Goose: ");
        beansLabel = new JLabel("Beans: ");
        farmerLabel = new JLabel("Farmer: ");

        // text in buttons with names and actionListener
        boatLeft = new JButton("<");
        boatLeft.setName("BoatLeft");
        boatLeft.addActionListener(controller);

        boatRight = new JButton(">");
        boatRight.setName("BoatRight");
        boatRight.addActionListener(controller);

        foxLeft = new JButton("<");
        foxLeft.setName("FoxLeft");
        foxLeft.addActionListener(controller);

        foxRight = new JButton(">");
        foxRight.setName("FoxRight");
        foxRight.addActionListener(controller);

        gooseLeft = new JButton("<");
        gooseLeft.setName("GooseLeft");
        gooseLeft.addActionListener(controller);

        gooseRight = new JButton(">");
        gooseRight.setName("GooseRight");
        gooseRight.addActionListener(controller);

        beansLeft = new JButton("<");
        beansLeft.setName("BeansLeft");
        beansLeft.addActionListener(controller);

        beansRight = new JButton(">");
        beansRight.setName("BeansRight");
        beansRight.addActionListener(controller);

        farmerLeft = new JButton("<");
        farmerLeft.setName("FarmerLeft");
        farmerLeft.addActionListener(controller);

        farmerRight = new JButton(">");
        farmerRight.setName("FarmerRight");
        farmerRight.addActionListener(controller);

        // add buttons to the bottom panel
        jpBottom.add(boatLabel);
        jpBottom.add(boatLeft);
        jpBottom.add(boatRight);
        jpBottom.add(foxLabel);
        jpBottom.add(foxLeft);
        jpBottom.add(foxRight);
        jpBottom.add(gooseLabel);
        jpBottom.add(gooseLeft);
        jpBottom.add(gooseRight);
        jpBottom.add(beansLabel);
        jpBottom.add(beansLeft);
        jpBottom.add(beansRight);
        jpBottom.add(farmerLabel);
        jpBottom.add(farmerLeft);
        jpBottom.add(farmerRight);

        myFrame.pack();
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setVisible(true);
        myFrame.setResizable(true);

    }

    // water class which extends jpanel, uses image icon paints it to the frame
    class Water extends JPanel {

        public void paintComponent(Graphics w) {
            super.paintComponent(w);
            ImageIcon water = new ImageIcon("src/Images/water.png");
            water.paintIcon(this, w, 0, 0);
        }
    }

    // grass right class which extends jpanel, uses image icon paints it to the frame
    class GrassRight extends JPanel {

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            ImageIcon grass = new ImageIcon("src/Images/grass.png");
            grass.paintIcon(this, g, 0, 0);
        }
    }

    // grass left class which extends jpanel, uses image icon paints it to the frame
    class GrassLeft extends JPanel {

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            ImageIcon grass = new ImageIcon("src/Images/grass.png");
            grass.paintIcon(this, g, 0, 0);
        }
    }


    //updates the view depending on the model
    @Override
    public void update(Observable o, Object arg) {
        String[] grassRightList = new String[4];
        String[] grassLeftList = new String[4];
        String[] boatList = new String[2];

        for (int i = 0; i < grassRightList.length; i++) {
            grassRightList[i] = model.getGrassRight()[i];
            grassLeftList[i] = model.getGrassLeft()[i];
        }

        for (int i = 0; i < boatList.length; i++) {
            boatList[i] = model.getBoat()[i];
        }

        System.out.println(boatList[1]);
        
        // Updating the boat depending on what's on it and which direction it's going in
        if (boatList[0] == "farmer") {
            if (model.getDirection() == "right") {
                grassRight.remove(farmerIcon);
                water.remove(boatIcon);
                water.add(farmerAndBoatIcon, BorderLayout.EAST);
                model.boatLeft(false);
            }

            else if (model.getDirection() == "left") {
                grassLeft.remove(farmerIcon);
                water.remove(boatIcon);
                water.add(farmerAndBoatIcon, BorderLayout.WEST);
                model.boatLeft(true);
            }
        }

        if (boatList[1] == "fox"){
            if (model.getDirection() == "right") {
                grassRight.remove(foxIcon);
                water.remove(farmerAndBoatIcon);
                water.add(farmerAndFoxIcon, BorderLayout.EAST);
                model.boatLeft(false);
            }

            else if (model.getDirection() == "left") {
                grassLeft.remove(foxIcon);
                water.remove(farmerAndBoatIcon);
                water.add(farmerAndFoxIcon, BorderLayout.WEST);
                model.boatLeft(true);
            }

        } else if (boatList[1] == "goose") {
            if (model.getDirection() == "right") {
                grassRight.remove(gooseIcon);
                water.remove(farmerAndBoatIcon);
                water.add(farmerAndGooseIcon, BorderLayout.EAST);
            }

            else if (model.getDirection() == "left") {
                grassLeft.remove(gooseIcon);
                water.remove(farmerAndBoatIcon);
                water.add(farmerAndGooseIcon, BorderLayout.WEST);
                model.boatLeft(true);
            }
        } else if (boatList[1] == "bean") {
            if (model.getDirection() == "right") {
                grassRight.remove(beansIcon);
                water.remove(farmerAndBoatIcon);
                water.add(farmerAndBeansIcon, BorderLayout.EAST);
            }

            else if (model.getDirection() == "left") {
                grassLeft.remove(beansIcon);
                water.remove(farmerAndBoatIcon);
                water.add(farmerAndBeansIcon, BorderLayout.WEST);
                model.boatLeft(true);
            }
        }

        // Updates the East and West Bank depending what is on it
        if (grassRightList[0] == "fox") {
            grassRight.add(foxIcon);
            water.remove(farmerAndFoxIcon);

        } else if (grassLeftList[0] == "fox") {
            grassLeft.add(foxIcon);
            water.remove(farmerAndFoxIcon);
        }

        if (grassRightList[1] == "goose") {
            grassRight.add(gooseIcon);
            water.remove(farmerAndGooseIcon);

        } else if (grassLeftList[1] == "goose") {
            grassLeft.add(gooseIcon);
            water.remove(farmerAndGooseIcon);
        }

        if (grassRightList[2] == "bean") {
            grassRight.add(beansIcon);
            water.remove(farmerAndBeansIcon);


        } else if (grassLeftList[2] == "bean") {
            grassLeft.add(beansIcon);
            water.remove(farmerAndBeansIcon);
        }

        if (grassRightList[3] == "farmer") {
            grassRight.add(farmerIcon);
            water.remove(farmerAndBoatIcon);
            water.add(boatIcon, BorderLayout.EAST);


        } else if (grassLeftList[3] == "farmer" && boatList[1] == null) {
            grassLeft.add(farmerIcon);
            water.remove(farmerAndBoatIcon);
            water.add(boatIcon, BorderLayout.WEST);
        }

        // win condition in action
        if (model.getCondition() == true) {
            myFrame.setTitle("Game Over! Your score is: " + model.getCounter());
        }

        grassRight.revalidate();
        grassRight.repaint();
        grassLeft.revalidate();
        grassLeft.repaint();
        water.revalidate();
        water.repaint();
    }


}