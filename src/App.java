import java.util.HashMap;
import java.util.Map;
import Ejercicios.contorllers.Laberinto;
import Ejercicios.models.Celda;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Programación Dinámica");

        long startime, endtime = 0;
        startime = System.nanoTime();
        System.out.println(fibonacci(40));
        endtime = System.nanoTime();
        System.out.println("Time taken: " + (endtime - startime) + " ns");
        System.out.println("Time taken: " + ((endtime - startime) / 1_000_000_000.0) + " segundos");

        // long timeTakenInNanoseconds = (endtime - startime);
        // double timeTakenInSeconds = timeTakenInNanoseconds / 1_000_000_000.0;
        // System.out.println("Time taken: " + timeTakenInSeconds + " seconds");

        startime = System.nanoTime();
        System.out.println(fibonacciWithCaching(40));
        endtime = System.nanoTime();
        System.out.println("Time taken: " + (endtime - startime) + " ns");
        System.out.println("Time taken: " + ((endtime - startime) / 1_000_000_000.0) + " segundos");

        startime = System.nanoTime();
        System.out.println(fibonacciCaching(40));
        endtime = System.nanoTime();
        System.out.println("Time taken: " + (endtime - startime) + " ns");
        System.out.println("Time taken: " + ((endtime - startime) / 1_000_000_000.0) + " segundos");

        /// Ejericio 1
        runEjercicio();

    }

    // Normal recursive method
    public static int fibonacci(int n) {

        if (n <= 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    // First caching method: Using a Map

    // crear donde voy a almacenar variable globar
    private static Map<Integer, Integer> cacheMap = new HashMap<>();

    public static int fibonacciWithCaching(int n) {
        // caso base
        if (n <= 1) {
            return n;
        }

        // revisar en cache si ya se calculo
        // si es que contiene que calcule sino la 2da vez
        if (cacheMap.containsKey(n)) {
            return cacheMap.get(n);
        }

        int result = fibonacciWithCaching(n - 1) + fibonacciWithCaching(n - 2);
        cacheMap.put(n, result);
        return result;
    }

    // Second caching method: Using an array
    public static int fibonacciCaching(int n) {
        // lugar donde vamos a grabar
        int[] cache = new int[n + 1];
        // guardar todas las poscione
        // metodo que retorna un int
        return fibonacciArregloR(n, cache);
    }

    private static int fibonacciArregloR(int n, int[] cache) {
        if (n <= 1) {
            return n;
        }

        if (cache[n] != 0) {
            return cache[n];
        }
        // llamada recursiva
        cache[n] = fibonacciArregloR(n - 1, cache) + fibonacciArregloR(n - 2, cache);
        return cache[n];
    }

    public static void runEjercicio() {


        boolean[][] grid = {
                { true, true, true, true },
                { false, false, false, true },
                { true, true, false, true },
                { true, true, false, true }
        };

        Laberinto laberinto = new Laberinto();

        for (Celda cel : laberinto.getPath(grid)) {
            System.out.println(cel.toString());
        }

    }

}
