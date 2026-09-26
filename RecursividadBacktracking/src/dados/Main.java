
package dados;

import java.util.ArrayList;

public class Main {
    
    //mostrando combiaciones
    static String dadosValorExacto(int valor, int numDado, int suma, int[] combinacion) {
        if (numDado == 3) {
            
            if (suma == valor) {
                String valores = "";
                
                for (int v : combinacion)
                    valores += v + " + ";
                
                return valores.substring(0, valores.length() - 2) + "= " + valor + "\n";                
            }                
            
            return "";
            
        } else {
            String valores = "";
            
            for (int i = 1; i <= 6; i++) {
                
                if (suma + i <= valor) {
                    combinacion[numDado] = i;
                    valores += dadosValorExacto(valor, numDado + 1, suma + i, combinacion);
                    combinacion[numDado] = 0;
                } else {
                    break;
                } 
                                
            }
            
            return valores;            
        }
    }        
    
    static String dadosValorExactoSinRepetir(int valor, int numDado, int suma, 
            ArrayList<int[]> combinaciones, int[] tocada) {
        
        if (numDado == 3) {
                                    
            int[] copiaOrdenada;
            
            if (suma == valor && esPermitido(copiaOrdenada = ordenarCombinacion(tocada), combinaciones)) {
                combinaciones.add(copiaOrdenada);
                
                String valores = "";                
                for (int v : tocada)
                    valores += v + " + ";
                
                return valores.substring(0, valores.length() - 2) + "= " + valor + "\n";                
            }                
            
            return "";
            
        } else {
            String valores = "";
            
            for (int i = 1; i <= 6; i++) {
                
                if (suma + i <= valor) {
                    tocada[numDado] = i;
                    valores += dadosValorExactoSinRepetir(valor, numDado + 1, suma + i,
                            combinaciones, tocada);
                    tocada[numDado] = 0;
                } else {
                    break;
                } 
                                
            }
            
            return valores;            
        }
    }        
    
    static int[] ordenarCombinacion(int[] combinacion) {
        
        int[] copia = combinacion.clone();
                                        
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (copia[j] > copia[j + 1]) {
                    int aux = copia[j];
                    copia[j] = copia[j + 1];
                    copia[j + 1] = aux;
                }                    
            }
        }
        
        return copia;        
    }
    
    static boolean esPermitido(int[] nueva, ArrayList<int[]> combinaciones) {
        boolean permitir = true;
        int j;       
        
        if (combinaciones.isEmpty())
            return true;
        
        for (int[] vector : combinaciones) {
            j = 0;
            
            for (int i = 0; i < 3; i++) {
                if (nueva[i] == vector[i])
                    j++;                    
            }
            
            if (j == 3) {
                permitir = false;
                break;
            }            
        }
        
        return permitir;        
    }
    
    
    static String dadosValorSuperior(int valor, int numDado, int suma, int[] combinacion) {
        if (numDado == 3) {
            
            if (suma > valor) {
                String valores = "";
                
                for (int d : combinacion) {
                    valores += d + " + ";
                }
                
                return valores.substring(0, valores.length() - 2) + "= " + suma + " > " + valor + "\n";                
            }
            
            return "";
            
        } else {
            String valores = "";
            
            for (int i = 1; i <= 6; i++) {                
                combinacion[numDado] = i;
                valores += dadosValorSuperior(valor, numDado + 1, suma + i, combinacion);
                combinacion[numDado] = 0;                
            }
            
            return valores;
        }
    }
    
    public static void main(String[] args) {
        int valor = 6;
        
        System.out.println("Todas las combinaciones");
        System.out.println(dadosValorExacto(valor, 0, 0, new int[3]));
        System.out.println("\nSin repetir:");
        System.out.println(dadosValorExactoSinRepetir(valor, 0, 0, new ArrayList<>(), new int[3]));
        System.out.println("\nTodas las combinaciones superior a");
        System.out.println(dadosValorSuperior(valor, 0, 0, new int[3]));        
    }
    
    
}
