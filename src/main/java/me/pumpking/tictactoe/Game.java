package me.pumpking.tictactoe;

import javafx.application.Application;
import javafx.stage.Stage;
import me.pumpking.tictactoe.controllers.BoardController;
import me.pumpking.tictactoe.controllers.GameController;
import me.pumpking.tictactoe.controllers.GameViewController;
import me.pumpking.tictactoe.models.Board;
import me.pumpking.tictactoe.models.GameState;
import me.pumpking.tictactoe.views.GameView;

public class Game extends Application {

    private GameController gameController;
    private BoardController boardController;
    private GameViewController viewController;

    public static final int SIZE = 3;
    public static final GameState INITIAL_STATE = GameState.X_TURN;

    @Override
    public void init() {
        gameController = new GameController(this);
        boardController = new BoardController(this, new Board(SIZE));
        viewController = new GameViewController(this, new GameView(SIZE));
    }

    @Override
    public void start(Stage primaryStage) {
        viewController.showGUI(primaryStage);
        gameController.setAndShowGameState(INITIAL_STATE);
    }

    public GameController getGameController() {
        return gameController;
    }

    public BoardController getBoardController() {
        return boardController;
    }

    public GameViewController getViewController() {
        return viewController;
    }

    public static void main(String[] args) {
        launch(args);
    }

}
