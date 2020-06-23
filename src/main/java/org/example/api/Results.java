package org.example.api;

import java.io.Serializable;

public class Results implements Serializable {
    String date;
    int publico;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPublico() {
        return publico;
    }

    public void setPublico(int publico) {
        this.publico = publico;
    }
}