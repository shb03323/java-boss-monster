package bossmonster.domain.mp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ManaPointsLeftsTest {

    @DisplayName("남은 마나를 첫 생성시에는 초기 마나와 동일한 마나로 생성된다.")
    @Test
    void init_value_is_same_as_InitialManaPoints() {
        // given
        final int value = 100;
        final InitialManaPoints initialManaPoints = new InitialManaPoints(value);

        // when
        final ManaPointsLefts initialManaPointsLefts = ManaPointsLefts.init(initialManaPoints);

        // then
        assertThat(initialManaPointsLefts.getValue()).isEqualTo(initialManaPoints.getValue());
    }
}
