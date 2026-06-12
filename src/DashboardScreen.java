import controller.AuthController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class DashboardScreen {
    private AuthController auth;

    public DashboardScreen(AuthController auth){
        this.auth = auth;
    }

    public void show(Stage stage){
        String nomeUsuario = auth.getUsuarioLogado().getNome();

        Label appNome = new Label("Sistema Login");
        appNome.setStyle("-fx-font-size: 14px; -fx-font-weight: bold; -fx-text-fill: white;");

        Button btnInicio = criarItemMenu("Inicio", true);
        Button btnPerfil = criarItemMenu("Perfil", true);
        Button btnConfig = criarItemMenu
    }
}
