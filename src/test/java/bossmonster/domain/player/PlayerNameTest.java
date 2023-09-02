package bossmonster.domain.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerNameTest {

    @DisplayName("플레이어 이름의 길이가 3이면 생성에 성공한다.")
    @Test
    void construct_success_when_name_length_is_3() {
        // given
        final String name = "박정훈";

        // when, then
        assertThatCode(() -> new PlayerName(name))
                .doesNotThrowAnyException();
    }

    @DisplayName("플레이어 이름의 길이가 5보다 크면 생성에 실패한다.")
    @Test
    void construct_fail_when_name_length_over_5() {
        // given
        final String name = "김석호똥방구";

        // when, then
        assertThatThrownBy(() -> new PlayerName(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("플레이어 이름의 길이가 1보다 작으면 생성에 실패한다.")
    @Test
    void construct_fail_when_name_length_under_1() {
        // given
        final String name = "";

        // when, then
        assertThatThrownBy(() -> new PlayerName(name))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
