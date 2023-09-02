package bossmonster.domain.mp;

import bossmonster.exception.CustomException;

public final class InitialManaPoints {

    private static final int MINIMUM_VALUE = 0;

    private final int value;

    public InitialManaPoints(final int value) {
        validateNotLessThanMinimumValue(value);
        this.value = value;
    }

    private void validateNotLessThanMinimumValue(final int value) {
        if (value < MINIMUM_VALUE) {
            throw new CustomException(String.format("시작 MP는 %d 이상이어야 합니다.", MINIMUM_VALUE));
        }
    }

    public int getValue() {
        return value;
    }
}
