package preliminaries;

import java.awt.*;

public class Main {

    public static void main(String[] args) {

        Dimension runway = new Dimension(10, 100);

        Model model = new Model(10, 10, new Coordinates(5, 0), 5, 5);
        Controller controller = new Controller(model);
        View view = new View(controller, runway, model);

        model.addObserver(view);

        model.takeOff(view, runway);
    }
}
