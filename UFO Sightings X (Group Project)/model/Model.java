/**
 * holds all the data and main functionality 
 */

package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Observable;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import api.ripley.Incident;
import api.ripley.Ripley;

public class Model extends Observable {

	private Ripley ripley;

	private int currentPanelIndex;
	private int indexForStatisticsPanel1;
	private int indexForStatisticsPanel2;
	private int indexForStatisticsPanel3;
	private int indexForStatisticsPanel4;
	private int indexForTitle;
	private int to, from;

	private long lEndTime, lStartTime, difference;

	private boolean dateRangeReady;
	private boolean sort;
	private String rangeForDataGrabbing = "";
	private String dataGrabbedMisSecFormat = "";
	private String posted, city, duration, shape, date, eventDetails;
	private String IncidentsRangeFrom, IncidentsRangeTo;

	private HashMap<String, Integer> ufoCounter;
	private HashMap<String, Coordinates> states;
	private HashMap<String, Integer> check;
	private HashMap<Integer, String> selectedStatistics, selectedTitles;

	private ArrayList<Incident> results;
	private ArrayList<Incident> non_usa_sighting;
	private ArrayList<String> details;
	private ArrayList<String> statistics, titles;
	private ArrayList<Integer> savedIndexes = new ArrayList<Integer>();

	private Game main;

