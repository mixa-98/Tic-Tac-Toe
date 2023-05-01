package ttt.tictactoe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GamemodeController {
    @FXML
    protected void onGamemodeExitButton(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TicTacToeApp.class.getResource("MainScreen.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 1920, 1080);
        } catch (IOException ignored) {}
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void onAIButtonClick(ActionEvent event) {
        GameData gameData = new GameData();
        gameData.setGamemode(true);
        GameDataHolder gameDataHolder = GameDataHolder.getInstance();
        gameDataHolder.setData(gameData);
        FXMLLoader fxmlLoader = new FXMLLoader(TicTacToeApp.class.getResource("GameScreen.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 1920, 1080);
        } catch (IOException ignored) {}
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void on2PlayerClick(ActionEvent event) throws IOException {
        GameData gameData = new GameData();
        gameData.setGamemode(false);
        GameDataHolder gameDataHolder = GameDataHolder.getInstance();
        gameDataHolder.setData(gameData);
        FXMLLoader fxmlLoader = new FXMLLoader(TicTacToeApp.class.getResource("GameScreen.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 1920, 1080);
        } catch (IOException ignored) {}
        stage.setScene(scene);
        stage.show();
    }
}
