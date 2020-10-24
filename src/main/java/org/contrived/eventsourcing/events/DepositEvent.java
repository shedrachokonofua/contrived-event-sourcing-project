package org.contrived.eventsourcing.events;

import org.contrived.eventsourcing.domain.Money;

import java.util.UUID;

public class DepositEvent extends Event {
  private UUID depositorUUID;
  private Money amount;
}
