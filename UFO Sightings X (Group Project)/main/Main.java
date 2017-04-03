/**
 * main class
 */

package main;

import api.ripley.Ripley;
import controller.Controller;
import model.Model;
import view.MainFrame;

public class Main{

public static void main(String []args){
	
	Ripley ripley = new Ripley("10tLI3GXst2yVD6ql2OMtA==", "tBgm4pVp9g3VqL46EnH7ew==");
	System.out.println(ripley.getAcknowledgementString());
	
	Model model = new Model(ripley);
	Controller controller = new Controller(ripley, model);
	MainFrame main = new MainFrame(ripley, controller, model);
	
	model.addObserver(main);
	
	main.setVisible(true);
	
	}
}
