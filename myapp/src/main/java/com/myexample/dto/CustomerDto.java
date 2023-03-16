package com.myexample.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class CustomerDto implements Serializable {

    private UUID id;

    private String firstName;

    private String surname;

    private String address;

    private String email;

}
