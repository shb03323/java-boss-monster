package bossmonster.domain.mp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InitialManaPointsTest {

    @DisplayName("초기 MP가 0보다 크면 생성에 성공한다.")
    @Test
    void construct_success_when_value_over_0() {
        // given
        final int value = 10;

        // when, then
        assertThatCode(() -> new InitialManaPoints(value))
                .doesNotThrowAnyException();
    }

    @DisplayName("초기 MP가 0보다 작으면 생성에 실패한다.")
    @Test
    void construct_fail_when_value_under_0() {
        // given
        final int value = -10;

        // when, then
        assertThatThrownBy(() -> new InitialManaPoints(value))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
