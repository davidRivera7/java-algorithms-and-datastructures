
package ejercicio1;

import java.util.ArrayList;

public class Numero {
    
    static String combinacionesNumero(int numero, int suma, ArrayList<Integer> lista) {
        String resultado = "";
        
        if (suma == numero) {                                               
            for (int i : lista) 
                resultado += i + " - ";            
            
            return resultado + "\n";
        } else {
            
            for (int i = 1; i <= numero; i++) {
                suma += i;
                if (suma > numero) 
                    break;                
                
                lista.add(i);
                resultado += combinacionesNumero(numero, suma, lista);
                suma -= i;
                lista.removeLast();                
            }
                                    
            return resultado;
        }                
    }
    
    static String v2SinRepetir(int numero, int suma, ArrayList<Integer> listaAux, 
            ArrayList<ArrayList<Integer>> listasFin) {
        
        String resultado = "";
        
        if (suma == numero) {                                               
            
            ArrayList<Integer> copia = new ArrayList<>();

            for (int i : listaAux)//copiar lista                
                copia.add(i);            

            if (!verificarRepetidos(ordenarLista(copia), listasFin))
                return "";
                        
            for (int i : listaAux) 
                resultado += i + " - ";            

            listasFin.add(copia);
            return resultado + "\n";                       
            
        } else {
            
            for (int i = 1; i <= numero; i++) {
                suma += i;
                if (suma > numero) 
                    break;                
                
                listaAux.add(i);
                resultado += v2SinRepetir(numero, suma, listaAux, listasFin);
                suma -= i;
                listaAux.removeLast();                
            }
                                    
            return resultado;
        }                
    }
    
    static boolean verificarRepetidos(ArrayList<Integer> lista, 
            ArrayList<ArrayList<Integer>> listasFin) {
        
        if (listasFin.isEmpty())
            return true;
                            
        for (int i = 0; i < listasFin.size(); i++) {
            if (listasFin.get(i).equals(lista))
                return false;
        }           
        
        return true;
    }
    
    static ArrayList<Integer> ordenarLista(ArrayList<Integer> lista) {        
        int aux;
        
        for (int i = 0; i < lista.size() - 1; i++) {
            for (int j = 0; j < lista.size() - 1; j++) {
                if (lista.get(i) > lista.get(i + 1)) {
                    aux = lista.get(i);
                    lista.set(i, lista.get(i + 1));
                    lista.set(i + 1, aux);
                }                    
            }
        }
        
        return lista;        
    }
    
    public static void main(String[] args) {
        int numero = 6;
        
        System.out.println(combinacionesNumero(numero, 0, new ArrayList<>()));        
        System.out.println("");
        System.out.print(v2SinRepetir(numero, 0, new ArrayList<>(), new ArrayList<>()));
    }
    
    
    
}
