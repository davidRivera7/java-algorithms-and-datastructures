
package Mochila;

import java.util.ArrayList;

public class Main {
    
    public static void main(String[] args) {
        int pesoMochila = 15;
        
        Elemento[] elementos = {
            new Elemento("verde", 15, 12),                     
            new Elemento("gris", 2, 11),
            new Elemento("dorado", 10, 4),
            new Elemento("azul", 2, 2),
            new Elemento("naranja", 1, 1)
        };
        
        ArrayList<Elemento> mejor = new ArrayList<>();        
        mejorSolucionRepetidos(pesoMochila, 0, 0, elementos, mejor, new ArrayList<>());
        
        int i = 1;                
        for (Elemento e : mejor) {
            System.out.println(i + ": " + e);
            i++;
        }
        System.out.println("Con repetidos");
        System.out.println("Beneficio Total: " + getBeneficioMochila(mejor));
        System.out.println("Peso Total: " + getPesoMochila(mejor));
        
        mejor.clear();
        mejorSolucionSinRepetir(elementos, mejor, new ArrayList<>(), pesoMochila, 0, 0);
        
        System.out.println("");
        i = 1;                
        for (Elemento e : mejor) {
            System.out.println(i + ": " + e);
            i++;
        }        
        System.out.println("Sin repetidos");
        System.out.println("Beneficio Total: " + getBeneficioMochila(mejor));
        System.out.println("Peso Total: " + getPesoMochila(mejor));
    }
    
    static void mejorSolucionRepetidos(int pesoMochila, int pesoAct, int benAct, 
            Elemento[] elem, ArrayList<Elemento> mejor, 
            ArrayList<Elemento> aux) {
        
        if (benAct > getBeneficioMochila(mejor)) {            
            mejor.clear();            
            for (Elemento e : aux) 
                mejor.add(e);                                                
            
        } 
        
        for (int i = 0; i < elem.length; i++) {
            pesoAct += elem[i].peso;

            if (pesoAct <= pesoMochila) {
                benAct += elem[i].beneficio;
                aux.add(elem[i]);
                mejorSolucionRepetidos(pesoMochila, pesoAct, benAct, elem, mejor, aux);
                benAct -= elem[i].beneficio;
                aux.removeLast();
            }

            pesoAct -= elem[i].peso;
        }

    }
            
    static int getBeneficioMochila(ArrayList<Elemento> mochila) {
        int benef = 0;
        
        for (Elemento e : mochila) 
            benef += e.beneficio;
        
        return benef;
    }
    
    static int getPesoMochila(ArrayList<Elemento> mochila) {
        int peso = 0;
        
        for (Elemento e : mochila) 
            peso += e.peso;        
        
        return peso;
    }
    
    static void mejorSolucionSinRepetir(Elemento[] elem, ArrayList<Elemento> mejor, 
            ArrayList<Elemento> aux, int pesoMochila, int pesoAct, int benefAct) {
        
        if (benefAct > getBeneficioMochila(mejor)) {
            mejor.clear();
            
            for (Elemento e : aux) 
                mejor.add(e);            
        } 
                            
        for (int i = 0; i < elem.length; i++) {
            Elemento e = elem[i];
            pesoAct += e.peso;

            if (pesoAct <= pesoMochila && esPermitido(e, aux)) {
                benefAct += e.beneficio;
                aux.add(e);
                mejorSolucionSinRepetir(elem, mejor, aux, pesoMochila, pesoAct, benefAct);
                benefAct -= e.beneficio;
                aux.removeLast();
            }

            pesoAct -= e.peso;
        }       
        
    }
    
    static boolean esPermitido(Elemento e, ArrayList<Elemento> mochila) {        
        for (Elemento i : mochila) 
            if (e == i)
                return false;
                
        return true;
    }
    
}
