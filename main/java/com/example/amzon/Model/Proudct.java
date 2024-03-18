package com.example.amzon.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Proudct {
   @NotNull(message = "not empty")
    private Integer id;
    @NotEmpty(message = "id must be not empty")
    @Size(min = 3,message = "must be mor then 3 ")
    private String name;
    @Positive
    @NotNull(message = "price must be not empty")
    private double price;
    @NotNull(message = " Category ID must be not empty ")
    private Integer categoryID;

}
