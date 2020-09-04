package edu.escuelaing.arep.clientserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class URLReader {

    public static void main(String[] args) throws Exception {
        URL url = new URL(args[0]);
        readURL(url);
        readHeader(url);
    }

    public static void readURL(URL url){
        List<String> lines = new ArrayList<>();
        Path file = Paths.get(url.getHost()+".html");
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
            String inputLine;
            while ((inputLine = reader.readLine()) != null) {
                lines.add(inputLine);
            }
            Files.write(file, lines, StandardCharsets.UTF_8);
            System.out.printf("Archivo creado con éxito");
        } catch (IOException x) {
            System.err.println(x);
        }

    }

    public static void readHeader(URL url) throws IOException {
        List<String> lines = new ArrayList<>();
        Path file = Paths.get("Header"+url.getHost()+".html");
        URLConnection urlConnection = url.openConnection();
        Map<String, List<String>> headers = urlConnection.getHeaderFields();
        Set<Map.Entry<String, List<String>>> entrySet = headers.entrySet();
        for (Map.Entry<String, List<String>> entry : entrySet) {
            String headerName = entry.getKey();
            if (headerName != null) {
                lines.add(headerName+":");
            }
            List<String> headerValues = entry.getValue();
            for (String value : headerValues) {
                lines.add(value);
            }
        }

        lines.add("\n-------message-body------");
        BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        String inputLine;
        while ((inputLine = reader.readLine()) != null) {
            lines.add(inputLine);
        }
        Files.write(file, lines, StandardCharsets.UTF_8);
    }
}


