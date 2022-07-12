package com.example.Tris.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

@Component
public class Partita {

    private int matchid;
    private char vincitore = 'L';




    TreeMap<Integer, Character> griglia = new TreeMap<>();
    List<Integer> listamosse = new ArrayList<>();

    public Partita() {
        griglia.put(1, ' ');
        griglia.put(2, ' ');
        griglia.put(3, ' ');
        griglia.put(4, ' ');
        griglia.put(5, ' ');
        griglia.put(6, ' ');
        griglia.put(7, ' ');
        griglia.put(8, ' ');
        griglia.put(9, ' ');

        this.matchid++;
    }

    public char getVincitore() {
        return vincitore;
    }

    public void setVincitore(char vincitore) {
        this.vincitore = vincitore;
    }

    public int getMatchid() {
        return matchid;
    }

    public TreeMap<Integer, Character> getGriglia() {
        return griglia;
    }

    public void setGriglia(TreeMap<Integer, Character> griglia) {
        this.griglia = griglia;
    }

    public void setMatchid(int matchid) {
        this.matchid = matchid;
    }

    public List<Integer> getListamosse() {
        return listamosse;
    }

    public void setListamosse(List<Integer> listamosse) {
        this.listamosse = listamosse;
    }
    public void addmossa(int mossa){
        this.listamosse.add(mossa);
    }



    @Override
    public String toString() {
        return "Partita{" +
                "matchid=" + matchid + "\n"+
                ", griglia= \n" +  griglia.get(1) +"|"+ griglia.get(2) + "|"+ griglia.get(3) + "\n" +
                griglia.get(4) +"|"+ griglia.get(5) + "|"+ griglia.get(6) + "\n" +
                griglia.get(7) +"|"+ griglia.get(8) + "|"+ griglia.get(9) + "\n" +
                "il vincitore e': " + vincitore+
        '}';
    }
}
