package com.myexample.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
@AllArgsConstructor
@Builder
public class Customer implements Serializable {

    private final UUID id;

    private final String name;

    private final String surname;

    private final String address;

    private final String email;





}
