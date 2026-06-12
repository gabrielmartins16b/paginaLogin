import controller.AuthController;
import model.User;
import model.UserRepository;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application{

    @Override
    public void start(Stage stage){

        //TITULO
        Label titulo = new Label("Bem vindo!");
        titulo.setStyle("-fx-font-size: 13px; -fx-font-weight: bold;");

        Label subtitulo = new Label("Faça login para continuar");
        subtitulo.setStyle("-fx-font-size: 13px; -fx-text-fill: gray;");

        // Campo de e-mail
        Label labelEmail = new Label("E-mail");
        TextField campoEmail = new TextField();
        campoEmail.setPromptText("usuario@email.com");

        //Campo de senha
        Label labelSenha = new Label("Senha");
        PasswordField campoSenha = new PasswordField();
        campoSenha.setPromptText("Sua senha");

        // Mensagem de erro (começa invisível)
        Label mensagemErro = new Label();
        mensagemErro.setStyle("-fx-text-fill: red; -fx-font=size: 12px;");
        mensagemErro.setVisible(false);

        //Botão entrar
        Button btnEntrar = new Button("Entrar");
        btnEntrar.setMaxWidth(Double.MAX_VALUE);
        btnEntrar.setStyle("-fx-background-color: #2a6ab5; -fx-text-fill: white; -fx-font-size: 14px; -fx-padding: 8px;");

        //Botão criar conta
        Button btnCriarConta = new Button("Criar conta");
        btnCriarConta.setMaxWidth(Double.MAX_VALUE);
        btnCriarConta.setStyle("-fx-font-size: 13px;");

        btnEntrar.setOnAction(e -> {
            String email = campoEmail.getText();
            String senha = campoSenha.getText();

            if (email.isEmpty() || senha.isEmpty()) {
                mensagemErro.setText("Preencha todos os campos!");
                mensagemErro.setVisible(true);
            } else {
                System.out.println("Tentando login com:"+ email);
                mensagemErro.setVisible(false);
            }
        });

        //LAYOUT
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(40));
        layout.setAlignment(Pos.CENTER_LEFT);
        layout.setMaxWidth(320);
        layout.getChildren().addAll(
            titulo, subtitulo,
            new Label(""),
            labelEmail, campoEmail,
            labelSenha, campoSenha,
            mensagemErro,
            new Label(""),
            btnEntrar, btnCriarConta
        );

        //Centralizar o layout
        VBox root = new VBox(layout);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: #f4f4f4;");

        Scene scene = new Scene(root, 480, 500);
        stage.setTitle("Sistema de Login");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}

