package problem1;

import java.time.LocalDateTime;

public class Meat extends PerishableFoodItem{

  public Meat(String name, Double currentPrice, Integer currentQuantity,
      Integer maxAllowedQuantity, LocalDateTime orderDate,
      LocalDateTime expirationDate) {
    super(name, currentPrice, currentQuantity, maxAllowedQuantity, orderDate, expirationDate);
  }
}
