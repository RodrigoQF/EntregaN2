package org.example.dao;


import org.example.api.Estadios;
import org.example.api.Result;



import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class EstadiosDao {

    Estadios dataBase = new Estadios();

    public EstadiosDao() {
        readFile();
    }

    //CREATE
    public void createResult(Result result){
        this.dataBase.getResults().add(result);
        writeFile();
    }

    private void writeFile() {
    }

    //READ
    public Estadios getAllEstadios() {

        System.out.println("TrendsDAO - Lendo dados do arquivo CSV");
        return this.dataBase;

    }


    //UPDATE
    public void updateResult(Result result){
        for(int i=0; i<this.dataBase.getResults().size(); i++) {
            if (this.dataBase.getResults().get(i).getDate().equals(result.getDate())) {
                this.dataBase.getResults().set(i, result);
            }
        }
        writeFile();
    }

    //TODO:DELETE
    public void deleteResult(Result result){
        for(int i=0; i<this.dataBase.getResults().size(); i++) {
            if (this.dataBase.getResults().get(i).getDate().equals(result.getDate())) {
                this.dataBase.getResults().remove(i);
            }
        }
    }

    // FUNÇÕES AUXILIARES

    // Lê o arquivo csv e instancia a variável database
    public void readFile(){
        System.out.println("EstadiosDao - Lendo dados do arquivo CSV");

        try (Scanner scanner = new Scanner(new File(".idea/resources/multiTimeline.csv"));) {

            SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] cols = line.split(",");
                Date week = null; // usado para testar se a linha começa com uma data

                try {
                    week = sdf.parse(cols[0]);
                } catch(Exception e) { /*Não é uma data*/ }

                // Lendo dados
                if (week != null) {
                    Result result = new Result();
                    result.setDate(cols[0]);
                    result.setPublico(Integer.parseInt(cols[1]));
                    this.dataBase.getResults().add(result);

                    // Lendo cabecalho
                }  else if(cols.length > 0 && (cols[0].equals("Publico"))) {
                    this.dataBase.setTerm(cols[1]);
                }
            }

            System.out.println("EstadiosDao - Leitura realizada");
        } catch (Exception ex) {
            this.dataBase = new Estadios();
            ex.printStackTrace();
            System.out.println("EstadiosDao - Erro na leitura do CSV");
        }
    }
}