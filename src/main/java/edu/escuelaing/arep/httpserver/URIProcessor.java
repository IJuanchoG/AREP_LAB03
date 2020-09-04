package edu.escuelaing.arep.httpserver;

public interface URIProcessor {

    public void mapService(String commang) throws Exception;
    public String executeServices(String theuri);

}
