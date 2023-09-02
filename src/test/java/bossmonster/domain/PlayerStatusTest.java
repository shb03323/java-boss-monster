package bossmonster.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerStatusTest {

    @DisplayName("플레이어의 HP와 MP의 합이 200이면 플레이어 상태 생성에 성공한다.")
    @Test
    void construct_success_when_sum_of_HP_and_MP_is_200() {
        // given
        final int inputHP = 100;
        final int inputMP = 100;

        // when, then
        assertThatCode(() ->PlayerStatus.of(inputHP, inputMP))
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
}
