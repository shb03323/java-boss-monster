package bossmonster.domain.mp;

import java.util.Objects;

public final class ManaPointsLefts {

    private static final int MINIMUM_VALUE = 0;

    private final int value;

    public ManaPointsLefts(final int value) {
        this.value = value;
    }

    public static ManaPointsLefts init(final InitialManaPoints initialManaPoints) {
        return new ManaPointsLefts(initialManaPoints.getValue());
    }

    public ManaPointsLefts changeManaPoints(final int value) {
        final int changedValue = this.value + value;
        validateValueNotNegative(changedValue);
        return new ManaPointsLefts(changedValue);
    }

    private void validateValueNotNegative(final int value) {
        if (value < MINIMUM_VALUE) {
            throw new IllegalArgumentException("MP가 0보다 작게 됩니다.");
        }
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof ManaPointsLefts that)) return false;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
