package bossmonster.domain.boss;

import bossmonster.domain.hp.HealthPoints;
import bossmonster.exception.CustomException;

public final class Boss {

    private static final int MINIMUM_BOSS_HP = 100;
    private static final int MAXIMUM_BOSS_HP = 300;

    private final HealthPoints healthPoints;

    private Boss(final HealthPoints healthPoints) {
        this.healthPoints = healthPoints;
    }

    public static Boss from(final int inputHP) {
        validateHealthPoints(inputHP);
        final HealthPoints healthPoints = HealthPoints.init(inputHP);
        return new Boss(healthPoints);
    }

    private static void validateHealthPoints(final int input) {
        if (input < MINIMUM_BOSS_HP) {
            throw new CustomException("보스의 체력은 100보다 작을 수 없습니다.");
        }
        if (input > MAXIMUM_BOSS_HP) {
            throw new CustomException("보스의 체력은 300보다 클 수 없습니다.");
        }
    }

    public Boss damaged(final int damagePoint) {
        final HealthPoints damagedHealthPoints = healthPoints.damaged(damagePoint);
        return new Boss(damagedHealthPoints);
    }

    public boolean isDead() {
        return healthPoints.isHealthPointsLeftsLessThanMinimumValue();
    }

    public HealthPoints getHealthPoints() {
        return healthPoints;
    }
}
