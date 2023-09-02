package bossmonster.domain.hp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class HealthPointsLeftsTest {

    @DisplayName("데미지를 입는다.")
    @Test
    void get_damage() {
        // given
        final int initialHealthPoints = 100;
        final int damage = 30;
        final HealthPointsLefts healthPointsLefts = new HealthPointsLefts(initialHealthPoints);

        // when
        final HealthPointsLefts actual = healthPointsLefts.damaged(damage);
        final HealthPointsLefts expected = new HealthPointsLefts(initialHealthPoints - damage);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("남은 HP가 최소 HP 미만인지 확인한다.")
    @ParameterizedTest
    @CsvSource(value = {"10:true", "0:false"})
    void is_HP_less_than_minimum_HP(final int element, final boolean expected) {
        // given
        final HealthPointsLefts healthPointsLefts = new HealthPointsLefts(element);

        // when
        final boolean actual = healthPointsLefts.isLessThanMinimumValue();

        // then
        assertThat(actual).isEqualTo(expected);
    }
}
