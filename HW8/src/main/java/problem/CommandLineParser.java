package problem;

import java.io.File;
import java.util.Objects;

/**
 * Processes and validates command line arguments. This class doesn't *do* anything with the values
 * provided by the user beyond initial validation. It is another class' responsibility to determine
 * what to do with the user input.
 */
public class CommandLineParser {

  public static final String EMAIL = "--email";
  public static final String EMAIL_TEMPLATE = "--email-template";
  public static final String LETTER = "--letter";
  public static final String LETTER_TEMPLATE = "--letter-template";
  public static final String OUTPUT_DIR = "--output-dir";
  public static final String CSV_FILE = "--csv-file";

  private Boolean email = false;
  private String emailTemplate = null;
  private Boolean letter = false;
  private String letterTemplate = null;
  private String outputDir = null;
  private String csvFile = null;

  /**
   * Constructor for the CommandLineParser class.
   *
   * @param args - arguments provided by the user
   * @throws InvalidArgumentException if the arguments supplied are invalid
   */
  public CommandLineParser(String[] args) throws InvalidArgumentException {
    this.processArgs(args);
  }

  /**
   * Helper method to populate the instance variables.
   *
   * @param args - arguments provided by the user
   * @throws InvalidArgumentException if the arguments supplied are invalid
   */
  private void processArgs(String[] args) throws InvalidArgumentException {
    // scan the string objects in the argument array one by one
    for (int i = 0; i < args.length; i++) {
      switch (args[i]) {
        case EMAIL:
          // set this.email to true when there is an --email option
          this.email = true;
          break;
        case EMAIL_TEMPLATE:
          // assign the argument after --email-template to this.emailTemplate when there is an --email-template option
          this.emailTemplate = ((i + 1) < args.length) ? args[i + 1] : null;
          break;
        case LETTER:
          // set this.letter to true when there is a --letter option
          this.letter = true;
          break;
        case LETTER_TEMPLATE:
          // assign the argument after --letter-template to this.letterTemplate when there is a --letter-template option
          this.letterTemplate = ((i + 1) < args.length) ? args[i + 1] : null;
          break;
        case OUTPUT_DIR:
          // assign the argument after --output-dir to this.outputDir when there is an --output-dir option
          this.outputDir = ((i + 1) < args.length) ? args[i + 1] : null;
          break;
        case CSV_FILE:
          // assign the argument after --csv-file to this.csvFile when there is a --csv-file option
          this.csvFile = ((i + 1) < args.length) ? args[i + 1] : null;
          break;
      }
    }
    // if there is no --output-dir option or there is no argument for --output-dir
    if (this.outputDir == null) {
      throw new InvalidArgumentException("Error: no --output-dir was given.");
    }
    File outputDir = new File(this.outputDir);
    // if the file denoted by the argument of --output-dir does not exist or is not a directory
    if (!outputDir.isDirectory()) {
      throw new InvalidArgumentException("Error: " + this.outputDir + " is not a directory.");
    }
    // if there is no --csv-file option or there is no argument for --csv-file
    if (this.csvFile == null) {
      throw new InvalidArgumentException("Error: no --csv-file was given.");
    }
    File csvFile = new File(this.csvFile);
    // if the file denoted by the argument of --csv-file does not exist or is not a file
    if (!csvFile.isFile()) {
      throw new InvalidArgumentException("Error: " + this.csvFile + " is not a file.");
    }
    // if the filename does not end with .csv
    if (!this.csvFile.endsWith(".csv")) {
      throw new InvalidArgumentException("Error: " + this.csvFile + " is not a csv file.");
    }
    // if there is an --email option
    if (this.email) {
      // if there is no --email-template option or there is no argument for --email-template
      if (this.emailTemplate == null) {
        throw new InvalidArgumentException(
            "Error: --email provided but no --email-template was given.");
      }
      File emailTemplateFile = new File(this.emailTemplate);
      // if the file denoted by the argument of --email-template does not exist or is not a file
      if (!emailTemplateFile.isFile()) {
        throw new InvalidArgumentException("Error: " + this.emailTemplate + " is not a file.");
      }
    }
    // if there is a --letter option
    if (this.letter) {
      // if there is no --letter-template option or there is no argument for --letter-template
      if (this.letterTemplate == null) {
        throw new InvalidArgumentException(
            "Error: --letter provided but no --letter-template was given.");
      }
      File letterTemplateFile = new File(this.letterTemplate);
      // if the file denoted by the argument of --letter-template does not exist or is not a file
      if (!letterTemplateFile.isFile()) {
        throw new InvalidArgumentException("Error: " + this.letterTemplate + " is not a file.");
      }
    }
  }

  /**
   * @return true if there is an --email option, otherwise return false
   */
  public Boolean getEmail() {
    return email;
  }

  /**
   * @return the email template path if there is an --email-template option and the subsequent
   * argument is valid
   */
  public String getEmailTemplate() {
    return emailTemplate;
  }

  /**
   * @return true if there is a --letter option, otherwise return false
   */
  public Boolean getLetter() {
    return letter;
  }

  /**
   * @return the letter template path if there is a --letter-template option and the subsequent
   * argument is valid
   */
  public String getLetterTemplate() {
    return letterTemplate;
  }

  /**
   * @return the output directory path if there is a --output-dir option and the subsequent argument
   * is valid
   */
  public String getOutputDir() {
    return outputDir;
  }

  /**
   * @return the csv file path if there is a --csv-file option and the subsequent argument is valid
   */
  public String getCsvFile() {
    return csvFile;
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
    CommandLineParser that = (CommandLineParser) o;
    return Objects.equals(email, that.email) && Objects.equals(emailTemplate,
        that.emailTemplate) && Objects.equals(letter, that.letter)
        && Objects.equals(letterTemplate, that.letterTemplate) && Objects.equals(
        outputDir, that.outputDir) && Objects.equals(csvFile, that.csvFile);
  }

  /**
   * Returns a hash code value for the object.
   *
   * @return a hash code value for this object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(email, emailTemplate, letter, letterTemplate, outputDir, csvFile);
  }

  /**
   * Returns a string representation of the object.
   *
   * @return a string representation of the object.
   */
  @Override
  public String toString() {
    return "CommandLineParser{" +
        "email=" + email +
        ", emailTemplate='" + emailTemplate + '\'' +
        ", letter=" + letter +
        ", letterTemplate='" + letterTemplate + '\'' +
        ", outputDir='" + outputDir + '\'' +
        ", csvFile='" + csvFile + '\'' +
        '}';
  }
}
