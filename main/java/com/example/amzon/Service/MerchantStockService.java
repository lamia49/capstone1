package com.example.amzon.Service;

import com.example.amzon.Model.MerchantStock;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MerchantStockService {
   public ArrayList<MerchantStock>merchantStocks=new ArrayList<>();

    public void add(MerchantStock merchant){
        merchantStocks.add(merchant);
    }

    public ArrayList get(){
        return merchantStocks;
    }

    public boolean update(int id , MerchantStock merchant){
        for(int i=0 ;i<merchantStocks.size();i++){
            if(merchantStocks.get(i).getId()==id){
                merchantStocks.set(i,merchant);
                return true;
            }}
        return false;
    }
    public boolean delete(int id){
        for(int i=0 ;i<merchantStocks.size();i++){
            if(merchantStocks.get(i).getId()==id){
                merchantStocks.remove(i);
                return true;
            }}
        return false;
    }


}
