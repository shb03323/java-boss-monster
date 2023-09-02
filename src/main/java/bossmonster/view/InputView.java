package bossmonster.view;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String PLAYER_STATUS_SPLITTER = ",";

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

    public String inputPlayerName() {
        System.out.println("플레이어의 이름을 입력해주세요.");
        return sc.nextLine();
    }

    public List<Integer> inputPlayerStatus() {
        System.out.println("플레이어의 HP와 MP를 입력해주세요.(,로 구분)");
        final List<String> inputs = splitPlayerStatusInput(sc.nextLine());
        return mapToNumber(inputs);
    }

    private List<String> splitPlayerStatusInput(final String input) {
        final List<String> splitInput = Arrays.stream(input.split(PLAYER_STATUS_SPLITTER)).toList();
        validateInputCount(splitInput);
        for (String eachInput : splitInput) {
            validateInputNotBlank(eachInput);
        }
        return splitInput;
    }

    private void validateInputCount(final List<String> splitInput) {
        if (splitInput.size() != 2) {
            throw new IllegalArgumentException("HP와 MP 두 가지만 입력해주세요. 구분자는 , 입니다.");
        }
    }

    private void validateInputNotBlank(final String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("HP와 MP에 공백을 입력하면 안됩니다.");
        }
    }

    private List<Integer> mapToNumber(final List<String> inputs) {
        try {
            return inputs.stream()
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("HP와 MP는 숫자이어야 합니다.");
        }
    }
}
