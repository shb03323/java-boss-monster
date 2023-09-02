package bossmonster.domain;

public enum PlayerAttack {
    PHYSICAL_ATTACK(10, 10),
    MAGIC_ATTACK(-30, 20);

    private final int manaChanges;
    private final int damage;

    PlayerAttack(final int manaChanges, final int damage) {
        this.manaChanges = manaChanges;
        this.damage = damage;
    }

    public int getManaChanges() {
        return manaChanges;
    }

    public int getDamage() {
        return damage;
    }
}
