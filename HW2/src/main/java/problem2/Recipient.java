package problem2;

import java.util.Objects;

/**
 * Class Recipient stores information about recipient - first name, last name and email address
 */
public class Recipient {

  private final String firstName;
  private final String lastName;
  private final String emailAddress;

  /**
   * Constructor for the class Recipient
   *
   * @param firstName    - first name, encoded as String
   * @param lastName     - last name, encoded as String
   * @param emailAddress - email address, encoded as String
   */
  public Recipient(String firstName, String lastName, String emailAddress) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.emailAddress = emailAddress;
  }

  /**
   * Getter for first name
   *
   * @return - first name, encoded as String
   */
  public String getFirstName() {
    return this.firstName;
  }

  /**
   * Getter for last name
   *
   * @return - last name, encoded as String
   */
  public String getLastName() {
    return this.lastName;
  }

  /**
   * Getter for email address
   *
   * @return - email address, encoded as String
   */
  public String getEmailAddress() {
    return this.emailAddress;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Recipient recipient = (Recipient) o;
    return Objects.equals(this.firstName, recipient.firstName) && Objects.equals(
        this.lastName, recipient.lastName) && Objects.equals(this.emailAddress,
        recipient.emailAddress);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.firstName, this.lastName, this.emailAddress);
  }
}
