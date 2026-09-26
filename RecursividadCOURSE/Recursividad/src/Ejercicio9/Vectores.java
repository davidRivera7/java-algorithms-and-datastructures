
package Ejercicio9;

public class Vectores {
    
    static boolean compararStrings(String vectorUno, String vectorDos, int i) {
        if (vectorUno.length() != vectorDos.length() 
                || (i < vectorUno.length() && vectorUno.charAt(i) != vectorDos.charAt(i)))
            return false;
        else if (i == vectorUno.length()) 
            return true;
        else 
            return compararStrings(vectorUno, vectorDos, i + 1);
    }
    
    static String revertirString(String array, int i) {
        if (i == array.length()) 
            return "";
        else 
            return revertirString(array, i + 1) + array.charAt(i);        
    }
    
    static boolean compararArrays(int[] arrUno, int[] arrDos, int i) {
        if (arrUno.length != arrDos.length || 
                ( i < arrUno.length && arrUno[i] != arrDos[i]) ) 
            return false;
        else if (i == arrUno.length) 
            return true;
        else 
            return compararArrays(arrUno, arrDos, i + 1);
    }
    
    static void invertirArray(int[] arr, int i) {
        if (arr.length == 0)
            return;
        
        if (i <= (arr.length - 1) / 2) {                                           
            int aux = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = aux;
            invertirArray(arr, i + 1);
        }
    }
    
    static int invertirArray(int[] arr, int[] arrCopia, int i) {                
        if (arr.length == 0)
            throw new RuntimeException("Arreglo que intenta copiar vacio");        
        
        if (i == arr.length) 
            return arr[i - 1];
        else {
            arrCopia[arrCopia.length - 1 - i] = invertirArray(arr, arrCopia, i + 1);
            return (i != 0) ? arr[i - 1] : -1;
        }
    }
            
    public static void main(String[] args) {
//        String vectorUno = " david eduardo r ";
//        String vectorDos = " davi d eduardo r ";
//                
//        System.out.println("Strings comparados: " + compararStrings(vectorUno, vectorDos, 0));
//        System.out.println("String invertido: " + revertirString(vectorUno, 0));
        
        int[] numerosUno = {};
        int[] numerosDos = new int[numerosUno.length];        
        
//        System.out.println("Array numeros iguales: " + compararArrays(numerosUno, numerosDos, 0));
        
        try {
            invertirArray(numerosUno, numerosDos, 0);
        } catch (RuntimeException r) {
            System.out.println(r);
        }
        
        System.out.println("Array invertido: ");
        
        for (int i : numerosUno) 
            System.out.print(i + " - ");        
        
        System.out.println("");
        for (int i : numerosDos) 
            System.out.print(i + " - ");        
       
    }
    
}
