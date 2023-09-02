package bossmonster.domain.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerTest {

    @DisplayName("플레이어가 마나를 소비하면 플레이어 상태를 변경한다.")
    @Test
    void changeMana_success() {
        // given
        final int initialMana = 100;
        final Player player = new Player(new PlayerName("ditoo"), PlayerStatus.of(100, initialMana));
        final int manaChanges = -10;

        // when
        final Player manaChangedPlayer = player.changeMana(manaChanges);

        // then
        assertThat(manaChangedPlayer.getPlayerStatus().getManaPoints().getLeftValue()).isEqualTo(initialMana + manaChanges);
    }

    @DisplayName("플레이어가 마나를 소비하면 플레이어 상태를 변경한다.")
    @Test
    void changeMana_fail_when_mana_be_0() {
        // given
        final int initialMana = 10;
        final Player player = new Player(new PlayerName("ditoo"), PlayerStatus.of(190, initialMana));
        final int manaChanges = -30;

        // when
        assertThatThrownBy(() -> player.changeMana(manaChanges))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
