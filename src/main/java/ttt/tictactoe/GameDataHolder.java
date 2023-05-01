package ttt.tictactoe;

public class GameDataHolder {
    private GameData gameData;
    private final static GameDataHolder INSTANCE = new GameDataHolder();

    private GameDataHolder() {}

    public static GameDataHolder getInstance() {
        return INSTANCE;
    }

    public void setData(GameData gameData) {
        this.gameData = gameData;
    }

    public GameData getData() {
        return this.gameData;
    }
}
