package bossmonster.domain.hp;

import bossmonster.exception.CustomException;

public final class InitialHealthPoints {

    private static final int MINIMUM_VALUE = 1;

    private final int value;

    public InitialHealthPoints(final int value) {
        validateNotLessThanMinimumValue();
        this.value = value;
    }

    private void validateNotLessThanMinimumValue(final int value) {
        if (value < MINIMUM_VALUE) {
            throw new CustomException(String.format("시작 HP는 %d 이상이어야 합니다.", MINIMUM_VALUE));
        }
    }

    public int getValue() {
        return value;
    }
}
