package bossmonster.domain;

import bossmonster.domain.boss.Boss;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

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

    @DisplayName("보스에게 20인 데미지로 공격하면 보스의 체력이 20 깎인다.")
    @Test
    void boss_damaged_when_attack_to_20_damage() {
        // given
        final int initialHP = 100;
        final Boss boss = Boss.from(initialHP);
        final int damagePoint = 20;

        // when
        final Boss damagedBoss = boss.damaged(damagePoint);

        // then
        assertThat(damagedBoss.getHealthPoints().getLeftValue()).isEqualTo(initialHP - damagePoint);
    }
}
