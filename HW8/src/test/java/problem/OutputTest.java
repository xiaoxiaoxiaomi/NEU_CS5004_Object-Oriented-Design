package problem;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OutputTest {

  CSVReader testCSVReader;
  TemplateReader testTemplateReader;
  Processor testProcessor;
  List<String> testOutputFiles = new ArrayList<>();
  Output testOutput;

  @BeforeEach
  void setUp() throws IOException {
    testCSVReader = new CSVReader("insurance-company-members.csv");
    testTemplateReader = new TemplateReader("email-template.txt");
    testProcessor = new Processor(testCSVReader.getCsvLines(), testTemplateReader.getTemplate(), testTemplateReader.getPlaceholders());
    testOutputFiles = testProcessor.getOutputFiles();
  }

  @Test
  void writeFile() throws IOException {
    String fileSep = System.getProperty("file.separator");
    testOutput = new Output("emails" + fileSep + "email_", testOutputFiles);
  }
}