package bossmonster.controller;

import bossmonster.view.InputView;
import bossmonster.view.OutputView;

public class BossGameController {

    private final InputView inputView;
    private final OutputView outputView;

    public BossGameController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }
}
