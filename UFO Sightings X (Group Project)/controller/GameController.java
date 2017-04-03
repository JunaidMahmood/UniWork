/**
 *Controller for GamePanel
 */

package controller;

import model.GameModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class GameController implements ActionListener, KeyListener{

    private GameModel gameModel;

    public GameController(GameModel gameModel){

        this.gameModel = gameModel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    	gameModel.move();
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
        	gameModel.setRightPlayerMove("up");

        } else if(e.getKeyCode() == KeyEvent.VK_DOWN){
        	gameModel.setRightPlayerMove("down");

        } else if(e.getKeyCode() == KeyEvent.VK_W){
        	gameModel.setLeftPlayerMove("up");

        } else if(e.getKeyCode() == KeyEvent.VK_S){
        	gameModel.setLeftPlayerMove("down");
        }
    }
}