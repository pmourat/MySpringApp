package com.myexample.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@Builder
public class Order {

    private final UUID id;

    private final String orderNumber;

    private final LocalDateTime orderDate;

    private final UUID customerId;


}
