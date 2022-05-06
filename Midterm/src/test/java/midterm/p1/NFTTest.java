package midterm.p1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NFTTest {
  Name testName1;
  Name testName2;
  Name testName3;
  Name[] testCreatorName;
  Name[] testOwnerName;
  Meme testMeme;
  DigitalArt testDigitalArt;
  Game testGame;
  Music testMusic;

  @BeforeEach
  void setUp() {
    testName1 = new Name("f1", "m1", "l1", "n1");
    testName2 = new Name("f2", "m2", "l2", "n2");
    testName3 = new Name("f3", "m3", "l3", "n3");
    testCreatorName = new Name[]{testName1, testName2};
    testOwnerName = new Name[]{testName3};
    testMeme = new Meme("meme", testCreatorName, testOwnerName, 1000.0, "BIT-123");
    testDigitalArt = new DigitalArt("digitalArt", testCreatorName, testOwnerName, 500.0, "ABC-456");
    testGame = new Game("game", testCreatorName, testOwnerName, 300.0, "ERC-721");
    testGame.setNumberOfDaysForAuction(61);
    testMusic = new Music("music", testCreatorName, testOwnerName, 800.0, "AAA-111");
    testMusic.setNumberOfDaysForAuction(62);
  }

  @Test
  void calculateStartingBid() {
    assertEquals(1000.0 * 1.25 * 1.2, testMeme.calculateStartingBid());
    testCreatorName = new Name[]{testName1, testName2, testName3};
    testMeme = new Meme("meme", testCreatorName, testOwnerName, 1000.0, "BIT-123");
    testMeme.setNumberOfDaysForAuction(16);
    assertEquals(1000.0 * 1.25 * 0.7, testMeme.calculateStartingBid());
    assertEquals(500.0 * 1.25, testDigitalArt.calculateStartingBid());
    assertEquals(300.0 * 1.25 * 0.6, testGame.calculateStartingBid());
    assertEquals(800.0 * 1.25, testMusic.calculateStartingBid());
  }
}