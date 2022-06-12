import java.util.Scanner;

public class DepositCalculator {
    private final double percentDeposit;

    public DepositCalculator(double percentDeposit) {
        this.percentDeposit = percentDeposit;
    }

    double calculateComplexPercent(double amount, double percent, int depositTerm) {
        double pay = amount * Math.pow((1 + percent / 12), 12 * depositTerm);

        return round(pay, 2);
    }

    double calculateSimplePercent(double amount, double percent, int depositTerm) {
        return round(amount + amount * percent * depositTerm, 2);
    }

    double round(double value, int places) {
        double scale = Math.pow(10, places);

        return Math.round(value * scale) / scale;
    }

    void calculateDeposit() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();

        System.out.println("Введите срок вклада в годах:");
        int depositTerm = scanner.nextInt();

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        int command = scanner.nextInt();

        double result = 0;

        switch (command) {
            case 1:
                result = calculateSimplePercent(amount, percentDeposit, depositTerm);
                break;
            case 2:
                result = calculateComplexPercent(amount, percentDeposit, depositTerm);
                break;
        }


        System.out.printf("Результат вклада: %d за %d лет превратятся в %.0f\n", amount, depositTerm, result);
    }

    public static void main(String[] args) {
        new DepositCalculator(0.06).calculateDeposit();
    }
}
