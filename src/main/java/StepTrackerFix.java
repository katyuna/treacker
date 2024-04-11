import java.util.ArrayList;


public class StepTrackerFix {

    private static int targetNumberOfStepsPerDay = 10000;
    private ArrayList<ArrayList<Integer>> monthData = new ArrayList<>();
    private ArrayList<Integer> stepsPerDay = new ArrayList<>();


    //Заполняем массив массивов дефолтными нулями
    public void fillMonthData() {
        for (int i = 0; i < 12; i++) {
            for (int k = 0; k < 30; k++) {
                stepsPerDay.add(k, 0);
            }
            monthData.add(i, stepsPerDay);
        }
    }

    //Устанавливаем количество шагов
    public void setSteps(int month, int day, int steps) {
        if (month > 0 && month < 12 && day > 0 && day < 31 && steps > 0) {
            stepsPerDay.add(day - 1, steps);
            monthData.add(month - 1, stepsPerDay);
        } else {
            if (month <= 0 || month > 12) {
                System.out.println("Месяц указан неверно!");
            } else if (day <= 0 || day > 30) {
                System.out.println("День указан неверно!");
            }
            System.out.println("Вы ввели некорректные данные! Введите корректные данные.");
        }
    }

    //Метод вывода статистики за заданный месяц
    public void showMonthStat(int monthNumber) {
        int stepsAmount = 0;
        int stepsMax = 0;
        int currentSeries = 0;
        int maxSeries = 0;
        System.out.println("Ваша статистика за месяц " + monthNumber + ".");
        //Количество шагов по дням за заданный месяц
        for (int i = 0; i < 12; i++) {
            if (i == (monthNumber-1)) {
                for (int j = 0; j < 30; j++) {
                    Integer steps = stepsPerDay.get(j);
                    //Количество шагов по дням за заданный месяц
                    System.out.print(" " + (j+1) + " день, " + steps + ". ");
                    //Общее количество шагов за месяц
                    stepsAmount += steps;
                    //Максимальное пройденное количество шагов в месяце
                    if (steps > stepsMax) {
                        stepsMax = steps;
                    }
                    //Лучшая серия
                    if (steps > targetNumberOfStepsPerDay) {
                        currentSeries++;
                        if (currentSeries > maxSeries) {
                            maxSeries = currentSeries;
                        }
                    } else {
                        // Обнуляем текущую серию только если количество шагов за день не превышает целевое значение
                        currentSeries = 0;
                    }
                }
                System.out.println();
                System.out.println("Общее количество шагов за месяц: " + stepsAmount + ". ");
                System.out.println("Максимальное пройденное количество шагов : " + stepsMax + ". ");
                System.out.println("Лучшая серия: " + maxSeries + " дней выше целевого!");
                System.out.println("Пройденная дистанция за месяц: " + Converter.stepsToKm(stepsAmount) + " км.");
                System.out.println("Количество сожженных калорий: " + Converter.stepsToCl(stepsAmount) + " кКал.");
           }
        }
    }

    public static int getTargetNumberOfStepsPerDay() {
        return targetNumberOfStepsPerDay;
    }

    public void setTargetNumberOfStepsPerDay(int targetNumberOfStepsPerDay) {
        this.targetNumberOfStepsPerDay = targetNumberOfStepsPerDay;
    }

    public ArrayList<ArrayList<Integer>> getMonthData() {
        return monthData;
    }

    public void setMonthData(ArrayList<ArrayList<Integer>> monthData) {
        this.monthData = monthData;
    }

    public ArrayList<Integer> getStepsPerDay() {
        return stepsPerDay;
    }

    public void setStepsPerDay(ArrayList<Integer> stepsPerDay) {
        this.stepsPerDay = stepsPerDay;
    }
}
