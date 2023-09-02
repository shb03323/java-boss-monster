package bossmonster.view.dto;

import java.util.List;

public class PlayerStatusInputDto {

    private static final int HP_INDEX = 0;
    private static final int MP_INDEX = 1;

    private final int inputHP;
    private final int inputMP;

    private PlayerStatusInputDto(final int inputHP, final int inputMP) {
        this.inputHP = inputHP;
        this.inputMP = inputMP;
    }

    public static PlayerStatusInputDto from(final List<Integer> inputs) {
        final int inputHP = inputs.get(HP_INDEX);
        final int inputMP = inputs.get(MP_INDEX);
        return new PlayerStatusInputDto(inputHP, inputMP);
    }

    public int getInputHP() {
        return inputHP;
    }

    public int getInputMP() {
        return inputMP;
    }
}
