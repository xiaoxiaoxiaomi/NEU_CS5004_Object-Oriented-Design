/**
 * This class stores information about an author. The stored information includes name, email and
 * address.
 */
public class Author {

  private final Name name;
  private final String email;
  private final String address;

  /**
   * Create a new author given the author's name, email and address as strings.
   *
   * @param name    the author's name
   * @param email   the author's email address
   * @param address the author's physical address
   */
  public Author(Name name, String email, String address) {
    this.name = name;
    this.email = email;
    this.address = address;
  }

  /**
   * @return the name
   */
  public Name getName() {
    return name;
  }

  /**
   * @return the email
   */
  public String getEmail() {
    return email;
  }

  /**
   * @return the address
   */
  public String getAddress() {
    return address;
  }
}
