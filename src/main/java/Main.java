import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        printMenu();
        int userInput = scanner.nextInt();
            while (userInput !=0){
                if (userInput == 1){
                    System.out.println("Текущие настройки:");
                    System.out.println("Ваша цель: "+StepTracker.getTargetNumberOfStepsPerDay()+" шагов в день.");
                    System.out.println("Длина шага: "+Converter.getStepLength());
                    System.out.println("Что еще сделать?");
                } else if (userInput == 2){
                    System.out.println("Ваша текущая цель "+StepTracker.getTargetNumberOfStepsPerDay()+" шагов в день.");
                    System.out.println("Что еще сделать?");
                } else if (userInput == 3){
                    System.out.println("Ваша текущая цель "+StepTracker.getTargetNumberOfStepsPerDay()+" шагов в день.");
                    System.out.println("Задайте новую цель.");
                    int newTargetNumberOfStepsPerDay = scanner.nextInt();
                    StepTracker.setTargetNumberOfStepsPerDay(newTargetNumberOfStepsPerDay);
                    System.out.println("Что еще сделать?");
                } else if (userInput == 4){
                    System.out.println("Учет шагов.");
                    System.out.println("Введите номер месяца:");
                    int monthNo = scanner.nextInt();
                    System.out.println("Введите день:");
                    int dayNo = scanner.nextInt();
                    System.out.println("Введите количество шагов:");
                    int stepsAmount = scanner.nextInt();
                    StepTracker.setSteps(monthNo, dayNo, stepsAmount);
                    StepTracker.printMonthData(StepTracker.getMonthData());
                    System.out.println("Что еще сделать?");
                }else if (userInput == 5){
                    System.out.println("Вывод статистики за месяц. Введите номер месяца:");
                    int statMonthNo = scanner.nextInt();
                    StepTracker.showMonthStat(statMonthNo);
                    //StepTracker.showMonthStat(statMonthNo, StepTracker.getMonthData());
                } else {
                    System.out.println("Выберите вариант из меню");
                    //printMenu();
                   // userInput = scanner.nextInt();
                }
                 printMenu();
                 userInput = scanner.nextInt();
            }
        System.out.println("Вы вышли из трекера.");
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