package bossmonster.domain;

public class BossRaid {

    private final Player player;
    private final Boss boss;

    public BossRaid(final Player player, final Boss boss) {
        this.player = player;
        this.boss = boss;
    }
}
