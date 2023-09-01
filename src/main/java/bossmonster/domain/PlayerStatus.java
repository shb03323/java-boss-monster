package bossmonster.domain;

public final class PlayerStatus {

    private final HealthPoints healthPointsLefts;
    private final ManaPoints manaPointsLefts;

    public PlayerStatus(final HealthPoints healthPointsLefts, final ManaPoints manaPointsLefts) {
        this.healthPointsLefts = healthPointsLefts;
        this.manaPointsLefts = manaPointsLefts;
    }
}
