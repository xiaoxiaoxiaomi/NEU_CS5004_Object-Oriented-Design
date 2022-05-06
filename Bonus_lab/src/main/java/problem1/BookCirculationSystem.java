package problem1;

public interface BookCirculationSystem {

  Boolean isEmpty();

  Boolean addBook(Book book);

  Boolean removeBook(Book book) throws BookNotFoundException;

  Boolean findBook(Book book);

  Integer getNumBooks();

  Book getRandomBook();

  Book getBasedOnISBN(String ISBN) throws InvalidISBNException, BookNotFoundException;
}
