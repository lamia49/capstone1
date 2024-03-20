package com.example.amzon.Controller;

import com.example.amzon.Model.MerchantStock;
import com.example.amzon.Service.MerchantService;
import com.example.amzon.Service.MerchantStockService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/marchent_stock")
public class MerchantStockController {
    private final MerchantStockService merchantStockService;

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid MerchantStock merchantStock, Errors error) {
        if (error.hasErrors()) {
            String massege = error.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(massege);
        }
        merchantStockService.add(merchantStock);
        return ResponseEntity.status(200).body("added");
    }

    @GetMapping("/get")
    public ResponseEntity get() {
        return ResponseEntity.status(200).body(merchantStockService.get());
    }


    @PutMapping("/update/{id}")
    public ResponseEntity updste(@PathVariable int id,@PathVariable int merchentId, @RequestBody @Valid MerchantStock merchantStock, Errors error) {
        if (error.hasErrors()) {
            String massege = error.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(massege);
        }

        boolean isFounf = merchantStockService.update(id,merchentId,merchantStock);
        if (isFounf) {
            return ResponseEntity.status(200).body("updated");
        }
        return ResponseEntity.status(400).body("not Found");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable int id){
        boolean isFound= merchantStockService.delete(id);
        if (isFound) {
            return ResponseEntity.status(200).body("deleted");
        }
        return ResponseEntity.status(400).body("not Found");
    }
    }
