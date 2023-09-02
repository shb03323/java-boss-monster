package bossmonster.domain.mp;

public final class InitialManaPoints {

    private static final int MINIMUM_VALUE = 0;

    private final int value;

    public InitialManaPoints(final int value) {
        validateNotNegative(value);
        this.value = value;
    }

    private void validateNotNegative(final int value) {
        if (value < MINIMUM_VALUE) {
            throw new IllegalArgumentException("MP는 0보다 작을 수 없습니다.");
        }
    }

    public int getValue() {
        return value;
    }
}
