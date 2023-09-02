package bossmonster.view;

import bossmonster.controller.dto.BossInfoDto;
import bossmonster.controller.dto.PlayerInfoDto;
import bossmonster.view.dto.PlayerAttackCommand;

public class OutputView {

    public OutputView() {
    }

    public void printRaidStartMessage() {
        System.out.println("\n보스 레이드를 시작합니다!");
    }

    public void printInitialGameStatus(final BossInfoDto bossInfo, final PlayerInfoDto playerInfo) {
        System.out.println("\n============================");
        System.out.printf("BOSS HP [%d/%d]\n", bossInfo.getBossHPLefts(), bossInfo.getBossHPStarts());
        System.out.println("____________________________\n" +
                "   ^-^\n" +
                " / 0 0 \\\n" +
                "(   \"   )\n" +
                " \\  -  /\n" +
                "  - ^ -                           \n" +
                "____________________________\n");
        printPlayerInfo(playerInfo);
        System.out.println("============================");
    }

    private void printPlayerInfo(final PlayerInfoDto playerInfo) {
        System.out.printf("%s HP [%d/%d] MP [%d/%d]\n",
                playerInfo.getPlayerName(),
                playerInfo.getPlayerHPLefts(), playerInfo.getPlayerHPStarts(),
                playerInfo.getPlayerMPLefts(), playerInfo.getPlayerMPStarts());
    }

    public void printPlayerAttackMessage(final PlayerAttackCommand playerAttackCommand) {
        System.out.printf("\n%s을 했습니다.\n", playerAttackCommand.getAttackName());
    }

    public void printBossAttackMessage(final int bossDamage) {
        System.out.printf("보스가 공격 했습니다.\n" +
                "HP -%d\n", bossDamage);
    }

    public void printPlayerVictory(final PlayerInfoDto playerInfo, final int battleCount) {
        System.out.printf("\n%s 님이 %d번의 전투 끝에 보스 몬스터를 잡았습니다.\n", playerInfo.getPlayerName(), battleCount);
    }

    public void printPlayerLose() {
        System.out.println("\nHP가 0이 되었습니다.\n" +
                "보스 레이드에 실패했습니다.");
    }

    public void printGameStatus(final BossInfoDto bossInfo, final PlayerInfoDto playerInfo) {
        System.out.println("\n============================");
        System.out.printf("BOSS HP [%d/%d]\n", bossInfo.getBossHPLefts(), bossInfo.getBossHPStarts());
        System.out.println("____________________________\n" +
                "   ^-^\n" +
                " / x x \\\n" +
                "(   \"   )\n" +
                " \\  -  /\n" +
                "  - ^ -                           \n" +
                "____________________________\n");
        printPlayerInfo(playerInfo);
        System.out.println("============================");
    }
}
