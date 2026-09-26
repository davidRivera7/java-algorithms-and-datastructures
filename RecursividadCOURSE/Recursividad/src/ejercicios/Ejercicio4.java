
package ejercicios;

public class Ejercicio4 {
    
    public static String invertirNumero(int numero) {
        if (numero < 10) 
            return numero + "";
        else 
            return (numero % 10) + invertirNumero(numero / 10);       
    }
    
    /**
     * 
     * @param numero numero a invertir
     * @param cifras cantidad de ceros del numero     
     */
    public static int invertirNumero(int numero, int cifras) {
        if (numero < 10) 
            return numero;
        else 
            return (numero % 10) * (int) Math.pow(10, cifras) + 
                    invertirNumero(numero / 10, cifras - 1);
    }
    
    public static int obtenerCantidadCeros(int numero) {
        if (numero < 10) {
            return 0;
        } else {
            return 1 + obtenerCantidadCeros(numero / 10);
        }        
    }
    
    public static String invertirPalabra(String palabra, int iterador) {
        if (iterador == palabra.length()) 
            return "";
        else 
            return invertirPalabra(palabra, iterador + 1) + palabra.charAt(iterador);        
    }
    
    public static void main(String[] args) {
        int numero = 1234567891;
        int cantidadCeros = obtenerCantidadCeros(numero);
        
        System.out.println("Original: " + numero);
        System.out.println("Invertido: " + invertirNumero(numero, cantidadCeros));
        
        System.out.println("\n");
        String palabra = "David Rivera";
        System.out.println("Palabra original: " + palabra);
        System.out.println("Invertida: " + invertirPalabra(palabra, 0));
    }
    
}
