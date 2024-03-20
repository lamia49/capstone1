package com.example.amzon.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Merchant {
@NotNull(message = "id must be not empty")
    private Integer id;
@NotEmpty(message = "name must be not empty")
    @Size(min = 3, message = "name must have more then 3")
    private String name;
    private int numberOfPurchases;
}
