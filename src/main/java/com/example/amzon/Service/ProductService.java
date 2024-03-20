package com.example.amzon.Service;

import com.example.amzon.Model.Proudct;
import com.example.amzon.Model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class ProductService {


private  final CatogaryService catogaryService;
    ArrayList<Proudct> proudcts = new ArrayList<>();

    public void adding(Proudct proudct) {

        proudcts.add(proudct);
    }

    public ArrayList getting() {
        return proudcts;
    }

    public boolean update(int id, int catogaryID, Proudct proudct) {
        for(int j=0;j<catogaryService.catogaries.size();j++)
            if(catogaryService.catogaries.get(j).getId()==id)
        for (int i = 0; i < proudcts.size(); i++) {
            if (proudcts.get(i).getId() == id) {
                proudcts.set(i, proudct);
                return true;
            }
        }
        return false;
    }

    public boolean delete(int id) {
        for (int i = 0; i < proudcts.size(); i++) {
            if (proudcts.get(i).getId() == id) {
                proudcts.remove(i);
                return true;
            }
        }
        return false;
    }



}




