package problem1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencyCounter {

  private static final Double DEFAULT_COUNT = 0.0;

  public FrequencyCounter() {
  }

  public Map<Integer, Double> getRelativeFrequency(List<Integer> integers) {
    Map<Integer, Double> resultingFrequencies = new HashMap<>();
    final Double INDIVIDUAL_INCREMENT = (double) 1 / integers.size();
    for (Integer number : integers) {
      Double helperCount = resultingFrequencies.getOrDefault(number, DEFAULT_COUNT) + INDIVIDUAL_INCREMENT;
      resultingFrequencies.put(number, helperCount);
    }
    return resultingFrequencies;
  }
}
