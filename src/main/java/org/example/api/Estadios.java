package org.example.api;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Estadios implements Serializable {
    private String term;
    private List<Results> date;
    private List<Results> mandante;
    private List<Results> estadio;
    private List<Results> publico;

    public Estadios() {
        this.estadio = new ArrayList();
    }

    public Estadios(String term, List<Results> estadio) {
        this.term = term;
        this.estadio = estadio;
    }

    public Data() {
        this.estadio = new ArrayList();
    }

    public Data(String term, List<Results> date) {
        this.term = term;
        this.date = date;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public List<Results> getResults() {
        return estadio;
    }

    public void setResults(List<Results> results) {
        this.estadio = results == null ? new ArrayList() : results;
    }
}