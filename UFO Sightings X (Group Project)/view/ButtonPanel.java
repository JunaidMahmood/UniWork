/**
 * panel, which has a button, which allows to go to the GamePanel
 */

package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import controller.Controller;
import model.Model;

public class ButtonPanel extends JPanel implements Observer {

	private Model model;
	private Controller controller;
	private JButton playButton;
	private ImageIcon buttonImage;

	public ButtonPanel(Model model, Controller controller) {

		this.model = model;
		this.controller = controller;
		
		buttonImage = new ImageIcon("src/images/buttonImage.gif");
		
		setLayout(new BorderLayout());
		
		playButton = new JButton(buttonImage);
		playButton.setName("playButton");
		playButton.setPreferredSize(new Dimension(480, 269));
		playButton.addActionListener(controller);
		add(playButton, BorderLayout.CENTER);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	}
}