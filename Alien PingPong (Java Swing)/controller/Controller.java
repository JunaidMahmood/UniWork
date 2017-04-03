package controller;

import model.Model;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller implements ActionListener, KeyListener{

    Model model;

    public Controller(Model model){

        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        model.move();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

        if(e.getKeyCode() == KeyEvent.VK_UP){
            model.setRightPlayerMove("up");

        } else if(e.getKeyCode() == KeyEvent.VK_DOWN){
            model.setRightPlayerMove("down");

        } else if(e.getKeyCode() == KeyEvent.VK_W){
            model.setLeftPlayerMove("up");

        } else if(e.getKeyCode() == KeyEvent.VK_S){
            model.setLeftPlayerMove("down");
        }
    }
}