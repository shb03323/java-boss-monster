package bossmonster.domain.player;

public final class Player {

    private final PlayerName playerName;
    private final PlayerStatus playerStatus;

    public Player(final PlayerName playerName, final PlayerStatus playerStatus) {
        this.playerName = playerName;
        this.playerStatus = playerStatus;
    }

    public Player changeMana(final int manaChanges) {
        final PlayerStatus changedPlayerStatus = playerStatus.changeMana(manaChanges);
        return new Player(playerName, changedPlayerStatus);
    }

    public Player damaged(final int damagePoint) {
        return new Player(playerName, playerStatus.damageHealthPoints(damagePoint));
    }

    public boolean isDead() {
        return playerStatus.isHealthPointsLeftsLessThanMinimumValue();
    }

    public String getPlayerName() {
        return playerName.getName();
    }

    public PlayerStatus getPlayerStatus() {
        return playerStatus;
    }
}
