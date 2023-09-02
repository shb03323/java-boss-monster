package bossmonster.domain.hp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InitialHealthPointsTest {

    @DisplayName("초기 HP가 1 이상 이면 생성에 성공한다.")
    @Test
    void construct_success_when_value_over_0() {
        // given
        final int value = 10;

        // when, then
        assertThatCode(() -> new InitialHealthPoints(value))
                .doesNotThrowAnyException();
    }

    @DisplayName("초기 HP가 1보다 작으면 생성에 실패한다.")
    @Test
    void construct_fail_when_value_under_1() {
        // given
        final int value = -10;

        // when, then
        assertThatThrownBy(() -> new InitialHealthPoints(value))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
