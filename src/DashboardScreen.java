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
        Button btnPerfil = criarItemMenu("Perfil", false);
        Button btnConfig = criarItemMenu("Configurações", false);

        Button btnSair = new Button("Sair");
        btnSair.setMaxWidth(Double.MAX_VALUE);
        btnSair.setStyle("""
            -fx-background-color: transparent;
            -fx-text-fill: #ffaaaa;
            -fx-font-size: 13px;
            -fx-padding: 8px 12px;
            -fx-alignment: CENTER-LEFT;
            -fx-cursor: hand;
        """);

        VBox sidebar = new VBox(8);
        sidebar.setPadding(new Insets(24, 12, 24, 12));
        sidebar.setPrefWidth(180);
        sidebar.setStyle("-fx-background-color: #1e2d40;");

        // Empurra o botão sair para o final
        Region espacador = new Region();
        VBox.setVgrow(espacador, Priority.ALWAYS);

        sidebar.getChildren().addAll(appNome, new Label(""), btnInicio, btnPerfil, btnConfig, espacador, btnSair);

        // ── Conteúdo principal ───────────────────
        Label saudacao = new Label("Olá, " + nomeUsuario);
        saudacao.setStyle("-fx-font-size: 22px; -fx-font-weight: bold;");

        Label subtitulo = new Label("Você está logado no sistema.");
        subtitulo.setStyle("-fx-font-size: 13px; -fx-text-fill: gray;");

        // Card de sessão ativa
        VBox card = new VBox(6);
        card.setPadding(new Insets(16));
        card.setStyle("""
            -fx-background-color: white;
            -fx-border-color: #e0e0e0;
            -fx-border-radius: 8px;
            -fx-background-radius: 8px;
        """);
        Label cardTitulo = new Label("Sessão ativa");
        cardTitulo.setStyle("-fx-font-weight: bold;");
        Label cardEmail = new Label("E-mail: " + auth.getUsuarioLogado().getEmail());
        cardEmail.setStyle("-fx-text-fill: gray; -fx-font-size: 12px;");
        card.getChildren().addAll(cardTitulo, cardEmail);

        VBox conteudo = new VBox(12);
        conteudo.setPadding(new Insets(32));
        conteudo.getChildren().addAll(saudacao, subtitulo, new Label(""), card);

        // ── Layout geral ─────────────────────────
        HBox root = new HBox(sidebar, conteudo);
        HBox.setHgrow(conteudo, Priority.ALWAYS);
        root.setStyle("-fx-background-color: #f4f4f4;");

        // ── Ação do botão sair ───────────────────
        btnSair.setOnAction(e -> {
            auth.logout();
            // Volta para o login
            new LoginScreen(auth).show(stage);
        });

        Scene scene = new Scene(root, 700, 450);
        stage.setTitle("Dashboard");
        stage.setScene(scene);
        stage.show();
    }

    private Button criarItemMenu(String texto, boolean ativo) {
        Button btn = new Button(texto);
        btn.setMaxWidth(Double.MAX_VALUE);
        String estiloBase = """
            -fx-font-size: 13px;
            -fx-padding: 8px 12px;
            -fx-alignment: CENTER-LEFT;
            -fx-cursor: hand;
            -fx-border-radius: 6px;
            -fx-background-radius: 6px;
        """;
        if (ativo) {
            btn.setStyle(estiloBase + "-fx-background-color: #2a6ab5; -fx-text-fill: white;");
        } else {
            btn.setStyle(estiloBase + "-fx-background-color: transparent; -fx-text-fill: #ccddee;");
        }
        return btn;
    }
}
