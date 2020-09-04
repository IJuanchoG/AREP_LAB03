package edu.escuelaing.arep.MicroSpring.componenttests;

import edu.escuelaing.arep.MicroSpring.RequestMapping;

public class HelloController {

    @RequestMapping("/hello")
    public static String greetings() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/pi")
    public static String theValueOfPi() {
        String outputLine = "<!DOCTYPE html>\n"
                + "<html>\n"
                + "<head>\n"
                + "<meta charset=\"UTF-8\">\n"
                + "<title>Title of the document</title>\n"
                + "</head>\n"
                + "<body>\n"
                + "<h1>EL VALOR DE EULER</h1>\n"
                + "<p>" + "PI: " + Math.PI+ "</p"
                + "</body>\n"
                + "</html>\n";
        return outputLine;
    }

    @RequestMapping("/webapp")
    public static String pagina() {
        String outputLine = "<!DOCTYPE html>\n"
                + "<html>\n"
                + "<head>\n"
                + "<meta charset=\"UTF-8\">\n"
                + "<title>Title of the document</title>\n"
                + "</head>\n"
                + "<body>\n"
                + "<h1>EL VALOR DE EULER</h1>\n"
                + "<p>" + Math.E + "</p"
                + "</body>\n"
                + "</html>\n";
        return outputLine;
    }
}