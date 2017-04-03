import controller.Controller;
import model.Model;
import view.GameFrame;

public class Main {

    public static void main(String[] args) {
        Model model = new Model();
        Controller controller = new Controller(model);
        GameFrame game = new GameFrame(model, controller);

        model.addObserver(game);
    }
}