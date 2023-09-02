package bossmonster.domain.attack;

import java.util.Random;

public class RandomDamageGenerator implements DamageGenerator {

    private static final int MINIMUM_DAMAGE = 0;
    private static final int MAXIMUM_DAMAGE = 20;
    private static final Random random = new Random();

    @Override
    public int generate() {
        return random.nextInt(MINIMUM_DAMAGE, MAXIMUM_DAMAGE + 1);
    }
}
