package org.example.api;

import java.io.Serializable;

public class Result implements Serializable {
    String date;
    long value;



    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getPublico() {
        return this.value;
    }

    public void setPublico(long value) {
        this.value = value;
    }
}