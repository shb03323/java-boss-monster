package bossmonster.domain;

public final class BattleCount {

    private static final int INITIAL_VALUE = 0;
    private static final int EACH_COUNT = 1;

    private final int value;

    private BattleCount(final int value) {
        this.value = value;
    }

    public static BattleCount init() {
        return new BattleCount(INITIAL_VALUE);
    }

    public BattleCount addCount() {
        return new BattleCount(value + EACH_COUNT);
    }

    public int getValue() {
        return value;
    }
}
