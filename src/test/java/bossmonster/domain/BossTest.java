package bossmonster.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BossTest {

    @DisplayName("입력받은 보스의 체력이 200이면 생성에 성공한다.")
    @Test
    void construct_success_when_boss_hp_200() {
        // given
        final int inputHP = 200;

        // when, then
        assertThatCode(() -> Boss.from(inputHP))
                .doesNotThrowAnyException();
    }

    @DisplayName("입력받은 보스의 체력이 300보다 크면 생성에 실패한다.")
    @Test
    void construct_fail_when_boss_hp_over_300() {
        // given
        final int inputHP = 400;

        // when, then
        assertThatThrownBy(() -> Boss.from(inputHP))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력받은 보스의 체력이 100보다 작으면 생성에 실패한다.")
    @Test
    void construct_fail_when_boss_hp_under_100() {
        // given
        final int inputHP = 50;

        // when, then
        assertThatThrownBy(() -> Boss.from(inputHP))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
