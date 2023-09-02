package bossmonster.domain.player;

import bossmonster.exception.CustomException;

public final class PlayerName {

    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;

    private final String name;

    public PlayerName(final String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(final String name) {
        if (name.length() < MIN_LENGTH) {
            throw new CustomException("플레이어 이름은 1자보다 작을 수 없습니다.");
        }
        if (name.length() > MAX_LENGTH) {
            throw new CustomException("플레이어 이름은 5자보다 클 수 없습니다.");
        }
    }

    public String getName() {
        return name;
    }
}
