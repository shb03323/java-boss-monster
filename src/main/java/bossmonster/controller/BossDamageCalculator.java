package bossmonster.controller;

import bossmonster.domain.BossRaid;

public class BossDamageCalculator {

    public static int calculate(final BossRaid beforeBossAttack, final BossRaid afterBossAttack) {
        final int before = beforeBossAttack.getPlayer().getPlayerStatus().getHealthPoints().getLeftValue();
        final int after = afterBossAttack.getPlayer().getPlayerStatus().getHealthPoints().getLeftValue();
        return before - after;
    }
}
