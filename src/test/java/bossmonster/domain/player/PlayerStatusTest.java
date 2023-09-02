package bossmonster.domain.player;

import bossmonster.domain.player.PlayerStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PlayerStatusTest {

    @DisplayName("플레이어의 HP와 MP의 합이 200이면 플레이어 상태 생성에 성공한다.")
    @Test
    void construct_success_when_sum_of_HP_and_MP_is_200() {
        // given
        final int inputHP = 100;
        final int inputMP = 100;

        // when, then
        assertThatCode(() -> PlayerStatus.of(inputHP, inputMP))
                .doesNotThrowAnyException();
    }

    @DisplayName("플레이어의 HP와 MP의 합이 200이 아니면 플레이어 상태 생성에 실패한다.")
    @Test
    void construct_fail_when_sum_of_HP_and_MP_is_not_200() {
        // given
        final int inputHP = 200;
        final int inputMP = 100;

        // when, then
        assertThatThrownBy(() -> PlayerStatus.of(inputHP, inputMP))
                .isInstanceOf(IllegalArgumentException.class);
    }
    
    @DisplayName("플레이어의 MP를 변경하는데 성공한다.")
    @Test
    void change_mana_of_player_success() {
        // given
        final int initialMP = 100;
        final int changesMP = -30;
        final PlayerStatus playerStatus = PlayerStatus.of(100, initialMP);

        // when
        final PlayerStatus changedPlayerStatus = playerStatus.changeMana(changesMP);

        // then
        assertThat(changedPlayerStatus.getManaPoints().getLeftValue()).isEqualTo(initialMP + changesMP);
    }

    @DisplayName("플레이어의 MP가 0 미만이 되면 MP를 변경하는데 실패한다.")
    @Test
    void change_mana_of_player_fail_when_MP_be_under_0() {
        // given
        final int initialMP = 10;
        final int changesMP = -30;
        final PlayerStatus playerStatus = PlayerStatus.of(190, initialMP);

        // when, then
        assertThatThrownBy(() -> playerStatus.changeMana(changesMP))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("플레이어의 HP가 공격 받는다.")
    @Test
    void damageHealthPoints() {
        // given
        final int initialHP = 30;
        final int damagePoints = 10;
        final PlayerStatus playerStatus = PlayerStatus.of(initialHP, 170);

        // when
        final PlayerStatus damagedPlayerStatus = playerStatus.damageHealthPoints(damagePoints);

        // then
        assertThat(damagedPlayerStatus.getHealthPoints().getLeftValue()).isEqualTo(initialHP - damagePoints);
    }
}
