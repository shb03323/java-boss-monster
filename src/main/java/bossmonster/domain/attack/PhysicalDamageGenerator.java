package bossmonster.domain.attack;

public class PhysicalDamageGenerator implements DamageGenerator {

    private static final int DAMAGE = 10;

    @Override
    public int generate() {
        return DAMAGE;
    }
}
