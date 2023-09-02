package bossmonster.domain.mp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ManaPointsTest {

    @DisplayName("changeMana 메소드로 MP를 바꾸는 경우에 MP가 매개변수 숫자만큼 더해진다.")
    @Test
    void changeMana_success() {
        // given
        final int initialMana = 50;
        final int manaChanges = -30;
        final ManaPoints initialManaPoints = ManaPoints.init(initialMana);

        // when
        final ManaPoints changedManaPoints = initialManaPoints.changeMana(manaChanges);

        // then
        assertThat(changedManaPoints.getLeftValue()).isEqualTo(initialMana - manaChanges);
    }

    @DisplayName("changeMana 메소드로 MP를 바꾸는 경우에 초기 MP는 변하지 않는다.")
    @Test
    void changeMana_does_not_change_inital_mana() {
        // given
        final int initialMana = 50;
        final int manaChanges = -30;
        final ManaPoints initialManaPoints = ManaPoints.init(initialMana);

        // when
        final ManaPoints changedManaPoints = initialManaPoints.changeMana(manaChanges);

        // then
        assertThat(changedManaPoints.getStartValue()).isEqualTo(initialMana);
    }

    @DisplayName("MP를 바꾸는 경우에 MP가 0보다 작게 되면 예외가 발생한다.")
    @Test
    void make_exception_when_MP_changes_to_under_0() {
        // given
        final int manaChanges = -30;
        final ManaPoints initialManaPoints = ManaPoints.init(10);

        // when
        assertThatThrownBy(() -> initialManaPoints.changeMana(manaChanges))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
