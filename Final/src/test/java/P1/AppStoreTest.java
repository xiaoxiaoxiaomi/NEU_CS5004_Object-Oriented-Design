package P1;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

class AppStoreTest {

  MobileApp mobileApp1;
  MobileApp mobileApp2;
  MobileApp mobileApp3;
  MobileApp mobileApp4;
  MobileApp mobileApp5;
  MobileApp mobileApp6;
  MobileApp mobileApp7;
  MobileApp mobileApp8;
  MobileApp mobileApp9;
  Map approvedApps;
  List<MobileApp> appsUnderReview;
  AppStore appStore;

  @BeforeEach
  void setUp() {
    mobileApp1 = new MobileApp("app1", MobileAppCategory.EDUCATIONAL_APP, 1.1f, 11.1f,
        new ArrayList<>(), new ArrayList<>(), LocalDate.of(2011, 1, 1), LocalDate.of(2021, 11, 11));
    mobileApp2 = new MobileApp("app2", MobileAppCategory.LIFESTYLE_APP, 2.2f, 22.2f,
        new ArrayList<>(), new ArrayList<>(), LocalDate.of(2012, 2, 2), LocalDate.of(2022, 2, 22));
    mobileApp3 = new MobileApp("app3", MobileAppCategory.EDUCATIONAL_APP, 3.3f, 33.3f,
        new ArrayList<>(), new ArrayList<>(), LocalDate.of(2013, 3, 3), LocalDate.of(2022, 3, 30));
    mobileApp4 = new MobileApp("app4", MobileAppCategory.GAME_APP, 4.4f, 44.4f,
        new ArrayList<>(), new ArrayList<>(), LocalDate.of(2014, 4, 4), LocalDate.of(2022, 4, 14));
    mobileApp5 = new MobileApp("app5", MobileAppCategory.GAME_APP, 5.5f, 55.5f,
        new ArrayList<>(), new ArrayList<>(), LocalDate.of(2015, 5, 5), LocalDate.of(2022, 5, 1));
    List<String> requestedPermissions1 = new ArrayList<>(
        Arrays.asList("permission1", "permission2", "permission3"));
    mobileApp6 = new MobileApp("app6", MobileAppCategory.ENTERTAINMENT_APP, 6.6f, 66.6f,
        new ArrayList<>(), requestedPermissions1, LocalDate.of(2016, 6, 6),
        LocalDate.of(2022, 4, 6));
    List<String> requestedPermissions2 = new ArrayList<>(
        Arrays.asList("permission4", "permission5"));
    mobileApp7 = new MobileApp("app7", MobileAppCategory.PRODUCTIVITY_APP, 7.7f, 77.7f,
        new ArrayList<>(), requestedPermissions2, LocalDate.of(2017, 7, 7),
        LocalDate.of(2022, 3, 17));
    List<String> requestedPermissions3 = new ArrayList<>(
        Arrays.asList("permission1", "permission2", "permission3", "permission4", "permission5"));
    mobileApp8 = new MobileApp("app8", MobileAppCategory.GAME_APP, 8.8f, 88.8f,
        new ArrayList<>(), requestedPermissions3, LocalDate.of(2018, 8, 8),
        LocalDate.of(2022, 2, 28));
    List<String> requestedPermissions4 = new ArrayList<>(
        Arrays.asList("permission1"));
    mobileApp9 = new MobileApp("app9", MobileAppCategory.SOCIAL_MEDIA_APP, 9.9f, 99.9f,
        new ArrayList<>(), requestedPermissions4, LocalDate.of(2019, 9, 9),
        LocalDate.of(2022, 1, 9));
    approvedApps = new HashMap<>();
    approvedApps.put(mobileApp1, 100);
    approvedApps.put(mobileApp2, 200);
    approvedApps.put(mobileApp3, 300);
    approvedApps.put(mobileApp4, 400);
    approvedApps.put(mobileApp5, 500);
    appsUnderReview = new ArrayList<>();
    appsUnderReview.add(mobileApp6);
    appsUnderReview.add(mobileApp7);
    appsUnderReview.add(mobileApp8);
    appsUnderReview.add(mobileApp9);
    appStore = new AppStore(approvedApps, appsUnderReview);
  }

  @Test
  void mysteryMethod() {
    List<MobileApp> expectedAppList1 = new ArrayList<>();
    expectedAppList1.add(mobileApp3);
    assertEquals(expectedAppList1,
        appStore.mysteryMethod(MobileAppCategory.EDUCATIONAL_APP, LocalDate.of(2012, 1, 1)));
    List<MobileApp> expectedAppList2 = new ArrayList<>();
    expectedAppList2.add(mobileApp4);
    expectedAppList2.add(mobileApp5);
    assertEquals(expectedAppList2,
        appStore.mysteryMethod(MobileAppCategory.GAME_APP, LocalDate.of(2013, 1, 1)));
    List<MobileApp> expectedAppList3 = new ArrayList<>();
    assertEquals(expectedAppList3,
        appStore.mysteryMethod(MobileAppCategory.SOCIAL_MEDIA_APP, LocalDate.of(2010, 1, 1)));
  }

  @Test
  void filterByRequestedPermissions() {
    List<MobileApp> expectedAppList1 = new ArrayList<>();
    expectedAppList1.add(mobileApp9);
    assertEquals(expectedAppList1, appStore.filterByRequestedPermissions(1, "permission2", "permission4"));
    List<MobileApp> expectedAppList2 = new ArrayList<>();
    expectedAppList2.add(mobileApp6);
    expectedAppList2.add(mobileApp9);
    assertEquals(expectedAppList2, appStore.filterByRequestedPermissions(5, "permission4", "permission5"));
    List<MobileApp> expectedAppList3 = new ArrayList<>();
    expectedAppList3.add(mobileApp6);
    expectedAppList3.add(mobileApp7);
    expectedAppList3.add(mobileApp8);
    expectedAppList3.add(mobileApp9);
    assertEquals(expectedAppList3, appStore.filterByRequestedPermissions(5, "permission6", "permission7"));
  }
}