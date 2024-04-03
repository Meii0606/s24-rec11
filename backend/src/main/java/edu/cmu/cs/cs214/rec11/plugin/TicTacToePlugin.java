package edu.cmu.cs.cs214.rec11.plugin;

import edu.cmu.cs.cs214.rec11.framework.core.GameFramework;
import edu.cmu.cs.cs214.rec11.framework.core.GamePlugin;
import edu.cmu.cs.cs214.rec11.games.TicTacToe;

public class TicTacToePlugin implements GamePlugin<Integer>{
    private static final int WIDTH = 3;
    private static final int HEIGHT = 3;

    private static final String GAME_NAME = "TicTacToe";

    private GameFramework framework;
    private TicTacToe game;


    @Override
    public String getGameName() {
        return GAME_NAME;
    }

    @Override
    public int getGridWidth() {
        return WIDTH;
    }

    @Override
    public int getGridHeight() {
        return HEIGHT;
    }

    @Override
    public void onRegister(GameFramework f) {
        framework = f;
    }

    @Override
    public void onNewGame() {
        game = new TicTacToe();
    }

    @Override
    public void onNewMove() {
        String currentPlayer = game.currentPlayer() == TicTacToe.Player.X ? "1" : "2";
        framework.setFooterText("Player " + currentPlayer + "'s turn");
    }

    @Override
    public boolean isMoveValid(int x, int y) {
        return game.isValidPlay(x, y);
    }

    @Override
    public void onMovePlayed(int x, int y) {
        game.play(x, y);
    }

    @Override
    public boolean isMoveOver() {
        return game.isOver();
    }

    @Override
    public boolean isGameOver() {
        return game.isOver();
    }

    @Override
    public String getGameOverMessage() {
        return "Player " + game.winner() + " wins!";
    }

    public Integer getSquare(int x, int y) {
        TicTacToe.Player player = game.getSquare(x, y);
        if (player == null) {
            return null;
        }
        return player == TicTacToe.Player.X ? 0 : 1;
    }

    @Override
    public void onGameClosed() {
        // Do nothing
    }    

    @Override
    public Integer currentPlayer() {
        return game.currentPlayer() == TicTacToe.Player.X ? 1 : 2;
    }
}
