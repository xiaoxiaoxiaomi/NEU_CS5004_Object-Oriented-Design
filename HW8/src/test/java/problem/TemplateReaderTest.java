package problem;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TemplateReaderTest {

  TemplateReader testTemplateReader;
  String expectedTemplate = "";

  @BeforeEach
  void setUp() throws IOException {
    testTemplateReader = new TemplateReader("email-template.txt");
    BufferedReader reader = new BufferedReader(new FileReader("email-template.txt"));
    String line = "";
    StringBuilder template = new StringBuilder();
    while ((line = reader.readLine()) != null) {
      template.append(line).append("\n");
    }
    expectedTemplate = template.toString();
  }

  @Test
  void testThrows() {
    assertThrows(IOException.class, () -> {
      new TemplateReader("nothing.txt");
    });
  }

  @Test
  void getTemplate() throws IOException {
    assertEquals(expectedTemplate, testTemplateReader.getTemplate());
  }

  @Test
  void getPlaceholders() {
    List<String> expectedPlaceholders = new ArrayList<>();
    expectedPlaceholders.add("email");
    expectedPlaceholders.add("first_name");
    expectedPlaceholders.add("last_name");
    assertEquals(expectedPlaceholders, testTemplateReader.getPlaceholders());
  }

  @Test
  void testEquals() throws IOException {
    assertTrue(testTemplateReader.equals(testTemplateReader));
    assertFalse(testTemplateReader.equals(null));
    assertFalse(testTemplateReader.equals("email-template.txt"));
    TemplateReader newTemplateReader1 = new TemplateReader("letter-template.txt");
    assertFalse(testTemplateReader.equals(newTemplateReader1));
    TemplateReader newTemplateReader2 = new TemplateReader("email-template.txt");
    assertTrue(testTemplateReader.equals(newTemplateReader2));
  }

  @Test
  void testHashCode() {
    int expectedHashCode = Objects.hash(testTemplateReader.getTemplate(), testTemplateReader.getPlaceholders());
    assertEquals(expectedHashCode, testTemplateReader.hashCode());
  }

  @Test
  void testToString() {
    String expectedString = "TemplateReader{" +
        "template='" + testTemplateReader.getTemplate() + '\'' +
        ", placeholders=" + testTemplateReader.getPlaceholders() +
        '}';
    assertEquals(expectedString, testTemplateReader.toString());
  }
}