package tanks;

public abstract class Player {
    private Tank tank;
    private int playerNumber;
    private String playerName;

    public Player(int playerNumber, String playerName, Tank tank) {
        this.playerNumber = playerNumber;
        this.playerName = playerName;
        this.tank = tank;
    }

    abstract public Move makeMove(double deltaTime);

    public Tank getPlayerTank() {return tank; }
    public int getPlayerNumber() {
        return playerNumber;
    }
    public String getPlayerName() { return playerName; }

}
