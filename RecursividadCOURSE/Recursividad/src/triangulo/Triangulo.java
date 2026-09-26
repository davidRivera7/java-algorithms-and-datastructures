
package triangulo;

public class Triangulo {  
             
    public static void main(String[] args) {        
        int numFilas = 100;        
        int ast = 1;
        
        for (int f = 0; f < numFilas; f++) {
            
            for (int b = 0; b < numFilas - (f + 1); b++) 
                System.out.print(" ");            
            
            for (int a = 0; a < ast; a++) 
                System.out.print("*");
            
            System.out.println("");
            ast += 2;
        }                
    }
}
    
