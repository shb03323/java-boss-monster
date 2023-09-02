package bossmonster.domain.attack;

public class MagicDamageGenerator implements DamageGenerator {

    private static final int DAMAGE = 20;

    @Override
    public int generate() {
        return DAMAGE;
    }
}
