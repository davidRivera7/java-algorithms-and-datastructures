
package ejercicios;

public class Ejercicio5 {
    
    public static float potencia(int numero, int potencia) {
        if (potencia == 0) 
            return 1;
        else {            
            if (potencia > 0)
                return numero * potencia(numero, potencia - 1);
            
            return potencia(numero, potencia + 1) / numero;
        }       
    }
    
    public static int sumarDigitosEntero(int numero) {
        if (numero < 10) 
            return numero;
        else 
            return sumarDigitosEntero(numero / 10) + numero % 10;        
    }
    
    public static int sumarDigitosString(String numero) {
        if (numero.length() == 0) 
            return 0;
        else             
            return Integer.parseInt(numero.charAt(numero.length() - 1) + "") + 
                    sumarDigitosString(numero.substring(0, numero.length() - 1));                    
    }
    
    public static void main(String[] args) {
        int numero = 6;
        int potencia = -7;
        System.out.println("Numero: " + numero);
        System.out.println("Potencia: " + potencia);
        System.out.println(numero + "^" + potencia + " = " + potencia(numero, potencia));
        
        int digitos = 12346;
        System.out.println("Digitos: " + digitos);
        System.out.println("Suma: " + sumarDigitosEntero(digitos));
        
        String digitosString = "471394";
        System.out.println(sumarDigitosString(digitosString));
    }
    
}
