package problem2and3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainSwimmerClass {

  private List<Swimmer> swimmers;

  public MainSwimmerClass(List<Swimmer> swimmers) {
    this.swimmers = swimmers;
  }

  public MainSwimmerClass() {
    this.swimmers = new ArrayList<>();
  }

  public static void main(String[] args) {
    MainSwimmerClass swimmersMain = new MainSwimmerClass();
    List<Double> freestyleTimes = new ArrayList<>();
    freestyleTimes.add(17.56);
    freestyleTimes.add(19.23);
    freestyleTimes.add(20.5);

    List<Double> nullTimes = new ArrayList<>();

    Swimmer swimmerA = new Swimmer("Michael Phelps", nullTimes, nullTimes, nullTimes,
        freestyleTimes);
    swimmersMain.swimmers.add(swimmerA);

    List<Double> freestyleTimes2 = new ArrayList<>();
    freestyleTimes2.add(17.56);
    freestyleTimes2.add(19.23);
    freestyleTimes2.add(20.0);
    freestyleTimes2.add(18.34);
    Swimmer swimmerB = new Swimmer("Johnny W", nullTimes, nullTimes, nullTimes, freestyleTimes2);
    swimmersMain.swimmers.add(swimmerB);

    List<Double> freestyleTimes3 = new ArrayList<>();
    freestyleTimes3.add(17.56);
    freestyleTimes3.add(19.23);
    freestyleTimes3.add(21.1);
    freestyleTimes3.add(18.34);
    freestyleTimes3.add(15.75);
    Swimmer swimmerC = new Swimmer("Luca B", nullTimes, nullTimes, nullTimes, freestyleTimes3);
    swimmersMain.swimmers.add(swimmerC);

    for (Swimmer swimmer : swimmersMain.swimmers) {
      System.out.println(swimmer);
    }

    Collections.sort(swimmersMain.swimmers);
    for (Swimmer swimmer : swimmersMain.swimmers) {
      StringBuilder stringToPrint = new StringBuilder(
          swimmer + swimmer.getAverageSwimTime(swimmer.getFreestyle50mTimes()).toString());
      System.out.println(stringToPrint);
    }

    FastestFreeStyleTimeComparator fastestFreeStyleTime = new FastestFreeStyleTimeComparator();
    swimmersMain.swimmers.sort(fastestFreeStyleTime);
    for (Swimmer swimmer : swimmersMain.swimmers) {
      StringBuilder stringToPrint = new StringBuilder(
          swimmer + swimmer.getFastestSwimTime(swimmer.getFreestyle50mTimes()).toString());
      System.out.println(stringToPrint);
    }

    Comparator<Swimmer> slowestSwimTime = new Comparator<Swimmer>() {
      @Override
      public int compare(Swimmer o1, Swimmer o2) {
        return o1.getSlowestSwimTime(o1.getFreestyle50mTimes())
            .compareTo(o2.getSlowestSwimTime(o2.getFreestyle50mTimes()));
      }
    };
    swimmersMain.swimmers.sort(slowestSwimTime);
    for (Swimmer swimmer : swimmersMain.swimmers) {
      StringBuilder stringToPrint = new StringBuilder(
          swimmer + swimmer.getSlowestSwimTime(swimmer.getFreestyle50mTimes()).toString());
      System.out.println(stringToPrint);
    }
  }
}
