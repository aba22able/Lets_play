package com.kodilla.TicTacToe;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class GameLogic extends Application
{
    private char whoseTurnIs = 'X';

    private Cell[][] cell = new Cell[3][3];

    private Label status = new Label("X's turn to play");

    public char getWhoseTurnIs()
    {
        return whoseTurnIs;
    }

    public Label getStatus()
    {
        return status;
    }

    @Override
    public void start(Stage primaryStage) {

        Button xButton = new Button("X");
        Button oButton = new Button("O");
        Button exit = new Button("Exit");
        Button play = new Button("New Game");
        xButton.setStyle("-fx-font-size: 15pt;");
        oButton.setStyle("-fx-font-size: 15pt;");
        exit.setStyle("-fx-font-size: 15pt;");
        play.setStyle("-fx-font-size: 15pt;");

        exit.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent e) {
                Platform.exit();
            }
        });

        GridPane pane = new GridPane();

        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                pane.add(cell[i][j] = new Cell(), j, i);

            }
        }

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(pane);
        borderPane.setBottom(status);

        HBox buttonBar = new HBox();
        buttonBar.setSpacing(87.0);
        buttonBar.getChildren().addAll(xButton, oButton, play, exit);

        borderPane.setTop(buttonBar);


        Scene scene = new Scene(borderPane, 550, 470);
        primaryStage.setTitle("TicTacToe");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);

    }

    public boolean boardIsFull()
    {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (cell[i][j].getToken() == ' ')
                    return false;

        return true;
    }

    public boolean whoWon(char token)
    {
        for (int i = 0; i < 3; i++)
            if (cell[i][0].getToken() == token
                    && cell[i][1].getToken() == token
                    && cell[i][2].getToken() == token)
            {
                return true;
            }

        for (int j = 0; j < 3; j++)
            if (cell[0][j].getToken() == token
                    && cell[1][j].getToken() == token
                    && cell[2][j].getToken() == token)
            {
                return true;
            }

        if (cell[0][0].getToken() == token
                && cell[1][1].getToken() == token
                && cell[2][2].getToken() == token)
        {
            return true;
        }

        if (cell[0][2].getToken() == token
                && cell[1][1].getToken() == token
                && cell[2][0].getToken() == token)
        {
            return true;
        }

        return false;
    }
}
