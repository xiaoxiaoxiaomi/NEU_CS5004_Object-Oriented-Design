package problem1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TrendingTopics {

  public static Map<String, Long> countTopics_nonFunctional(List<String> listOfWords) {
    Map<String, Long> resultingTopics = new HashMap<>();
    Long temporaryCount;
    for (String topic : listOfWords) {
      temporaryCount = resultingTopics.getOrDefault(topic, 0l);
      temporaryCount++;
      resultingTopics.put(topic, temporaryCount);
    }
    return resultingTopics;
  }

  public static Map<String, Long> countTopics(List<String> listOfWOrds) {
    return listOfWOrds.stream()
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
  }

  public static List<String> replaceWord_nonFunctional(List<String> listOfWords,
      String offensiveWord, String replacementWord) {
    List<String> resultingList = new ArrayList<>();
    for (String word : listOfWords) {
      if (word.equals(offensiveWord)) {
        word = replacementWord;
      }
      resultingList.add(word);
    }
    return resultingList;
  }

  public static List<String> replaceWord(List<String> listOfWords, String offensiveWord,
      String replacementWord) {
    return listOfWords.stream().map(x -> {
      if (x.equals(offensiveWord)) {
        x = replacementWord;
      }
      return x;
    }).collect(Collectors.toList());
  }

  private static String returnOrReplace(String originWord, String offensiveWord,
      String replacementWord) {
    if (originWord.equals(offensiveWord)) {
      return replacementWord;
    } else {
      return originWord;
    }
  }

  public static List<String> replaceWord_helperMethod(List<String> listOfWords,
      String offensiveWord, String replacementWord) {
    return listOfWords.stream()
        .map(x -> TrendingTopics.returnOrReplace(x, offensiveWord, replacementWord))
        .collect(Collectors.toList());
  }
}
