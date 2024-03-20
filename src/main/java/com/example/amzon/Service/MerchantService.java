package com.example.amzon.Service;

import com.example.amzon.Model.Merchant;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MerchantService {
    ArrayList<Merchant>merchants=new ArrayList<>();

    public void add(Merchant merchant){
        merchants.add(merchant);
    }

    public ArrayList get(){
        return merchants;
    }

    public boolean update(int id , Merchant merchant){
        for(int i=0 ;i<merchants.size();i++){
            if(merchants.get(i).getId()==id){
                merchants.set(i,merchant);
                return true;
            }}
        return false;
    }

    public boolean delete(int id){
        for(int i=0 ;i<merchants.size();i++){
            if(merchants.get(i).getId()==id){
                merchants.remove(i);
                return true;
            }}
        return false;
    }


}
