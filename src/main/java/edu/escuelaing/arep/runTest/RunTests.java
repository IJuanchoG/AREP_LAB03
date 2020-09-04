package edu.escuelaing.arep.runTest;

import java.lang.reflect.Method;

public class RunTests {

    public static void main(String[] args) throws Exception {

        int passed = 0, failed = 0;

        for (Method m : Class.forName(args[0]).getMethods()) {
            System.out.println("Revisión de los métodos:" + m.getName());
            if (m.isAnnotationPresent(Test.class)) {
                System.out.println("Tiene anotación @Test");
                try {

                    m.invoke(null);

                    passed++;

                } catch (Throwable ex) {

                    System.out.printf("Test %s failed: %s %n", m, ex.getCause());

                    failed++;

                }
            }
        }

        System.out.printf("Passed: %d, Failed %d%n", passed, failed);

    }
}