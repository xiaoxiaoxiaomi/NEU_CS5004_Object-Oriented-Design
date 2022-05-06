package problem2and3;

import java.util.Collections;
import java.util.List;

/**
 * Class Swimmer contains information about a swimmer, and the list of their swimming times, when
 * swimming 50m. Four swimming styles are considered: butterfly, backstroke, breaststroke, and
 * freestyle.
 */
public class Swimmer implements Comparable<Swimmer> {

  private String name;
  private List<Double> butterfly50mTimes;
  private List<Double> backstroke50mTimes;
  private List<Double> breaststroke50mTimes;
  private List<Double> freestyle50mTimes;

  public Swimmer(String name, List<Double> butterfly50mTimes, List<Double> backstroke50mTimes,
      List<Double> breaststroke50mTimes, List<Double> freestyle50mTimes) {
    this.name = name;
    this.butterfly50mTimes = butterfly50mTimes;
    this.backstroke50mTimes = backstroke50mTimes;
    this.breaststroke50mTimes = breaststroke50mTimes;
    this.freestyle50mTimes = freestyle50mTimes;
  }

  public String getName() {
    return name;
  }

  public List<Double> getButterfly50mTimes() {
    return butterfly50mTimes;
  }

  public List<Double> getBackstroke50mTimes() {
    return backstroke50mTimes;
  }

  public List<Double> getBreaststroke50mTimes() {
    return breaststroke50mTimes;
  }

  public List<Double> getFreestyle50mTimes() {
    return freestyle50mTimes;
  }

  protected Double getAverageSwimTime(List<Double> swimTimes) {
    Double totalSwimTime = 0.0;
    for (Double swimTime : swimTimes) {
      totalSwimTime += swimTime;
    }
    return totalSwimTime / swimTimes.size();
  }

  protected Double getFastestSwimTime(List<Double> swimTimes) {
    Collections.sort(swimTimes);
    return swimTimes.get(0);
  }

  protected Double getSlowestSwimTime(List<Double> swimTimes) {
    Collections.sort(swimTimes);
    return swimTimes.get(swimTimes.size() - 1);
  }

  @Override
  //YOUR CODE HERE
  public int compareTo(Swimmer otherSwimmer) {
    return this.getAverageSwimTime(this.getFreestyle50mTimes())
        .compareTo(otherSwimmer.getAverageSwimTime(otherSwimmer.getFreestyle50mTimes()));
  }

  @Override
  public String toString() {
    return "Swimmer{" +
        "name='" + name + '\'' +
        '}';
  }
}

