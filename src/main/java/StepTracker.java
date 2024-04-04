import java.util.HashMap;
import java.util.Map;

public class StepTracker {

    private static int targetNumberOfStepsPerDay = 10000;
       static HashMap<Integer,  HashMap<Integer, Integer>> monthData= new HashMap<Integer, HashMap<Integer,Integer>>();
       static HashMap<Integer,  Integer> daySteps= new HashMap<>();
    //Заполняем HashMap
    public static void setSteps(int month, int day, int steps){
          if(month>0 && month<12 && day>0 && day<31 && steps>0){
           daySteps.put(day,steps);
           monthData.put(month, daySteps);
            System.out.println("Ваши шаги сохранены!");
            }else {
            System.out.println("Вы ввели некорректные данные! Введите корректные данные.");
        }
    }

    //Метод для печати HashMap
    public static void printMonthData(HashMap<Integer, HashMap<Integer, Integer>> monthData) {
        //итерация через все записи в HashMap'ам
        //Для каждой записи (ключ-значение) в наборе записей monthData сделай
        for (Map.Entry<Integer, HashMap<Integer, Integer>> entry : monthData.entrySet()) {
            Integer month = entry.getKey();
            System.out.println("Month: " + month);
            HashMap<Integer, Integer> dayStepMap = entry.getValue();
            for (Map.Entry<Integer, Integer> dayEntry : dayStepMap.entrySet()) {
                Integer day = dayEntry.getKey();
                Integer steps = dayEntry.getValue();
                System.out.println("Day " + day + ": " + steps + " steps");
            }
        }
    }

    public static void showMonthStat (int monthNumber){
        for (Map.Entry<Integer, HashMap<Integer, Integer>> entry : monthData.entrySet()) {
            Integer month = entry.getKey();
            System.out.println("Вот ваша статистика за месяц: " + month);
            if(month==monthNumber){
                HashMap<Integer, Integer> dayStepMapStats = entry.getValue();
                for (Map.Entry<Integer, Integer> dayEntryStats : dayStepMapStats.entrySet()){
                    Integer statDay = dayEntryStats.getKey();
                    Integer statsSteps = dayEntryStats.getValue();
                    System.out.println("В этот день: " + statDay + "Вы прошли шагов:" + statsSteps);
                 }


                }
        }
     }

    public static int getTargetNumberOfStepsPerDay() {
        return targetNumberOfStepsPerDay;
    }

    public static void setTargetNumberOfStepsPerDay(int targetNumberOfStepsPerDay) {
        StepTracker.targetNumberOfStepsPerDay = targetNumberOfStepsPerDay;
    }

    public static HashMap<Integer, HashMap<Integer, Integer>> getMonthData() {
        return monthData;
    }

}
