package P2;

import P1.Name;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/*
Class MobileApp contains information about a mobile app - app's name, app's category,
current version, current size, developers, requested permissions, date of original release,
date of the latest update, map of all the supported operating systems, and the
number of downloads for that operating system.
 */
public class MobileApp implements Comparable<MobileApp> {

  private String appName;
  private MobileAppCategory appCategory;
  private Float currentVersion;
  private Float currentSize;
  private List<P1.Name> developers;
  private List<String> requestedPermissions;
  private LocalDate dateOfOriginalRelease;
  private LocalDate dateOfLatestUpdate;
  private Map<String, Integer> supportedOS;

  public MobileApp(String appName, MobileAppCategory appCategory, Float currentVersion,
      Float currentSize,
      List<Name> developers, List<String> requestedPermissions, LocalDate dateOfOriginalRelease,
      LocalDate dateOfLatestUpdate, Map<String, Integer> supportedOS) {
    this.appName = appName;
    this.appCategory = appCategory;
    this.currentVersion = currentVersion;
    this.currentSize = currentSize;
    this.developers = developers;
    this.requestedPermissions = requestedPermissions;
    this.dateOfOriginalRelease = dateOfOriginalRelease;
    this.dateOfLatestUpdate = dateOfLatestUpdate;
    this.supportedOS = supportedOS;
  }

  public String getAppName() {
    return appName;
  }

  public MobileAppCategory getAppCategory() {
    return appCategory;
  }

  public Float getCurrentVersion() {
    return currentVersion;
  }

  public Float getCurrentSize() {
    return currentSize;
  }

  public List<Name> getDevelopers() {
    return developers;
  }

  public List<String> getRequestedPermissions() {
    return requestedPermissions;
  }

  public LocalDate getDateOfOriginalRelease() {
    return dateOfOriginalRelease;
  }

  public LocalDate getDateOfLatestUpdate() {
    return dateOfLatestUpdate;
  }

  public Map<String, Integer> getSupportedOS() {
    return supportedOS;
  }

  /**
   * Compares this object with the specified object for order.  Returns a negative integer, zero, or
   * a positive integer as this object is less than, equal to, or greater than the specified
   * object.
   *
   * <p>The implementor must ensure
   * {@code sgn(x.compareTo(y)) == -sgn(y.compareTo(x))} for all {@code x} and {@code y}.  (This
   * implies that {@code x.compareTo(y)} must throw an exception iff {@code y.compareTo(x)} throws
   * an exception.)
   *
   * <p>The implementor must also ensure that the relation is transitive:
   * {@code (x.compareTo(y) > 0 && y.compareTo(z) > 0)} implies {@code x.compareTo(z) > 0}.
   *
   * <p>Finally, the implementor must ensure that {@code x.compareTo(y)==0}
   * implies that {@code sgn(x.compareTo(z)) == sgn(y.compareTo(z))}, for all {@code z}.
   *
   * <p>It is strongly recommended, but <i>not</i> strictly required that
   * {@code (x.compareTo(y)==0) == (x.equals(y))}.  Generally speaking, any class that implements
   * the {@code Comparable} interface and violates this condition should clearly indicate this fact.
   *  The recommended language is "Note: this class has a natural ordering that is inconsistent with
   * equals."
   *
   * <p>In the foregoing description, the notation
   * {@code sgn(}<i>expression</i>{@code )} designates the mathematical
   * <i>signum</i> function, which is defined to return one of {@code -1},
   * {@code 0}, or {@code 1} according to whether the value of
   * <i>expression</i> is negative, zero, or positive, respectively.
   *
   * @param o the object to be compared.
   * @return a negative integer, zero, or a positive integer as this object is less than, equal to,
   * or greater than the specified object.
   * @throws NullPointerException if the specified object is null
   * @throws ClassCastException   if the specified object's type prevents it from being compared to
   *                              this object.
   */
  @Override
  public int compareTo(MobileApp o) {
    return Integer.compare(this.getTotalNumberOfDownloads(), o.getTotalNumberOfDownloads());
  }

  private int getTotalNumberOfDownloads() {
    return this.getSupportedOS().values().stream().mapToInt(i -> i).sum();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof MobileApp)) {
      return false;
    }
    MobileApp mobileApp = (MobileApp) o;
    return Objects.equals(getAppName(), mobileApp.getAppName()) &&
        getAppCategory() == mobileApp.getAppCategory() &&
        Objects.equals(getCurrentVersion(), mobileApp.getCurrentVersion()) &&
        Objects.equals(getCurrentSize(), mobileApp.getCurrentSize()) &&
        Objects.equals(getDevelopers(), mobileApp.getDevelopers()) &&
        Objects.equals(getRequestedPermissions(), mobileApp.getRequestedPermissions()) &&
        Objects.equals(getDateOfOriginalRelease(), mobileApp.getDateOfOriginalRelease()) &&
        Objects.equals(getDateOfLatestUpdate(), mobileApp.getDateOfLatestUpdate()) &&
        Objects.equals(getSupportedOS(), mobileApp.getSupportedOS());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getAppName(), getAppCategory(), getCurrentVersion(),
        getCurrentSize(), getDevelopers(), getRequestedPermissions(), getDateOfOriginalRelease(),
        getDateOfLatestUpdate(), getSupportedOS());
  }

  @Override
  public String toString() {
    return "MobileApp{" +
        "appName='" + appName + '\'' +
        ", appCategory=" + appCategory +
        ", currentVersion=" + currentVersion +
        ", currentSize=" + currentSize +
        ", developers=" + developers +
        ", requestedPermissions=" + requestedPermissions +
        ", dateOfOriginalRelease=" + dateOfOriginalRelease +
        ", dateOfLatestUpdate=" + dateOfLatestUpdate +
        ", supportedOS=" + supportedOS +
        '}';
  }
}
