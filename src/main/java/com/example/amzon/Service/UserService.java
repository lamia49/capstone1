package com.example.amzon.Service;

import com.example.amzon.Model.Merchant;
import com.example.amzon.Model.MerchantStock;
import com.example.amzon.Model.Proudct;
import com.example.amzon.Model.User;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@AllArgsConstructor

public class UserService {
    private final MerchantStockService merchantStockService;
    private final ProductService productService;
    private final MerchantService merchantService;


    ArrayList<User> users = new ArrayList<>();

    public void add(User user) {
        users.add(user);
    }

    public ArrayList get() {
        return users;
    }

    public boolean update(int id, User user) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == id) {
                users.set(i, user);
                return true;
            }
        }
        return false;
    }

    public boolean delete(int id) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == id) {
                users.remove(i);
                return true;
            }
        }
        return false;
    }


    public boolean addToStock(int idMarchents, int ProudectId, int amount) {
        for (int i = 0; i < merchantStockService.merchantStocks.size(); i++)
            if (merchantStockService.merchantStocks.get(i).getId() == idMarchents) {
                for (int j = 0; j < productService.proudcts.size(); j++) {
                    if (productService.proudcts.get(j).getId() == ProudectId) {
                        int addStock = merchantStockService.merchantStocks.get(i).getStock() + amount;
                        merchantStockService.merchantStocks.get(i).setStock(addStock);
                        return true;
                    }
                }
            }
        return false;
    }

    public boolean buy(int userID, int ProudectId, int  idMarchents) {
        for (int a=0;a<users.size();a++ )
            if(users.get(a).getId()==userID) {
                for (int i = 0; i < merchantStockService.merchantStocks.size(); i++){
                    if (merchantStockService.merchantStocks.get(i).getId() == idMarchents) {
                        for (int j = 0; j < productService.proudcts.size(); j++) {
                            if (productService.proudcts.get(j).getId() == ProudectId) {
                                if(productService.proudcts.get(j).getPrice()<=users.get(a).getBalance()){
                                int pay = merchantStockService.merchantStocks.get(i).getStock() - 1;
                                merchantStockService.merchantStocks.get(i).setStock(pay);
                                for(Merchant merchant: merchantService.merchants)
                                    if(merchant.getId()==idMarchents) {
                                        int count = merchant.getNumberOfPurchases() + 1;
                                        merchant.setNumberOfPurchases(count);
                               double reduceBalance= users.get(a).getBalance()-productService.proudcts.get(i).getPrice();
                               users.get(a).setBalance(reduceBalance);
                                return true;
                            }}
                        }return false;
                    }}}}
        return false;
    }

    public boolean refund(int userId1,int userId2,int proudctId){
        for(int i=0;i<users.size();i++)
        if (users.get(i).getId()==userId1&&users.get(i).getRole().equalsIgnoreCase("Admin")){
            for(int a=0;a<users.size();a++){
            if(users.get(a).getId()==userId2)
            for (int j=0;j<productService.proudcts.size();j++){
                if(productService.proudcts.get(j).getId()==proudctId){
                  double amount=productService.proudcts.get(j).getPrice()+users.get(a).getBalance();
                  users.get(a).setBalance(amount);
                  return true;
                }}}}
        return false;
    }

    public boolean discount(int userID, int ProudectId,double discount) {
        for (int i = 0; i < users.size(); i++)
            if (users.get(i).getId() == userID && users.get(i).getRole().equalsIgnoreCase("Admin")) {
                for (int j = 0; j < productService.proudcts.size(); j++) {
                    if (productService.proudcts.get(j).getId() == ProudectId) {
                        double offers = productService.proudcts.get(j).getPrice() - productService.proudcts.get(j).getPrice() * discount;
                        productService.proudcts.get(j).setPrice(offers);
                        return true;
                    }
                }
            }
        return false;
    }
}