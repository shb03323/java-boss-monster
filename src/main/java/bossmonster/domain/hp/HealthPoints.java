package bossmonster.domain.hp;

import java.util.Objects;

public final class HealthPoints {

    private final InitialHealthPoints startValue;
    private final HealthPointsLefts leftValue;

    private HealthPoints(final InitialHealthPoints startValue, final HealthPointsLefts leftValue) {
        this.startValue = startValue;
        this.leftValue = leftValue;
    }

    public static HealthPoints init(final int value) {
        return new HealthPoints(new InitialHealthPoints(value), new HealthPointsLefts(value));
    }



    public int getStartValue() {
        return startValue.getValue();
    }

    public int getLeftValue() {
        return leftValue.getValue();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof HealthPoints that)) return false;
        return Objects.equals(startValue, that.startValue) && Objects.equals(leftValue, that.leftValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startValue, leftValue);
    }
}
