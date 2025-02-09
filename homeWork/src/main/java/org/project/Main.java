package org.project;
import java.util.Scanner;

public class Main {
    public static int taxEarningsMinusSpendings(int earnings, int spendings) {
        int tax = (earnings - spendings) * 15 / 100;
        return Math.max(tax, 0);
    }
    public static int earningsMinusTax(int earnings) {
        int tax2 = earnings * 6 / 100;
        return Math.max(tax2, 0);
    }
    public static int taxDifference(int tax, int tax2) {
        return Math.abs(tax - tax2);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int earnings = 0;
        int spendings = 0;

        while (true) {
            System.out.println("Выберите операцию и введите её номер:\n" +
                    "1. Добавить новый доход\n" +
                    "2. Добавить новый расход\n" +
                    "3. Выбрать систему налогообложения\n" +
                    "Введите 'end' для выхода");

            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }

            int operation;
            try {
                operation = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка ввода! Введите число или 'end' для выхода.");
                continue;
            }

            switch (operation) {
                case 1:
                    System.out.println("Введите сумму дохода:");
                    int money = Integer.parseInt(scanner.nextLine());
                    earnings += money;
                    break;

                case 2:
                    System.out.println("Введите сумму расхода:");
                    int expenses = Integer.parseInt(scanner.nextLine());
                    spendings += expenses;
                    break;

                case 3:
                    int tax = taxEarningsMinusSpendings(earnings, spendings);
                    int tax2 = earningsMinusTax(earnings);

                    if (tax < tax2) {
                        System.out.println("Мы советуем вам УСН доходы минус расходы\n" +
                                "Ваш налог составит: " + tax +
                                "\nНалог на другой системе: " + tax2 +
                                "\nЭкономия: " + taxDifference(tax, tax2));
                    } else {
                        System.out.println("Мы советуем вам УСН доходы\n" +
                                "Ваш налог составит: " + tax2 +
                                "\nНалог на другой системе: " + tax +
                                "\nЭкономия: " + taxDifference(tax, tax2));
                    }
                    break;

                default:
                    System.out.println("Такой операции нет");
            }
        }

        System.out.println("Программа завершена!");
    }
}