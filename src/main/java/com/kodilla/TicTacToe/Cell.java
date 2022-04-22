package com.kodilla.TicTacToe;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;

public class Cell extends Pane
{
    private char token = ' ';

    public Cell() {
        setStyle("-fx-border-color: black");
        this.setPrefSize(2000, 2000);
        this.setOnMouseClicked(e -> handleMouseClick());
    }

    public char getToken() {
        return token;
    }

    public void setToken(char c) {
        token = c;

        if (token == 'X') {
            Line line1 = new Line(10, 10,
                    this.getWidth() - 10, this.getHeight() - 10);
            line1.endXProperty().bind(this.widthProperty().subtract(10));
            line1.endYProperty().bind(this.heightProperty().subtract(10));
            Line line2 = new Line(10, this.getHeight() - 10,
                    this.getWidth() - 10, 10);
            line2.startYProperty().bind(
                    this.heightProperty().subtract(10));
            line2.endXProperty().bind(this.widthProperty().subtract(10));

            // Add the lines to the pane
            this.getChildren().addAll(line1, line2);
        }
        else if (token == 'O') {
            Ellipse ellipse = new Ellipse(this.getWidth() / 2,
                    this.getHeight() / 2, this.getWidth() / 2 - 10,
                    this.getHeight() / 2 - 10);
            ellipse.centerXProperty().bind(
                    this.widthProperty().divide(2));
            ellipse.centerYProperty().bind(
                    this.heightProperty().divide(2));
            ellipse.radiusXProperty().bind(
                    this.widthProperty().divide(2).subtract(10));
            ellipse.radiusYProperty().bind(
                    this.heightProperty().divide(2).subtract(10));
            ellipse.setStroke(Color.BLACK);
            ellipse.setFill(Color.WHITE);

            getChildren().add(ellipse);
        }
    }

    private void handleMouseClick(char whoseTurnIs, Label status) {
        TheGame theGame = new TheGame();

        if (token == ' ' && whoseTurnIs != ' ') {
            setToken(whoseTurnIs);


            if (whoWon.theGame(whoseTurnIs)) {
                status.setText(whoseTurnIs + " won! Game Over");
                whoseTurnIs = ' ';
            }
            else if (boardIsFull.theGame()) {
                status.setText("Draw! Game Over");
                whoseTurnIs = ' ';
            }
            else {
                whoseTurnIs = (whoseTurnIs == 'X') ? 'O' : 'X';
                status.setText(whoseTurnIs + "'s turn.");
            }
        }
    }
}
