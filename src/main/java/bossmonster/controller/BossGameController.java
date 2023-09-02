package bossmonster.controller;

import bossmonster.controller.dto.BossInfoDto;
import bossmonster.controller.dto.PlayerInfoDto;
import bossmonster.domain.boss.Boss;
import bossmonster.domain.player.Player;
import bossmonster.domain.player.PlayerName;
import bossmonster.domain.player.PlayerStatus;
import bossmonster.view.InputView;
import bossmonster.view.OutputView;
import bossmonster.view.dto.PlayerStatusInputDto;

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
        startBossRaid(boss, player);
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

    private void startBossRaid(final Boss boss, final Player player) {
        printBossRaidStartMessage(boss, player);

    }

    private void printBossRaidStartMessage(final Boss boss, final Player player) {
        outputView.printRaidStartMessage();
        outputView.printInitialGameStatus(bossToBossInfoDto(boss), playerToPlayerInfoDto(player));
    }

    private BossInfoDto bossToBossInfoDto(final Boss boss) {
        return new BossInfoDto(
                boss.getHealthPoints().getStartValue(),
                boss.getHealthPoints().getLeftValue()
        );
    }

    private PlayerInfoDto playerToPlayerInfoDto(final Player player) {
        return new PlayerInfoDto(
                player.getPlayerName(),
                player.getPlayerStatus().getHealthPoints().getStartValue(),
                player.getPlayerStatus().getManaPoints().getStartValue(),
                player.getPlayerStatus().getHealthPoints().getLeftValue(),
                player.getPlayerStatus().getManaPoints().getLeftValue());
    }
}
