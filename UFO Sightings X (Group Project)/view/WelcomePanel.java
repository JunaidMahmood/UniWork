/**
 * welcome panel
 */

package view;

import java.awt.BorderLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import api.ripley.Ripley;
import model.Model;

public class WelcomePanel extends JPanel implements Observer {

	private Model model;
	private Ripley ripley;
	private JLabel jlWelcomeMessage;
	private String welcomeString;
	private String dataMessage = "nothing";

	/**
	 * WelcomePanel Constructor
	 */
	public WelcomePanel(Model model, Ripley ripley) {

		this.model = model;
		this.ripley = ripley;

		setLayout(new BorderLayout());

		double versionNumber = ripley.getVersion();

		welcomeString = "<html><center>Welcome to the Ripley API " + versionNumber + ".<br>Please select"
				+ " from the dates above, in order to <br>begin analysing UFO sighting data.<br><br>";

		jlWelcomeMessage = new JLabel(welcomeString, SwingConstants.CENTER);

		add(jlWelcomeMessage);
	}

	/**
	 * 
	 * @param b
	 */
	public void setDateRange(String b) {

		dataMessage = b + "<br><br>Grabbing data..<br><br>";
		jlWelcomeMessage.setText(welcomeString + dataMessage);
	}

	/**
	 * this methods updates the message in the welcome panel and adds
	 * information about the time it took to grab data
	 */
	public void setJlWelcomeMessage(String a) {
		dataMessage = dataMessage + a;
		jlWelcomeMessage.setText(welcomeString + dataMessage);
	}

	@Override
	public void update(Observable o, Object arg) {
		if (model.isDateRangeReady()) {
			setDateRange(model.getRangeForDataGrabbing());
			setJlWelcomeMessage(model.getDataGrabbedMisSecFormat());
		}
	}
}