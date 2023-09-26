import java.util.ArrayList;
import java.util.List;

public class CpfValidator {

    private static final String pattern = "^(?!(\\d)\\1{10})\\d{11}$";
    private static Integer sum1, sum2, rest1, rest2, firstVerificator, secondVerificator;
    private static final List<Integer> cpfNumbers = new ArrayList<Integer>();

    public static boolean isMatch(String cpf) {
        return cpf.matches(pattern);
    }

    public static void stringToInteger(String cpf) {
        for (int i = 0; i < 11; i++) {
            Integer convertedNumber = Integer.parseInt(String.valueOf(cpf.charAt(i)));
            cpfNumbers.add(convertedNumber);
        }
    }

    public static void setSum1() {
        sum1 = (10 * cpfNumbers.get(0)) + (9 * cpfNumbers.get(1)) + (8 * cpfNumbers.get(2)) + (7 * cpfNumbers.get(3)) +
                (6 * cpfNumbers.get(4)) + (5 * cpfNumbers.get(5)) + (4 * cpfNumbers.get(6)) + (3 * cpfNumbers.get(7)) +
                (2 * cpfNumbers.get(8));
    }

    public static void setRest1() {
        rest1 = sum1 % 11;
    }

    public static void setFirstVerificator() {
        if (rest1 <= 1) {
            firstVerificator = 0;
        } else {
            firstVerificator = 11 - rest1;
        }
    }

    public static boolean isFirstVerificatorEquals() {
        return firstVerificator.equals(cpfNumbers.get(9));
    }

    public static void setSum2() {
        sum2 = (11 * cpfNumbers.get(0)) + (10 * cpfNumbers.get(1)) + (9 * cpfNumbers.get(2)) + (8 * cpfNumbers.get(3)) +
                (7 * cpfNumbers.get(4)) + (6 * cpfNumbers.get(5)) + (5 * cpfNumbers.get(6)) + (4 * cpfNumbers.get(7)) +
                (3 * cpfNumbers.get(8)) + (2 * cpfNumbers.get(9));
    }

    public static void setRest2() {
        rest2 = sum2 % 11;
    }

    public static void setSecondVerificator() {
        if (rest2 <= 1) {
            secondVerificator = 0;
        } else {
            secondVerificator = 11 - rest2;
        }
    }

    public static boolean isSecondVerificatorEquals() {
        return secondVerificator.equals(cpfNumbers.get(10));
    }
}
