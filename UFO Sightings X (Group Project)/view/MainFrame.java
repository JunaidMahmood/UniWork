/**
 * main view
 */

package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import api.ripley.Ripley;
import controller.Controller;
import model.Model;


public class MainFrame extends JFrame implements Observer {

	private Ripley ripley;
	private Model model;
	private Controller controller;
	private ArrayList<Integer> startYear, latestYear;
	private JComboBox startBox, latestBox;
	private JButton jbLeft, jbRight;
	private JPanel changeablePanel;
	private ArrayList<JPanel> panels = new ArrayList<JPanel>();
	private WelcomePanel welcomePanel;
	private MapPanel mapPanel;
	private StatisticsPanel statisticsPanel;
	private ButtonPanel buttonPanel;

	/**
	 * Constructor
	 * @param ripley
	 * @param controller
	 * @param model
	 */
	public MainFrame(Ripley ripley, Controller controller, Model model) {
		this.ripley = ripley;
		this.controller = controller;
		this.model = model;

		addWindowListener(controller);

		welcomePanel = new WelcomePanel(model, ripley);
		mapPanel = new MapPanel(model, controller);
		statisticsPanel = new StatisticsPanel(model, controller);
		buttonPanel = new ButtonPanel(model, controller);

		model.addObserver(welcomePanel);
		model.addObserver(statisticsPanel);
		model.addObserver(buttonPanel);

		panels.add(welcomePanel);
		panels.add(mapPanel);
		panels.add(statisticsPanel);
		panels.add(buttonPanel);

		startYear = new ArrayList<Integer>();
		latestYear = new ArrayList<Integer>();

		for (int i = ripley.getStartYear(); i <= ripley.getLatestYear(); i++) {

			startYear.add(i);
			latestYear.add(i);
		}

		// creating the widgets of the main frame
		startBox = new JComboBox(startYear.toArray());
		latestBox = new JComboBox(latestYear.toArray());

		startBox.setName("fromBox");
		latestBox.setName("toBox");

		startBox.addActionListener(controller);
		latestBox.addActionListener(controller);

		JLabel jlFrom = new JLabel("From: ");
		JLabel jlTo = new JLabel("To: ");

		JLabel jlStatus = new JLabel(ripley.getLastUpdated(), SwingConstants.CENTER);

		jbLeft = new JButton("<");
		jbRight = new JButton(">");

		jbLeft.setEnabled(false);
		jbRight.setEnabled(false);

		jbLeft.setName("leftButton");
		jbRight.setName("rightButton");

		jbLeft.addActionListener(controller);
		jbRight.addActionListener(controller);

		// creating and adding the panels to the main frame
		JPanel jpNorth = new JPanel(new FlowLayout(FlowLayout.RIGHT));

		jpNorth.add(jlFrom);
		jpNorth.add(startBox);
		jpNorth.add(jlTo);
		jpNorth.add(latestBox);

		changeablePanel = new JPanel(new BorderLayout());
		changeablePanel.setBorder(BorderFactory.createLineBorder(Color.black));
		changeablePanel.add(panels.get(model.getCurrentPanelIndex()));

		JPanel jpSouth = new JPanel(new BorderLayout());
		jpSouth.add(jbLeft, BorderLayout.WEST);
		jpSouth.add(jlStatus, BorderLayout.CENTER);
		jpSouth.add(jbRight, BorderLayout.EAST);

		setLayout(new BorderLayout());

		add(jpNorth, BorderLayout.NORTH);
		add(changeablePanel, BorderLayout.CENTER);
		add(jpSouth, BorderLayout.SOUTH);

		setMinimumSize(new Dimension(950, 700));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
	}

	@Override
	public void update(Observable o, Object arg) {

		if (model.getCurrentPanelIndex() == 0) {

			startBox.setEnabled(true);
			latestBox.setEnabled(true);

			if (!model.isDateRangeReady()) {

				latestBox.removeActionListener(controller);
				latestBox.removeAllItems();

				for (int i = model.getDropDownValueFrom(); i <= ripley.getLatestYear(); i++) {
					latestBox.addItem(i);
				}

				latestBox.addActionListener(controller);

				jbLeft.setEnabled(false);
				jbRight.setEnabled(false);

			} else {

				jbLeft.setEnabled(true);
				jbRight.setEnabled(true);
			}
		}

		else {

			startBox.setEnabled(false);
			latestBox.setEnabled(false);
		}

		changeablePanel.removeAll();
		changeablePanel.add(panels.get(model.getCurrentPanelIndex()));

		revalidate();
		repaint();
	}
}