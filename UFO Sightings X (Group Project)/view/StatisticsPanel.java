/**
 * view for panel 3
 */

package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import controller.Controller;
import model.Model;


public class StatisticsPanel extends JPanel implements Observer {

	private Controller controller;
	private Model model;

	private JPanel nwPanel, nePanel, swPanel, sePanel;
	private JPanel nwInsidePanel, neInsidePanel, swInsidePanel, seInsidePanel;

	private JButton leftNW, leftNE, leftSW, leftSE;
	private JButton rightNW, rightNE, rightSW, rightSE;

	private JLabel titleNW, titleNE, titleSW, titleSE;
	private JLabel statisticsLabelNW, statisticsLabelNE, statisticsLabelSW, statisticsLabelSE;

	/**
	 * Panel3 Constructor: initialises all the widgets and layouts
	 * 
	 * @param model
	 * @param controller
	 */
	public StatisticsPanel(Model model, Controller controller) {

		this.controller = controller;
		this.model = model;

		nwPanel = new JPanel(new BorderLayout());
		nePanel = new JPanel(new BorderLayout());
		swPanel = new JPanel(new BorderLayout());
		sePanel = new JPanel(new BorderLayout());

		nwInsidePanel = new JPanel(new BorderLayout());
		neInsidePanel = new JPanel(new BorderLayout());
		swInsidePanel = new JPanel(new BorderLayout());
		seInsidePanel = new JPanel(new BorderLayout());

		leftNW = new JButton("<");
		rightNW = new JButton(">");
		leftNE = new JButton("<");
		rightNE = new JButton(">");
		leftSW = new JButton("<");
		rightSW = new JButton(">");
		leftSE = new JButton("<");
		rightSE = new JButton(">");

		leftNW.setName("leftNW");
		leftNE.setName("leftNE");
		rightNW.setName("rightNW");
		rightNE.setName("rightNE");
		leftSW.setName("leftSW");
		leftSE.setName("leftSE");
		rightSW.setName("rightSW");
		rightSE.setName("rightSE");

		leftNW.addActionListener(controller);
		leftNE.addActionListener(controller);
		rightNW.addActionListener(controller);
		rightNE.addActionListener(controller);
		leftSW.addActionListener(controller);
		leftSE.addActionListener(controller);
		rightSW.addActionListener(controller);
		rightSE.addActionListener(controller);

		titleNW = new JLabel("title1", SwingConstants.CENTER);
		titleNE = new JLabel("title2", SwingConstants.CENTER);
		titleSW = new JLabel("title3", SwingConstants.CENTER);
		titleSE = new JLabel("title4", SwingConstants.CENTER);

		statisticsLabelNW = new JLabel("statistics 1", SwingConstants.CENTER);
		statisticsLabelNE = new JLabel("statistics 2", SwingConstants.CENTER);
		statisticsLabelSW = new JLabel("statistics 3", SwingConstants.CENTER);
		statisticsLabelSE = new JLabel("statistics 4", SwingConstants.CENTER);

		titleNW.setFont(new Font("sans-serif", Font.BOLD, 16));
		titleNE.setFont(new Font("sans-serif", Font.BOLD, 16));
		titleSW.setFont(new Font("sans-serif", Font.BOLD, 16));
		titleSE.setFont(new Font("sans-serif", Font.BOLD, 16));

		statisticsLabelNW.setFont(new Font("sans-serif", Font.BOLD, 14));
		statisticsLabelNE.setFont(new Font("sans-serif", Font.BOLD, 14));
		statisticsLabelSW.setFont(new Font("sans-serif", Font.BOLD, 14));
		statisticsLabelSE.setFont(new Font("sans-serif", Font.BOLD, 14));

		nwInsidePanel.add(titleNW, BorderLayout.NORTH);
		nwInsidePanel.add(statisticsLabelNW, BorderLayout.CENTER);
		neInsidePanel.add(titleNE, BorderLayout.NORTH);
		neInsidePanel.add(statisticsLabelNE, BorderLayout.CENTER);
		swInsidePanel.add(titleSW, BorderLayout.NORTH);
		swInsidePanel.add(statisticsLabelSW, BorderLayout.CENTER);
		seInsidePanel.add(titleSE, BorderLayout.NORTH);
		seInsidePanel.add(statisticsLabelSE, BorderLayout.CENTER);

		nwPanel.add(leftNW, BorderLayout.WEST);
		nwPanel.add(nwInsidePanel, BorderLayout.CENTER);
		nwPanel.add(rightNW, BorderLayout.EAST);

		nePanel.add(leftNE, BorderLayout.WEST);
		nePanel.add(neInsidePanel, BorderLayout.CENTER);
		nePanel.add(rightNE, BorderLayout.EAST);

		swPanel.add(leftSW, BorderLayout.WEST);
		swPanel.add(swInsidePanel, BorderLayout.CENTER);
		swPanel.add(rightSW, BorderLayout.EAST);

		sePanel.add(leftSE, BorderLayout.WEST);
		sePanel.add(seInsidePanel, BorderLayout.CENTER);
		sePanel.add(rightSE, BorderLayout.EAST);

		setLayout(new GridLayout(2, 2));

		add(nwPanel);
		add(nePanel);
		add(swPanel);
		add(sePanel);

	}

	@Override
	public void update(Observable o, Object arg) {
		if (model.getCurrentPanelIndex() == 2) {

			titleNW.setText(model.getSelectedTitles().get(model.getIndexForStatisticsPanel1()));
			statisticsLabelNW.setText(model.getSelectedStatistics().get(model.getIndexForStatisticsPanel1()));
			titleNE.setText(model.getSelectedTitles().get(model.getIndexForStatisticsPanel2()));
			statisticsLabelNE.setText(model.getSelectedStatistics().get(model.getIndexForStatisticsPanel2()));
			titleSW.setText(model.getSelectedTitles().get(model.getIndexForStatisticsPanel3()));
			statisticsLabelSW.setText(model.getSelectedStatistics().get(model.getIndexForStatisticsPanel3()));
			titleSE.setText(model.getSelectedTitles().get(model.getIndexForStatisticsPanel4()));
			statisticsLabelSE.setText(model.getSelectedStatistics().get(model.getIndexForStatisticsPanel4()));

		}
	}
}