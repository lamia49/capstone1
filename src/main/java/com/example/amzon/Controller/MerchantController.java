package com.example.amzon.Controller;


import com.example.amzon.Model.Merchant;
import com.example.amzon.Service.MerchantService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/merchant")
public class MerchantController {

   private final MerchantService merchantService;

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid Merchant merchant , Errors error){
        if (error.hasErrors()) {
            String massege = error.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(massege);
        }
        merchantService.add(merchant);
        return ResponseEntity.status(200).body("added");
    }
@GetMapping("/get")
    public ResponseEntity get(){
        return ResponseEntity.status(200).body(merchantService.get());
    }


    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable int id ,@RequestBody @Valid Merchant merchant,Errors error){
        if (error.hasErrors()) {
            String massege = error.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(massege);
        }
       boolean isFound= merchantService.update(id,merchant);
        if(isFound){
            return ResponseEntity.status(200).body("updated");
        }
        return ResponseEntity.status(400).body("not Found");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable int id){
        boolean isFound= merchantService.delete(id);
        if(isFound){
            return ResponseEntity.status(200).body("deleted");
        }
        return ResponseEntity.status(400).body("not Found");
    }



}
