package com.kodilla.TicTacToe;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class TheGame extends Application {

    private Button[][] board;
    private String player;
    private Label lbl;
    private Label lblGameStatus;
    private int playerXCount;
    private int playerOCount;
    private int playerXCountWin;
    private int playerOCountWin;
    private Button resetButton;

    public TheGame() {
        board = new Button[3][3];
        player = "X";
        playerXCount = 0;
        playerOCount = 0;
        playerXCountWin = 0;
        playerOCountWin = 0;
        resetButton = new Button("New Game");
        lbl = new Label("Turn: X");
        lblGameStatus = new Label("Score: X:" + playerXCountWin + ", O:" + playerOCountWin);
    }

    @Override
    public void start(Stage stage) {
        BorderPane layout = new BorderPane();
        GridPane grid = new GridPane();

        lbl.setFont(Font.font("Monospaced", 25));
        lblGameStatus.setFont(Font.font("Monospaced", 25));
        createButtons(grid, lbl);

        grid.setVgap(10);
        grid.setHgap(10);
        grid.setAlignment(Pos.CENTER);
        layout.setRight(resetButton);
        layout.setTop(lbl);
        layout.setBottom(lblGameStatus);
        layout.setCenter(grid);

        Scene scene = new Scene(layout, 370, 300);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
    public void createButtons(GridPane grid, Label lbl){

        for(int col = 0; col < 3; col++){
            for(int row = 0; row < 3; row++){
                Button button = new Button(" ");
                button.setFont(Font.font("Monospaced", 40));
                grid.add(button, col, row);
                board[row][col] = button;

                button.setOnAction(e -> {

                    if(button.getText().equals(" ")){
                        button.setText(player);
                        if(player.equals("X")){
                            player = "O";
                            lbl.setText("Turn: O");
                            playerXCount++;
                            System.out.println("X: "+ playerXCount);
                            System.out.println("O: "+ playerOCount);
                            checkForWinner();
                            System.out.println("Checking for Winner....");
                        }else {
                            player = "X";
                            lbl.setText("Turn: X");
                            playerOCount++;
                            System.out.println("X: "+ playerXCount);
                            System.out.println("O: "+ playerOCount);
                            checkForWinner();
                            System.out.println("Checking for Winner....");
                        }
                        if(playerOCount + playerXCount == 9){
                            endgame();
                        }
                        if(playerOCount == 4 && playerXCount == 4)
                            draw();
                    }
                });

                resetButton.setFont(Font.font("Monospaced", 20));

                resetButton.setOnAction(e -> {
                        for (int colu = 0; colu < 3; colu++) {
                            for (int rows = 0; rows < 3; rows++) {
                                board[rows][colu].setText(" ");
                            }
                        }
                        createButtons(grid, lbl);
                        playerOCount = 0;
                        playerXCount = 0;
                        player = "X";
                        lbl.setText("Turn: X");

                });
            }
        }
    }

    private boolean checkRowsForWinner() {
        for(int row = 0; row < 3; row++){
            if(board[row][0].getText().equals(board[row][1].getText()) &&
                    board[row][0].getText().equals(board[row][2].getText()) &&
                    !board[row][0].getText().equals(" ")){
                endgame();
            }
        }
        return false;
    }

    private void checkColumnsForWinner() {
        for(int col = 0; col < 3; col++){
            if(board[0][col].getText().equals(board[1][col].getText()) &&
                    board[0][col].getText().equals(board[2][col].getText()) &&
                    !board[0][col].getText().equals(" ")){
                endgame();
            }
        }
    }

    private boolean checkDiagonalLeftForWinner() {
        if(board[0][0].getText().equals(board[1][1].getText()) &&
                board[0][0].getText().equals(board[2][2].getText()) &&
                !board[0][0].getText().equals(" ")){
            endgame();
        }
        return false;
    }

    private boolean checkDiagonalRightForWinner() {
        if(board[0][2].getText().equals(board[1][1].getText()) &&
                board[0][2].getText().equals(board[2][0].getText()) &&
                !board[0][2].getText().equals(" ")){
            endgame();
        }
        return false;
    }

    public void checkForWinner(){
        checkRowsForWinner();
        checkColumnsForWinner();
        checkDiagonalLeftForWinner();
        checkDiagonalRightForWinner();
    }

    private void endgame() {
        if(player.equals("X"))
        {
            lbl.setText("The end! O has won");
            playerOCountWin++;
            lblGameStatus.setText("Score: X:" + playerXCountWin + ", O:" + playerOCountWin);
        } else {
            lbl.setText("The end! X has won");
            playerXCountWin++;
            lblGameStatus.setText("Score: X:" + playerXCountWin + ", O:" + playerOCountWin);
        }

        for(int row = 0; row < 3; row++){
            for(int col = 0; col < 3; col++){
                board[row][col].setDisable(true);
            }
        }
    }

    private void draw() {
        lbl.setText("Draw!");
        for(int row = 0; row < 3; row++){
            for(int col = 0; col < 3; col++){
                board[row][col].setDisable(true);
            }
        }
    }
}
