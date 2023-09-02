package bossmonster.controller.dto;

public class BossInfoDto {

    private final int BossHPStarts;
    private final int BossHPLefts;

    public BossInfoDto(final int bossHPStarts, final int bossHPLefts) {
        BossHPStarts = bossHPStarts;
        BossHPLefts = bossHPLefts;
    }

    public int getBossHPStarts() {
        return BossHPStarts;
    }

    public int getBossHPLefts() {
        return BossHPLefts;
    }
}
