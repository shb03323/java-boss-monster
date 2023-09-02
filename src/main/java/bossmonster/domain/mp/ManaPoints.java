package bossmonster.domain.mp;

public final class ManaPoints {

    private final InitialManaPoints startValue;
    private final ManaPointsLefts leftValue;

    private ManaPoints(final InitialManaPoints startValue, final ManaPointsLefts leftValue) {
        this.startValue = startValue;
        this.leftValue = leftValue;
    }

    public static ManaPoints init(final int value) {
        return new ManaPoints(new InitialManaPoints(value), new ManaPointsLefts(value));
    }

    public ManaPoints changeMana(final int value) {
        final ManaPointsLefts leftValueChanges = leftValue.changeManaPoints(value);
        return new ManaPoints(startValue, leftValueChanges);
    }

    public int getStartValue() {
        return startValue.getValue();
    }

    public int getLeftValue() {
        return leftValue.getValue();
    }
}
