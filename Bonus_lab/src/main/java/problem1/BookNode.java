package problem1;

import java.util.Objects;

public class BookNode {

  private Book book;
  private BookNode nextBookNode;

  public BookNode(Book book, BookNode nextBookNode) {
    this.book = book;
    this.nextBookNode = nextBookNode;
  }

  public Book getBook() {
    return book;
  }

  public void setBook(Book book) {
    this.book = book;
  }

  public BookNode getNextBookNode() {
    return nextBookNode;
  }

  public void setNextBookNode(BookNode nextBookNode) {
    this.nextBookNode = nextBookNode;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BookNode bookNode = (BookNode) o;
    return Objects.equals(book, bookNode.book) && Objects.equals(nextBookNode,
        bookNode.nextBookNode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(book, nextBookNode);
  }

  @Override
  public String toString() {
    return "BookNode{" +
        "book=" + book +
        ", nextBookNode=" + nextBookNode +
        '}';
  }
}
