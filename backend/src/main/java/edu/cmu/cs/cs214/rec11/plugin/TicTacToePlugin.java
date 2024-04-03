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
        framework.setFooterText("");
    }

    @Override
    public boolean isMoveValid(int x, int y) {
        return game.isValidPlay(x, y);
    }

    @Override
    public void onMovePlayed(int x, int y) {
        game.play(x, y);
        framework.setSquare(x, y, game.currentPlayer().toString());
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
        String winner = game.winner() == TicTacToe.Player.X ? "Player 1" : "Player 2";
        return String.format("Game over! Winner: %s", winner);
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
