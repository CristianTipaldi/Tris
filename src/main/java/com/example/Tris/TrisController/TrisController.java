package com.example.Tris.TrisController;


import com.example.Tris.Model.Partita;
import com.example.Tris.Model.Utente;
import com.example.Tris.TrisService.TrisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.TreeMap;

@RestController
@RequestMapping(value = "/api/tris")
public class TrisController {

    @Autowired
    TrisService trisService;

    @GetMapping("/new")
    public String griglianuova(Partita partita){
        return trisService.nuovapartita(partita).toString();
    }

    @GetMapping("/getall")
    public String griglianuova(){
        return trisService.getAll().toString();
    }
    @PutMapping("/{id}")
    public String resetPartita(@PathVariable("id") int id){
         return trisService.reset(id).toString();
    }

    @PutMapping("/{id}/move/{c}/{k}")
    public String move(@PathVariable("id")int id,@PathVariable("c") char c, @PathVariable("k") int k){
        return trisService.move(id,c,k).toString();
    }

    
    @PutMapping("/{id}/back")
    public String back(@PathVariable("id")int id){
        return trisService.back(id).toString();
    }

}
