package tanks;

public class HumanGameState extends GameState {

    public HumanGameState(StateManager stateManager, String fxmlFileName, String playerOneName, String playerTwoName) {
        super(stateManager, fxmlFileName, playerOneName, playerTwoName);

        players[0] = new HumanPlayer(0, playerOneName, gameObjectFactory.createTank(startingPositions[0].getX(), startingPositions[0].getY(),
                90, 32, 50, 50, "tankRudy", playerOneName));
        players[1] = new HumanPlayer(1, playerTwoName, gameObjectFactory.createTank(startingPositions[1].getX(), startingPositions[1].getY(),
                -90, 32, 50, 50, "tankWaffen", playerTwoName));
    }

    protected void updateGame(double deltaTime) {
        ((HumanGameStateController)controller).setMovesBasedOnKeyboard();
        super.updateGame(deltaTime);
    }

    protected void draw() {
        super.draw();
    }

    protected void endGame() {
        super.endGame();
        stateManager.pushOnStateStack(new ResultState(stateManager, stateManager.getFXMLFileName("ResultsScene"), "Player one"));
    }
}
