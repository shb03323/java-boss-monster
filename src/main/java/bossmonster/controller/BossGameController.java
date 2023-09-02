package bossmonster.controller;

import bossmonster.domain.Boss;
import bossmonster.domain.Player;
import bossmonster.domain.PlayerName;
import bossmonster.domain.PlayerStatus;
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
        final PlayerName playerName = initPlayerName();
        final PlayerStatus playerStatus = initPlayerStatus();
        return new Player(playerName, playerStatus);
    }

    private PlayerName initPlayerName() {
        try {
            final String playerName = inputView.inputPlayerName();
            System.out.println(playerName);
            return new PlayerName(playerName);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return initPlayerName();
        }
    }

    private PlayerStatus initPlayerStatus() {
        try {
            final PlayerStatusInputDto playerStatusInputDto = inputView.inputPlayerStatus();
            return PlayerStatus.of(playerStatusInputDto.getInputHP(), playerStatusInputDto.getInputMP());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return initPlayerStatus();
        }
    }
}
