package com.example.amzon.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
@NotNull(message = "id must be not empty")
    private Integer id;
@NotEmpty(message = "username must be not empty")
@Size(min = 6,message = "user name must be mor then 5")
    private String  username;
    @NotEmpty
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d).{7,}$" , message = "password only digits and charcters , and must be mor then 6")
    private String password;
    @Email(message ="must be valid email ")
    private String email;
    @NotEmpty(message = "role must be not null")
    @Pattern(regexp ="^(Admin|Customer)$",message = "role must be admin or customer")
    private String role;
    @NotNull(message = "balance must be not empty")
    @Positive(message = "balance must be only postive number")
    private double balance;

}
