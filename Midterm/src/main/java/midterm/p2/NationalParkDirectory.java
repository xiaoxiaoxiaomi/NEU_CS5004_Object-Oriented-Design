package midterm.p2;

import java.util.Arrays;

/**
 * Class NationalParkDirectory is used to store and manage information about the US national parks
 */
public class NationalParkDirectory implements INationalParkDirectory {

  private NationalPark[] directory;

  public NationalParkDirectory() {
    this.directory = new NationalPark[0];
  }

  public NationalParkDirectory(NationalPark[] directory) {
    this.directory = directory;
  }

  /**
   * Count the number of NationalParks in the NationalParkDirectory
   *
   * @return the number of NationalParks in the NationalParkDirectory
   */
  @Override
  public Integer count() {
    return this.directory.length;
  }

  /**
   * Check if a specified NationalPark is included in the NationalParkDirectory.
   *
   * @param nationalPark - national park, encoded as NationalPark
   * @return true if the given national park is in the NationalParkDirectory, otherwise return False
   */
  @Override
  public Boolean contains(NationalPark nationalPark) {
    for (NationalPark park : this.directory) {
      if (park == nationalPark) {
        return true;
      }
    }
    return false;
  }

  /**
   * Add a new National Park to the NationalParkDirectory.
   *
   * @param nationalPark - national park, encoded as NationalPark
   */
  @Override
  public void add(NationalPark nationalPark) {
    if (!this.contains(nationalPark)) {
      NationalPark[] newDirectory = new NationalPark[this.directory.length + 1];
      System.arraycopy(this.directory, 0, newDirectory, 0, this.directory.length);
      newDirectory[this.directory.length] = nationalPark;
      this.directory = newDirectory;
    }
  }

  /**
   * Modify the national park’s area about an existing NationalPark
   *
   * @param nationalPark - national park, encoded as NationalPark
   * @param area         - area, encoded as Double
   * @throws NationalParkNotFoundException if the NationalPark requested to be modified does not
   *                                       exist in the NationalParkDirectory
   */
  @Override
  public void modifyArea(NationalPark nationalPark, Double area)
      throws NationalParkNotFoundException {
    if (!this.contains(nationalPark)) {
      throw new NationalParkNotFoundException(
          "The NationalPark requested to be modified does not exist!");
    }
    for (NationalPark park : this.directory) {
      if (park == nationalPark) {
        park.setArea(area);
      }
    }
  }

  /**
   * Modify the national park’s visitor centers about an existing NationalPark
   *
   * @param nationalPark   - national park, encoded as NationalPark
   * @param visitorCenters - visitor centers, encoded as String[]
   * @throws NationalParkNotFoundException if the NationalPark requested to be modified does not
   *                                       exist in the NationalParkDirectory
   */
  @Override
  public void modifyVisitorCenters(NationalPark nationalPark, String[] visitorCenters)
      throws NationalParkNotFoundException {
    if (!this.contains(nationalPark)) {
      throw new NationalParkNotFoundException(
          "The NationalPark requested to be modified does not exist!");
    }
    for (NationalPark park : this.directory) {
      if (park == nationalPark) {
        park.setVisitorCenters(visitorCenters);
      }
    }
  }

  /**
   * Remove a specified NationalPark from the NationalParkDirectory
   *
   * @param nationalPark - national park, encoded as NationalPark
   * @throws NationalParkNotFoundException if the NationalPark does not exist in the
   *                                       NationalParkDirectory
   */
  @Override
  public void remove(NationalPark nationalPark) throws NationalParkNotFoundException {
    if (!this.contains(nationalPark)) {
      throw new NationalParkNotFoundException(
          "The NationalPark requested to be removed does not exist!");
    }
    NationalPark[] newDirectory = new NationalPark[this.directory.length - 1];
    int i = 0;
    for (NationalPark park : this.directory) {
      if (park != nationalPark) {
        newDirectory[i++] = park;
      }
    }
    this.directory = newDirectory;
  }

  /**
   * Find and return any one NationalPark from the NationalParkDirectory that is located within the
   * same state
   *
   * @param state - state, encoded as String
   * @return any one NationalPark from the NationalParkDirectory that is located within the same
   * state
   */
  @Override
  public NationalPark oneNationalParkInState(String state) {
    for (NationalPark park : this.directory) {
      if (park.getState() == state) {
        return park;
      }
    }
    return null;
  }

  /**
   * Find and return all National Park from the NationalParkDirectory that are located within the
   * same state
   *
   * @param state - state, encoded as String
   * @return all National Park from the NationalParkDirectory that are located within the same state
   */
  @Override
  public NationalPark[] allNationalParkInState(String state) {
    NationalPark[] newDirectory = new NationalPark[this.directory.length];
    int i = 0;
    for (NationalPark park : this.directory) {
      if (park.getState() == state) {
        newDirectory[i++] = park;
      }
    }
    NationalPark[] ans = new NationalPark[i];
    System.arraycopy(newDirectory, 0, ans, 0, i);
    return ans;
  }

  /**
   * Find and return all NationalParks from the NationalParkDirectory that are opened year round
   *
   * @return all NationalParks from the NationalParkDirectory that are opened year round
   */
  @Override
  public NationalPark[] allNationalParkOpenedYearRound() {
    NationalPark[] newDirectory = new NationalPark[this.directory.length];
    int i = 0;
    for (NationalPark park : this.directory) {
      if (park.getOpenYearRound()) {
        newDirectory[i++] = park;
      }
    }
    NationalPark[] ans = new NationalPark[i];
    System.arraycopy(newDirectory, 0, ans, 0, i);
    return ans;
  }

  /**
   * Get a NationalPark from the NationalParkDirectorySystem based upon the NationalPark’s unique
   * identifier, nationalParkID
   *
   * @param nationalParkID - national park ID, encoded as String
   * @return a NationalPark from the NationalParkDirectorySystem based upon nationalParkID
   * @throws InvalidNationalParkIDException if the given unique ID does not exist
   */
  @Override
  public NationalPark getNationalParkByID(String nationalParkID)
      throws InvalidNationalParkIDException {
    for (NationalPark park : this.directory) {
      if (park.getNationalParkID() == nationalParkID) {
        return park;
      }
    }
    throw new InvalidNationalParkIDException("The given unique ID does not exist");
  }
}
