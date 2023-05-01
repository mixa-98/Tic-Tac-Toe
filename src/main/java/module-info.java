module ttt.tictactoe {
    requires javafx.controls;
    requires javafx.fxml;

    opens ttt.tictactoe to javafx.fxml;
    exports ttt.tictactoe;
}