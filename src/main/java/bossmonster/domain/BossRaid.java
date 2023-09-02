package bossmonster.domain;

import bossmonster.domain.attack.DamageGenerator;
import bossmonster.domain.attack.PlayerAttack;
import bossmonster.domain.boss.Boss;
import bossmonster.domain.player.Player;

public final class BossRaid {

    private final Boss boss;
    private final Player player;
    private final BattleCount battleCount;
    private final DamageGenerator bossDamageGenerator;

    private BossRaid(final Boss boss, final Player player, final BattleCount battleCount, final DamageGenerator bossDamageGenerator) {
        this.player = player;
        this.boss = boss;
        this.battleCount = battleCount;
        this.bossDamageGenerator = bossDamageGenerator;
    }

    public BossRaid(final Boss boss, final Player player, final DamageGenerator bossDamageGenerator) {
        this.player = player;
        this.boss = boss;
        this.battleCount = BattleCount.init();
        this.bossDamageGenerator = bossDamageGenerator;
    }

    public BossRaid takePlayerTurn(final PlayerAttack playerAttack) {
        final Player manaChangedPlayer = player.changeMana(playerAttack.getManaChanges());
        final Boss damagedBoss = boss.damaged(playerAttack.getDamageInflicted());
        return new BossRaid(damagedBoss, manaChangedPlayer, battleCount.addCount(), bossDamageGenerator);
    }

    public boolean isBossDead() {
        return boss.isDead();
    }

    public BossRaid takeBossTurn() {
        final int damagePoint = bossDamageGenerator.generate();
        final Player damagedPlayer = player.damaged(damagePoint);
        return new BossRaid(boss, damagedPlayer, battleCount, bossDamageGenerator);
    }

    public boolean isPlayerDead() {
        return player.isDead();
    }

    public Player getPlayer() {
        return player;
    }

    public Boss getBoss() {
        return boss;
    }

    public int getBattleCount() {
        return battleCount.getValue();
    }
}
