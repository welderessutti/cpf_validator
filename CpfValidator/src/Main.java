import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String cpf;
        Scanner input = new Scanner(System.in);

        System.out.println("Digite o CPF (somente números): ");
        cpf = input.nextLine().strip();

        if (CpfValidator.isMatch(cpf)) {
            CpfValidator.stringToInteger(cpf);
            CpfValidator.setSum1();
            CpfValidator.setRest1();
            CpfValidator.setFirstVerificator();

            if (CpfValidator.isFirstVerificatorEquals()) {
                CpfValidator.setSum2();
                CpfValidator.setRest2();
                CpfValidator.setSecondVerificator();

                if (CpfValidator.isSecondVerificatorEquals()) {
                    System.out.println("CPF válido!");
                } else {
                    System.out.println("CPF inválido no 2o verificador!");
                }

            } else {
                System.out.println("CPF inválido no 1o verificador!");
            }

        } else {
            System.out.println("Sequência de dígitos inválida! Insira 11 dígitos válidos.");
        }
    }
}
