package ttt.tictactoe;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainScreenController {
    @FXML
    private Pane settingsPane;

    @FXML
    protected void onSettingsButtonClick() {
        settingsPane.setVisible(true);
    }
    @FXML
    protected void onExitButtonClick() {
        Platform.exit();
    }
    @FXML
    protected void onStartButtonClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TicTacToeApp.class.getResource("GamemodeScreen.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 1920, 1080);
        } catch (IOException ignored) {}
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void onSettingsExitButtonClick() {
        settingsPane.setVisible(false);
    }

}