	/**
	 * Model Constructor
	 */
	public Model(Ripley ripley) {

		this.ripley = ripley;
		from = ripley.getStartYear();

		details = new ArrayList<String>();
		non_usa_sighting = new ArrayList<Incident>();
		statistics = new ArrayList<String>();
		titles = new ArrayList<String>();

		states = new HashMap<String, Coordinates>(); //intialising
		ufoCounter = new HashMap<String, Integer>();
		check = new HashMap<String, Integer>();
		selectedStatistics = new HashMap<Integer, String>();
		selectedTitles = new HashMap<Integer, String>();

		states.put("WA", new Coordinates(138, 18));
		states.put("OR", new Coordinates(100, 90));
		states.put("CA", new Coordinates(50, 201));
		states.put("NV", new Coordinates(129, 180));	//putting state names and coordinates
		states.put("AK", new Coordinates(102, 450));
		states.put("ID", new Coordinates(185, 95));
		states.put("UT", new Coordinates(217, 220));
		states.put("AZ", new Coordinates(193, 320));
		states.put("MT", new Coordinates(275, 65));
		states.put("WY", new Coordinates(286, 145));
		states.put("CO", new Coordinates(302, 235));
		states.put("NM", new Coordinates(290, 325));
		states.put("ND", new Coordinates(412, 65));
		states.put("SD", new Coordinates(406, 125));
		states.put("NE", new Coordinates(405, 190));
		states.put("KS", new Coordinates(453, 259));
		states.put("OK", new Coordinates(474, 326));
		states.put("TX", new Coordinates(380, 400));
		states.put("MN", new Coordinates(505, 70));
		states.put("IA", new Coordinates(509, 185));
		states.put("MO", new Coordinates(514, 249));
		states.put("AR", new Coordinates(534, 335));
		states.put("WI", new Coordinates(576, 120));
		states.put("IL", new Coordinates(596, 209));
		states.put("MI", new Coordinates(658, 129));
		states.put("IN", new Coordinates(639, 215));
		states.put("OH", new Coordinates(697, 212));
		states.put("KY", new Coordinates(678, 268));
		states.put("VA", new Coordinates(785, 255));
		states.put("WV", new Coordinates(736, 249));
		states.put("PA", new Coordinates(751, 180));
		states.put("NY", new Coordinates(796, 114));
		states.put("ME", new Coordinates(887, 38));
		states.put("VT", new Coordinates(843, 90));
		states.put("NH", new Coordinates(861, 107));
		states.put("MA", new Coordinates(855, 134));
		states.put("CT", new Coordinates(844, 160));
		states.put("RI", new Coordinates(874, 150));
		states.put("NJ", new Coordinates(834, 183));
		states.put("DE", new Coordinates(826, 227));
		states.put("MD", new Coordinates(801, 225));
		states.put("TN", new Coordinates(674, 320));
		states.put("NC", new Coordinates(795, 320));
		states.put("SC", new Coordinates(729, 339));
		states.put("GA", new Coordinates(695, 370));
		states.put("AL", new Coordinates(645, 411));
		states.put("MS", new Coordinates(595, 370));
		states.put("LA", new Coordinates(542, 415));
		states.put("FL", new Coordinates(757, 465));
		states.put("HI", new Coordinates(290, 510));

		ufoCounter.put("WA", 0);
		ufoCounter.put("OR", 0);
		ufoCounter.put("CA", 0);
		ufoCounter.put("NV", 0);
		ufoCounter.put("AK", 0);	//putting the state names, with their count of ufo sightings
		ufoCounter.put("ID", 0);
		ufoCounter.put("UT", 0);
		ufoCounter.put("AZ", 0);
		ufoCounter.put("MT", 0);
		ufoCounter.put("WY", 0);
		ufoCounter.put("CO", 0);
		ufoCounter.put("NM", 0);
		ufoCounter.put("ND", 0);
		ufoCounter.put("SD", 0);
		ufoCounter.put("NE", 0);
		ufoCounter.put("KS", 0);
		ufoCounter.put("OK", 0);
		ufoCounter.put("TX", 0);
		ufoCounter.put("MN", 0);
		ufoCounter.put("IA", 0);
		ufoCounter.put("MO", 0);
		ufoCounter.put("AR", 0);
		ufoCounter.put("WI", 0);
		ufoCounter.put("IL", 0);
		ufoCounter.put("MI", 0);
		ufoCounter.put("IN", 0);
		ufoCounter.put("OH", 0);
		ufoCounter.put("KY", 0);
		ufoCounter.put("VA", 0);
		ufoCounter.put("WV", 0);
		ufoCounter.put("PA", 0);
		ufoCounter.put("NY", 0);
		ufoCounter.put("ME", 0);
		ufoCounter.put("VT", 0);
		ufoCounter.put("NH", 0);
		ufoCounter.put("MA", 0);
		ufoCounter.put("CT", 0);
		ufoCounter.put("RI", 0);
		ufoCounter.put("NJ", 0);
		ufoCounter.put("DE", 0);
		ufoCounter.put("MD", 0);
		ufoCounter.put("TN", 0);
		ufoCounter.put("NC", 0);
		ufoCounter.put("SC", 0);
		ufoCounter.put("GA", 0);
		ufoCounter.put("AL", 0);
		ufoCounter.put("MS", 0);
		ufoCounter.put("LA", 0);
		ufoCounter.put("FL", 0);
		ufoCounter.put("HI", 0);

		check.put("Circle", 0);
		check.put("Teardrop", 0);
		check.put("Cone", 0);
		check.put("Egg", 0);
		check.put("Cross", 0);		//different shapes sightings count
		check.put("Triangle", 0);
		check.put("Rectangle", 0);
		check.put("Not specified", 0);
		check.put("Diamond", 0);
		check.put("Sphere", 0);
		check.put("Cylinder", 0);
		check.put("Cigar", 0);
		check.put("Fireball", 0);
		check.put("Unknown", 0);
		check.put("Changing", 0);
		check.put("Light", 0);
		check.put("Oval", 0);
		check.put("Chevron", 0);
		check.put("Flash", 0);
		check.put("Disk", 0);
		check.put("Formation", 0);
		check.put("Other", 0);

	}

	/**
	 * FROM drop down value setter
	 */
	public void setFrom(int from) {

		this.from = from;
		to = from;
		dateRangeReady = false;

		setChanged();
		notifyObservers();
	}

	/**
	 * TO drop down value setter
	 */
	public void setTo(int to) {

		this.to = to;
		dateRangeReady = true;

		rangeForDataGrabbing = dataRange();

		setChanged();
		notifyObservers();

		Thread thread = new Thread() {  
			public void run() {
				try {
					getDifference();
				} catch (IOException e) {
					e.printStackTrace();
				}

				dataGrabbedMisSecFormat = minsecFormat();
				System.out.println("dataGrabbedMisSecFormat " + dataGrabbedMisSecFormat);

				setChanged();
				notifyObservers();
			}
		};

		thread.start();  
	}

