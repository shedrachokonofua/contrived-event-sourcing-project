package org.contrived.eventsourcing.domain;

import java.util.UUID;

public record Customer (
        UUID uuid,
        String name
) {}
