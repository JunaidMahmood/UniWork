package view;

import controller.Controller;
import model.Model;
import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

public class GameFrame extends JFrame implements Observer {

    private GamePanel gamePanel;

    Model model;
    Controller controller;

    public GameFrame(Model model, Controller controller){

        this.model = model;
        this.controller = controller;
        gamePanel = new GamePanel(model, controller);

        model.addObserver(gamePanel);

        addKeyListener(controller);
        add(gamePanel);
        setSize(950, 650);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}