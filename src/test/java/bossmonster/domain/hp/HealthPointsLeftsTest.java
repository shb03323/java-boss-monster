package bossmonster.domain.hp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}
