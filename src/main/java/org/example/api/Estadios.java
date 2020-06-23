package org.example.api;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Estadios implements Serializable {
    private String term;
    private List<Result> results;

    public Estadios() {
        this.results = new ArrayList();
    }

    public Estadios (String term, List<Result> data) {
        this.term = term;
        this.results = data;
    }

    public String getTerm() {
        return this.term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public List<Result> getResults() {
        return this.results;
    }

    public void setResults(List<Result> results) {
        this.results = (List)(results == null ? new ArrayList() : results);
    }
}