package edu.escuelaing.arep.MicroSpring;

import edu.escuelaing.arep.httpserver.HttpServer;
import edu.escuelaing.arep.httpserver.URIProcessor;

public class MicroSpringBoot {

    public static void main(String[] args){

        try {
            URIProcessor mspring = new MicroSpring();
            mspring.mapService(args[0]);
            HttpServer server = new HttpServer(mspring);
            server.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
