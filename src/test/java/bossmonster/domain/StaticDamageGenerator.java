package bossmonster.domain;

import bossmonster.domain.attack.DamageGenerator;

public class StaticDamageGenerator implements DamageGenerator {

    private final int damage;

    public StaticDamageGenerator(final int damage) {
        this.damage = damage;
    }

    @Override
    public int generate() {
        return damage;
    }
}
