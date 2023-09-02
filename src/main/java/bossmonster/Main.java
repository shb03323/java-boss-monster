package bossmonster;

import bossmonster.controller.BossGameController;
import bossmonster.view.InputView;
import bossmonster.view.OutputView;

public class Main {
    public static void main(String[] args) {
        final BossGameController bossGameController = new BossGameController(new InputView(), new OutputView());
        bossGameController.runGame();
    }
}
