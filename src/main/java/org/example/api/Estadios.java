package org.example.api;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Estadios implements Serializable {
    private String term;
    private List<Results> results;

    public Estadios(){
        this.results = new ArrayList<>();
    }

    public Estadios(String term, List<Results>data){
        this.term = term;
        this.results = data;
    }

    public String getTerm(){
        return term;
    }

    public void setTerm(String term){
        this.term = term;
    }

    public List<Results> getResults(){
        return  results;
    }

    public void setResults(List<Results> results){
        this.results = results == null ? new ArrayList() : results;
    }

}