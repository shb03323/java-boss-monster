package bossmonster.domain.hp;

import java.util.Objects;

public final class HealthPointsLefts {

    private final int value;

    public HealthPointsLefts(final int value) {
        this.value = value;
    }

    public HealthPointsLefts damaged(final int value) {
        return new HealthPointsLefts(this.value - value);
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof HealthPointsLefts that)) return false;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
