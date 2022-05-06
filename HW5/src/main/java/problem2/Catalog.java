package problem2;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Class Catalog stores a collection of all the items in the library
 */
public class Catalog {

  private ArrayList<Item> itemList;

  /**
   * Default constructor for class Catalog
   */
  public Catalog() {
    this.itemList = new ArrayList<>();
  }

  /**
   * Constructor for class Catalog which instantiates a Catalog specifying the items in the
   * collection
   *
   * @param itemList - a collection of all the items in the library, encoded as ArrayList
   */
  public Catalog(ArrayList<Item> itemList) {
    this.itemList = itemList;
  }

  /**
   * Add item to the collection
   *
   * @param item - item, encoded as Item
   */
  public void add(Item item) {
    this.itemList.add(item);
  }

  /**
   * Remove item from the collection
   *
   * @param item - item, encoded as Item
   */
  public void remove(Item item) {
    itemList.remove(item);
  }

  /**
   * Retrieve all items in the catalog, regardless of type, that have a title containing the
   * keyword
   *
   * @param keyword - keyword, encoded as String
   * @return list of items that have a title containing the keyword
   */
  public ArrayList<Item> search(String keyword) {
    ArrayList<Item> ans = new ArrayList<>();
    for (Item item : this.itemList) {
      if (item.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
        ans.add(item);
      }
    }
    return ans;
  }

  /**
   * Retrieve all items in the catalog that have an exact match for the given author.
   *
   * @param author - author, encoded as Author
   * @return list of items in the catalog that have an exact match for the given author.
   */
  public ArrayList<Item> search(Author author) {
    ArrayList<Item> ans = new ArrayList<>();
    for (Item item : this.itemList) {
      if (item.getCreator() == author) {
        ans.add(item);
      }
    }
    return ans;
  }

  /**
   * Retrieve all items in the catalog that have an exact match for the given artist.
   *
   * @param artist - artist, encoded as Artist
   * @return list of items in the catalog that have an exact match for the given artist.
   */
  public ArrayList<Item> search(RecordingArtist artist) {
    ArrayList<Item> ans = new ArrayList<>();
    for (Item item : this.itemList) {
      if (item.getCreator().containsArtist(artist)) {
        ans.add(item);
      }
    }
    return ans;
  }

  /**
   * Indicates whether some other object is "equal to" this one.
   *
   * @param o - the reference object with which to compare.
   * @return true if this object is the same as the obj argument; false otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Catalog catalog = (Catalog) o;
    Map<Item, Long> map1 = itemList.stream()
        .collect(Collectors.groupingBy(p -> p, Collectors.counting()));
    Map<Item, Long> map2 = catalog.itemList.stream()
        .collect(Collectors.groupingBy(p -> p, Collectors.counting()));
    return map1.equals(map2);
  }

  /**
   * Returns a hash code value for the object.
   *
   * @return a hash code value for this object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(itemList.stream()
        .collect(Collectors.groupingBy(p -> p, Collectors.counting())));
  }

  /**
   * Returns a string representation of the object.
   *
   * @return a string representation of the object.
   */
  @Override
  public String toString() {
    return "Catalog{" +
        "itemList=" + itemList +
        '}';
  }
}
