package bossmonster.controller;

import bossmonster.domain.Boss;
import bossmonster.view.InputView;
import bossmonster.view.OutputView;

public class BossGameController {

    private final InputView inputView;
    private final OutputView outputView;

    public BossGameController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void runGame() {
        final Boss boss = initBoss();
    }

    private Boss initBoss() {
        try {
            return Boss.from(inputView.inputBossMonsterHP());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return initBoss();
        }
    }
}
