package bossmonster.domain.hp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HealthPointsTest {

    @DisplayName("데미지를 받으면 남은 체력이 줄어든다.")
    @Test
    void get_damaged_changes_health_points_lefts() {
        // given
        final int initialHealthPoints = 100;
        final HealthPoints healthPoints = HealthPoints.init(100);
        final int damage = 30;

        // when
        final HealthPoints damagedHealthPoints = healthPoints.damaged(damage);

        // then
        assertThat(damagedHealthPoints.getLeftValue()).isEqualTo(initialHealthPoints - damage);
    }

}
