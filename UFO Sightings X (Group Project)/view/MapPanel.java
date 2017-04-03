/**
 * view for the Map
 */

package view;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import api.ripley.Incident;
import api.ripley.Ripley;
import controller.Controller;
import model.Model;


public class MapPanel extends JPanel {
	private Ripley ripley;
	private ImageIcon markerImage;
	private HashMap<String, Integer> ufoCounter;
	private Model model;
	private Controller controller;

	/**
	 * MapPanel Constructor
	 */
	public MapPanel(Model model, Controller controller) {

		ripley = new Ripley("10tLI3GXst2yVD6ql2OMtA==", "tBgm4pVp9g3VqL46EnH7ew==");
		setLayout(new BorderLayout());

		this.controller = controller;
		this.model = model;
		this.addMouseListener(controller);

		// getting the ufoCounter hashMap from the model
		ufoCounter = model.getUfoCounter();
	}

	/**
	 * paints the images and checks the size of the image
	 */
	public void paintComponent(Graphics m) {

		super.paintComponent(m);

		ImageIcon mapImage = new ImageIcon("src/images/map.png");
		ImageIcon markerSmall = new ImageIcon("src/images/markerSmall.png");
		ImageIcon markerMedium = new ImageIcon("src/images/markerMedium.png");
		ImageIcon markerLarge = new ImageIcon("src/images/markerLarge.png");

		JLabel smallMarker = new JLabel(markerSmall);
		JLabel mediumMarker = new JLabel(markerMedium);
		JLabel largeMarker = new JLabel(markerLarge);

		smallMarker.addMouseListener(controller);
		mediumMarker.addMouseListener(controller);
		largeMarker.addMouseListener(controller);

		mapImage.paintIcon(this, m, 0, 0);

		int leastNumberOfSightings = Integer.MAX_VALUE;
		int mostNumberOfSightings = 0;

		for (String alien : ufoCounter.keySet()) {
			if (ufoCounter.get(alien) > mostNumberOfSightings) {
				mostNumberOfSightings = ufoCounter.get(alien);
			}
			if (ufoCounter.get(alien) < leastNumberOfSightings) {
				leastNumberOfSightings = ufoCounter.get(alien);
			}
		}

		int range = mostNumberOfSightings - leastNumberOfSightings;
		int thirdOfRange = range / 3;

		//for each string in the hashMap check
		for (String alien : ufoCounter.keySet()) {
			//paints the small icon
			if (ufoCounter.get(alien) > 0 && ufoCounter.get(alien) < thirdOfRange) {
				markerSmall.paintIcon(this, m, model.getStates().get(alien).getX(),
						model.getStates().get(alien).getY());
				} 
			//paints the medium image
			else if (ufoCounter.get(alien) < thirdOfRange * 2) {
				markerMedium.paintIcon(this, m, model.getStates().get(alien).getX(),
						model.getStates().get(alien).getY());

			} 
			//paints the large image
			else if (ufoCounter.get(alien) > thirdOfRange * 2) {
				markerLarge.paintIcon(this, m, model.getStates().get(alien).getX(),
						model.getStates().get(alien).getY());
			}
		}
	}
}