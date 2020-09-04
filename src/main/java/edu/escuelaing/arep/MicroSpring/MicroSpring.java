package edu.escuelaing.arep.MicroSpring;

import edu.escuelaing.arep.httpserver.URIProcessor;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;


public class MicroSpring implements URIProcessor {
    Map<String,Method> webServices = new HashMap<>();


    public void mapService(String componentName) throws Exception {

        int nMethods = 0;

        for (Method m : Class.forName(componentName).getMethods()) {
            if (m.isAnnotationPresent(RequestMapping.class)) {
                System.out.printf("Metodo %s Tiene anotación @RequestMapping. %n", m.getName());


                    RequestMapping rm = m.getAnnotation(RequestMapping.class);
                    webServices.put(rm.value(), m);
                    nMethods++;

            }
        }

        System.out.printf("Number of WebServices %d.%n", nMethods);

    }
    public String executeServices(String theuri){
        try {
            return webServices.get(theuri).invoke(null).toString();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return "Error";
    }
}
