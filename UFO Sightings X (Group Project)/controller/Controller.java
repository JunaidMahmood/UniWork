/**
 * Controller for saving and loading the positions for Statistics panel, for buttons in WelcomePanel and in MapPanel
 */

package controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import api.ripley.Ripley;
import model.Model;
import view.PopUp;


public class Controller implements ActionListener, MouseListener, WindowListener {
	private Ripley ripley;
	private Model model;

	public Controller(Ripley ripley, Model model) {
		this.ripley = ripley;
		this.model = model;
	}
	/**
	 * windowListener, when the window is opened
	 */
	public void windowOpened(WindowEvent e) {

		ArrayList<Integer> savedIndexes = new ArrayList<Integer>();
		try (BufferedReader reader = new BufferedReader(new FileReader("src/view/statistics.txt"))) {
			String word;
			while ((word = reader.readLine()) != null) {
				int index = Integer.parseInt(word);
				System.out.println("number scanned from text file: " + index);
				savedIndexes.add(index);
			}

			reader.close();
			model.setLoadedIndexes(savedIndexes);

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * writes the text files again after closing jframe, overwriting previous
	 * copies since entries can be add and removed.
	 * 
	 * @Override
	 */
	public void windowClosing(WindowEvent e) {

		FileWriter writer = null;
		BufferedWriter out = null;

		File file = new File("src/view/statistics.txt");

		// writes calendar list model on closing using BufferedWriter and FileWriter
		try {
			PrintWriter pw = new PrintWriter("src/view/statistics.txt");
			pw.close();
			writer = new FileWriter(file.getAbsoluteFile(), true);
			out = new BufferedWriter(writer);
			for (Integer key : model.getSelectedStatistics().keySet()) {
				System.out.print(key + " HELLOLOLOLOL: " + model.getSelectedStatistics().get(key));
				out.append(key.toString() + "\n");
			}
			
			out.close();
			writer.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * 
	 * @Override 
	 */	
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() instanceof JComboBox) {
			JComboBox box = (JComboBox) e.getSource();

			String nameOfUsedComboBox = box.getName();

			if (nameOfUsedComboBox.equals("fromBox")) {
				model.setFrom((int) box.getSelectedItem());
			}
			if (nameOfUsedComboBox.equals("toBox")) {
				model.setTo((int) box.getSelectedItem());
			}
			if (box.getName().equals("panel2Box")) {
				if (box.getSelectedItem().equals("Date")) {

				}
			}
		}

		if (e.getSource() instanceof JButton) {

			JButton button = (JButton) e.getSource();

			// switching between the 4 main panels
			if (button.getName().equals("leftButton") || button.getName().equals("rightButton")) {
				model.changeCurrentPanelIndex(button.getName());
			}

			// start game button controller
			else if (button.getName().equals("playButton")) {
				model.runGame();
			}

			// switching between the 8 statistic panels
			else if (button.getName().equals("leftNW") || button.getName().equals("rightNW")) {
				model.changeStatisticsPanel1Index(button.getName());

			} else if (button.getName().equals("leftNE") || button.getName().equals("rightNE")) {
				model.changeStatisticsPanel2Index(button.getName());

			} else if (button.getName().equals("leftSW") || button.getName().equals("rightSW")) {
				model.changeStatisticsPanel3Index(button.getName());

			} else if (button.getName().equals("leftSE") || button.getName().equals("rightSE")) {
				model.changeStatisticsPanel4Index(button.getName());
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		PopUp view = new PopUp(this, model);
		model.addObserver(view);
		if (e.getSource() instanceof JPanel) {
			for (String state : model.getStates().keySet()) {
				if ((e.getX() >= model.getStates().get(state).getX() - 18
						&& e.getX() <= model.getStates().get(state).getX() + 18)
						&& (e.getY() >= model.getStates().get(state).getY() - 15)) {
					System.out.println("Times..");
					model.process(state);
					view.setTitle(state);
					view.setVisible(true);
				}
			}
		}
		if (e.getSource() instanceof JList) {
			JFrame popUp = new JFrame();
			popUp.setSize(new Dimension(70, 70));
			JOptionPane.showMessageDialog(popUp, "<html><p style='width: 300px;'>" + model.getEventDetails() + "</p></html>");
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

}
