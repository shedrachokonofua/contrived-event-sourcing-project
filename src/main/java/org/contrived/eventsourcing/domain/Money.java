package org.contrived.eventsourcing.domain;

import java.math.BigDecimal;

public class Money {
  public final BigDecimal value;

  public static class NegativeAmountError extends RuntimeException {
    public NegativeAmountError() {
      super("Amount must be positive.");
    }
  }

  private boolean isBigDecimalNegative(BigDecimal bigDecimal) {
    return bigDecimal.compareTo(BigDecimal.ZERO) < 0;
  }

  public Money(double amount) {
    this.value = new BigDecimal(amount);
  }

  private Money(BigDecimal amount) {
    if (isBigDecimalNegative(amount)) throw new NegativeAmountError();

    this.value = amount;
  }

  public Money add(Money operator) {
    BigDecimal resultValue = value.add(operator.value);
    return new Money(resultValue);
  }

  public Money subtract(Money operator) {
    BigDecimal resultValue = value.subtract(operator.value);
    return new Money(resultValue);
  }

  public Money divide(Money operator) {
    BigDecimal resultValue = value.divide(operator.value);
    return new Money(resultValue);
  }

  public Money multiply(Money operator) {
    BigDecimal resultValue = value.multiply(operator.value);
    return new Money(resultValue);
  }
}