	/**
	 * FROM drop down value getter
	 */
	public int getDropDownValueFrom() {

		return from;
	}

	/**
	 * TO drop down value getter
	 */
	public int getDropDownValueTo() {

		return to;
	}

	/**
	 * 
	 * @return
	 */
	public boolean isDateRangeReady() {

		return dateRangeReady;
	}

	/**
	 * this method calls the grab data method and it checks the time it took to
	 * for the process
	 * 
	 * @throws IOException
	 */
	public void getTimeYearlyDetails() throws IOException {

		lStartTime = new Date().getTime();

		grabData();

		lEndTime = new Date().getTime();

		difference = lEndTime - lStartTime; //calculating timer difference

	}

	/**
	 * 
	 * @return
	 * @throws IOException
	 */
	public long getDifference() throws IOException { //throw exception otherwise

		getTimeYearlyDetails();

		return difference;
	}

	/**
	 * this method will grab the UFO data within the given date range. It will
	 * count the number of aliens in each state and update the ufoCounter
	 * hashMap
	 * 
	 * @throws IOException
	 */
	public void grabData() throws IOException {

		// reseting the values of all the keys in the ufoCounter hashMap
		for (String key : ufoCounter.keySet()) {

			ufoCounter.put(key, 0);
		}

		IncidentsRangeFrom = from + "-01-01 00:00:00";
		IncidentsRangeTo = to + "-12-31 23:59:59";

		results = ripley.getIncidentsInRange(IncidentsRangeFrom, IncidentsRangeTo);

		for (int i = 0; i < results.size(); i++) { //iterate through results arraylist

			Incident incident = results.get(i);
			boolean found_usa_sighting = false;

			for (String key : ufoCounter.keySet()) { //for each going through hashmap
				if (key.equals(incident.getState())) {

					ufoCounter.put(key, ufoCounter.get(key) + 1); //increment by 1
					found_usa_sighting = true;
				}
			}

			if (found_usa_sighting == false) {

				non_usa_sighting.add(incident);
			}
		}

		for (String key : ufoCounter.keySet()) {
			System.out.print(key + ":" + ufoCounter.get(key) + ". ");
		}

		setStatistics();
		setStatisticTitles();
		 
		populateSelectedStatistics();

		setChanged();
		notifyObservers();
	}
	
	
	/**
	 * 
	 * @return
	 */
	public String dataRange() {

		return ("Date range selected, " + getDropDownValueFrom() + "-" + getDropDownValueTo() + ".");
	}

