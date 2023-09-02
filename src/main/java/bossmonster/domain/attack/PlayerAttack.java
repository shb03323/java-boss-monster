package bossmonster.domain.attack;

public enum PlayerAttack {
    PHYSICAL_ATTACK(10, new PhysicalDamageGenerator()),
    MAGIC_ATTACK(-30, new MagicDamageGenerator());

    private final int manaChanges;
    private final DamageGenerator damageGenerator;

    PlayerAttack(final int manaChanges, final DamageGenerator damageGenerator) {
        this.manaChanges = manaChanges;
        this.damageGenerator = damageGenerator;
    }

    public int getManaChanges() {
        return manaChanges;
    }

    public int getDamageInflicted() {
        return damageGenerator.generate();
    }
}
