/**
 * this is the driver class, it contains objects of the model, view and controller
 */
package driver;

import controller.Controller;
import model.Model;
import view.View;

public class Main {
    public static void main(String[] args) {

        Model model = new Model();
        // model past into controller
        Controller controller = new Controller(model);
        // model and controller past into view
        View view = new View(model, controller);

        // view observes model
        model.addObserver(view);
    }
}