	/**
	 * converts the time into minutes and seconds
	 * @return
	 */
	public String minsecFormat() {

		return "Data grabbed in " + String.format("%d min, %d sec.",

				TimeUnit.MILLISECONDS.toMinutes(difference),
				TimeUnit.MILLISECONDS.toSeconds(difference)
						- TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(difference)))
				+ "<br><br><b>Please now interact with this data using the buttons</b>";
	}

	/**
	 * this method will change the current panel index number
	 * @param buttonName
	 */
	public void changeCurrentPanelIndex(String buttonName) {

		if (buttonName.equals("leftButton")) {
			if (currentPanelIndex > 0) {
				currentPanelIndex--;
			}

		} else if (buttonName.equals("rightButton")) {
			if (currentPanelIndex < 3) {
				currentPanelIndex++;
			}
		}

		setChanged();
		notifyObservers("changing panel");
	}

	/**
	 *  method for changing the positions of the labels
	 * @param buttonName
	 */
	public void changeStatisticsPanel1Index(String buttonName) {

		selectedTitles.remove(indexForStatisticsPanel1);
		selectedStatistics.remove(indexForStatisticsPanel1);

		if (buttonName.equals("leftNW")) {
			if (indexForStatisticsPanel1 > 0) {
				indexForStatisticsPanel1--;
			}
			while (selectedStatistics.containsKey(indexForStatisticsPanel1)) {
				indexForStatisticsPanel1--;
				if (indexForStatisticsPanel1 < 0) {
					indexForStatisticsPanel1 = 7;
				}
			}
		} else if (buttonName.equals("rightNW")) {
			if (indexForStatisticsPanel1 < 7) {
				indexForStatisticsPanel1++;
			}
			while (selectedStatistics.containsKey(indexForStatisticsPanel1)) {
				indexForStatisticsPanel1++;
				if (indexForStatisticsPanel1 >= 7) {
					indexForStatisticsPanel1 = 0;
				}
			}
		}
		selectedTitles.put(indexForStatisticsPanel1, titles.get(indexForStatisticsPanel1));
		selectedStatistics.put(indexForStatisticsPanel1, statistics.get(indexForStatisticsPanel1));

		setChanged();
		notifyObservers();
	}

	/**
	 *  method for changing the positions of the labels
	 * @param buttonName
	 */
	public void changeStatisticsPanel2Index(String buttonName) {

		selectedTitles.remove(indexForStatisticsPanel2);
		selectedStatistics.remove(indexForStatisticsPanel2);

		if (buttonName.equals("leftNE")) {
			if (indexForStatisticsPanel2 > 0) {
				indexForStatisticsPanel2--;
			}
			while (selectedStatistics.containsKey(indexForStatisticsPanel2)) {
				indexForStatisticsPanel2--;
				if (indexForStatisticsPanel2 < 0) {
					indexForStatisticsPanel2 = 7;
				}
			}
		} else if (buttonName.equals("rightNE")) {
			if (indexForStatisticsPanel2 < 7) {
				indexForStatisticsPanel2++;
			}
			while (selectedStatistics.containsKey(indexForStatisticsPanel2)) {
				indexForStatisticsPanel2++;
				if (indexForStatisticsPanel2 >= 7) {
					indexForStatisticsPanel2 = 0;
				}
			}
		}

		selectedTitles.put(indexForStatisticsPanel2, titles.get(indexForStatisticsPanel2));
		selectedStatistics.put(indexForStatisticsPanel2, statistics.get(indexForStatisticsPanel2));

		setChanged();
		notifyObservers();
	}

	/**
	 *  method for changing the positions of the labels
	 * @param buttonName
	 */
	public void changeStatisticsPanel3Index(String buttonName) {

		selectedTitles.remove(indexForStatisticsPanel3);
		selectedStatistics.remove(indexForStatisticsPanel3);

		if (buttonName.equals("leftSW")) {
			if (indexForStatisticsPanel3 > 0) {
				indexForStatisticsPanel3--;
			}
			while (selectedStatistics.containsKey(indexForStatisticsPanel3)) {
				indexForStatisticsPanel3--;
				if (indexForStatisticsPanel3 < 0) {
					indexForStatisticsPanel3 = 7;
				}
			}
		} else if (buttonName.equals("rightSW")) {
			if (indexForStatisticsPanel3 < 7) {
				indexForStatisticsPanel3++;
			}
			while (selectedStatistics.containsKey(indexForStatisticsPanel3)) {
				indexForStatisticsPanel3++;
				if (indexForStatisticsPanel3 >= 7) {
					indexForStatisticsPanel3 = 0;
				}
			}
		}

		selectedTitles.put(indexForStatisticsPanel3, titles.get(indexForStatisticsPanel3));
		selectedStatistics.put(indexForStatisticsPanel3, statistics.get(indexForStatisticsPanel3));

		setChanged();
		notifyObservers();
	}

	/**
	 * method for changing the positions of the labels
	 * @param buttonName
	 */
	public void changeStatisticsPanel4Index(String buttonName) {

		selectedTitles.remove(indexForStatisticsPanel4);
		selectedStatistics.remove(indexForStatisticsPanel4);

		if (buttonName.equals("leftSE")) {
			if (indexForStatisticsPanel4 > 0) {
				indexForStatisticsPanel4--;
			}
			while (selectedStatistics.containsKey(indexForStatisticsPanel4)) {
				indexForStatisticsPanel4--;
				if (indexForStatisticsPanel4 < 0) {
					indexForStatisticsPanel4 = 7;
				}
			}
		} else if (buttonName.equals("rightSE")) {
			if (indexForStatisticsPanel4 < 7) {
				indexForStatisticsPanel4++;
			}
			while (selectedStatistics.containsKey(indexForStatisticsPanel4)) {
				indexForStatisticsPanel4++;
				if (indexForStatisticsPanel4 >= 7) {
					indexForStatisticsPanel4 = 0;
				}
			}
		}

		selectedTitles.put(indexForStatisticsPanel4, titles.get(indexForStatisticsPanel4));
		selectedStatistics.put(indexForStatisticsPanel4, statistics.get(indexForStatisticsPanel4));

		setChanged();
		notifyObservers();
	}

	/**
	 * 
	 * @return
	 */
	public int getIndexForStatisticsPanel1() {
		return indexForStatisticsPanel1;
	}

	/**
	 * 
	 * @return
	 */
	public int getIndexForStatisticsPanel2() {
		return indexForStatisticsPanel2;
	}

	/**
	 * 
	 * @return
	 */
	public int getIndexForStatisticsPanel3() {
		return indexForStatisticsPanel3;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getIndexForStatisticsPanel4() {
		return indexForStatisticsPanel4;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getIndexForTitle() {
		return indexForTitle;
	}

	/**
	 * currentPanelIndex getter
	 */
	public int getCurrentPanelIndex() {
		return currentPanelIndex;
	}
	
	/**
	 * 
	 * @return
	 */
	public HashMap<String, Integer> getUfoCounter() {
		return ufoCounter;
	}

	/**
	 * 
	 * @return
	 */
	public HashMap<String, Coordinates> getStates() {
		return states;
	}

	/**
	 * 
	 * @return
	 */
	public String getRangeForDataGrabbing() {
		return rangeForDataGrabbing;
	}

	/**
	 * 
	 * @return
	 */
	public String getDataGrabbedMisSecFormat() {
		return dataGrabbedMisSecFormat;
	}

	/**
	 * gets the date for each incident
	 * @param state
	 */
	public void process(String state) {
		IncidentsRangeFrom = from + "-01-01 00:00:00";
		IncidentsRangeTo = to + "-12-31 23:59:59";
		int index = 0;

		for (int i = 0; i < results.size(); i++) {

			if (state.equals(results.get(i).getState())) {	//if it equals state name
				index = i;

				posted = results.get(i).getPosted();		//getting the relevant info
				city = results.get(i).getCity();
				duration = results.get(i).getDuration();
				date = results.get(i).getDateAndTime();
				shape = results.get(i).getShape();
				String id = results.get(i).getIncidentID();
				eventDetails = ripley.getIncidentDetails(id);
				details.add(eventDetails);

				setChanged();
				notifyObservers();
				index++;
			}
		}
	}

	/**
	 * 
	 * @return
	 */
	public ArrayList<String> getEventDetails() {
		return details;
	}

	/**
	 * 
	 * @return
	 */
	public String setListSightings() {
		String last = ("Time: " + date + " City: " + city + " Shape: " + shape + " Duration: " + duration + " Posted: "
				+ posted);
		return last;		
	}
	
	/**
	 * 
	 * @param sort
	 */
	public void setDateSorting(boolean sort) {
		this.sort = sort;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean getSort() {
		return sort;
	}

	/**
	 * this method returns the number of possible hoaxes of USA sightings
	 * 
	 * @return numberOfHoaxes with a type String
	 */
	public String getNumberOfHoaxes() {

		int numberOfHoaxes = 0;

		for (int i = 0; i < results.size(); i++) {

			Pattern pattern = Pattern.compile("[Hh][Oo][Aa][Xx]");  //this is the pattern
			Matcher matcher = pattern.matcher(results.get(i).toString());

			if (matcher.find()) {
				numberOfHoaxes++;	//when matched
			}
		}
		return "" + numberOfHoaxes;
	}

	/**
	 * this method returns the number of UFO sightings outside the USA
	 * @return
	 */
	public String getNumberOfNonUSAincidents() {
		return "" + non_usa_sighting.size();
	}

	/**
	 * this method returns the name of the state which is likely to receive a
	 * UFO sighting next. this is assumed by looking at the state with the most
	 * sightings over the period.
	 * @return
	 */
	public String getLikeliestState() {

		int maxSightingsInOneState = 0;
		String stateWithMaxSighting = "";

		for (String state : ufoCounter.keySet()) {
			if (ufoCounter.get(state) >= maxSightingsInOneState) {
				maxSightingsInOneState = ufoCounter.get(state);
				stateWithMaxSighting = state;
			}
		}
		return stateWithMaxSighting;
	}

	/**
	 * this method returns the number of UFO YouTube videos posted in between
	 * 2013 and 2017
	 * 
	 * @return a String that holds the number of videos in each of the 5 years
	 * @throws IOException
	 */
	public String sightingsViaGoogleAPI() throws IOException {
		HashMap<Integer, String> youtubeSearchAPI = new HashMap<Integer, String>();

		String my_API = "AIzaSyA0AEn-pM8u6AnhsaVfqhL7NgD0-d58eCc"; //this is our api
		String query = "real+ufo+alien+sighting+caught+on+camera";

		//returning search results
		youtubeSearchAPI.put(2013,
				getUrlSource(
						"https://www.googleapis.com/youtube/v3/search?part=snippet&publishedAfter=2013-01-01T00%3A00%3A00Z&publishedBefore=2013-01-31T23%3A59%3A59Z&q="
								+ query + "&key=" + my_API));
		youtubeSearchAPI.put(2014,
				getUrlSource(
						"https://www.googleapis.com/youtube/v3/search?part=snippet&publishedAfter=2014-01-01T00%3A00%3A00Z&publishedBefore=2014-01-31T23%3A59%3A59Z&q="
								+ query + "&key=" + my_API));
		youtubeSearchAPI.put(2015,
				getUrlSource(
						"https://www.googleapis.com/youtube/v3/search?part=snippet&publishedAfter=2015-01-01T00%3A00%3A00Z&publishedBefore=2015-01-31T23%3A59%3A59Z&q="
								+ query + "&key=" + my_API));
		youtubeSearchAPI.put(2016,
				getUrlSource(
						"https://www.googleapis.com/youtube/v3/search?part=snippet&publishedAfter=2016-01-01T00%3A00%3A00Z&publishedBefore=2016-01-31T23%3A59%3A59Z&q="
								+ query + "&key=" + my_API));
		youtubeSearchAPI.put(2017,
				getUrlSource(
						"https://www.googleapis.com/youtube/v3/search?part=snippet&publishedAfter=2017-01-01T00%3A00%3A00Z&publishedBefore=2017-01-31T23%3A59%3A59Z&q="
								+ query + "&key=" + my_API));

		Pattern pattern = Pattern.compile("\"totalResults\":\\s\\d+");

		String resultOfyearSearch = "<html>";

		for (int i = 2013; i <= 2017; i++) {	//from these years
			Matcher matcher = pattern.matcher(youtubeSearchAPI.get(i));

			if (matcher.find()) {

				String numberOfVideos = matcher.group();
				numberOfVideos = numberOfVideos.replaceAll("\"totalResults\":\\s", "");
				resultOfyearSearch += (i + ": &nbsp;&nbsp;" + numberOfVideos + "<br>");
			}
		}

		return resultOfyearSearch;
	}

	/**
	 * method from stackoverflow: http://stackoverflow.com/a/8616808/6744085
	 * 
	 * @param url
	 * @return the html of a web page as a string
	 * @throws IOException
	 */
	private static String getUrlSource(String url) throws IOException {
		URL urlWebPage = new URL(url);
		URLConnection connection = urlWebPage.openConnection();
		
		//taking the information and storing in text file
		BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
		String inputLine;
		StringBuilder a = new StringBuilder();
		while ((inputLine = in.readLine()) != null)
			a.append(inputLine);
		in.close();

		return a.toString();
	}

	/**
	 * get the UFO sightings percentages of North, South, East and West of USA.
	 */
	public String getNorthSouthEastWestPercentages() {

		int numberOfUSAsightings = 0;
		int southEast = 0;
		int southWest = 0;
		int northEast = 0;
		int northWest = 0;

		// checking all the states
		for (String key : ufoCounter.keySet()) {
			numberOfUSAsightings += ufoCounter.get(key);

			// checking all the sightings of the current state
			for (int i = 0; i < ufoCounter.get(key); i++) {
				
		// conditions with specific coordinates

				if (states.get(key).getX() >= 475 && states.get(key).getY() >= 350) {
					southEast++;
				}
				if (states.get(key).getX() >= 475 && states.get(key).getY() < 350) {
					northEast++;
				}
				if (states.get(key).getX() < 475 && states.get(key).getY() >= 350) {
					southWest++;
				}
				if (states.get(key).getX() < 475 && states.get(key).getY() < 350) {
					northWest++;
				}
			}
		}

		//calculating percentage
		int se = (int) Math.round((100.0 * southEast / numberOfUSAsightings));
		int sw = (int) Math.round((100.0 * southWest / numberOfUSAsightings));
		int ne = (int) Math.round((100.0 * northEast / numberOfUSAsightings));
		int nw = (int) Math.round((100.0 * northWest / numberOfUSAsightings));

		return "<html>North West: " + nw + "%&nbsp;&nbsp;&nbsp;North East:" + ne + "%<br><br><br>South West: " + sw
				+ "%&nbsp;&nbsp;&nbsp;South East: " + se + "%";
	}

	/**
	 * calculates the percentage for shapes
	 * @return
	 */
	public String getShapePercentage() {

		int totalCounter = 0;

		//for each going through hashmap
		for (String key : check.keySet()) {
			for (int a = 0; a < results.size(); a++) {
				if (results.get(a).getShape().equals(key)) {
					
					//increment value for shape that matches

					totalCounter++;
					check.put(key, check.get(key) + 1);
				}
			}
		}
		String shapePercentages = "<html>";

		// this integer is just for line breaks after every 2 shape strings
		int indexForLineBreak = 1;

		for (String key : check.keySet()) {

			int percent = (int) Math.round((100.0 * check.get(key) / totalCounter));

			//calculate percentage
			indexForLineBreak++;

			if (indexForLineBreak % 2 == 0) {
				shapePercentages += "<br>";
			}
			shapePercentages += (key + ": " + percent + "%&nbsp;&nbsp;&nbsp;");
		}

		return shapePercentages;
	}

	/**
	 * calculates the percentage for posted
	 * @return
	 */
	public String getPostedPercentage() {
		int thirdOfRange = (to - from) / 3;
		ArrayList<Integer> posted = new ArrayList<Integer>();
		for (int i = 0; i < results.size(); i++) {
			String b = results.get(i).getPosted().substring(0, 4);
			int a = Integer.parseInt(b);
			posted.add(a);
		}
		int firstRange = 0;
		int secondRange = 0;
		int thirdRange = 0;

		for (Integer year : posted) {
			if (year >= from && year < from + thirdOfRange) {
				firstRange++;
			} else if (year >= from + thirdOfRange && year < from + thirdOfRange * 2) {
				secondRange++;
			} else if (year >= from + thirdOfRange * 2 + thirdOfRange && year < to) {
				thirdRange++;
			}
		}

		double firstPercentage =  Math.round((100.0 * firstRange / posted.size()));
		double secondPercentage =  Math.round((100.0 * secondRange / posted.size()));
		double thirdPercentage =  Math.round((100.0 * thirdRange / posted.size()));

		String finalPercentage = "<html>Percentage from " + from + " to " + (from + thirdOfRange) + " is : "
				+ firstPercentage + "%<br>Percentage from " + (from + thirdOfRange) + " to " + (from + thirdOfRange * 2)
				+ " is: " + secondPercentage + "%<br>Percentage from " + (from + thirdOfRange * 2) + " to " + to
				+ " is: " + thirdPercentage + "%";

		return finalPercentage;
	}

	/**
	 * this method returns a String representing UFO sighting percentages around
	 * the world
	 */
	public String getWorldPercentage() {

		int numberOfUSAsightings = 0;

		for (String key : ufoCounter.keySet()) {
			numberOfUSAsightings += ufoCounter.get(key);
		}

		int totalSightings = numberOfUSAsightings + non_usa_sighting.size();

		String usaPercentage = (numberOfUSAsightings * 100 / totalSightings) + "";
		String nonUsaPercentage = ((non_usa_sighting.size() * 100 / totalSightings)) + "";

		return "<html>USA sighting percentage: " + usaPercentage + "%<br><br>Non-USA sighting percentage: "
				+ nonUsaPercentage + "%";
	}
	
	/**
	 * adds the data to arrayList
	 * @throws IOException
	 */
	public void setStatistics() throws IOException {

		statistics.add(getNumberOfHoaxes());
		statistics.add(getNumberOfNonUSAincidents());
		statistics.add(getLikeliestState());
		statistics.add(sightingsViaGoogleAPI());
		statistics.add(getNorthSouthEastWestPercentages());
		statistics.add(getShapePercentage());
		statistics.add(getPostedPercentage());
		statistics.add(getWorldPercentage());
	}
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<String> getStatistics() {

		return statistics;
	}

	/**
	 * adds the Strings to arrayList
	 */
	public void setStatisticTitles() {

		titles.add("Number of Hoaxes: ");
		titles.add("Non-US Sightings: ");
		titles.add("Likeliest State: ");
		titles.add("<html>Number of UFO videos posted in<br>January of each of the last 5 years");
		titles.add("Direction Sightings: ");
		titles.add("Percentage Per Shape: ");
		titles.add("Posted Sightings Percentages: ");
		titles.add("US vs World Percentages: ");

	}

	/**
	 * this method will add the first 4 items of the statistics hashMap to the
	 * selectedStatistics, and it will add the first 4 items of the titles
	 * hasMap to the selectedTitles
	 */
	public void populateSelectedStatistics() {

		selectedStatistics.put(savedIndexes.get(0), statistics.get(savedIndexes.get(0)));
		selectedStatistics.put(savedIndexes.get(1), statistics.get(savedIndexes.get(1)));
		selectedStatistics.put(savedIndexes.get(2), statistics.get(savedIndexes.get(2)));
		selectedStatistics.put(savedIndexes.get(3), statistics.get(savedIndexes.get(3)));
		selectedTitles.put(savedIndexes.get(0), titles.get(savedIndexes.get(0)));
		selectedTitles.put(savedIndexes.get(1), titles.get(savedIndexes.get(1)));
		selectedTitles.put(savedIndexes.get(2), titles.get(savedIndexes.get(2)));
		selectedTitles.put(savedIndexes.get(3), titles.get(savedIndexes.get(3)));

	}
	/**
	 * puts the index into hashMap
	 * @param index
	 */
	public void loadedSelectedStatistics(int index) {
		selectedStatistics.put(index, statistics.get(index));
		selectedTitles.put(index, titles.get(index));
	}

	/**
	 * this method sets the indexes to the numbers passed from the text file
	 * @param indexes: ArrayList with 4 numbers 
	 */
	public void setLoadedIndexes(ArrayList<Integer> indexes) {
		savedIndexes = indexes;
		indexForStatisticsPanel1 = savedIndexes.get(0);
		indexForStatisticsPanel2 = savedIndexes.get(1);
		indexForStatisticsPanel3 = savedIndexes.get(2);
		indexForStatisticsPanel4 = savedIndexes.get(3);

	}

	/**
	 * this method is a selectedTitles getter
	 * 
	 * @return selectedTitles of type HashMap<Integer, String>
	 */
	public HashMap<Integer, String> getSelectedTitles() {
		return selectedTitles;
	}

	/**
	 * this method is a selectedStatistics getter
	 * 
	 * @return selectedStatistics of type HashMap<Integer, String>
	 */
	public HashMap<Integer, String> getSelectedStatistics() {
		return selectedStatistics;
	}

	/**
	 * this method creates an instance of the Game and it starts it
	 */
	public void runGame() {

		main = new Game();
	}
}
