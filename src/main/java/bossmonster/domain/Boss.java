package bossmonster.domain;

import bossmonster.exception.CustomException;

public class Boss {

    private static final int MINIMUM_BOSS_HP = 100;
    private static final int MAXIMUM_BOSS_HP = 300;

    private final HealthPoints healthPointsLefts;

    private Boss(final HealthPoints healthPointsLefts) {
        this.healthPointsLefts = healthPointsLefts;
    }

    public static Boss from(final int inputHP) {
        validateHealthPoints(inputHP);
        final HealthPoints healthPoints = new HealthPoints(inputHP);
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
}
