package bossmonster.domain.mp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ManaPointsLeftsTest {

    @DisplayName("남은 MP를 첫 생성시에는 초기 마나와 동일한 MP로 생성된다.")
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

    @DisplayName("MP를 소모할 때 MP가 0 미만이 되면 예외가 발생한다.")
    @Test
    void throw_exception_when_mana_changes_under_0() {
        // given
        final int initialValue = 10;
        final int manaChanges = -20;
        final ManaPointsLefts initialManaPointsLefts = ManaPointsLefts.init(new InitialManaPoints(initialValue));

        // when, then
        assertThatThrownBy(() -> initialManaPointsLefts.changeManaPoints(manaChanges))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
