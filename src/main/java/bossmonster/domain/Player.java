package bossmonster.domain;

public class Player {

    private final PlayerName playerName;
    private final PlayerStatus playerStatus;

    public Player(final PlayerName playerName, final PlayerStatus playerStatus) {
        this.playerName = playerName;
        this.playerStatus = playerStatus;
    }

    public String getPlayerName() {
        return playerName.getName();
    }

    public PlayerStatus getPlayerStatus() {
        return playerStatus;
    }
}
