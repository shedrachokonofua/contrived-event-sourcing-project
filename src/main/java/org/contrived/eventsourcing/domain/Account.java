package org.contrived.eventsourcing.domain;

import java.util.UUID;

public class Account {
  final public UUID uuid;
  final public Customer holder;
  private Money balance;

  public static class InsufficientBalanceError extends RuntimeException {
    public InsufficientBalanceError() {
      super("Insufficient balance.");
    }
  }

  public Account(UUID uuid, Customer holder, Money balance) {
    this.uuid = uuid;
    this.holder = holder;
    this.balance = balance;
  }

  public Account(Customer holder, Money balance) {
    this.uuid = UUID.randomUUID();
    this.holder = holder;
    this.balance = balance;
  }

}
