package bossmonster.domain;

import bossmonster.exception.CustomException;

public final class PlayerStatus {

    private static final int INITIAL_SUM_OF_HP_AND_MP = 200;

    private final HealthPoints healthPointsLefts;
    private final ManaPoints manaPointsLefts;

    private PlayerStatus(final HealthPoints healthPointsLefts, final ManaPoints manaPointsLefts) {
        this.healthPointsLefts = healthPointsLefts;
        this.manaPointsLefts = manaPointsLefts;
    }

    public static PlayerStatus of(final int inputHP, final int inputMP) {
        validateSumOfHPAndMP(inputHP, inputMP);
        return new PlayerStatus(new HealthPoints(inputHP), new ManaPoints(inputMP));
    }

    private static void validateSumOfHPAndMP(final int inputHP, final int inputMP) {
        if (inputHP + inputMP != INITIAL_SUM_OF_HP_AND_MP) {
            throw new CustomException("플레이어의 HP와 MP의 합은 200이어야 합니다.");
        }
    }
}
