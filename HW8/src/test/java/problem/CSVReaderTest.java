package problem;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CSVReaderTest {

  CSVReader testCSVReader;

  @BeforeEach
  void setUp() throws IOException {
    testCSVReader = new CSVReader("insurance-company-members.csv");
  }

  @Test
  void testThrows() {
    assertThrows(IOException.class, () -> {
      new CSVReader("nothing.csv");
    });
  }

  @Test
  void getCsvLines() throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader("insurance-company-members.csv"));
    List<String> expectedCsvLines = new ArrayList<>();
    String line = "";
    while ((line = reader.readLine()) != null) {
      if (line.trim().isEmpty()) {
        continue;
      }
      expectedCsvLines.add(line);
    }
    assertEquals(expectedCsvLines, testCSVReader.getCsvLines());
  }

  @Test
  void testEquals() throws IOException {
    assertTrue(testCSVReader.equals(testCSVReader));
    assertFalse(testCSVReader.equals(null));
    assertFalse(testCSVReader.equals("insurance-company-members.csv"));
    CSVReader newCSVReader1 = new CSVReader("test.csv");
    assertFalse(testCSVReader.equals(newCSVReader1));
    CSVReader newCSVReader2 = new CSVReader("insurance-company-members.csv");
    assertTrue(testCSVReader.equals(newCSVReader2));
  }

  @Test
  void testHashCode() {
    int expectedHashCode = Objects.hash(testCSVReader.getCsvLines());
    assertEquals(expectedHashCode, testCSVReader.hashCode());
  }

  @Test
  void testToString() {
    String expectedString = "CSVReader{" +
        "csvLines=" + testCSVReader.getCsvLines() +
        '}';
    assertEquals(expectedString, testCSVReader.toString());
  }
}