package problem2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CatalogTest {

  Author author1;
  Author author2;
  Book book1;
  Book book2;
  Book book3;
  RecordingArtist artist1;
  RecordingArtist artist2;
  RecordingArtist artist3;
  HashSet<RecordingArtist> members;
  Band band;
  Music music1;
  Music music2;
  Music music3;
  ArrayList<Item> itemList;
  Catalog catalog1;
  Catalog catalog2;

  @BeforeEach
  void setUp() {
    author1 = new Author("authorF1", "authorL1");
    author2 = new Author("authorF2", "authorL2");
    book1 = new Book(author1, "abC", 2011);
    book2 = new Book(author2, "Bcd", 2012);
    book3 = new Book(author2, "cDe", 2013);
    artist1 = new RecordingArtist("artistF1", "artistL1");
    artist2 = new RecordingArtist("artistF2", "artistL2");
    artist3 = new RecordingArtist("artistF3", "artistL3");
    members = new HashSet<>(Arrays.asList(artist1, artist2));
    band = new Band("band", members);
    music1 = new Music(artist1, "deF", 2014);
    music2 = new Music(band, "Efg", 2015);
    music3 = new Music(artist3, "fGh", 2016);
    itemList = new ArrayList<>(Arrays.asList(book1, book2, book3, music1, music2, music3));
    catalog1 = new Catalog();
    catalog2 = new Catalog(itemList);
  }

  @Test
  void getFirstName() {
    assertEquals("authorF1", author1.getFirstName());
  }

  @Test
  void getLastName() {
    assertEquals("artistL2", artist2.getLastName());
  }

  @Test
  void getName() {
    assertEquals("band", band.getName());
  }

  @Test
  void getYear() {
    assertEquals(2011, book1.getYear());
  }

  @Test
  void add() {
    catalog1.add(book1);
    catalog1.add(music1);
    Catalog expectedCatalog = new Catalog(new ArrayList<>(Arrays.asList(music1, book1)));
    assertEquals(expectedCatalog, catalog1);
  }

  @Test
  void remove() {
    catalog2.remove(book2);
    catalog2.remove(music2);
    Catalog expectedCatalog = new Catalog(
        new ArrayList<>(Arrays.asList(music3, music1, book1, book3)));
    assertEquals(expectedCatalog, catalog2);
  }

  @Test
  void search_Keyword() {
    ArrayList<Item> expectedItemList = new ArrayList<>(Arrays.asList(book2, book3, music1));
    assertEquals(expectedItemList, catalog2.search("D"));
  }

  @Test
  void search_Author() {
    ArrayList<Item> expectedItemList = new ArrayList<>(Arrays.asList(book2, book3));
    assertEquals(expectedItemList, catalog2.search(author2));
  }

  @Test
  void search_Artist() {
    ArrayList<Item> expectedItemList1 = new ArrayList<>(Arrays.asList(music1, music2));
    assertEquals(expectedItemList1, catalog2.search(artist1));
    ArrayList<Item> expectedItemList2 = new ArrayList<>(Arrays.asList(music3));
    assertEquals(expectedItemList2, catalog2.search(artist3));
  }

  @Test
  void testEquals_SameObject() {
    assertTrue(author1.equals(author1));
    assertTrue(band.equals(band));
    assertTrue(book1.equals(book1));
    assertTrue(catalog2.equals(catalog2));
  }

  @Test
  void testEquals_DifferentObject() {
    assertFalse(author1.equals(band));
    assertFalse(band.equals(artist1));
    assertFalse(book1.equals(catalog1));
    assertFalse(catalog2.equals(itemList));
  }

  @Test
  void testEquals_NullObject() {
    assertFalse(author1.equals(null));
    assertFalse(band.equals(null));
    assertFalse(book1.equals(null));
    assertFalse(catalog2.equals(null));
  }

  @Test
  void testEquals_DifferentFirstName() {
    Author testAuthor = new Author("F1", "authorL1");
    assertFalse(author1.equals(testAuthor));
  }

  @Test
  void testEquals_DifferentLastName() {
    Author testAuthor = new Author("authorF1", "L1");
    assertFalse(author1.equals(testAuthor));
  }

  @Test
  void testEquals_DifferentName() {
    Band testBand = new Band("anotherBand", members);
    assertFalse(band.equals(testBand));
  }

  @Test
  void testEquals_DifferentMembers() {
    HashSet<RecordingArtist> testMembers = new HashSet<>(Arrays.asList(artist2, artist3));
    Band testBand = new Band("band", testMembers);
    assertFalse(band.equals(testBand));
  }

  @Test
  void testEquals_DifferentCreator() {
    Book testBook = new Book(author2, "abC", 2011);
    assertFalse(book1.equals(testBook));
  }

  @Test
  void testEquals_DifferentTitle() {
    Book testBook = new Book(author1, "cba", 2011);
    assertFalse(book1.equals(testBook));
  }

  @Test
  void testEquals_DifferentYear() {
    Book testBook = new Book(author1, "abC", 2012);
    assertFalse(book1.equals(testBook));
  }

  @Test
  void testEquals_DifferentItemList() {
    assertFalse(catalog2.equals(catalog1));
  }

  @Test
  void testEquals_SameFieldsOverall() {
    // Individual
    Author testAuthor = new Author("authorF1", "authorL1");
    assertTrue(author1.equals(testAuthor));
    // Band
    HashSet<RecordingArtist> testMembers = new HashSet<>(Arrays.asList(artist1, artist2));
    Band testBand = new Band("band", testMembers);
    assertTrue(band.equals(testBand));
    // Item
    Book testBook = new Book(author1, "abC", 2011);
    assertTrue(book1.equals(testBook));
    // Catalog
    ArrayList<Item> testItemList = new ArrayList<>(
        Arrays.asList(book1, book2, book3, music1, music2, music3));
    Catalog testCatalog = new Catalog(testItemList);
    assertTrue(catalog2.equals(testCatalog));
  }

  @Test
  void testHashCode() {
    int expectedHashCode = Objects.hash(
        itemList.stream().collect(Collectors.groupingBy(p -> p, Collectors.counting())));
    assertEquals(expectedHashCode, catalog2.hashCode());
  }

  @Test
  void testToString() {
    String expectedString = "Catalog{" +
        "itemList=" + itemList.toString() +
        '}';
    assertEquals(expectedString, catalog2.toString());
  }
}