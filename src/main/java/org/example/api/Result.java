package org.example.api;

import java.io.Serializable;

public class Result implements Serializable {
    String date;
    long publico;



    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getPublico() {
        return this.publico;
    }

    public void setPublico(long publico) {
        this.publico = publico;
    }
}