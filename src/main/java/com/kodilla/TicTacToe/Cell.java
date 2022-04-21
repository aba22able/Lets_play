package com.kodilla.TicTacToe;

import javafx.scene.layout.Pane;

public class Cell extends Pane
{
    private char token = ' ';

    public Cell() {
        setStyle("-fx-border-color: black");
        this.setPrefSize(2000, 2000);
    }

    public char getToken() {
        return token;
    }

    public void setToken(char c)
    {
        token = c;
    }


}
