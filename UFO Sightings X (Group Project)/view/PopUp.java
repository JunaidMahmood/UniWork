/**
 * view for pop up window, which holds all the information about the specific state
 */

package view;

import java.awt.BorderLayout;
import java.util.Observable;
import java.util.Observer;
import api.ripley.Ripley;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import controller.Controller;
import model.Model;


public class PopUp extends JFrame implements Observer {

	private JComboBox<String> comboBox;
	private JPanel popUp;
	private JList<String> list;
	private DefaultListModel<String> listModel;
	private Ripley ripley;
	private Model model;
	private Controller controller;
	private JScrollPane scrollPane;

	/**
	 * This is the constructor which takes these classes as parameters , I have
	 * called the initWidgets within.
	 */
	public PopUp(Controller controller, Model model) {
		this.model = model;
		this.controller = controller;

		this.ripley = new Ripley("10tLI3GXst2yVD6ql2OMtA==", "tBgm4pVp9g3VqL46EnH7ew==");
		initWidgets();
	}

	/**
	 * The widgets required to create the GUI for the programme.
	 */
	private void initWidgets() {
		popUp = new JPanel(new BorderLayout());

		comboBox = new JComboBox<String>();

		comboBox.setName("panel2Box");
		comboBox.addActionListener(controller);

		comboBox.addItem("-");
		comboBox.addItem("Date");
		comboBox.addItem("City");
		comboBox.addItem("Shape");
		comboBox.addItem("Duration");
		comboBox.addItem("Posted");

		listModel = new DefaultListModel<String>();

		list = new JList<String>(listModel);
		scrollPane = new JScrollPane(list);
		list.addMouseListener(controller);
		popUp.add(comboBox, BorderLayout.NORTH);

		popUp.add(scrollPane);

		add(popUp);
		pack();
		setSize(700, 300);
	}

	@Override
	public void update(Observable o, Object arg) {
		listModel.addElement(model.setListSightings());
	}
}