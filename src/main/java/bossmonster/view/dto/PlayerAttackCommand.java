package bossmonster.view.dto;

import java.util.Arrays;

public enum PlayerAttackCommand {

    PHYSICAL_ATTACK("1", "물리 공격"),
    MAGIC_ATTACK("2", "마법 공격");

    private final String command;
    private final String attackName;

    PlayerAttackCommand(final String command, final String attackName) {
        this.command = command;
        this.attackName = attackName;
    }

    public static PlayerAttackCommand from(final String command) {
        return Arrays.stream(PlayerAttackCommand.values())
                .filter(playerAttackCommand -> playerAttackCommand.command.equals(command))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("1 또는 2를 입력해주세요."));
    }

    public String getAttackName() {
        return attackName;
    }
}
