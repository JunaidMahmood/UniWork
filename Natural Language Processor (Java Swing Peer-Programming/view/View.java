/**
 * this is the view class, it consists of JLists and JTabbedPanes. It takes instances of the controller and model through its parameters
 */
package view;

import java.awt.BorderLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import controller.Controller;
import model.Model;

public class View extends JFrame implements Observer{

    // j components
    private JTabbedPane jtp;
    private JPanel calendarPanel;
    private JPanel reminderPanel;
    private JTextField calendarInput;
    private JTextField reminderInput;
    private JList<String> calendarList;
    private JList<String> reminderList;
    private JScrollPane calendarScroll;
    private JScrollPane reminderScroll;
    private Model model;

    public View(Model model, Controller controller){

        setSize(700, 600); // size of jframe set

        this.addWindowListener(controller); // used to trigger events on closing and opening JFrame
        this.model = model;

        // panel for the calender and reminders
        calendarPanel = new JPanel(new BorderLayout());
        reminderPanel = new JPanel(new BorderLayout());

        // jlists for the panels and mouse listeners for deleting entries
        calendarList = new JList<String>(model.getCalendar());
        calendarList.addMouseListener(controller);
        reminderList = new JList<String>(model.getReminders());
        reminderList.addMouseListener(controller);

        // jlists add to scroll panes
        calendarScroll = new JScrollPane(calendarList);
        reminderScroll = new JScrollPane(reminderList);

        // texts fields for the panes, with action listeners for returning entries
        calendarInput = new JTextField();
        calendarInput.addActionListener(controller);
        reminderInput = new JTextField();
        reminderInput.addActionListener(controller);

        // scroll panes and text fields add to panels with positioning
        calendarPanel.add(calendarScroll, BorderLayout.CENTER);
        calendarPanel.add(calendarInput, BorderLayout.SOUTH);
        reminderPanel.add(reminderScroll, BorderLayout.CENTER);
        reminderPanel.add(reminderInput, BorderLayout.SOUTH);

        // 2 tabbed panes created
        jtp = new JTabbedPane();
        jtp.addTab("Calendar", null, calendarPanel, "Calendar panel");
        jtp.addTab("Reminders", null, reminderPanel, "Reminder panel");

        setContentPane(jtp);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    // update method, observes model
    @Override
    public void update(Observable o, Object arg) {
        calendarList.revalidate();
        calendarList.repaint();

        reminderList.revalidate();
        reminderList.repaint();
    }
}