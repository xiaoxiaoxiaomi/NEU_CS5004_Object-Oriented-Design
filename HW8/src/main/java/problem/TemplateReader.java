package problem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Read template from file to a string, and extract placeholders from the template.
 */
public class TemplateReader {

  private String template = "";
  private List<String> placeholders = new ArrayList<>();

  /**
   * Constructor for the TemplateReader class.
   *
   * @param path - template file path
   * @throws IOException if an I/O error occurs
   */
  public TemplateReader(String path) throws IOException {
    this.readTemplateFile(path);
    this.findEmailTemplatePlaceholders();
  }

  /**
   * Load template form file and store as a string.
   *
   * @param path - template file path
   * @throws IOException if an I/O error occurs
   */
  private void readTemplateFile(String path) throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
      String line = "";
      StringBuilder template = new StringBuilder();
      // read the file line by line
      while ((line = reader.readLine()) != null) {
        // append current line to the StringBuilder object with newline character
        template.append(line).append("\n");
      }
      // get the string representing the template
      this.template = template.toString();
    } catch (IOException e) {
      throw new IOException();
    }
  }

  /**
   * Extract placeholders from the template.
   */
  private void findEmailTemplatePlaceholders() {
    Pattern p = Pattern.compile("\\[\\[(.+?)\\]\\]");
    Matcher m = p.matcher(this.template);
    while (m.find()) {
      // m.group(1) is the string between [[ and ]]
      this.placeholders.add(m.group(1));
    }
  }

  /**
   * Getter for template
   *
   * @return template, as String
   */
  public String getTemplate() {
    return template;
  }

  /**
   * Getter for placeholders
   *
   * @return placeholders, as String List
   */
  public List<String> getPlaceholders() {
    return placeholders;
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
    TemplateReader that = (TemplateReader) o;
    return Objects.equals(template, that.template) && Objects.equals(placeholders,
        that.placeholders);
  }

  /**
   * Returns a hash code value for the object.
   *
   * @return a hash code value for this object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(template, placeholders);
  }

  /**
   * Returns a string representation of the object.
   *
   * @return a string representation of the object.
   */
  @Override
  public String toString() {
    return "TemplateReader{" +
        "template='" + template + '\'' +
        ", placeholders=" + placeholders +
        '}';
  }
}
