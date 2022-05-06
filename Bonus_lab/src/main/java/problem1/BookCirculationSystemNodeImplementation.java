package problem1;

public class BookCirculationSystemNodeImplementation implements BookCirculationSystem {

  private static final Integer TEN_DIGITS = 10;
  private BookNode firstBook;
  private Integer numBooks;

  public BookCirculationSystemNodeImplementation(BookNode firstBook, Integer numBooks) {
    this.firstBook = firstBook;
    this.numBooks = numBooks;
  }

  public BookCirculationSystemNodeImplementation(BookNode firstBook) {
    this.firstBook = firstBook;
    this.numBooks = 1;
  }

  @Override
  public Boolean isEmpty() {
    return this.numBooks.equals(0);
  }

  @Override
  public Boolean addBook(Book book) {
    BookNode newBook = new BookNode(book, this.firstBook);
    this.firstBook = newBook;
    this.numBooks++;
    return true;
  }

  @Override
  public Boolean removeBook(Book book) throws BookNotFoundException {
    if (this.findBook(book)) {
      BookNode currNode = this.firstBook;
      // remove first node
      if (currNode.getBook().equals(book)) {
        this.firstBook = currNode.getNextBookNode();
        return true;
      }
      BookNode previousNode = currNode;
      currNode = currNode.getNextBookNode();
      while (currNode != null) {
        if (currNode.getBook().equals(book)) {
          previousNode.setNextBookNode(currNode.getNextBookNode());
          return true;
        } else {
          previousNode = currNode;
          currNode = currNode.getNextBookNode();
        }
      }
    } else {
      throw new BookNotFoundException("This book is not a part of the circulation system!");
    }
    return false;
  }

  @Override
  public Boolean findBook(Book book) {
    BookNode currBook = this.firstBook;
    while (currBook != null) {
      if (currBook.getBook().equals(book)) {
        return true;
      } else {
        currBook = currBook.getNextBookNode();
      }
    }
    return false;
  }

  @Override
  public Integer getNumBooks() {
    return this.numBooks;
  }

  @Override
  public Book getRandomBook() {
    if (this.firstBook.getNextBookNode() != null) {
      return this.firstBook.getNextBookNode().getBook();
    } else {
      return this.firstBook.getBook();
    }
  }

  @Override
  public Book getBasedOnISBN(String ISBN) throws InvalidISBNException, BookNotFoundException {
    if (ISBN.length() != TEN_DIGITS) {
      throw new InvalidISBNException("Invalid ISBN");
    } else {
      BookNode currBook = this.firstBook;
      while (currBook != null) {
        if (currBook.getBook().getISBN().equals(ISBN)) {
          return currBook.getBook();
        } else {
          currBook = currBook.getNextBookNode();
        }
      }
      throw new BookNotFoundException("Book with this ISBN doesn't exist!");
    }
  }
}
