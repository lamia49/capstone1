package com.example.amzon.Service;

import com.example.amzon.Model.Catogary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CatogaryService {
    ArrayList<Catogary>catogaries=new ArrayList<>();
    public void adding(Catogary catogary){
        catogaries.add(catogary);
    }
    public ArrayList getting(){
        return catogaries;
    }
    public boolean update(int id , Catogary catogary){
        for (int i=0; i<catogaries.size();i++){
            if(catogaries.get(i).getId()==id){
                catogaries.set(i,catogary);
                return true;
            }
        }
        return false;
    }

    public boolean delete(int id){
        for (int i=0; i<catogaries.size();i++){
            if(catogaries.get(i).getId()==id){
                catogaries.remove(i);
                return true;
            }
        }
        return false;
    }
}
