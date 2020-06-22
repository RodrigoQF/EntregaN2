package org.example;


import org.example.dao.EstadiosDao;
import org.example.recursos.EstadiosRecursos;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
public class App extends Application<Configuration>
{
    public static void main( String[] args )
    {
        try{
            (new App()).run(args);
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<Configuration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(Configuration configuration, Environment environment) throws Exception {
        EstadiosDao dao = new EstadiosDao();
        EstadiosRecursos trendsResource = new EstadiosRecursos(dao);
        environment.jersey().register(trendsResource);
    }

}