package com.example.Tris.TrisService;


import com.example.Tris.Model.Partita;
import com.example.Tris.TrisRepository.TrisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.TreeMap;

@Service
public class TrisService {



    @Autowired
    private TrisRepository trisRepository;

    public Partita nuovapartita(Partita partita){
        return trisRepository.add(partita);

    }

    public List<Partita> getAll(){
        return trisRepository.getAll();
    }

    public Partita find(int id){
        return trisRepository.findByID(id).orElse(new Partita());
    }

    public Partita reset(int id){
        return trisRepository.reset(id);
    }

    public Partita move(int id,char c, int key){
        return trisRepository.move(id,c, key);
    }

    public Partita back(int id){
        return trisRepository.back(id);
    }

}
