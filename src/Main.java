import controller.AuthController;
import model.User;
import model.UserRepository;
import javafx.application.Application;
import javafx.stage.stage;

public class Main extends Application {

    @Override
    public void start(Stage stage){
        AuthController auth = new AuthController();
        auth.registrar();

        new LoginScreen(auth).show(stage);
    }
    public static void main(String[] args) {
        launch(args);
    }
}

