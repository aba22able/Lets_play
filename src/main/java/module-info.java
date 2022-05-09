module com.kodilla.lets_play {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.kodilla.lets_play to javafx.fxml,javafx.graphics;
    exports com.kodilla.lets_play;
    exports com.kodilla.blackjack;
    exports com.kodilla.TicTacToe;
}