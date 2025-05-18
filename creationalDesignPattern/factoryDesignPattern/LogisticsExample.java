package creationalDesignPattern.factoryDesignPattern;

interface Logistics {

  void send();

}

class ByAir implements Logistics {
  @Override
  public void send() {
    System.out.println("Logistics handles via air.");
  }
}

class ByRoad implements Logistics {

  public void send() {
    System.err.println("Logistics handles via road.");
  }
}

class LogisticsFactory {

  public static Logistics getLogistics(String mode) {
    if (mode.equalsIgnoreCase("Road")) {
      return new ByRoad();
    } else if (mode.equalsIgnoreCase("Air")) {
      return new ByAir();
    }
    throw new IllegalArgumentException("Unknown logistics mode: " + mode);
  }
}

class LogisticsService {

  public static void send(String mode) {
    Logistics logistics = LogisticsFactory.getLogistics(mode);
    logistics.send();
  }
}

public class LogisticsExample {

  public static void main(String[] args) {

    LogisticsService.send("road");
  }

}
