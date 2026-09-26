
package ejercicios;

public class Ejercicio2 {
    
    /**     
     * @param numeros arreglo
     * @param i iterador
     * @return 
     */
    public static String recorrerArrayEnteros(int[] numeros, int i) {
        if (i == numeros.length - 1) 
            return numeros[i] + "";
        else
            return numeros[i] + " - " + recorrerArrayEnteros(numeros, i + 1);        
    }
    
    /**     
     * retorna la posicion del elemento a buscar
     * @param numeros arreglo
     * @param i iterador
     * @param busqueda numero a buscar
     * @return posicion en que se encuentra
     */
    public static int buscarElementoArrayEnteros(int[] numeros, int i, int busqueda) {
        if (i == numeros.length || numeros[i] == busqueda) {                                    
            
            if (i < numeros.length)
                return i;
            
            return -1;
        } else 
            return buscarElementoArrayEnteros(numeros, i + 1, busqueda);        
    }
       
    public static String obtenerPosicionesElemento(int[] numeros, int i, int busqueda) {
        if (i == numeros.length) 
            return "";            
        else {
            if (numeros[i] == busqueda)
                return i + ", " + obtenerPosicionesElemento(numeros, i + 1, busqueda);
            
            return obtenerPosicionesElemento(numeros, i + 1, busqueda);
        }
    }
    
    public static void main(String[] args) {
        int[] numeros = {1, 4, 6, 7, 10, 89, 4, 2, 6, 1};
        int busqueda = 1;
        
        System.out.println(recorrerArrayEnteros(numeros, 0));
        System.out.println("Busqueda: " + busqueda);
        
        int primerPosicion;
        
        if ((primerPosicion = buscarElementoArrayEnteros(numeros, 0, busqueda)) == -1) {
            System.out.println("Elemento no encontrado");            
            return;
        }
        System.out.println("Primera Posicion: " + primerPosicion);                
        System.out.println("Posiciones: " + obtenerPosicionesElemento(numeros, 0, busqueda));       
    }
    
}
