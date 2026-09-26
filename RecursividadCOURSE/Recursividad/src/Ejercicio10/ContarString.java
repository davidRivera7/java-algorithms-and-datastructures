
package Ejercicio10;

public class ContarString {
    
    static int contarCaracteresString(String cadena, int i) {
        if (i == cadena.length()) 
            return 0;
        else 
            return 1 + contarCaracteresString(cadena, i + 1);                
    }
    
    static int contarString(String cadena, int i) {        
        try {
            cadena.charAt(i);            
            return 1 + contarString(cadena, i + 1);                        
        } catch(RuntimeException r) {
            return 0;
        }                
    }
    
    static String mostrarCadena(String cadena, int i) {
        try {            
            return cadena.charAt(i) + mostrarCadena(cadena, i + 1);
        } catch (RuntimeException r) {
            return "";
        }        
    }
    
    public static void main(String[] args) {
        String cadena = "David";
        
        System.out.println(contarString(cadena, 0));
        System.out.println("Muestra cadena: " + mostrarCadena(cadena, 0));
    }
    
}
