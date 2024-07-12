package Ejercicios.contorllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Ejercicios.models.Celda;

/*
 * Un jugador está en la esquina superior izquierda (0,0) de un tablero m x n. En el tablero hay celdas
 * transitables (true) y no transitables (false). Encuentra un camino válido para ir a la esquina
 * inferior derecha con el jugador, sabiendo que solo se puede mover hacia abajo y hacia la derecha.
 * 
 * Ejemplo 1:
 *  Input:
 *    [
 *      [true,true,true,true]
 *      [false,false,false,true]
 *      [true,true,false,true]
 *      [true,true,false,true]
 *    ]
 *
 *  Output: [(0,0), (0,1), (0,2), (0,3), (1,3), (2,3), (3,3)]
 *
 * Ejemplo 2:
 *  Input:
 *    [
 *      [true,true,true,true]
 *      [false,true,true,true]x
 *      [true,true,false,false]
 *      [true,true,true,true]
 *    ]
 *
 *  Output: [(0,0), (0,1), (1,1), (2,1), (3,1), (3,2), (3,3)]
 *
 */
public class Laberinto {

    public List<Celda> getPath (boolean[][] grid) {
        List<Celda> path= new ArrayList<>();
        //nulo, vacio, no tenga camino
        //validacion para ver si esta bien hecho
        if (grid == null || grid.length ==0 || grid[0].length ==0) {
            return path;
        }
        //Map para almacenar si ya visitamos una celda y si es parte del camino
        //para ver si sigue su camino o no y guardo el cache cuando ya hice el calculo
        Map<Celda,Boolean> cache = new HashMap<>();
        if (getPath(grid,0,0,path,cache)) {
            return path; // si es false retorna una celda vacia 
        }
        return new ArrayList<>();

    }

    public boolean getPath(boolean[][] grid, int row, int col, List<Celda> path, Map<Celda, Boolean> cache) {
        //1er caso base y fila y cplumna esta a la altura del laberinto 
        if (row >= grid.length || col >= grid.length || !grid[row] [col]) {
            return false;
        }   
        //si esta dentro de la matriz pregunto por el catch
        Celda point = new Celda(row, col);

        //parte de catching si ya visitamos esta celda su valor es cache
        if (cache.containsKey(point)) {
            return cache.get(point);
        }

        //caso base 2. si estamos en la celda del final(viendo si la fil y col son las ultimas) de destin
        boolean end = (row == grid.length -1 && col ==grid[0].length-1);
        boolean success = false;    


        //parte rescursiva. intentamos movernos haciaa abj o dere
        if (end || getPath(grid, row + 1, col, path, cache) || getPath(grid, row, col + 1, path, cache)) {
        path.add(point);
        success=true;
        }

        //parte de catching . guardamos el resultado en cache
        cache.put(point, success);
        return success;

    }
}