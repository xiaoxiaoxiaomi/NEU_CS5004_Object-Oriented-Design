package problem;

import java.io.IOException;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    // get the file path separator under current system
    String fileSep = System.getProperty("file.separator");
    try {
      // construct a CommandLineParser
      CommandLineParser parser = new CommandLineParser(args);
      // construct a CSVReader
      CSVReader csvReader = new CSVReader(parser.getCsvFile());
      // get csv lines
      List<String> csvLines = csvReader.getCsvLines();
      // if there is an --email option
      if (parser.getEmail()) {
        // construct a emailTemplateReader
        TemplateReader emailTemplateReader = new TemplateReader(parser.getEmailTemplate());
        // get the email template
        String emailTemplate = emailTemplateReader.getTemplate();
        // get placeholders in the email template
        List<String> emailPlaceholders = emailTemplateReader.getPlaceholders();
        // construct a emailProcessor
        Processor emailProcessor = new Processor(csvLines, emailTemplate, emailPlaceholders);
        // get the output files
        List<String> outputFiles = emailProcessor.getOutputFiles();
        // write output files to output directory
        Output emailOutput = new Output(
            parser.getOutputDir() + fileSep + "email_", outputFiles);
      }
      // if there is a --letter option
      if (parser.getLetter()) {
        // construct a letterTemplateReader
        TemplateReader letterTemplateReader = new TemplateReader(parser.getLetterTemplate());
        // get the letter template
        String letterTemplate = letterTemplateReader.getTemplate();
        // get placeholders in the letter template
        List<String> letterPlaceholders = letterTemplateReader.getPlaceholders();
        // construct a letterProcessor
        Processor letterProcessor = new Processor(csvLines, letterTemplate, letterPlaceholders);
        // get the output files
        List<String> outputFiles = letterProcessor.getOutputFiles();
        // write output files to output directory
        Output letterOutput = new Output(
            parser.getOutputDir() + fileSep + "letter_", outputFiles);
      }
    } catch (InvalidArgumentException | IOException e) {
      e.printStackTrace();
    }
  }
}
