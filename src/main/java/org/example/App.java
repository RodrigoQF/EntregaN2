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
        AssestsBundle assestsBundle = new AssetsBundle("/site","/","index.html");
        bootstrap.addBundle(assestsBundle);
    }

    @Override
    public void run(Configuration configuration, Environment environment) throws Exception {

        final FilterRegistration.Dynamic cors = environment.servlets().addFilter("CORS", CrossOriginFilter.class);
        cors.setInitParameter("allowedOrigins","*");
        cors.setInitParameter("allowedHeaders","X-Request-Width,Content-Type,Accept,Origin");
        cors.setInitParameter("allowedMethods","OPTIONS,GET,PUT,POST,DELETE,HEAD");
        cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/");

        EstadiosDao dao = new EstadiosDao();
        EstadiosRecursos trendsResource = new EstadiosRecursos(dao);
        environment.jersey().register(trendsResource);
        environment.jersey().setUrlPattern("/api/*");
    }
    teste123
}