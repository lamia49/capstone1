package com.example.amzon.Controller;

import com.example.amzon.Model.Proudct;
import com.example.amzon.Service.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/products")
public class ProudctController {
   private final ProductService productService;



    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid Proudct proudct , Errors error){
        if(error.hasErrors()){
            String massege= error.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(massege);
        }
        productService.adding(proudct);
        return ResponseEntity.status(200).body("added");
    }
    @GetMapping("/get")
    public ResponseEntity get(){
        return ResponseEntity.status(200).body(productService.getting());
    }


    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable int id,@RequestBody @Valid Proudct proudct ,Errors error){
        if(error.hasErrors()){
            String massege= error.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(massege);
        }
        boolean isFound= productService.update(id,proudct);
        if(isFound){
            return  ResponseEntity.status(200).body("updated");
        }
         return ResponseEntity.status(200).body("Not found");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable int id){
        boolean isFound= productService.delete(id);
        if(isFound){
            return  ResponseEntity.status(200).body("deleted");
        }
        return ResponseEntity.status(200).body("Not found");
    }




    }



