import java.util.HashMap;
import java.util.Map;

public class StepTracker {

    private static int targetNumberOfStepsPerDay = 10000;
    static HashMap<Integer, HashMap<Integer, Integer>> monthData = new HashMap<>();
    static HashMap<Integer, Integer> daySteps = new HashMap<>();

    //Заполняем HashMap начальными значениями - во всех месяцах и днях количество шагов = 0
    public void fillMonthData() {
        for (int i = 0; i < 12; i++) {
            for (int k = 0; k < 30; k++) {
                daySteps.put(k, 0);
            }
            monthData.put(i, daySteps);
        }
    }

    //Устанавливаем количество шагов
    public void setSteps(int month, int day, int steps) {
        if (month > 0 && month < 12 && day > 0 && day < 31 && steps > 0) {
            // Проверяем, существует ли уже HashMap для указанного месяца
            if (!monthData.containsKey(month)) {
                // Если нет, создаем новую HashMap для этого месяца
                monthData.put(month - 1, new HashMap<>());
            }
            // Получаем HashMap для указанного месяца
            HashMap<Integer, Integer> daySteps = monthData.get(month - 1);
            // Добавляем значение для указанного дня
            daySteps.put(day - 1, steps);
            System.out.println("Ваши шаги сохранены!");
        } else {
            if (month <= 0 || month > 12) {
                System.out.println("Месяц указан неверно!");
            } else if (day <= 0 || day > 30) {
                System.out.println("День указан неверно!");
            }
            System.out.println("Вы ввели некорректные данные! Введите корректные данные.");
        }
    }


    //Метод вывода статистики за заданным месяц
    public void showMonthStat(int monthNumber) {
        //Итерация через все записи в HashMap'ам
        //Для каждой записи (ключ-значение) в наборе записей monthData сделай
        for (Map.Entry<Integer, HashMap<Integer, Integer>> entry : monthData.entrySet()) {
            //Получаем номер месяца
            Integer month = entry.getKey();
            int monthStepsAmount = 0;
            int monthStepsMax = 0;
            int currentSeries = 0;
            int maxSeries = 0;
            if (monthNumber == month + 1) {
                System.out.println("Вот ваша статистика за месяц: " + monthNumber + ". ");
                HashMap<Integer, Integer> dayStepMapStats = entry.getValue();
                //Количество шагов по дням за заданный месяц
                for (Map.Entry<Integer, Integer> dayEntryStats : dayStepMapStats.entrySet()) {
                    int dayNo = dayEntryStats.getKey();
                    int stepsPerDay = dayEntryStats.getValue();
                    //Вывод количества шагов по дням за заданный месяц
                    if (dayNo != 29) {
                        System.out.print((dayNo + 1) + " день: " + stepsPerDay + ", ");
                    } else {
                        System.out.println((dayNo + 1) + " день: " + stepsPerDay + ".");
                    }
                    //Общее количество шагов за месяц
                    monthStepsAmount = monthStepsAmount + stepsPerDay;
                    //Максимальное пройденное количество шагов в месяце
                    if (stepsPerDay > monthStepsMax) {
                        monthStepsMax = stepsPerDay;
                    }
                    //Лучшая серия
                    if (stepsPerDay > targetNumberOfStepsPerDay) {
                        currentSeries++;
                        if (currentSeries > maxSeries) {
                            maxSeries = currentSeries;
                        }
                    } else {
                        // Обнуляем текущую серию только если количество шагов за день не превышает целевое значение
                        currentSeries = 0;
                    }
                }
                    System.out.println("Целевое количество шагов: " + targetNumberOfStepsPerDay);
                    System.out.println("Лучшая серия: " + maxSeries + " дней выше целевого!");
                    System.out.println("Общее количество шагов за месяц: " + monthStepsAmount);
                    System.out.println("Среднее количество шагов в день: " + monthStepsAmount / 30);
                    System.out.println("Максимальное количество шагов в день: " + monthStepsMax);
                    System.out.println("Пройденная дистанция за месяц: " + Converter.stepsToKm(monthStepsAmount) + " км.");
                    System.out.println("Количество сожженных калорий: " + Converter.stepsToCl(monthStepsAmount) + " кКал.");
                }
            }
        }

    public static int getTargetNumberOfStepsPerDay() {
        return targetNumberOfStepsPerDay;
    }

    public void setTargetNumberOfStepsPerDay(int targetNumberOfStepsPerDay) {
        StepTracker.targetNumberOfStepsPerDay = targetNumberOfStepsPerDay;
    }

    public HashMap<Integer, HashMap<Integer, Integer>> getMonthData() {
        return monthData;
    }

    public void setMonthData(HashMap<Integer, HashMap<Integer, Integer>> monthData) {
        StepTracker.monthData = monthData;
    }

    public HashMap<Integer, Integer> getDaySteps() {
        return daySteps;
    }

    public void setDaySteps(HashMap<Integer, Integer> daySteps) {
        StepTracker.daySteps = daySteps;
    }
        //Вспомогательный метод для печати всей HashMap
/*   public static void printMonthData(HashMap<Integer, HashMap<Integer, Integer>> monthData) {
        //Итерация через все записи в HashMap'ам
        //Для каждой записи (ключ-значение) в наборе записей monthData сделай
        for (Map.Entry<Integer, HashMap<Integer, Integer>> entry : monthData.entrySet()) {
            Integer month = entry.getKey();
            System.out.println();
            System.out.print("Месяц: " + (month+1) + ". ");
            HashMap<Integer, Integer> dayStepMap = entry.getValue();
            for (Map.Entry<Integer, Integer> dayEntry : dayStepMap.entrySet()) {
                Integer day = dayEntry.getKey();
                Integer steps = dayEntry.getValue();
                System.out.print("День " + (day+1) + ": " + steps + " шагов. ");
            }
        }
    }
*/


    }
