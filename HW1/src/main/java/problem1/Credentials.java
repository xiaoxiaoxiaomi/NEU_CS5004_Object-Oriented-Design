package problem1;

import java.util.Objects;

/**
 Credentials is a simple class that keeps track of a pair (username, passwordHash), both encoded as Strings.
 Note: encoding a password as Strings is a bad and insecure practice, but please notice that we are *not* encoding a password as a String. Instead, we are storing information about a hash of a password.
 */
public class Credentials {
    private String username;
    private String passwordHash;

    /**
     * Constructor, creating a new Credentials object, with the provided
     username and password hash.
     * @param username - username, encoded as String
     * @param passwordHash - hash of the password, encoded as String
     */
    public Credentials(String username, String passwordHash) {
        this.username = username;
        this.passwordHash = passwordHash;
    }

    /**
     * Returns the username
     * @return the username
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Sets username to the given username
     * @param username - username, encoded as String
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Returns the hash of the password
     * @return the hash of the password
     */
    public String getPasswordHash() {
        return this.passwordHash;
    }

    /**
     * Sets the hash of the password to the given hash
     * @param passwordHash - hash of the password, encoded as String
     */
    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
}
