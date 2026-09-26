
package mochila2Best;

import java.util.ArrayList;

public class Main {
    
    public static void main(String[] args) {
        final int pesoMochila = 15;
        
        Elemento[] elementos = {
            new Elemento(15, 12, "verde"),                     
            new Elemento(2, 11, "gris"),
            new Elemento(10, 4, "dorado"),
            new Elemento(2, 2, "azul"),
            new Elemento(4, 2, "cafe"),
            new Elemento(2, 1, "violeta"),
            new Elemento(1, 1, "naranja")
        };
                
        ArrayList<Elemento> mejor = new ArrayList<>();
        llenarMochila(elementos, pesoMochila, 0, 0, new ArrayList<>(), mejor, false);
        
        for (Elemento e : mejor) 
            System.out.println(e);
        
        System.out.println("Beneficio total: " + getBeneficioMochila(mejor));
        System.out.println("Peso total:" + getPesoMochila(mejor));
    }
    
    static void llenarMochila(Elemento[] elementos, int pesoMochila, int pesoActual, int beneficioActual,
            ArrayList<Elemento> aux, ArrayList<Elemento> mejor, boolean llena) {
        
        if (llena) {
            
            if (beneficioActual > getBeneficioMochila(mejor)) {
                mejor.clear();
                for (Elemento e : aux) 
                    mejor.add(e);                                
            }                
            
        } else {
            
            for (int i = 0; i < elementos.length; i++) {
                
                if (pesoActual + elementos[i].peso <= pesoMochila) {
                    aux.add(elementos[i]);
                    llenarMochila(elementos, pesoMochila, pesoActual + elementos[i].peso,
                            beneficioActual + elementos[i].beneficio, aux, mejor, false);
                    aux.removeLast();
                } else {
                    llenarMochila(elementos, pesoMochila, pesoActual, beneficioActual, aux, mejor, true);
                }
                                
            }
            
        }                
        
    }
    
    static int getPesoMochila(ArrayList<Elemento> mochila) {
        int pesoMochila = 0;
        
        for (Elemento e : mochila) 
            pesoMochila += e.peso;
                
        return pesoMochila;
    }
    
    static int getBeneficioMochila(ArrayList<Elemento> mochila) {
        int beneficioMochila = 0;
        
        for (Elemento e : mochila) 
            beneficioMochila += e.beneficio;
                
        return beneficioMochila;
    }
    
    static boolean esPermitido(Elemento e, ArrayList<Elemento> mejor) {
        for (Elemento i : mejor)
            if (e == i)
                return false;
       
        return true;
    }
    
}
