package problem;

/**
 * Signals an error when the argument is invalid
 */
public class InvalidArgumentException extends Exception {

  static final String DEFAULT_MESSAGE =
      "\n\nUsage:\n"
          + "--email Generate email messages. If this option is provided, then -- email-template must also be provided.\n"
          + "--email-template <path/to/file> A filename for the email template. --letter Generate letters. If this option is provided, then --letter- template must also be provided.\n"
          + "--letter-template <path/to/file> A filename for the letter template. --output-dir <path/to/folder> The folder to store all generated files. This option is required.\n"
          + "--csv-file <path/to/folder> The CSV file to process. This option is required.\n"
          + "\nExamples:\n"
          + "--email --email-template email-template.txt --output-dir emails -- csv-file customer.csv\n"
          + "--letter --letter-template letter-template.txt --output-dir letters - -csv-file customer.csv";

  /**
   * Constructs a new InvalidArgumentException with the specified detail message
   *
   * @param message - the detail message
   */

  public InvalidArgumentException(String message) {
    super(message + DEFAULT_MESSAGE);
  }
}
