package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class JogoDaVelha extends Application {

    private String[][] tabuleiro = new String[3][3];
    private boolean turnoX = true;
    private Button[][] botoes;
    private Image icone;

    @Override
    public void start(Stage stage) {
    	icone = new Image(getClass().getResource("/tictactoe.png").toExternalForm());
    	stage.getIcons().add(icone);
    	
    	stage.setResizable(false);
    	stage.setTitle("Jogo da Velha");
    	Label texto = new Label("Bem-vindo ao jogo da velha!");
    	Button iniciar = new Button("Iniciar Jogo");
    	VBox root = new VBox(10);
    	root.setAlignment(Pos.CENTER);

    	
    	root.getChildren().addAll(texto, iniciar);
    	

        Scene menuScene = new Scene(root, 300, 300);	
    	
        GridPane grid = new GridPane();
        Scene jogoScene = new Scene(grid, 300, 300);
        botoes = new Button[3][3];
        
        iniciar.setOnAction(e -> stage.setScene(jogoScene));
        stage.setScene(menuScene);
    	stage.show();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Button btn = new Button("");
                botoes[i][j] = btn;
                btn.setPrefSize(100, 100);

                int linha = i;
                int coluna = j;

                btn.setOnAction(e -> jogar(btn, linha, coluna));

                grid.add(btn, j, i);
            }
        }
    }
    
    private void aplicarIcone(Alert alert) {
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(icone);
    }
    
    private void PopupVitoria(String j) {
    	
    	Alert vitoria = new Alert(AlertType.CONFIRMATION, "Deseja jogar de novo?", ButtonType.YES, ButtonType.NO);
    	ImageView img = new ImageView(
    		    new Image(getClass().getResource("/velha.png").toExternalForm())
    		);
    	
    		img.setFitWidth(50);
    		img.setFitHeight(50);

    		vitoria.setGraphic(img);
    	aplicarIcone(vitoria);
    	vitoria.setTitle("Vitória!");
        vitoria.setHeaderText("Vitória do " + j + "!");
        vitoria.showAndWait().ifPresent(response ->{
        	if(response == ButtonType.YES) {
        		reiniciarJogo();
        	} else {
        		System.exit(0);
        	}
        });
    	
    }
    
    private void PopupEmpate() {
    	Alert empate = new Alert(AlertType.CONFIRMATION, "Deseja jogar de novo?", ButtonType.YES, ButtonType.NO);
    	ImageView img = new ImageView(
    		    new Image(getClass().getResource("/velha.png").toExternalForm())
    		);

    		img.setFitWidth(50);
    		img.setFitHeight(50);

    		empate.setGraphic(img);
    	aplicarIcone(empate);
    	empate.setTitle("Deu velha!");
    	empate.setHeaderText(null);
    	empate.showAndWait().ifPresent(response ->{
    		if(response == ButtonType.YES) {
    			reiniciarJogo();
    		} else {
    			System.exit(0);
    		}
    	});
    }
    
    private boolean tabuleiroCheio() {
    	for (int i = 0; i < tabuleiro.length; i++) {
    		for(int j = 0; j < tabuleiro.length; j++) {
    			if(tabuleiro[i][j] == null) return false;
    		}
    	}
    	return true;
    }
    

    private void jogar(Button btn, int linha, int coluna) {
        if (!btn.getText().isEmpty()) return;

        String jogador = turnoX ? "X" : "O";
        btn.setText(jogador);
        tabuleiro[linha][coluna] = jogador;

        if (verificarVitoria(jogador)) {
            PopupVitoria(jogador);
            return;
        } else if(tabuleiroCheio()) {
        	PopupEmpate();
        	return;
        }

        turnoX = !turnoX;
    }
    
    private void reiniciarJogo() {
    	
    	for(int i = 0;i < 3; i++) {
    		for(int j = 0; j < 3; j++) {
    			tabuleiro[i][j] = null;
    			botoes[i][j].setText("");
     		}
    	}
    	turnoX = true;
    	
    }
    

    private boolean verificarVitoria(String j) {
        for (int i = 0; i < 3; i++) {
            if (j.equals(tabuleiro[i][0]) &&
                j.equals(tabuleiro[i][1]) &&
                j.equals(tabuleiro[i][2]))return true;

            if (j.equals(tabuleiro[0][i]) &&
                j.equals(tabuleiro[1][i]) &&
                j.equals(tabuleiro[2][i])) return true;
        }

        if (j.equals(tabuleiro[0][0]) &&
            j.equals(tabuleiro[1][1]) &&
            j.equals(tabuleiro[2][2])) return true;

        if (j.equals(tabuleiro[0][2]) &&
            j.equals(tabuleiro[1][1]) &&
            j.equals(tabuleiro[2][0])) return true;
        
       
        return false;
        
    }
    

    public static void main(String[] args) {
        launch();
    }
}