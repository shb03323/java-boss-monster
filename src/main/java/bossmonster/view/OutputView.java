package bossmonster.view;

import bossmonster.controller.dto.PlayerInfoDto;

public class OutputView {

    public OutputView() {
    }

    public void printRaidStartMessage() {
        System.out.println("\n보스 레이드를 시작합니다!");
    }

    public void printInitialGameStatus(final PlayerInfoDto playerInfo) {
        System.out.println("\n============================\n" +
                "BOSS HP [100/100]\n" +
                "____________________________\n" +
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
}
