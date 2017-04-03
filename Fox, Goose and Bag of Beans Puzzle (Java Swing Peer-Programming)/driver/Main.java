/**
 * this is in the driver class with objects of the model, controller and view classes
 */
package driver;

import view.View;
import model.Model;
import controller.Controller;

public class Main {

    public static void main(String[] args) {

        //objects of main classes
        Model model = new Model();
        Controller controller = new Controller(model);
        View view = new View(controller, model);
        model.addObserver(view);
    }
}
