import java.util.HashMap;
import java.util.Map;

public class StepTracker {

    private static int targetNumberOfStepsPerDay = 10000;
    static HashMap<Integer, MonthData> monthData= new HashMap<Integer, MonthData>();

    //Заполняем HashMap
    public static void setSteps(int month, int day, int steps){
          if(month>0 && month<12 && day>0 && day<31 && steps>0){
                MonthData data = new MonthData();
                data.setDay(day);
                data.setSteps(steps);
                // Помещаем объект MonthData в HashMap
                monthData.put(month, data);
            System.out.println("Ваши шаги сохранены!");
            }else {
            System.out.println("Вы ввели некорректные данные! Введите корректные данные.");
        }
    }

    //Метод для печати HashMap
    public static void printMonthData(HashMap<Integer, MonthData> monthData) {
        //итерация через все записи в HashMap
        //Для каждой записи (ключ-значение) в наборе записей monthData типа Map.Entry<Integer, MonthData>, сделай
        for (Map.Entry<Integer, MonthData> entry : monthData.entrySet()) {
            Integer key = entry.getKey();
            MonthData value = entry.getValue();
            System.out.println("Месяц: " + key + ". День: " + value.getDay() + ". Шаги: " + value.getSteps());
        }
    }

    public static int getTargetNumberOfStepsPerDay() {
        return targetNumberOfStepsPerDay;
    }

    public static void setTargetNumberOfStepsPerDay(int targetNumberOfStepsPerDay) {
        StepTracker.targetNumberOfStepsPerDay = targetNumberOfStepsPerDay;
    }

    public static HashMap<Integer, MonthData> getMonthData() {
        return monthData;
    }
}
