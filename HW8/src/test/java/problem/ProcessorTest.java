package problem;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProcessorTest {

  CSVReader testCSVReader;
  TemplateReader testTemplateReader;
  Processor testProcessor;
  List<String> testCsvLines;
  String testTemplate;
  List<String> testPlaceholders;

  @BeforeEach
  void setUp() throws IOException {
    testCSVReader = new CSVReader("insurance-company-members.csv");
    testTemplateReader = new TemplateReader("email-template.txt");
    testCsvLines = testCSVReader.getCsvLines();
    testTemplate = testTemplateReader.getTemplate();
    testPlaceholders = testTemplateReader.getPlaceholders();
    testProcessor = new Processor(testCsvLines, testTemplate, testPlaceholders);
  }

  @Test
  void getOutputFiles() {
    String[] csvHeader = testCsvLines.get(0).split("\"*,*\"");
    Map<String, Integer> columnMap = new HashMap<>();
    for (String placeholder : testPlaceholders) {
      for (int j = 0; j < csvHeader.length; j++) {
        if (placeholder.equals(csvHeader[j])) {
          columnMap.put(placeholder, j);
        }
      }
    }
    List<String> expectedOutputFiles = new ArrayList<>();
    for (int i = 1; i < testCsvLines.size(); i++) {
      String a = testCsvLines.get(i);
      String[] array = a.split("\"*,*\"");
      String outputFile = testTemplate;
      for (String placeholder : testPlaceholders) {
        String regularExp = "\\[\\[" + placeholder + "\\]\\]";
        Integer colIdx = columnMap.get(placeholder);
        outputFile = outputFile.replaceAll(regularExp, array[colIdx]);
      }
      expectedOutputFiles.add(outputFile);
    }
    assertEquals(expectedOutputFiles, testProcessor.getOutputFiles());
  }

  @Test
  void testEquals() throws IOException {
    assertTrue(testProcessor.equals(testProcessor));
    assertFalse(testProcessor.equals(null));
    assertFalse(testProcessor.equals(testCsvLines));
    TemplateReader newTemplateReader = new TemplateReader("letter-template.txt");
    Processor newProcessor1 = new Processor(testCsvLines, newTemplateReader.getTemplate(), newTemplateReader.getPlaceholders());
    assertFalse(testProcessor.equals(newProcessor1));
    Processor newProcessor2 = new Processor(testCsvLines, testTemplate, testPlaceholders);
    assertTrue(testProcessor.equals(newProcessor2));
  }

  @Test
  void testHashCode() {
    int expectedHashCode = Objects.hash(testProcessor.getOutputFiles());
    assertEquals(expectedHashCode, testProcessor.hashCode());
  }

  @Test
  void testToString() {
    String expectedString = "Processor{" +
        "outputFiles=" + testProcessor.getOutputFiles() +
        '}';
    assertEquals(expectedString, testProcessor.toString());
  }
}