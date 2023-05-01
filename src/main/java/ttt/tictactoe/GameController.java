package ttt.tictactoe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class GameController {
    @FXML
    private ImageView square1;
    @FXML
    private ImageView square2;
    @FXML
    private ImageView square3;
    @FXML
    private ImageView square4;
    @FXML
    private ImageView square5;
    @FXML
    private ImageView square6;
    @FXML
    private ImageView square7;
    @FXML
    private ImageView square8;
    @FXML
    private ImageView square9;
    @FXML
    private Pane GameOverPane;

    private void paintSquare(byte squareID, String color) {
        Image image = new Image(GameController.class.getResource(color + ".png").getPath().substring(1));
        switch (squareID) {
            case 1 -> square1.setImage(image);
            case 2 -> square2.setImage(image);
            case 3 -> square3.setImage(image);
            case 4 -> square4.setImage(image);
            case 5 -> square5.setImage(image);
            case 6 -> square6.setImage(image);
            case 7 -> square7.setImage(image);
            case 8 -> square8.setImage(image);
            case 9 -> square9.setImage(image);
        }
    }

    private void refresh() {
        GameLogic.getInstance().setColor(true);
        for (SquareN squareN : GameLogic.getInstance().getSquares()) {
            squareN.setType((byte) 0);
        }
    }

    private void gameOver() {
        GameOverPane.setVisible(true);
        for (SquareN squareN : GameLogic.getInstance().getSquares()) {
            squareN.setType((byte) -1);
        }
    }

    protected void squareProcess(byte squareID) {
        String color = GameLogic.getInstance().squareClicked(squareID);
        if (color.indexOf('o') > -1) {
            List<SquareN> winSquareNS = GameLogic.getInstance().getWinLine().getSquares();
            paintSquare(winSquareNS.get(0).getSquareID(), color);
            paintSquare(winSquareNS.get(1).getSquareID(), color);
            paintSquare(winSquareNS.get(2).getSquareID(), color);
            gameOver();
            return;
        }
        paintSquare(squareID, color);
        if(GameLogic.getInstance().getEmptySquare() == null) {
            gameOver();
            return;
        }
        if(GameDataHolder.getInstance().getData().getGamemode()) {
            squareID = GameLogic.getInstance().getEmptySquare().getSquareID();
            color = GameLogic.getInstance().squareClicked(squareID);
            if (color.indexOf('o') > -1) {
                List<SquareN> winSquareNS = GameLogic.getInstance().getWinLine().getSquares();
                paintSquare(winSquareNS.get(0).getSquareID(), color);
                paintSquare(winSquareNS.get(1).getSquareID(), color);
                paintSquare(winSquareNS.get(2).getSquareID(), color);
                gameOver();
                return;
            }
            paintSquare(squareID, color);
            if(GameLogic.getInstance().getEmptySquare() == null) {
                gameOver();
            }
        }
    }

    @FXML
    protected void onSquare1Click() {
        if (GameLogic.getInstance().getSquares().get(0).getType() == -1 && !GameOverPane.isVisible()) {
            refresh();
        }
        if (GameLogic.getInstance().isEmpty((byte) 1)) {
            squareProcess((byte) 1);
        }
    }
    @FXML
    protected void onSquare2Click() {
        if (GameLogic.getInstance().getSquares().get(0).getType() == -1 && !GameOverPane.isVisible()) {
            refresh();
        }
        if (GameLogic.getInstance().isEmpty((byte) 2)) {
            squareProcess((byte) 2);
        }
    }
    @FXML
    protected void onSquare3Click() {
        if (GameLogic.getInstance().getSquares().get(0).getType() == -1 && !GameOverPane.isVisible()) {
            refresh();
        }
        if (GameLogic.getInstance().isEmpty((byte) 3)) {
            squareProcess((byte) 3);
        }
    }
    @FXML
    protected void onSquare4Click() {
        if (GameLogic.getInstance().getSquares().get(0).getType() == -1 && !GameOverPane.isVisible()) {
            refresh();
        }
        if (GameLogic.getInstance().isEmpty((byte) 4)) {
            squareProcess((byte) 4);
        }
    }
    @FXML
    protected void onSquare5Click() {
        if (GameLogic.getInstance().getSquares().get(0).getType() == -1 && !GameOverPane.isVisible()) {
            refresh();
        }
        if (GameLogic.getInstance().isEmpty((byte) 5)) {
            squareProcess((byte) 5);
        }
    }
    @FXML
    protected void onSquare6Click() {
        if (GameLogic.getInstance().getSquares().get(0).getType() == -1 && !GameOverPane.isVisible()) {
            refresh();
        }
        if (GameLogic.getInstance().isEmpty((byte) 6)) {
            squareProcess((byte) 6);
        }
    }
    @FXML
    protected void onSquare7Click() {
        if (GameLogic.getInstance().getSquares().get(0).getType() == -1 && !GameOverPane.isVisible()) {
            refresh();
        }
        if (GameLogic.getInstance().isEmpty((byte) 7)) {
            squareProcess((byte) 7);
        }
    }
    @FXML
    protected void onSquare8Click() {
        if (GameLogic.getInstance().getSquares().get(0).getType() == -1 && !GameOverPane.isVisible()) {
            refresh();
        }
        if (GameLogic.getInstance().isEmpty((byte) 8)) {
            squareProcess((byte) 8);
        }
    }
    @FXML
    protected void onSquare9Click() {
        if (GameLogic.getInstance().getSquares().get(0).getType() == -1 && !GameOverPane.isVisible()) {
            refresh();
        }
        if (GameLogic.getInstance().isEmpty((byte) 9)) {
            squareProcess((byte) 9);
        }
    }

    @FXML
    protected void onMainMenuClick(ActionEvent event) {
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
    protected void onNewGameClick(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(TicTacToeApp.class.getResource("GameScreen.fxml"));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 1920, 1080);
        } catch (IOException ignored) {}
        stage.setScene(scene);
        stage.show();
        refresh();
    }

}
