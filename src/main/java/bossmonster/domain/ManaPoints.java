package bossmonster.domain;

public final class ManaPoints {

    private final int startValue;
    private final int leftValue;

    private ManaPoints(final int startValue, final int leftValue) {
        this.startValue = startValue;
        this.leftValue = leftValue;
    }

    public static ManaPoints init(final int value) {
        return new ManaPoints(value, value);
    }

    public int getStartValue() {
        return startValue;
    }

    public int getLeftValue() {
        return leftValue;
    }
}
