package bossmonster.domain;

public class Player {

    private final PlayerName playerName;
    private final PlayerStatus playerStatus;

    private Player(final PlayerName playerName, final PlayerStatus playerStatus) {
        this.playerName = playerName;
        this.playerStatus = playerStatus;
    }

    public static Player of(final String inputName, final int inputHP, final int inputMP) {
        final PlayerName playerName = new PlayerName(inputName);
        final PlayerStatus playerStatus = PlayerStatus.of(inputHP, inputMP);
        return new Player(playerName, playerStatus);
    }
}
