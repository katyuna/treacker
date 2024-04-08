import java.util.HashMap;
import java.util.Map;

public class StepTracker {

    private static int targetNumberOfStepsPerDay = 10000;
       static HashMap<Integer,  HashMap<Integer, Integer>> monthData= new HashMap<Integer, HashMap<Integer,Integer>>();
      // static HashMap<Integer,  Integer> daySteps= new HashMap<>();
    //Заполняем HashMap
    public static void setSteps(int month, int day, int steps){
          if(month>0 && month<12 && day>0 && day<31 && steps>0){
              // Проверяем, существует ли уже HashMap для указанного месяца
              if (!monthData.containsKey(month)) {
                  // Если нет, создаем новую HashMap для этого месяца
                  monthData.put(month, new HashMap<>());
              }
              // Получаем HashMap для указанного месяца
              HashMap<Integer, Integer> daySteps = monthData.get(month);
              // Добавляем значение для указанного дня
              daySteps.put(day, steps);
              System.out.println("Ваши шаги сохранены!");
            }else {
              if (month<=0 || month>12){
                  System.out.println("Месяц указан неверно!");
              } else if (day<=0 || day>30){
                  System.out.println("День указан неверно!");
              }
            System.out.println("Вы ввели некорректные данные! Введите корректные данные.");
        }
    }

    //Метод для печати HashMap
    public static void printMonthData(HashMap<Integer, HashMap<Integer, Integer>> monthData) {
        //итерация через все записи в HashMap'ам
        //Для каждой записи (ключ-значение) в наборе записей monthData сделай
        for (Map.Entry<Integer, HashMap<Integer, Integer>> entry : monthData.entrySet()) {
            Integer month = entry.getKey();
            System.out.println("");
            System.out.print("Месяц: " + month + ". ");
            HashMap<Integer, Integer> dayStepMap = entry.getValue();
            for (Map.Entry<Integer, Integer> dayEntry : dayStepMap.entrySet()) {
                Integer day = dayEntry.getKey();
                Integer steps = dayEntry.getValue();
                System.out.print("День " + day + ": " + steps + " шагов. ");
            }
        }
    }

    //Вывод статистики работает не правильно
    public static void showMonthStat (int monthNumber){
        for (Map.Entry<Integer, HashMap<Integer, Integer>> entry : monthData.entrySet()) {
            Integer month = entry.getKey();
            System.out.println("Вот ваша статистика за месяц: " + month + ". ");
            if(month==monthNumber){
                HashMap<Integer, Integer> dayStepMapStats = entry.getValue();
                for (Map.Entry<Integer, Integer> dayEntryStats : dayStepMapStats.entrySet()){
                    Integer statDay = dayEntryStats.getKey();
                    Integer statsSteps = dayEntryStats.getValue();
                    System.out.print(statDay + "день, " + statsSteps );
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
