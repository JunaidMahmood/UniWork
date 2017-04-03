/**
 * this is the controller class, contains action listener for returning entries into jlist, mouse listener for removing selection
 * and window listeners for performing actions on closing and opening jframe
 */
package controller;

import java.awt.event.*;
import java.io.*;
import java.text.ParseException;
import javax.swing.JList;
import javax.swing.JTextField;
import model.Model;

// implements listeners
public class Controller implements ActionListener, MouseListener, WindowListener {

    private Model model;

    public Controller(Model model){
        this.model = model;
    }

    // action listener which enters users input upon pressing return and checks input against pattern matchers in the model
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().getClass() == JTextField.class) {
            JTextField input = (JTextField)e.getSource();
            try {
                model.match(input.getText());
            } catch (ParseException e1) {
                e1.printStackTrace();
            }
            input.setText("");
        }
    }

    // mouse listener which deletes the selected entry once double clicked.
    @SuppressWarnings("unchecked")
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount()==2) {
            // if source is the calendar list model, deletes the selected index from there
            if (((JList<String>)e.getSource()).getModel().equals(model.getCalendar())) {
                model.getCalendar().remove(((JList<String>)e.getSource()).getSelectedIndex());
            }
            // if source is the reminder list model, deletes the selected index from there
            else if (((JList<String>)e.getSource()).getModel().equals(model.getReminders())) {
                model.getReminders().remove(((JList<String>)e.getSource()).getSelectedIndex());
            }
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

    // window listener for loading the text files when the jframe is opened. Uses buffered reader
    @Override
    public void windowOpened(WindowEvent e) {
        // loads the calendar text file
        try (BufferedReader reader = new BufferedReader(new FileReader("src/textFileCalendar.txt"))) {
            String word;
            while ((word = reader.readLine()) != null){
                model.addToCalendar(word);
            }
            reader.close();
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        // loads the reminders text file
        try (BufferedReader reader = new BufferedReader(new FileReader("src/textFileReminder.txt"))) {
            String word;
            while ((word = reader.readLine()) != null){
                model.addToReminders(word);
            }
            reader.close();
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    // writes the text files again after closing jframe, overwriting previous copies since entries can be add and removed.
    @Override
    public void windowClosing(WindowEvent e) {
        FileWriter writer = null;
        BufferedWriter out = null ;

        File file = new File("src/textFileCalendar.txt");
        File file2 = new File("src/textFileReminder.txt");

        // writes calendar list model on closing using BufferedWriter and FileWriter
        try {
            PrintWriter pw = new PrintWriter("src/textFileCalendar.txt");
            pw.close();

            writer = new FileWriter(file.getAbsoluteFile(), true);
            out = new BufferedWriter(writer);
            for (Object a: model.getCalendar().toArray()) {
                out.append(a.toString() + "\n");
            }
            out.close();
            writer.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        // writes reminder list model on closing using BufferedWriter and FileWriter
        try {
            PrintWriter pw = new PrintWriter("src/textFileReminder.txt");
            pw.close();

            writer = new FileWriter(file2.getAbsoluteFile(), true);
            out = new BufferedWriter(writer);
            for (Object a: model.getReminders().toArray()) {
                out.append(a.toString() + "\n");
            }
            out.close();
            writer.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e){
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }
}