package bossmonster.domain;

import bossmonster.domain.attack.PlayerAttack;
import bossmonster.domain.attack.RandomDamageGenerator;
import bossmonster.domain.boss.Boss;
import bossmonster.domain.player.Player;
import bossmonster.domain.player.PlayerName;
import bossmonster.domain.player.PlayerStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class BossRaidTest {

    @DisplayName("플레이어가 보스에게 마법 공격에 성공한다.")
    @Test
    void player_magic_attack_success() {
        // given
        final int playerInitialMP = 100;
        final Player player = new Player(new PlayerName("ditoo"), PlayerStatus.of(100, playerInitialMP));
        final int bossInitialHP = 100;
        final Boss boss = Boss.from(bossInitialHP);
        final BossRaid bossRaid = new BossRaid(boss, player, new RandomDamageGenerator());

        // when
        final BossRaid afterBossAttack = bossRaid.takePlayerTurn(PlayerAttack.MAGIC_ATTACK);

        // then
        assertAll(
                () -> assertThat(afterBossAttack.getBoss().getHealthPoints().getLeftValue())
                        .isEqualTo(bossInitialHP - PlayerAttack.MAGIC_ATTACK.getDamageInflicted()),
                () -> assertThat(afterBossAttack.getPlayer().getPlayerStatus().getManaPoints().getLeftValue())
                        .isEqualTo(playerInitialMP + PlayerAttack.MAGIC_ATTACK.getManaChanges())
        );
    }

    @DisplayName("플레이어의 MP가 부족하면 보스에게 마법 공격에 실패한다.")
    @Test
    void player_magic_attack_fail_when_not_enough_MP() {
        // given
        final int playerInitialMP = 10;
        final Player player = new Player(new PlayerName("ditoo"), PlayerStatus.of(190, playerInitialMP));
        final int bossInitialHP = 100;
        final Boss boss = Boss.from(bossInitialHP);
        final BossRaid bossRaid = new BossRaid(boss, player, new RandomDamageGenerator());

        // when, then
        assertThatThrownBy(() -> bossRaid.takePlayerTurn(PlayerAttack.MAGIC_ATTACK))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("플레이어가 보스에게 물리 공격에 성공한다.")
    @Test
    void player_physical_attack_success() {
        // given
        final int playerInitialMP = 100;
        final Player player = new Player(new PlayerName("ditoo"), PlayerStatus.of(100, playerInitialMP));
        final int bossInitialHP = 100;
        final Boss boss = Boss.from(bossInitialHP);
        final BossRaid bossRaid = new BossRaid(boss, player, new RandomDamageGenerator());

        // when
        final BossRaid afterBossAttack = bossRaid.takePlayerTurn(PlayerAttack.PHYSICAL_ATTACK);

        // then
        assertAll(
                () -> assertThat(afterBossAttack.getBoss().getHealthPoints().getLeftValue())
                        .isEqualTo(bossInitialHP - PlayerAttack.PHYSICAL_ATTACK.getDamageInflicted()),
                () -> assertThat(afterBossAttack.getPlayer().getPlayerStatus().getManaPoints().getLeftValue())
                        .isEqualTo(playerInitialMP + PlayerAttack.PHYSICAL_ATTACK.getManaChanges())
        );
    }
}
