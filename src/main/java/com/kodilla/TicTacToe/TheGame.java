package com.kodilla.TicTacToe;

import javafx.scene.control.Cell;
import javafx.scene.layout.GridPane;

public class TheGame
{
    Cell[][] cell = new Cell[3][3];

    GridPane pane = new GridPane();

    public void gridCreator() {
        for (int i=0; i<3; i++)
        {
            for (int j=0; j<3; j++)
            {
                pane.add(cell[i][j] = new Cell(), j, i);
            }
        }
    }

    public boolean whoWon(char token)
    {
        for(int i=0; i<3; i++) {
            if (cell[i][0].getToken() == token &&
                    cell[i][1].getToken() == token &&
                    cell[i][2].getToken() == token) {
                return true;
            }
        }
            
        for(int j=0; j<3; j++)
        {
            if(cell[j][0].getToken() == token &&
                    cell[j][1].getToken() == token &&
                    cell[j][2].getToken() == token)
            {
                return true;
            }
        }

        if(cell[0][0].getToken() == token &&
                cell[1][1].getToken() == token &&
                cell[2][2].getToken() == token)
        {
            return true;
        } else if(cell[0][2].getToken() == token &&
                cell[1][1].getToken() == token &&
                cell[2][0].getToken() == token) {
            return true;
    }

        return false;
    }
}
