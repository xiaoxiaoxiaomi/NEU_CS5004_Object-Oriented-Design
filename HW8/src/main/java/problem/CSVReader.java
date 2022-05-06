package problem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Load data from csv file and store it in list.
 */
public class CSVReader {

  private List<String> csvLines = new ArrayList<>();

  /**
   * Constructor for the CSVReader class.
   *
   * @param path - csv file path
   * @throws IOException if an I/O error occurs
   */
  public CSVReader(String path) throws IOException {
    this.readCSVFile(path);
  }

  /**
   * Load data from csv file into ArrayList
   *
   * @param path - csv file path
   * @throws IOException if an I/O error occurs
   */
  private void readCSVFile(String path) throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
      String line = "";
      // read the file line by line
      while ((line = reader.readLine()) != null) {
        // skip empty row
        if (line.trim().isEmpty()) {
          continue;
        }
        // add line into ArrayList
        this.csvLines.add(line);
      }
    } catch (IOException e) {
      throw new IOException();
    }
  }

  /**
   * Getter for csv lines
   *
   * @return csv lines, as String List
   */
  public List<String> getCsvLines() {
    return csvLines;
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
    CSVReader csvReader = (CSVReader) o;
    return Objects.equals(csvLines, csvReader.csvLines);
  }

  /**
   * Returns a hash code value for the object.
   *
   * @return a hash code value for this object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(csvLines);
  }

  /**
   * Returns a string representation of the object.
   *
   * @return a string representation of the object.
   */
  @Override
  public String toString() {
    return "CSVReader{" +
        "csvLines=" + csvLines +
        '}';
  }
}
