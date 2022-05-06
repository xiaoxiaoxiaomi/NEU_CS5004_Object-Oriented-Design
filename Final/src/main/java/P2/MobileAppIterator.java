package P2;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Collectors;

public class MobileAppIterator implements Iterator<MobileApp> {

  private static final LocalDate ORIGINAL_RELEASE_DATE_THRESHOLD = LocalDate.of(2017, 1, 1);
  private static final String PERMISSION_PHOTOS = "PHOTOS";
  private static final String PERMISSION_MESSAGES = "MESSAGES";
  private static final String PERMISSION_LOCATION = "LOCATION";
  private List<MobileApp> mobileAppList;

  public MobileAppIterator(List<MobileApp> mobileAppList) {
    this.mobileAppList = filterMobileAppList(mobileAppList);
  }

  private List<MobileApp> filterMobileAppList(List<MobileApp> mobileAppList) {
    return mobileAppList.stream()
        .filter(x -> x.getDateOfOriginalRelease().isAfter(ORIGINAL_RELEASE_DATE_THRESHOLD))
        .filter(y -> y.getAppCategory().equals(MobileAppCategory.EDUCATIONAL_APP)
            || y.getAppCategory().equals(MobileAppCategory.PRODUCTIVITY_APP))
        .filter(z -> !z.getRequestedPermissions().contains(PERMISSION_PHOTOS)
            && !z.getRequestedPermissions().contains(PERMISSION_MESSAGES)
            && !z.getRequestedPermissions().contains(PERMISSION_LOCATION))
        .collect(Collectors.toList());
  }

  /**
   * Returns {@code true} if the iteration has more elements. (In other words, returns {@code true}
   * if {@link #next} would return an element rather than throwing an exception.)
   *
   * @return {@code true} if the iteration has more elements
   */
  @Override
  public boolean hasNext() {
    return this.mobileAppList.size() > 0;
  }

  /**
   * Returns the next element in the iteration.
   *
   * @return the next element in the iteration
   * @throws NoSuchElementException if the iteration has no more elements
   */
  @Override
  public MobileApp next() {
    return this.mobileAppList.remove(0);
  }

  public List<MobileApp> getMobileAppList() {
    return mobileAppList;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MobileAppIterator that = (MobileAppIterator) o;
    return Objects.equals(mobileAppList, that.mobileAppList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mobileAppList);
  }

  @Override
  public String toString() {
    return "MobileAppIterator{" +
        "mobileAppList=" + mobileAppList +
        '}';
  }
}
