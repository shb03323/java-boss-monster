package bossmonster.controller;

import bossmonster.controller.dto.BossInfoDto;
import bossmonster.controller.dto.PlayerInfoDto;
import bossmonster.domain.BossRaid;
import bossmonster.domain.attack.PlayerAttack;
import bossmonster.domain.attack.RandomDamageGenerator;
import bossmonster.domain.boss.Boss;
import bossmonster.domain.player.Player;
import bossmonster.domain.player.PlayerName;
import bossmonster.domain.player.PlayerStatus;
import bossmonster.view.InputView;
import bossmonster.view.OutputView;
import bossmonster.view.dto.PlayerAttackCommand;
import bossmonster.view.dto.PlayerStatusInputDto;

import java.util.EnumMap;
import java.util.Map;

public class BossGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final Map<PlayerAttackCommand, PlayerAttack> playerAttackCommands;

    public BossGameController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.playerAttackCommands = new EnumMap<>(PlayerAttackCommand.class);
        initPlayerAttackCommand();
    }

    private void initPlayerAttackCommand() {
        playerAttackCommands.put(PlayerAttackCommand.PHYSICAL_ATTACK, PlayerAttack.PHYSICAL_ATTACK);
        playerAttackCommands.put(PlayerAttackCommand.MAGIC_ATTACK, PlayerAttack.MAGIC_ATTACK);
    }

    public void runGame() {
        final Boss boss = initBoss();
        final Player player = initPlayer();
        final BossRaid bossRaid = startBossRaid(boss, player);
        doBossRaid(bossRaid);
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

    private BossRaid startBossRaid(final Boss boss, final Player player) {
        printBossRaidStartMessage(boss, player);
        return new BossRaid(boss, player, new RandomDamageGenerator());
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

    private void doBossRaid(BossRaid bossRaid) {
        while (true) {
            final BossRaid afterPlayerTurn = takePlayerTurn(bossRaid);
            if (afterPlayerTurn.isBossDead()) {
                outputView.printPlayerVictory(playerToPlayerInfoDto(afterPlayerTurn.getPlayer()), afterPlayerTurn.getBattleCount());
                break;
            }
            final BossRaid afterBossTurn = takeBossTurn(afterPlayerTurn);
            if (afterBossTurn.isPlayerDead()) {
                outputView.printPlayerLose();
                break;
            }
            outputView.printGameStatus(bossToBossInfoDto(afterBossTurn.getBoss()), playerToPlayerInfoDto(afterBossTurn.getPlayer()));
            bossRaid = afterBossTurn;
        }
    }

    private BossRaid takePlayerTurn(final BossRaid bossRaid) {
        try {
            final PlayerAttackCommand playerAttackCommand = inputView.inputPlayerAttack();
            final BossRaid afterPlayerAttack = bossRaid.takePlayerTurn(playerAttackCommands.get(playerAttackCommand));
            outputView.printPlayerAttackMessage(playerAttackCommand);
            return afterPlayerAttack;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return takePlayerTurn(bossRaid);
        }
    }

    private BossRaid takeBossTurn(final BossRaid bossRaid) {
        final BossRaid afterBossTurn = bossRaid.takeBossTurn();
        final int bossDamage = BossDamageCalculator.calculate(bossRaid, afterBossTurn);
        outputView.printBossAttackMessage(bossDamage);
        return afterBossTurn;
    }
}
