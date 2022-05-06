package P1;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/*
Class MobileApp contains information about a mobile app - app's name, app's category,
current version, current size, developers, requested permissions, date of original release,
and date of the latest update.
 */
public class MobileApp {

  private String appName;
  private MobileAppCategory appCategory;
  private Float currentVersion;
  private Float currentSize;
  private List<Name> developers;
  private List<String> requestedPermissions;
  private LocalDate dateOfOriginalRelease;
  private LocalDate dateOfLatestUpdate;

  public MobileApp(String appName, MobileAppCategory appCategory, Float currentVersion,
      Float currentSize,
      List<Name> developers, List<String> requestedPermissions, LocalDate dateOfOriginalRelease,
      LocalDate dateOfLatestUpdate) {
    this.appName = appName;
    this.appCategory = appCategory;
    this.currentVersion = currentVersion;
    this.currentSize = currentSize;
    this.developers = developers;
    this.requestedPermissions = requestedPermissions;
    this.dateOfOriginalRelease = dateOfOriginalRelease;
    this.dateOfLatestUpdate = dateOfLatestUpdate;
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
        Objects.equals(getDateOfLatestUpdate(), mobileApp.getDateOfLatestUpdate());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getAppName(), getAppCategory(), getCurrentVersion(),
        getCurrentSize(), getDevelopers(), getRequestedPermissions(), getDateOfOriginalRelease(),
        getDateOfLatestUpdate());
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
        '}';
  }
}
