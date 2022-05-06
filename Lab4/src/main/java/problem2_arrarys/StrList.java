package problem2_arrarys;

import java.util.Arrays;
import java.util.Objects;

public class StrList implements ListOfStrings {

  private Integer listSize;
  private String[] container;
  private static final Integer INITIAL_CAPACITY = 10;

  public StrList(Integer listSize, String[] container) {
    this.listSize = listSize;
    this.container = container;
  }

  public StrList() {
    this.listSize = 0;
    this.container = new String[INITIAL_CAPACITY];
  }

  @Override
  public Boolean isEmpty() {
    return (this.listSize.equals(0));
  }

  @Override
  public Integer size() {
    return this.listSize;
  }

  @Override
  public Boolean contains(String element) {
    for (int index = 0; index < this.listSize; index++) {
      if (this.container[index].equals(element)) {
        return Boolean.TRUE;
      }
    }
    return Boolean.FALSE;
  }

  @Override
  public Boolean containsAll(String[] elements) {
    for (String element : elements) {
      if (!this.contains(element)) {
        return false;
      }
    }
    return true;
  }

  private String getElement(Integer index) {
    if (index >= 0 && index <= this.listSize) {
      return this.container[index];
    }
    return null;
  }

  @Override
  public ListOfStrings filterLargerThan(Integer largerThanBound) {
    String[] newArray = new String[this.listSize];
    int newArrayIndex = 0;
    for (int index = 0; index < this.listSize; index++) {
      if (this.container[index].length() > largerThanBound) {
        newArray[newArrayIndex] = container[index];
      }
      newArrayIndex++;
    }
    return new StrList(newArrayIndex, newArray);
  }

  @Override
  public Boolean hasDuplicates() {
    for (int i = 0; i < this.listSize; i++) {
      for (int j = i + 1; j < this.listSize; j++) {
        if (Objects.equals(this.container[i], this.container[j])) {
          return true;
        }
      }
    }
    return false;
  }

  @Override
  public ListOfStrings removeDuplicates() {
    String[] newArray = new String[this.listSize];
    int newArrayIndex = 0;
    for (int i = 0; i < this.listSize; i++) {
      boolean exist = false;
      for (String s : newArray) {
        if (Objects.equals(s, this.container[i])) {
          exist = true;
          break;
        }
      }
      if (!exist) {
        newArray[newArrayIndex++] = this.container[i];
      }
    }
    return new StrList(newArrayIndex, newArray);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StrList strList = (StrList) o;
    return Objects.equals(listSize, strList.listSize) && Arrays.equals(container,
        strList.container);
  }

  @Override
  public int hashCode() {
    int result = Objects.hash(listSize);
    result = 31 * result + Arrays.hashCode(container);
    return result;
  }

  @Override
  public String toString() {
    return "StrList{" +
        "listSize=" + listSize +
        ", container=" + Arrays.toString(container) +
        '}';
  }
}
