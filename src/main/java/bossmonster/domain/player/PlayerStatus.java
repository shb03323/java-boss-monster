package bossmonster.domain.player;

import bossmonster.domain.hp.HealthPoints;
import bossmonster.domain.mp.ManaPoints;
import bossmonster.exception.CustomException;

import java.util.Objects;

public final class PlayerStatus {

    private static final int INITIAL_SUM_OF_HP_AND_MP = 200;

    private final HealthPoints healthPoints;
    private final ManaPoints manaPoints;

    private PlayerStatus(final HealthPoints healthPoints, final ManaPoints manaPoints) {
        this.healthPoints = healthPoints;
        this.manaPoints = manaPoints;
    }

    public static PlayerStatus of(final int inputHP, final int inputMP) {
        validateSumOfHPAndMP(inputHP, inputMP);
        return new PlayerStatus(HealthPoints.init(inputHP), ManaPoints.init(inputMP));
    }

    private static void validateSumOfHPAndMP(final int inputHP, final int inputMP) {
        if (inputHP + inputMP != INITIAL_SUM_OF_HP_AND_MP) {
            throw new CustomException("플레이어의 HP와 MP의 합은 200이어야 합니다.");
        }
    }

    public PlayerStatus changeMana(final int value) {
        final ManaPoints changedManaPoints = manaPoints.changeMana(value);
        return new PlayerStatus(healthPoints, changedManaPoints);
    }

    public PlayerStatus damageHealthPoints(final int value) {
        final HealthPoints damagedHealthPoints = healthPoints.damaged(value);
        return new PlayerStatus(damagedHealthPoints, manaPoints);
    }

    public HealthPoints getHealthPoints() {
        return healthPoints;
    }

    public ManaPoints getManaPoints() {
        return manaPoints;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof PlayerStatus that)) return false;
        return Objects.equals(healthPoints, that.healthPoints) && Objects.equals(manaPoints, that.manaPoints);
    }

    @Override
    public int hashCode() {
        return Objects.hash(healthPoints, manaPoints);
    }
}
