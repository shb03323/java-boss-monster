package bossmonster.domain;

import bossmonster.domain.attack.PlayerAttack;
import bossmonster.domain.boss.Boss;
import bossmonster.domain.player.Player;

public final class BossRaid {

    private final Player player;
    private final Boss boss;

    public BossRaid(final Player player, final Boss boss) {
        this.player = player;
        this.boss = boss;
    }

    public BossRaid takePlayerTurn(final PlayerAttack playerAttack) {
        final Player manaChangedPlayer = player.changeMana(playerAttack.getManaChanges());
        final Boss damagedBoss = boss.damaged(playerAttack.getDamageInflicted());
        return new BossRaid(manaChangedPlayer, damagedBoss);
    }

    public Player getPlayer() {
        return player;
    }

    public Boss getBoss() {
        return boss;
    }
}
