package problem2and3;

import java.util.Comparator;

public class FastestFreeStyleTimeComparator implements Comparator<Swimmer> {

  @Override
  public int compare(Swimmer o1, Swimmer o2) {
    return o1.getFastestSwimTime(o1.getFreestyle50mTimes())
        .compareTo(o2.getFastestSwimTime(o2.getFreestyle50mTimes()));
  }
}
