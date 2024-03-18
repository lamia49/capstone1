package com.example.amzon.Model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MerchantStock {
    @NotNull(message = "id must be not empty")
    private Integer id;
   @NotNull(message = " merchantid must be not empty")
    private Integer  merchantId;
    @NotNull(message = "Stock must be not empty")
    @Min(value = 10,message = "must be more then 10")
    private Integer stock;


}
