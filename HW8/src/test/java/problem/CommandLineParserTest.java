package problem;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CommandLineParserTest {

  String[] testArgs1;
  String[] testArgs2;
  CommandLineParser testCommandLineParser1;
  CommandLineParser testCommandLineParser2;
  static final String DEFAULT_MESSAGE =
      "\n\nUsage:\n"
          + "--email Generate email messages. If this option is provided, then -- email-template must also be provided.\n"
          + "--email-template <path/to/file> A filename for the email template. --letter Generate letters. If this option is provided, then --letter- template must also be provided.\n"
          + "--letter-template <path/to/file> A filename for the letter template. --output-dir <path/to/folder> The folder to store all generated files. This option is required.\n"
          + "--csv-file <path/to/folder> The CSV file to process. This option is required.\n"
          + "\nExamples:\n"
          + "--email --email-template email-template.txt --output-dir emails -- csv-file customer.csv\n"
          + "--letter --letter-template letter-template.txt --output-dir letters - -csv-file customer.csv";

  @BeforeEach
  void setUp() throws InvalidArgumentException {
    String arg1 = "--email --email-template email-template.txt --letter --letter-template letter-template.txt --csv-file insurance-company-members.csv --output-dir emails_and_letters";
    testArgs1 = arg1.split(" ");
    testCommandLineParser1 = new CommandLineParser(testArgs1);
    String arg2 = "--email --email-template email-template.txt --csv-file insurance-company-members.csv --output-dir emails_and_letters";
    testArgs2 = arg2.split(" ");
    testCommandLineParser2 = new CommandLineParser(testArgs2);
  }

  @Test
  void testProcessArgs() throws InvalidArgumentException {
    // output dir not provided
    String[] newArgs1 = "--email --email-template email-template.txt --csv-file insurance-company-members.csv --output-dir".split(
        " ");
    Exception e = assertThrows(InvalidArgumentException.class, () -> {
      new CommandLineParser(newArgs1);
    });
    assertEquals("Error: no --output-dir was given." + DEFAULT_MESSAGE, e.getMessage());
    // provided output dir is not a directory
    String[] newArgs2 = "--email --email-template email-template.txt --csv-file insurance-company-members.csv --output-dir out".split(
        " ");
    e = assertThrows(InvalidArgumentException.class, () -> {
      new CommandLineParser(newArgs2);
    });
    assertEquals("Error: out is not a directory." + DEFAULT_MESSAGE, e.getMessage());
    // csv file not provided
    String[] newArgs3 = "--email --email-template email-template.txt --output-dir emails --csv-file".split(
        " ");
    e = assertThrows(InvalidArgumentException.class, () -> {
      new CommandLineParser(newArgs3);
    });
    assertEquals("Error: no --csv-file was given." + DEFAULT_MESSAGE, e.getMessage());
    // provided csv file is not a file
    String[] newArgs4 = "--email --email-template email-template.txt --output-dir emails --csv-file nothing.csv".split(
        " ");
    e = assertThrows(InvalidArgumentException.class, () -> {
      new CommandLineParser(newArgs4);
    });
    assertEquals("Error: nothing.csv is not a file." + DEFAULT_MESSAGE, e.getMessage());
    // provided csv file is not a csv file
    String[] newArgs5 = "--email --email-template email-template.txt --output-dir emails --csv-file email-template.txt".split(
        " ");
    e = assertThrows(InvalidArgumentException.class, () -> {
      new CommandLineParser(newArgs5);
    });
    assertEquals("Error: email-template.txt is not a csv file." + DEFAULT_MESSAGE, e.getMessage());
    // email template not provided
    String[] newArgs6 = "--email --letter-template letter-template.txt --output-dir emails --csv-file insurance-company-members.csv".split(
        " ");
    e = assertThrows(InvalidArgumentException.class, () -> {
      new CommandLineParser(newArgs6);
    });
    assertEquals("Error: --email provided but no --email-template was given." + DEFAULT_MESSAGE,
        e.getMessage());
    String[] newArgs7 = "--email --output-dir emails --csv-file insurance-company-members.csv --email-template".split(
        " ");
    e = assertThrows(InvalidArgumentException.class, () -> {
      new CommandLineParser(newArgs7);
    });
    assertEquals("Error: --email provided but no --email-template was given." + DEFAULT_MESSAGE,
        e.getMessage());
    // provided email template is not a file
    String[] newArgs8 = "--email --email-template nothing.txt --output-dir emails --csv-file insurance-company-members.csv".split(
        " ");
    e = assertThrows(InvalidArgumentException.class, () -> {
      new CommandLineParser(newArgs8);
    });
    assertEquals("Error: nothing.txt is not a file." + DEFAULT_MESSAGE, e.getMessage());
    // letter template not provided
    String[] newArgs9 = "--letter --email-template email-template.txt --output-dir letters --csv-file insurance-company-members.csv".split(
        " ");
    e = assertThrows(InvalidArgumentException.class, () -> {
      new CommandLineParser(newArgs9);
    });
    assertEquals("Error: --letter provided but no --letter-template was given." + DEFAULT_MESSAGE,
        e.getMessage());
    String[] newArgs10 = "--letter --output-dir letters --csv-file insurance-company-members.csv --letter-template".split(
        " ");
    e = assertThrows(InvalidArgumentException.class, () -> {
      new CommandLineParser(newArgs10);
    });
    assertEquals("Error: --letter provided but no --letter-template was given." + DEFAULT_MESSAGE,
        e.getMessage());
    // provided letter template is not a file
    String[] newArgs11 = "--letter --letter-template nothing.txt --output-dir letters --csv-file insurance-company-members.csv".split(
        " ");
    e = assertThrows(InvalidArgumentException.class, () -> {
      new CommandLineParser(newArgs11);
    });
    assertEquals("Error: nothing.txt is not a file." + DEFAULT_MESSAGE, e.getMessage());
  }

  @Test
  void getEmail() {
    assertEquals(true, testCommandLineParser1.getEmail());
  }

  @Test
  void getEmailTemplate() {
    assertEquals("email-template.txt", testCommandLineParser1.getEmailTemplate());
  }

  @Test
  void getLetter() {
    assertEquals(true, testCommandLineParser1.getLetter());
  }

  @Test
  void getLetterTemplate() {
    assertEquals("letter-template.txt", testCommandLineParser1.getLetterTemplate());
  }

  @Test
  void getOutputDir() {
    assertEquals("emails_and_letters", testCommandLineParser1.getOutputDir());
  }

  @Test
  void getCsvFile() {
    assertEquals("insurance-company-members.csv", testCommandLineParser1.getCsvFile());
  }

  @Test
  void testEquals() throws InvalidArgumentException {
    assertTrue(testCommandLineParser1.equals(testCommandLineParser1));
    assertFalse(testCommandLineParser1.equals(null));
    assertFalse(testCommandLineParser1.equals(
        "--email --email-template email-template.txt --letter --letter-template letter-template.txt --csv-file insurance-company-members.csv --output-dir emails_and_letters"));
    String[] newArgs1 = "--email-template email-template.txt --letter --letter-template letter-template.txt --csv-file insurance-company-members.csv --output-dir emails_and_letters".split(
        " ");
    CommandLineParser newCommandLineParser1 = new CommandLineParser(newArgs1);
    assertFalse(testCommandLineParser1.equals(newCommandLineParser1));
    String[] newArgs2 = "--email --email-template letter-template.txt --letter --letter-template letter-template.txt --csv-file insurance-company-members.csv --output-dir emails_and_letters".split(
        " ");
    CommandLineParser newCommandLineParser2 = new CommandLineParser(newArgs2);
    assertFalse(testCommandLineParser1.equals(newCommandLineParser2));
    String[] newArgs3 = "--email --email-template email-template.txt --letter-template letter-template.txt --csv-file insurance-company-members.csv --output-dir emails_and_letters".split(
        " ");
    CommandLineParser newCommandLineParser3 = new CommandLineParser(newArgs3);
    assertFalse(testCommandLineParser1.equals(newCommandLineParser3));
    String[] newArgs4 = "--email --email-template email-template.txt --letter --letter-template email-template.txt --csv-file insurance-company-members.csv --output-dir emails_and_letters".split(
        " ");
    CommandLineParser newCommandLineParser4 = new CommandLineParser(newArgs4);
    assertFalse(testCommandLineParser1.equals(newCommandLineParser4));
    String[] newArgs5 = "--email --email-template email-template.txt --letter --letter-template letter-template.txt --csv-file test.csv --output-dir emails_and_letters".split(
        " ");
    CommandLineParser newCommandLineParser5 = new CommandLineParser(newArgs5);
    assertFalse(testCommandLineParser1.equals(newCommandLineParser5));
    String[] newArgs6 = "--email --email-template email-template.txt --letter --letter-template letter-template.txt --csv-file insurance-company-members.csv --output-dir emails".split(
        " ");
    CommandLineParser newCommandLineParser6 = new CommandLineParser(newArgs6);
    assertFalse(testCommandLineParser1.equals(newCommandLineParser6));
    String[] newArgs7 = "--email --email-template email-template.txt --letter --letter-template letter-template.txt --csv-file insurance-company-members.csv --output-dir emails_and_letters".split(
        " ");
    CommandLineParser newCommandLineParser7 = new CommandLineParser(newArgs7);
    assertTrue(testCommandLineParser1.equals(newCommandLineParser7));
  }

  @Test
  void testHashCode() {
    int expectedHashCode = Objects.hash(true, "email-template.txt", true, "letter-template.txt",
        "emails_and_letters", "insurance-company-members.csv");
    assertEquals(expectedHashCode, testCommandLineParser1.hashCode());
  }

  @Test
  void testToString() {
    String expectedString = "CommandLineParser{" +
        "email=" + true +
        ", emailTemplate='" + "email-template.txt" + '\'' +
        ", letter=" + true +
        ", letterTemplate='" + "letter-template.txt" + '\'' +
        ", outputDir='" + "emails_and_letters" + '\'' +
        ", csvFile='" + "insurance-company-members.csv" + '\'' +
        '}';
    assertEquals(expectedString, testCommandLineParser1.toString());
  }
}