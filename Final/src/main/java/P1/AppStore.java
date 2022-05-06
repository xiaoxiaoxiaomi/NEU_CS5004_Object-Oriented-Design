package P1;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/*
Class AppStore contains information about two different categories of apps - approved apps,
and apps currently under review, for approval and addition to the app store. Approved apps
are stored into a map, where the app represents the key, and the number of downloads,
represented as an Integer is the corresponding value.
 */
public class AppStore {

  private Map<MobileApp, Integer> approvedApps;
  private List<MobileApp> appsUnderReview;

  public AppStore(Map<MobileApp, Integer> approvedApps, List<MobileApp> appsUnderReview) {
    this.approvedApps = approvedApps;
    this.appsUnderReview = appsUnderReview;
  }

  public Map<MobileApp, Integer> getApprovedApps() {
    return approvedApps;
  }

  public List<MobileApp> getAppsUnderReview() {
    return appsUnderReview;
  }

  /**
   * Method takes a requested category and a requested date, creates a stream of the approved
   * apps(Note: use keySet() to extract keys from the map), filters the stream to only contains the
   * approved apps which belong to the requested category and originally released after the
   * requested date, and then uses the collect method to transform the stream to list.
   *
   * @param requestedCategory - requested category of the approved apps to filter out, as a
   *                          MobileAppCategory
   * @param requestedDate     - LocalDate representing date cutoff for our filter
   * @return list of approved apps in requested category and originally released after the requested
   * date
   */
  public List<MobileApp> mysteryMethod(MobileAppCategory requestedCategory,
      LocalDate requestedDate) {
    return this.approvedApps.keySet().stream()
        .filter(x -> x.getAppCategory().equals(requestedCategory))
        .filter(y -> y.getDateOfOriginalRelease().isAfter(requestedDate))
        .collect(Collectors.toList());
  }

  /**
   * (Note: change to public for testing) Method takes a max number of permissions and two
   * permissions, creates a stream of apps currently under review, filters the stream to only
   * contains the apps which are requesting at most the number of permissions defined by the input
   * and are not requesting any of the permissions provided, and then uses the collect method to
   * transform the stream to list.
   *
   * @param maxNumPermissions - integer representing the number of permissions cutoff for our
   *                          filter
   * @param permission1       - one of the permissions the apps are not allowed request, as String
   * @param permission2       - the other one of the permissions the apps are not allowed request,
   *                          as String
   * @return list of apps currently under review which are requesting at most the number of
   * permissions defined by the input and are not requesting any of the permissions provided
   */
  public List<MobileApp> filterByRequestedPermissions(Integer maxNumPermissions,
      String permission1,
      String permission2) {
    //YOUR CODE HERE
    return appsUnderReview.stream()
        .filter(x -> x.getRequestedPermissions().size() <= maxNumPermissions &&
            !x.getRequestedPermissions().contains(permission1) &&
            !x.getRequestedPermissions().contains(permission2))
        .collect(Collectors.toList());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof AppStore)) {
      return false;
    }
    AppStore appStore = (AppStore) o;
    return Objects.equals(getApprovedApps(), appStore.getApprovedApps()) &&
        Objects.equals(getAppsUnderReview(), appStore.getAppsUnderReview());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getApprovedApps(), getAppsUnderReview());
  }

  @Override
  public String toString() {
    return "AppStore{" +
        "approvedApps=" + approvedApps +
        ", appsUnderReview=" + appsUnderReview +
        '}';
  }
}
