module com.kodilla.lets_play {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.kodilla.lets_play to javafx.fxml;
    exports com.kodilla.lets_play;
}