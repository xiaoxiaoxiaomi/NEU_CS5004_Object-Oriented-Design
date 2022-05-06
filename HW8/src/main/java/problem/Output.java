package problem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Write the output files to output directory.
 */
public class Output {

  /**
   * Constructor for the Output class.
   *
   * @param path        - output directory path
   * @param outputFiles - output files, as String List
   */
  public Output(String path, List<String> outputFiles) {
    this.writeFile(path, outputFiles);
  }

  /**
   * Write the output files to output directory.
   *
   * @param path        - output directory path
   * @param outputFiles - output files, as String List
   */
  private void writeFile(String path, List<String> outputFiles) {
    for (int i = 0; i < outputFiles.size(); i++) {
      // use row index as file name
      try (BufferedWriter outputFile = new BufferedWriter(
          new FileWriter(path + (i + 1) + ".txt"))) {
        outputFile.write(outputFiles.get(i));
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
