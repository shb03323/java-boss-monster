package bossmonster.domain;

public final class HealthPoints {

    private final int startValue;
    private final int leftValue;

    private HealthPoints(final int startValue, final int leftValue) {
        this.startValue = startValue;
        this.leftValue = leftValue;
    }

    public static HealthPoints init(final int value) {
        return new HealthPoints(value, value);
    }

    public int getStartValue() {
        return startValue;
    }

    public int getLeftValue() {
        return leftValue;
    }
}
