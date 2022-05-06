package problem1;

import java.util.Objects;

public class Book {
  private String bookName;
  private String author;
  private String ISBN;
  private Integer yearOfIssue;

  public Book(String bookName, String author, String ISBN, Integer yearOfIssue) {
    this.bookName = bookName;
    this.author = author;
    this.ISBN = ISBN;
    this.yearOfIssue = yearOfIssue;
  }

  public String getBookName() {
    return bookName;
  }

  public String getAuthor() {
    return author;
  }

  public String getISBN() {
    return ISBN;
  }

  public Integer getYearOfIssue() {
    return yearOfIssue;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Book book = (Book) o;
    return Objects.equals(bookName, book.bookName) && Objects.equals(author,
        book.author) && Objects.equals(ISBN, book.ISBN) && Objects.equals(
        yearOfIssue, book.yearOfIssue);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bookName, author, ISBN, yearOfIssue);
  }
}
