package bossmonster.controller.dto;

public class PlayerInfoDto {

    private final String playerName;
    private final int playerHPStarts;
    private final int playerMPStarts;
    private final int playerHPLefts;
    private final int playerMPLefts;

    public PlayerInfoDto(final String playerName,
                         final int playerHPStarts,
                         final int playerMPStarts,
                         final int playerHPLefts,
                         final int playerMPLefts
    ) {
        this.playerName = playerName;
        this.playerHPStarts = playerHPStarts;
        this.playerMPStarts = playerMPStarts;
        this.playerHPLefts = playerHPLefts;
        this.playerMPLefts = playerMPLefts;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getPlayerHPLefts() {
        return playerHPLefts;
    }

    public int getPlayerMPLefts() {
        return playerMPLefts;
    }

    public int getPlayerHPStarts() {
        return playerHPStarts;
    }

    public int getPlayerMPStarts() {
        return playerMPStarts;
    }
}
