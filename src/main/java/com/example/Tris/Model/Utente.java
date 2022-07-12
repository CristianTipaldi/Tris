package com.example.Tris.Model;

import org.springframework.stereotype.Component;

import java.util.Objects;
@Component
public class Utente {

    private int id;
    private char c;


    public Utente() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public char getC() {
        return c;
    }

    public void setC(char c) {
        this.c = c;
    }
}
