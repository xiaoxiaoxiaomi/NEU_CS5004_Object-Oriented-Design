package problem1;

public class User {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private Credentials credentials;

    /**
     * Constructor, creating a new User object, with the provided
     first name, last name, phone number, email address and credential pair.
     * @param firstName - first name, encoded as String
     * @param lastName - last name, encoded as String
     * @param phoneNumber - phone number, encoded String, consisting of ten characters
     * @param email - email, encoded as String
     * @param credentials - credential pair, encoded as Credentials
     */
    public User(String firstName, String lastName, String phoneNumber, String email, Credentials credentials) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber.matches("^\\d{10}$") ? phoneNumber : "Not a phone number.";
        this.email = email;
        this.credentials = credentials;
    }

    /**
     * Returns the first name
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name to the given first name
     * @param firstName - first name, encoded as String
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns the last name
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name to the given last name
     * @param lastName - last name, encoded as String
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Returns the phone number
     * @return the phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets phone number to the given phone number
     * @param phoneNumber - phone number, encoded String, consisting of ten characters
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber.matches("^\\d{10}$") ? phoneNumber : "Not a phone number.";
    }

    /**
     * Returns the email
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email to the given email
     * @param email, encoded as String
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns the credentials
     * @return the credentials
     */
    public Credentials getCredentials() {
        return credentials;
    }

    /**
     * Sets credentials to the given credentials
     * @param credentials - credential pair, encoded as Credentials
     */
    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }
}
