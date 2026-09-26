
package ejercicios;

public class Ejercicio1 {
       
    public static int recursiveFactorial(int numero) {
        if (numero == 2) 
            return 2;
        else 
            return numero * recursiveFactorial(numero - 1);               
    }       
    
    public static String imprimirVocales(char[] vocales, int i) {
        if (i == vocales.length) 
            return "";
        else 
            return imprimirVocales(vocales, i + 1) + vocales[i];                                
    }             
    
    public static int sumarNumeros(int n) {
        if (n == 1) 
            return n;
        else 
            return n + sumarNumeros(n - 1);        
    }
            
    public static void main(String[] args) {               
//        char[] vocales = {'a', 'e', 'i', 'o', 'u'};        
                
//        System.out.println("Suma de N: " + sumarNumeros(10));        
//        System.out.println(imprimirVocales(vocales, 0));        
//        System.out.println("En forma recursiva: " + recursiveFactorial(5));
    }
    
}
