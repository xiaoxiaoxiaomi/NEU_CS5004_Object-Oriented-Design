package midterm.p2;

/**
 * This is an interface for NationalParkDirectory
 */
public interface INationalParkDirectory {

  /**
   * Count the number of NationalParks in the NationalParkDirectory
   *
   * @return the number of NationalParks in the NationalParkDirectory
   */
  Integer count();

  /**
   * Check if a specified NationalPark is included in the NationalParkDirectory.
   *
   * @param nationalPark - national park, encoded as NationalPark
   * @return true if the given national park is in the NationalParkDirectory, otherwise return False
   */
  Boolean contains(NationalPark nationalPark);

  /**
   * Add a new National Park to the NationalParkDirectory.
   *
   * @param nationalPark - national park, encoded as NationalPark
   */
  void add(NationalPark nationalPark);


  /**
   * Modify the national park’s area about an existing NationalPark
   *
   * @param nationalPark - national park, encoded as NationalPark
   * @param area         - area, encoded as Double
   * @throws NationalParkNotFoundException if the NationalPark requested to be modified does not
   *                                       exist in the NationalParkDirectory
   */
  void modifyArea(NationalPark nationalPark, Double area) throws NationalParkNotFoundException;

  /**
   * Modify the national park’s visitor centers about an existing NationalPark
   *
   * @param nationalPark   - national park, encoded as NationalPark
   * @param visitorCenters - visitor centers, encoded as String[]
   * @throws NationalParkNotFoundException if the NationalPark requested to be modified does not
   *                                       exist in the NationalParkDirectory
   */
  void modifyVisitorCenters(NationalPark nationalPark, String[] visitorCenters)
      throws NationalParkNotFoundException;

  /**
   * Remove a specified NationalPark from the NationalParkDirectory
   *
   * @param nationalPark - national park, encoded as NationalPark
   * @throws NationalParkNotFoundException if the NationalPark does not exist in the
   *                                       NationalParkDirectory
   */
  void remove(NationalPark nationalPark) throws NationalParkNotFoundException;

  /**
   * Find and return any one NationalPark from the NationalParkDirectory that is located within the
   * same state
   *
   * @param state - state, encoded as String
   * @return any one NationalPark from the NationalParkDirectory that is located within the same
   * state
   */
  NationalPark oneNationalParkInState(String state);

  /**
   * Find and return all National Park from the NationalParkDirectory that are located within the
   * same state
   *
   * @param state - state, encoded as String
   * @return all National Park from the NationalParkDirectory that are located within the same state
   */
  NationalPark[] allNationalParkInState(String state);

  /**
   * Find and return all NationalParks from the NationalParkDirectory that are opened year round
   *
   * @return all NationalParks from the NationalParkDirectory that are opened year round
   */
  NationalPark[] allNationalParkOpenedYearRound();

  /**
   * Get a NationalPark from the NationalParkDirectorySystem based upon the NationalPark’s unique
   * identifier, nationalParkID
   *
   * @param nationalParkID - national park ID, encoded as String
   * @return a NationalPark from the NationalParkDirectorySystem based upon nationalParkID
   * @throws InvalidNationalParkIDException if the given unique ID does not exist
   */
  NationalPark getNationalParkByID(String nationalParkID) throws InvalidNationalParkIDException;
}
