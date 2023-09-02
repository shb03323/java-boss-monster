package bossmonster.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerTest {

    @DisplayName("플레이어 이름이 5자가 넘어가면 플레이어 생성에 실패한다.")
    @Test
    void construct_fail_when_name_length_is_over_5() {
        // given
        final String playerName = "김석호똥방구";
        final int playerHP = 100;
        final int playerMP = 100;

        // when, then
        assertThatThrownBy(() -> Player.of(playerName, playerHP, playerMP))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("플레이어 이름이 1자 미만이면 플레이어 생성에 실패한다.")
    @Test
    void construct_fail_when_name_length_is_under_1() {
        // given
        final String playerName = "";
        final int playerHP = 100;
        final int playerMP = 100;

        // when, then
        assertThatThrownBy(() -> Player.of(playerName, playerHP, playerMP))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("플레이어 HP와 MP의 합이 200이 아니면 플레이어 생성에 실패한다.")
    @Test
    void construct_fail_when_sum_of_player_HP_and_MP_is_not_200() {
        // given
        final String playerName = "디투";
        final int playerHP = 123;
        final int playerMP = 321;

        // when, then
        assertThatThrownBy(() -> Player.of(playerName, playerHP, playerMP))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
