package problem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Generate an output file per row in the csv lines from template, with all placeholders replaced
 * with the appropriate value for that row.
 */
public class Processor {

  private List<String> outputFiles = new ArrayList<>();

  /**
   * Constructor for the Processor class.
   *
   * @param csvLines     - all lines in csv, as String List
   * @param template     - template, as String
   * @param placeholders - placeholders in the template, as String List
   */
  public Processor(List<String> csvLines, String template, List<String> placeholders) {
    this.processInput(csvLines, template, placeholders);
  }

  /**
   * Generate an output file per row in the csv lines from template, with all placeholders replaced
   * with the appropriate value for that row.
   *
   * @param csvLines     - all lines in csv, as String List
   * @param template     - template, as String
   * @param placeholders - placeholders in the template, as String List
   */
  private void processInput(List<String> csvLines, String template, List<String> placeholders) {
    // get the headers for each column
    String[] csvHeader = csvLines.get(0).split("\"*,*\"");
    // construct a map with placeholder as key and the corresponding column index as value
    Map<String, Integer> columnMap = new HashMap<>();
    for (String placeholder : placeholders) {
      for (int j = 0; j < csvHeader.length; j++) {
        // match placeholder with header and get the column index
        if (placeholder.equals(csvHeader[j])) {
          columnMap.put(placeholder, j);
        }
      }
    }
    // for each csv line
    for (int i = 1; i < csvLines.size(); i++) {
      String a = csvLines.get(i);
      String[] array = a.split("\"*,*\"");
      // initialize the output file as template
      String outputFile = template;
      // for each placeholder
      for (String placeholder : placeholders) {
        String regularExp = "\\[\\[" + placeholder + "\\]\\]";
        Integer colIdx = columnMap.get(placeholder);
        // replace the placeholder with corresponding column value
        outputFile = outputFile.replaceAll(regularExp, array[colIdx]);
      }
      this.outputFiles.add(outputFile);
    }
  }

  /**
   * Getter for output files
   *
   * @return output files, as String List
   */
  public List<String> getOutputFiles() {
    return outputFiles;
  }

  /**
   * Indicates whether some other object is "equal to" this one.
   *
   * @param o - the reference object with which to compare.
   * @return true if this object is the same as the obj argument; false otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Processor processor = (Processor) o;
    return Objects.equals(outputFiles, processor.outputFiles);
  }

  /**
   * Returns a hash code value for the object.
   *
   * @return a hash code value for this object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(outputFiles);
  }

  /**
   * Returns a string representation of the object.
   *
   * @return a string representation of the object.
   */
  @Override
  public String toString() {
    return "Processor{" +
        "outputFiles=" + outputFiles +
        '}';
  }
}
