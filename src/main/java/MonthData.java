import java.util.HashMap;

public class MonthData {

  static HashMap<Integer,  Integer> daySteps= new HashMap<Integer, Integer>();


private int day;
  private int steps;

  public int getDay() {
    return day;
  }

  public int getSteps() {
    return steps;
  }

  public void setDay(int day) {
    this.day = day;
  }

  public void setSteps(int steps) {
    this.steps = steps;
  }
}
