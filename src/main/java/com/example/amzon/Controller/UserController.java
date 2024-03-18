package com.example.amzon.Controller;

import com.example.amzon.Model.MerchantStock;
import com.example.amzon.Model.User;
import com.example.amzon.Service.MerchantStockService;
import com.example.amzon.Service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class UserController {
   private final UserService userService;



    @PostMapping("add")
    public ResponseEntity add(@RequestBody @Valid User user , Errors error){
        if(error.hasErrors()){
            String massege= error.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(massege);
        }

        userService.add(user);
        return ResponseEntity.status(200).body("added");}

    @GetMapping("/get")
    public ResponseEntity get(){
        return ResponseEntity.status(200).body(userService.get());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable int id ,@RequestBody @Valid User user,Errors error){
        if(error.hasErrors()){
            String massege= error.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(massege);
        }
        boolean isFound= userService.update(id,user);
        if(isFound){
            return ResponseEntity.status(200).body("updated");
        }
        return ResponseEntity.status(400).body("not found");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable int id){
        boolean isFound= userService.delete(id);
        if(isFound){
            return ResponseEntity.status(200).body("deleted");
        }
        return ResponseEntity.status(400).body("notfound");
    }


    @PutMapping("/addStock/{idMarchents}/{ProudctId}/{amount}")
    public ResponseEntity addStock(@PathVariable int  idMarchents ,@PathVariable int ProudctId,@PathVariable int amount){
        boolean check=userService.addToStock(idMarchents,ProudctId,amount);
        if(check){
            return ResponseEntity.status(200).body("add successfully");
        }
        return ResponseEntity.status(400).body("bad requst ");
    }

    @PutMapping("/buy/{userId}/{ProudctId}/{idMarchents}")

    public ResponseEntity buy(@PathVariable  int userId ,@PathVariable int ProudctId ,@PathVariable int idMarchents ){
        boolean pay=userService.buy(userId,ProudctId,idMarchents);
        if(pay){
            return ResponseEntity.status(200).body("buy successfully");
        }
        return ResponseEntity.status(400).body("bad Requset");
    }

    @PutMapping("/refund/{userId1}/{userId2}/{proudectID}")

    public ResponseEntity refund(@PathVariable int userId1 ,@PathVariable int userId2,@PathVariable int proudectID){

        boolean refund=userService.refund(userId1,userId2,proudectID);
        if(refund){
            return ResponseEntity.status(200).body("refund successfully");
        }
        return ResponseEntity.status(400).body("bad Request");
    }

    @PutMapping("/discount/{idUser}/{idProudect}/{discount}")
    public ResponseEntity offer(@PathVariable int idUser,@PathVariable int idProudect,@PathVariable double discount){
        boolean isFound= userService.discount(idUser,idProudect,discount);
        if(isFound){
            return ResponseEntity.status(200).body(" discount successfully");
        }
        return ResponseEntity.status(400).body("bad request");
    }

    }

