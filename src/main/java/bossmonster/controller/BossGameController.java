package bossmonster.controller;

import bossmonster.domain.Boss;
import bossmonster.domain.Player;
import bossmonster.view.InputView;
import bossmonster.view.OutputView;
import bossmonster.view.dto.PlayerStatusInputDto;

import java.util.List;

public class BossGameController {

    private final InputView inputView;
    private final OutputView outputView;

    public BossGameController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void runGame() {
        final Boss boss = initBoss();
        final Player player = initPlayer();
    }

    private Boss initBoss() {
        try {
            return Boss.from(inputView.inputBossMonsterHP());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return initBoss();
        }
    }

    private Player initPlayer() {
        try {
            final String playerName = inputView.inputPlayerName();
            final PlayerStatusInputDto playerStatusInputDto = inputView.inputPlayerStatus();
            return Player.of(playerName, playerStatusInputDto.getInputHP(), playerStatusInputDto.getInputMP());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return initPlayer();
        }
    }
}
