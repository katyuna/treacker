import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StepTrackerFix tracker = new StepTrackerFix();
        //StepTracker tracker = new StepTracker();
        tracker.fillMonthData();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            int userInput = scanner.nextInt();
            if (userInput == 0) {
                System.out.println("Вы вышли из трекера.");
                break;
            } else if (userInput == 1) {
                System.out.println("Текущие настройки:");
                printGoal();
                System.out.println("Длина шага: " + Converter.getStepLength());
            } else if (userInput == 2) {
                printGoal();
            } else if (userInput == 3) {
                printGoal();
                System.out.println("Задайте новую цель.");
                int newTargetNumberOfStepsPerDay = scanner.nextInt();
                if (newTargetNumberOfStepsPerDay > 0) {
                    tracker.setTargetNumberOfStepsPerDay(newTargetNumberOfStepsPerDay);
                } else {
                    System.out.println("Количество шагов не может быть отрицательным!");
                }
            } else if (userInput == 4) {
                System.out.println("Учет шагов.");
                System.out.println("Введите номер месяца:");
                int monthNo = scanner.nextInt();
                System.out.println("Введите день:");
                int dayNo = scanner.nextInt();
                System.out.println("Введите количество шагов:");
                int stepsAmount = scanner.nextInt();
                tracker.setSteps(monthNo, dayNo, stepsAmount);
            } else if (userInput == 5) {
                System.out.println("Вывод статистики за месяц. Введите номер месяца:");
                int statMonthNo = scanner.nextInt();
                tracker.showMonthStat(statMonthNo);
            } else {
                System.out.println("Выберите вариант из меню.");
            }

        }
    }

    private static void printGoal() {
        System.out.println("Ваша текущая цель " + StepTracker.getTargetNumberOfStepsPerDay() + " шагов в день.");
    }
    private static void printMenu() {
        System.out.println("1 - Показать настройки трекера.");
        System.out.println("2 - Показать цель по количеству шагов в месяц.");
        System.out.println("3 - Изменить цель по количеству шагов в месяц.");
        System.out.println("4 - Учет шагов.");
        System.out.println("5 - Вывод статистики.");
        System.out.println("0 - Выход из программы.");
    }
}


