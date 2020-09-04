package edu.escuelaing.arep.clientserver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Hello world!
 *
 */
public class URLComponents

{
    public static void main( String[] args ) throws IOException {
        try {
            URL personalSite = new URL("http://campusvirtual.escuelaing.edu.co:80/moodle/mod/assign/view.php?id=34731");
            seeInfoURL(personalSite);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }




    }

    public static void seeInfoURL(URL url) throws IOException {
        System.out.println("Protocol: "+url.getProtocol());
        System.out.println("Authority: "+url.getAuthority());
        System.out.println("Host: "+url.getHost());
        System.out.println("Port: "+url.getPort());
        System.out.println("Path: "+url.getPath());
        System.out.println("Query: "+url.getQuery());
        System.out.println("File: "+url.getFile());
        System.out.println("Ref: "+url.getRef());
        System.out.println("Content: "+url.getContent());


    }
}
