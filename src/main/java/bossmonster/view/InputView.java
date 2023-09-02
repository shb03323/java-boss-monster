package bossmonster.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {

    private static final Scanner sc = new Scanner(System.in);

    public InputView() {
    }

    public int inputBossMonsterHP() {
        try {
            System.out.println("보스 몬스터의 HP를 입력해주세요.");
            return sc.nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("보스 몬스터의 HP는 숫자만 가능합니다.");
        }
    }
}
