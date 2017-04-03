/**
 * this is the model class which contains the logic, such as the pattern matchers and default list models.
 */
package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Observable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultListModel;

// class is observed by view
public class Model extends Observable {

    private String[] weekdays;
    private String[] months;
    private String[] suffixes;

    private Pattern dateP;
    private Pattern timeP;
    private Pattern locationP;

    private DefaultListModel<String> calendar;
    private DefaultListModel<String> reminders;

    // patterns for the date, time and location. Strings for the weekdays, months and date suffixes. List models created for the two panes.
    public Model(){

        dateP = Pattern.compile("(\\b(on|at|in|during|at)\\b\\s*)?"
                        + "(((0[1-9]|[1-2][0-9]|3[0-1])([^(\\w|\\s|\\d)])(0[1-9]|1[0-2])([^(\\w|\\s|\\d)])((20|19)\\d\\d))|"
                        + "(((20|19)?\\d\\d)([^(\\w|\\s|\\d)])(0[1-9]|1[0-2])([^(\\w|\\s|\\d)])(0[1-9]|[1-2][0-9]|3[0-1]))|"
                        + "(\\b(Monday|Tuesday|Wednesday|Thursday|Friday|Saturday|Sunday)\\b)?(\\s*)((0?[1-9]|[12][0-9]|3[01])?(\\s*)(th|rd|st|nd)?(\\s*)"
                        + "((January|February|March|April|May|June|July|August|September|October|November|December))|"
                        + "((next|this)?(\\s*)(Monday|Tuesday|Wednesday|Thursday|Friday|Saturday|Sunday))|"
                        + "\\s*\\b(Today|Tomorrow)\\b\\s*))"
                , Pattern.CASE_INSENSITIVE);

        timeP = Pattern.compile("(\\b(at|around|in)\\b\\s*)?(([01]?[0-9]|2[0-3])(:)[0-5][0-9]|"
                        + "(1[012]|[1-9])(am|pm)|"
                        + "(\\b(the|a)\\b\\s*)?(\\b(morning|evening)\\b))"
                , Pattern.CASE_INSENSITIVE);

        locationP = Pattern.compile("((\\bat\\b\\s*)(the|a|my|her|his|their)?(\\s*)(\\w+('s|'))?(\\s*)"
                        + "\\b\\w+\\b)"
                , Pattern.CASE_INSENSITIVE);

        weekdays = new String[]{"","Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        months = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        suffixes = ",st,nd,rd,th,th,th,th,th,th,th,th,th,th,th,th,th,th,th,th,th,st,nd,rd,th,th,th,th,th,th,th,st".split(",");

        calendar = new DefaultListModel<String>();
        reminders = new DefaultListModel<String>();
    }

    // this is the match method which compares a string against the patterns
    public void match(String input2) throws ParseException {

        String input = input2;
        // initially time, date and location are empty (if no match found, they remain this way)
        String time = " - ";
        String location = " - ";
        String date = " - ";

        // date input matcher
        Matcher d = dateP.matcher(input);

        // calendar with current date
        Calendar c = Calendar.getInstance(Locale.UK);
        Calendar now = Calendar.getInstance(Locale.UK);

        // if date is found, it is converted into a suitable format 
        if (d.find()) {
            String a = d.group();
            String b = a.replaceAll("(\\b(on|at|in|this|at)\\b\\s*)", "");	// any prefixes are removed

            // conversion process if date is in a form of dd/mm/yyyy
            if (b.matches("((0[1-9]|[1-2][0-9]|3[0-1])([^(\\w|\\s|\\d)])(0?[1-9]|1[0-2])([^(\\w|\\s|\\d)])((20|19)\\d\\d))")) {
                b = b.replaceAll("[^(\\w|\\s|\\d]", " ");	//any division characters (backslashes and so on) are replaced with spaces
                SimpleDateFormat in = new SimpleDateFormat("dd MM yyyy");

                // input date is converted into the same simple date format 
                // the calendar date is set to be the input date
                c.setTime(in.parse(b));

             // conversion process if date is in a form of yyyy/mm/dd
            } else if (b.matches("((20|19)\\d\\d)([^(\\w|\\s|\\d)])(0?[1-9]|1[0-2])([^(\\w|\\s|\\d)])(0?[1-9]|[1-2][0-9]|3[0-1])")) {
                b = b.replaceAll("[^(\\w|\\s|\\d]", " ");
                SimpleDateFormat in = new SimpleDateFormat("yyyy MM dd");
                
                c.setTime(in.parse(b));
               
            } else if (b.matches("\\s*(?i)(Tomorrow)\\s*")) {
                c.add(Calendar.DATE, 1);
 
		        
            // conversion process if date is similar to (Tuesday 10th January)
            } else if (b.matches("(?i)((Monday|Tuesday|Wednesday|Thursday|Friday|Saturday|Sunday)?(\\s*)(([1-9]|[12][0-9]|3[01])?(\\s*)(th|rd|st|nd)?(\\s*)"
                    + "(January|February|March|April|May|June|July|August|September|October|November|December)))")) {
               
            	b = b.replaceAll("(\\s*)(th|rd|st|nd)(\\s)", " ");
            	
            	// Ignores weekday input as the user may be wrong about it
                b = b.replaceAll("(\\s*)\\b(Monday|Tuesday|Wednesday|Thursday|Friday|Saturday|Sunday)\\b(\\s*)", "");
                SimpleDateFormat in = new SimpleDateFormat("d MMMM");
                
                // Set the date to input
                c.setTime(in.parse(b));
                
                // If date if after or equal to today, it is of this year. If that date has already passed, then next year
                if (c.getTime().after(new Date()) || c.getTime().equals(new Date())) {
	                c.set(Calendar.YEAR, now.get(Calendar.YEAR)); }
                else {
                	c.set(Calendar.YEAR, now.get(Calendar.YEAR)+1);
                }
                
            // conversion process if input is this/next day of the week
            } else if (b.matches("(?i)((next|this)?(\\s*)(Monday|Tuesday|Wednesday|Thursday|Friday|Saturday|Sunday))")) {
                int dayC = 0;
                
                // Checks number of that day of the week (loops through the array with weekdays)
                for (int i = 1; i < 8; i++) {
                    b = b.replaceAll("(?i)(next|this)?(\\s*)", "");
                    if (weekdays[i].equals(b) || weekdays[i].toLowerCase().equals(b)) {
                        dayC = i;
                    }
                }
                
                // sets calendar date to be the closest input weekday
                while (c.get(Calendar.DAY_OF_WEEK) != dayC) {
                    c.add(Calendar.DATE, 1);
                }
                // if user asked for the next weekday, then adds 7 days
                if (b.contains("next") || b.contains("Next")) {
                    c.add(Calendar.DATE, 7);
                }
            }
                
            // final date representation
            date = weekdays[c.get(Calendar.DAY_OF_WEEK)] + " " + c.get(Calendar.DATE) + suffixes[c.get(Calendar.DATE)] + " " + months[c.get(Calendar.MONTH)];

            // remove date from input String so no other matchers consider it
            input = input.replace(a, "");
        
        }

        // time matcher
        Matcher t = timeP.matcher(input);
        
        // if time is found it is converted into suitable 24 hour format
        if (t.find()) {
            String a = t.group();
            
            // remove all the prefixes
            String b = a.replaceAll("\\b(at|around|in|the|a)\\b\\s*", "");
            
            // nothing changed if time is in 24 hour format
            if (b.matches("([01]?[0-9]|2[0-3])(:)[0-5][0-9]")) {
                time = b;
            
            // conversion process if time is in 12 hour format
            } else if (b.matches("(1[012]|[1-9])(am|pm)")) {
                SimpleDateFormat in = new SimpleDateFormat("hha");
                SimpleDateFormat out = new SimpleDateFormat("HH:mm");

                // reformat the time from 12 to 24 hour format
                time = out.format(in.parse(b));
                
            // if time input is "morning", set time to 8:00
            } else if (b.matches("(\\b(morning)\\b)")) {
                time = "9:00";
                
            // if time input is "evening", set time to 20:00
            } else if (b.matches("(\\b(evening)\\b)")) {
                time = "20:00";
            }

            // remove any time input from input String
            input = input.replace(a, "");
        }

        // Location input matcher
        Matcher l = locationP.matcher(input);
        
        // If location is found, convert remove "at" prefix
        if (l.find()) {
            String a = l.group();
            location = a.replaceAll("(\\bat\\b\\s*)", "");
            
            // remove location from final String
            input = input.replace(a, "");
        }

        // event is anything left in input String
        String event = input;

        // If "Remind me to" is present in the String, remove it and place the String into Reminders list
        if (event.matches("(?i)(Remind me to\\s*)(\\S\\s*)*")) {
            String element = event.replaceAll("(?i)(Remind me to)\\s*", "");
            
            //If date or time is present, add to Reminders string
            if (!element.matches("\\s*")) {
                if (!date.equals(" - ")) {
                    element += "| Date: " + date;
                }
                if (!time.equals(" - ")) {
                    element += "| Time: " + time;
                }
                
                // only add it to reminders if any text is present
                if (!element.matches("\\s*")){
                	reminders.addElement(element);
                	
                	// notify GUI about changes
                    setChanged();
                    notifyObservers();
                }
            }

        // only add it to calendar if any text is present
        } else if (!event.matches("\\s*") && event != null) {
            String element = "Event: " + event + "| Date: " + date + "| Time: " + time + "| Location: " + location;
            calendar.addElement(element);

         // notify GUI about changes
            setChanged();
            notifyObservers();
        }

    }

    // returns list model for the calendar
    public DefaultListModel<String> getCalendar() {
        return calendar;
    }

    // returns list model for the reminders
    public DefaultListModel<String> getReminders() {
        return reminders;
    }

    // adds string to the calendar list
    public void addToCalendar(String e) {
        calendar.addElement(e);
    }

    // adds string to the reminders list
    public void addToReminders(String e) {
        reminders.addElement(e);
    }

}
