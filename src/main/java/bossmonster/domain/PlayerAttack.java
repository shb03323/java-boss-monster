package bossmonster.domain;

public enum PlayerAttack {
    PHYSICAL_ATTACK(new ManaPoints(10)),
    MAGIC_ATTACK(new ManaPoints(-30));

    private final ManaPoints manaChanges;

    PlayerAttack(final ManaPoints manaChanges) {
        this.manaChanges = manaChanges;
    }

    public ManaPoints getManaChanges() {
        return manaChanges;
    }
}
