/**
 * this is the controller class, it updates the model. It contains the action listeners for the buttons.
 */

package controller;

import model.Model;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {

	private Model model; // model object to access it
	
	public Controller(Model model) {

	    this.model = model;
	}

	@Override
    public void actionPerformed(ActionEvent e) {
		// this bit of code allows us to find out which button is being pressed (including the JButton btn = (JButton) source
        Object source = e.getSource();
        
        // This makes sure that buttons cant be pressed if the game is over
        if  (model.getCondition() == false) {
        	if (source instanceof JButton) {
                JButton btn = (JButton) source;
                
                // The next clusterbomb of if statements is to check which button is pressed and what to do when the button is pressed
    	        if (btn.getName().equals("BoatLeft")) {
    	            model.moveLeft("boat");
    	            model.decrementCounter();
    	            model.winOrLoss();
    	        }
    	
    	        if (btn.getName().equals("BoatRight")) {
    	            model.moveRight("boat");
    	            model.decrementCounter();
    	            model.winOrLoss();
    	        }
    	
    	        if (btn.getName().equals("FoxLeft")) {
    	            model.moveLeft("fox");
    	            model.winOrLoss();
    	        }
    	        if (btn.getName().equals("FoxRight")) {
    	            model.moveRight("fox");
    	            model.winOrLoss();
    	        }
    	        if (btn.getName().equals("GooseLeft")) {
    	            model.moveLeft("goose");
    	            model.winOrLoss();
    	        }
    	        if (btn.getName().equals("GooseRight")) {
    	            model.moveRight("goose");
    	            model.winOrLoss();
    	        }
    	        if (btn.getName().equals("BeansLeft")) {
    	            model.moveLeft("bean");
    	            model.winOrLoss();
    	            System.out.println("Bean");
    	        } 
    	            
    	        if (btn.getName().equals("BeansRight")) {
    	            model.moveRight("bean");
    	            model.winOrLoss();
    	        } 
    	            
    	        if (btn.getName().equals("FarmerLeft")) {
    	            model.moveLeft("farmer");
    	            model.winOrLoss();
    	            System.out.println("21");
    	        } 
    	
    	        if (btn.getName().equals("FarmerRight")) {
    	        	model.moveRight("farmer");
    	        	model.winOrLoss();
    	        }
            }
        }
    }
}